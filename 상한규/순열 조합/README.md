# 순열과 조합(Permutation and Combination) & 부분 집합과 멱집합(Subset and Power set)

## What is
순열과 조합은 수학적 용어로, 각각 '서로 다른 n개에서 r개를 뽑아 정렬하는 경우의 수'와 '서로 다른 n개에서 순서 없이 r개를 뽑는 경우의 수'이다. 둘은 순서의 차이가 있다.<br>
순열과 조합은 각각 중복되는 경우가 존재하며, 중복 순열, 중복 조합이라고 부른다.<br>
<br>
부분 집합은 해당 집합에 포함되는 모든 집합이다. 순열과 조합을 구하는 것이 아니라, 해당 집합에 포함되는 모든 경우의 수를 구해야한다. {1, 2}의 경우는 부분 집합은 공집합, {1}, {2}, {1, 2}가 되는 것이다.<br>
멱집합은 해당 집합의 모든 부분 집합을 모아둔 것으로 위의 경우 {공집합, {1}, {2}, {1, 2}}가 되는 것이다.<br>

## When use
특정 개수를 뽑아서 진행하는 문제에서 사용한다.<br>
순서가 요구되는 경우 순열, 그렇지 않은 경우 조합, 그리고 각각 중복이 허용되는가를 확인하면 된다.<br><br>
부분 집합의 경우는 가능한 모든 경우를 뽑을 때 사용된다. 단, 순서가 고려되지 않기 때문에 순서를 고려해야한다면 다른 방법을 사용해야한다.<br>

## How to use
기저 조건 설정과 visited 배열 사용이 정말 중요하다.<br>
뽑아야하는 개수를 확인하여, 이를 재귀함수의 인자로 넘기면서 기저 조건을 설정한다.<br>
 
일반 순열 - visited를 사용하여 방문한 값이면 건너뛴다. 0번째 인덱스부터 반복하여 함수를 재귀한다. 방문처리와 해제를 재귀 전후로 진행한다.<br>

```java
// 0부터 n까지 반복
    for(int i = 0; i < n; i++) {
        // 방문하지 않은 값이면 넣기
        if(!visited[i]) {
            visited[i] = true;    // 방문 처리
            result[count] = arr[i];    // 현재 count를 인덱스로 사용
            permutation(count + 1, n, r);    // count + 1를 전달
            visited[i] = false; // 다음 순열을 뽑기위해 방문처리 제거
        }
    }
```

<br>
중복 순열 - visited를 사용하지 않아도 된다. 0번째 인덱스부터 반복하여 함수를 재귀한다.<br>

```java
// 0부터 n까지 반복
	for (int i = 0; i < n; i++) {
		result[count] = arr[i]; // 현재 count를 인덱스로 사용
		repeatPermutation(count + 1, n, r); // count + 1를 전달
	}
```

<br>
일반 조합 - visited를 사용하지 않아도 된다. 매개변수로 받은 인덱스 + 1부터 반복하여 함수를 재귀한다.<br>

```java
// start 부터 n까지 반복
	for(int i = start; i < n; i++) {
		result[count] = arr[i];	// 현재 count를 인덱스로 사용
		combination(i + 1, count + 1, n, r);	// i + 1, count + 1를 전달
	}
```

<br>
중복 조합 - visited를 사용하지 않아도 된다. 매개변수로 받은 인덱스부터 반복하여 함수를 재귀한다.<br>

```java
// start 부터 n까지 반복
	for(int i = start; i < n; i++) {
		result[count] = arr[i];	// 현재 count를 인덱스로 사용
		repeatCombination(i, count + 1, n, r);	// i, count + 1를 전달
	}
```

<br>
부분 집합 및 멱집합 - visited를 사용한다. for문을 돌리지 않고, visited 배열의 값을 true와 false 둘 다 확인해준다.<br>

```java
// start 부터 n까지 반복
	static void powerSet(int count) {
		if(count == n) {
			System.out.println(Arrays.toString(visited));
			return;
		}
		
		visited[count] = true;
		powerSet(count + 1);
		visited[count] = false;
		powerSet(count + 1);
	}
```

## ETC
- 백트래킹 기법이 많이 쓰이지만, 순열과 조합은 수학적 지식을 요구하기 때문에 따로 뺐다.
- 기저조건 설정과 visited 배열 사용 유무, 그리고 재귀를 시작할 인덱스를 잘 확인해야한다.
- 순열과 조합이라고 딱 나오는 문제는 코딩 테스트에서 많지 않은 것 같다. 다른 알고리즘과 함께 나오므로 백트래킹을 익히는 개념에서 잘 연습해보자.
- 소프티어 24년 8월?에 나왔던 문제처럼 몇개를 뽑아서 사용한다는 문제 조건이 있다면 백트래킹, 순열 조합을 생각해보자.
