# 정렬(Sort)

## What is
정렬은 알고리즘 부분에서 특정 나열을 정리할 때 쓰인다. 주로 오름차순과 내림차순의 정렬로 사용이 되며, 해당 문제를 정렬해야할지, 한다면 어떤 방법으로 정렬할지를 고민해야한다.<br>
정렬 문제는 상당 부분 시간 복잡도에 의해 방법을 고려해야하므로 문제의 조건을 유의 깊게 읽는 것이 중요하다.<br>

## When use
1. 버블 정렬(Bubble Sort)<br>
시간복잡도 평균 : O(n^2)<br>
시간복잡도 최악 : O(n^2)<br>
-> 구현하기 쉽다. 매번 연속된 두 인덱스를 비교하여 값이 큰 경우 이를 swap하는 형식이다.<br>
<br>
2. 선택 정렬(Selection Sort)<br>
시간복잡도 평균 : O(n^2)<br>
시간복잡도 최악 : O(n^2)<br>
-> n^2의 시간복잡도를 가지고 있는 방법 중 제일 교환 횟수가 작다. 0번째 인덱스를 기준으로 가장 작은 값을 찾아가며 해당 인덱스의 값끼리 swap한다.<br>
<br>
3. 카운팅 정렬(Counting Sort)<br>
시간복잡도 평균 : O(n + k)<br>
시간복잡도 최악 : O(n + k)<br>
-> n + k기 때문에 n이 작아야 효율적이다. Integer 형태만 가능하다. 또한 최대값이 배열의 범위를 넘어서도 안된다. count 배열을 생성하여 각 값에 맞는 인덱스에 1을 추가해준다. 이후 배열을 누적합으로 전환해준다. count 배열이 아닌 데이터 배열을 역방향 순회하면서 해당 값을 인덱스로 가지는 카운팅 인덱스의 값 - 1을 새 배열의 인덱스와 일치시킨 후, 새 배열 인덱스에 해당 값을 저장한다. 카운팅 인덱스의 값을 1 낮춘다. 모든 진행 후 배열이 정렬되며, 순서또한 지켜지기 때문에 해당 정렬은 stable sort의 성격을 가진다.카운팅 정렬은 정렬하고자 하는 값들의 차이가 클 때 생성해야하는 배열의 크기가 크기 때문에 메모리 낭비가 발생한다. <br>
<br>
4. 삽입 정렬(Insertion Sort)<br>
시간복잡도 평균 : O(n^2)<br>
시간복잡도 최악 : O(n^2)<br>
-> n이 작아야 효율적이다.<br>
<br>
5. 병합 정렬(Merge Sort)<br>
시간복잡도 평균 : O(nlogn)<br>
시간복잡도 최악 : O(nlogn)<br>
-> linkedList를 사용할 때 효율이 좋다. 분할 정복 기법을 활용하기 때문에 배열의 선언 및 삭제가 빈번하다. 각 배열을 분할한 뒤 병합하는 과정에서 정렬을 시행한다.<br>

```
mergeSort(arr[], left, right) {
    if left < right :
        mid <- (left + right) / 2
        mergeSort(arr, left ,mid)
        mergeSort(arr, mid + 1, right)
        merge(arr, left, mid, right)
}

merge(arr[], left, mid, right) {
    L <- left, R<- mid + 1
    index <- left
    while L <= mid && R <= right {
        if arr[L] <= arr[R]
            sortedArr[index++] <- arr[L++]
        else
             sortedArr[index++] <- arr[R++]
    }

    if(L <=mid) {
        for i in L to mid
            sortedArr[idx++] <-arr[i]
    } else {
        for i in R to right
            sortedArr[idx++] <-arr[i]

    }
    for i in left to right
        arr[i] <- sortedArr[i]
}
```

<br>
6. 퀵 정렬(Quick Sort)<br>
시간복잡도 평균 : O(nlogn)<br>
시간복잡도 최악 : O(n^2)<br>
-> 최악만 아니면 제일 빠르다. 여기서 최악은 이미 정렬되어 있는 경우를 말한다. nlogn인 병합 정렬에 비해 더 빠르고 효율적인 이유는 컴퓨터는 이미 선언된 메모리 및 값을 재사용하는 것이 빠르기 때문이다. 분할 정복 기법을 사용하며, 피벗이라는 요소를 사용한다. 피벗을 선택하여 배열을 두 부분으로 나누고 재귀적으로 정렬한다. 병합 정렬에 비해 추가 메모리를 필요로 하지 않는다. Hoare 파티션 방법과 Lomuto 파티션 방법이 존재한다. Hoare 파티션 방법은 피벗을 기준으로 피벗보다 작은 값과 큰 값을 영역으로 나눈다. 이 때 서로의 영역에 맞지 않는 값끼리 swap 한다. 이후 영역 사이에 있는 값 중 피벗보다 작은 값을 피벗과 바꾼다. 그 후 작은 값들을 정렬한다. Lomuto 파티션 방법은 맨 뒤에 피벗을 놓고 맨 앞부터 i와 j 인덱스를 증가시켜 간다. 피벗보다 작은값이 최대로 갈 수 있는 곳이 i이며, 큰 값이 나오면 j가 진행을 한다. 그러다가 피벗보다 작은 값이 나오면 i의 인덱스에 있는 값과 j의 인덱스에 있는 값이랑 swap한다. j는 다시 진행을 하고 끝나면 i보다 앞에 있는 값과 피벗을 변경한다. 그 피벗을 기준으로 분할 후 위의 방법을 진행한다. 일반적으로 hoare가 swap을 덜 진행하기 때문에 조금 더 효율적이다.<br>

## How to use
배열 등을 위의 방법으로 정렬한다.<br>


## 문제를 풀며 느낀 점
- 특정 정렬을 사용해라! 라는 문제는 많이 나오지 않는 것 같다.<br>
- 다만, counting sort에서 사용하는 누적합 기법이나, 분할 정복 등의 기법은 알아놔야 한다.<br>
- Comparator 및 Comparable을 사용하는 방법도 익혀놓자.<br>
- Arrays.sort()를 자주 쓰는데, 이 것은 integer만 지원하기 때문에 Arrays.sort((o1, o2)-> o1 - o2) 등의 형식으로 바꿔 써보는 연습을 하자.<br>


## ETC
- 퀵 정렬이 일반적인데,, java에서는 퀵 정렬 중 어느 파티션 방법을 쓰는지 궁금하다. 아직 못 찾았다,,<br>
- Heap Sort, Tim Sort, Dual-Pivot Sort 등도 존재하는 것 같다...<br>
Heap Sort는 평균 nlogn, 최악 nlogn 이고 Tim Sort도 동일하다. <br>
Tim Sort는 Insertion와 Merge를 결합하였다고 한다..<br>
Tim Sort가 2002년 고안되어 비교적 최근인데,, 아이디어는 다음과 같다. 현실에서는 무작위보단 어느정도 정리되어 있을 것이다. 그렇다면 정렬을 해야하는 전체 배열을 작은 덩어리들로 잘라 이를 삽입 정렬로 정렬한 뒤, 병합 정렬로 병합해보자!다.<br>
- Java는 Dual Pivot Quick Sort를 사용한다. 삽입 정렬과 퀵 정렬을 합친 형태다.<br>