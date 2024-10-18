# 정렬

## 🏷 정렬의 종류

![정렬 종류](<정렬 정리.jpg>)

<br/>
<br/>

## 🏷 버블 정렬 (Bubble Sort)

인접한 두 개의 원소를 비교한 후 교환하는 과정을 반복하여 데이터를 정렬하는 방식

### ⚙ 정렬 과정

1. 첫 번째 원소부터 인접한 원소와 비교하여 자리를 교환해가면서 마지막 자리까지 이동

2. 한 cycle이 끝나면 가장 큰 원소가 마지막 자리로 위치한다. (오름차순 정렬 기준)

### ⚙ 시간 복잡도

- O(n<sup>2</sup>)

### ⚙ 기본 코드

```java
// arr: 정렬할 배열, N: 배열의 크기
BubbleSort(int[] arr, int N) {

    for (int i = arr.length - 1; i >= 0; i--) {
        for (int j = 0; j <= i; i++) {

            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                a[j] = a[j + 1];
                a[j + 1] = temp;
            }

        }
    }

}
```

<br/>
<br/>

## 🏷 선택 정렬 (Selection Sort)

주어진 자료들 중 가장 작은 값의 원소부터 차례대로 선택하여 위치를 교환하는 방식

### ⚙ 정렬 과정

1. 주어진 리스트 중에서 최소값 찾기

2. 최소값을 리스트의 맨 앞에 위치한 값과 교환

3. 맨 처음 위치를 제외한 나머지 리스트를 대상으로 위 과정 반복

### ⚙ 시간 복잡도

- O(n<sup>2</sup>)

### ⚙ 기본 코드

```java
public class Main {

    public static void main(String[] args) {

        int[] nums = {10, 64, 25, 11, 28, 77, 34};

        selectionSort(nums);

    }

    // arr: 정렬할 배열
    static void selectionSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {

            int minIdx = i; // 최솟값 인덱스를 저장할 변수

            // 최솟값 찾기
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIdx] > arr[j]) minIdx = j;
            }

            // minIdx와 i 위치 바꾸기
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;

        }

    }

}
```

<br/>
<br/>

## 🏷 카운팅 정렬 (Counting Sort)

항목들의 순서를 결정하기 위해, 집합에 각 항목이 몇 개씩 있는지 세는 작업을 하여, 선형 시간에 정렬하는 효율적인 알고리즘

### ⚙ 시간 복잡도

- O(n + k)

- 배열의 길이 + 정수의 최댓값

### ⚙ 제한 사항

- 정수나 정수로 표현할 수 있는 자료에 대해서만 적용 가능

- 각 항목의 발생 횟수를 기록하기 위해, 정수 항목으로 인덱스 되는 카운트들의 배열을 사용하기 때문

- 카운트들을 위한 충분한 공간을 할당하려면, 집합 내의 가장 큰 정수를 알아야 한다.

### ⚙ 기본 코드

```java
public class Main {

    public static void main(String[] args) {

        int[] arr = {4, 9, 11, 23, 2, 19, 7};

        // 최댓값 확인
        int maxValue = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxValue) maxValue = arr[i];
        }

        // count 배열을 통해 원소 count
        int[] count = new int[maxValue + 1];

        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        // count 배열 -> 누적합 배열
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // 원본 배열을 역방향으로 순회하며, 정렬 후 위치 찾기 => Stable Sort
        int sortedArr[] = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            sortedArr[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        System.out.println(Arrays.toString(sortedArr));

    }

}
```

<br/>
<br/>

## 🏷 삽입 정렬 (Insertion Sort)

자료 배열의 모든 원소들을 앞에서부터 차례대로 이미 정렬된 부분과 비교하며 자신의 위치를 찾아내는 방식

### ⚙ 정렬 방식

1. 정렬할 자료를 두 개의 부분집합 S와 U로 가정

   - 부분집합 S : 정렬된 앞부분의 원소들
   - 부분집합 U : 아직 정렬되지 않은 나머지 원소들

2. 정렬되지 않은 부분집합 U의 원소를 하나씩 꺼내어 이미 정렬 되어있는 부분집합 S의 마지막 원소부터 비교하면서 위치를 찾아 삽입

3. 삽입 정렬을 반복하면서 부분집합 S의 원소는 하나씩 늘리고, 부분집합 U의 원소는 하나씩 감소시킨다.

4. 부분집합 U가 공집합이 되면 삽입정렬 완성

### ⚙ 시간 복잡도

- O(n<sup>2</sup>)

### ⚙ 기본 코드

```java
public class Main {

    public static void main(String[] args) {

        int[] arr = new int[] { 69, 10, 30, 2, 16, 8, 31, 22 };

        insertSort(arr);

    }

    static void insertSort(int[] arr) {

        // i : 정렬되지 않은 집합의 첫 번째 원소
        for (int i = 1; i < arr.length; i++) {

            int data = arr[i];

            // 정렬된 집합의 뒤에서부터 비교하면서 위치 찾기
            int j;
            for (int j = i - 1; j >= 0 && arr[j] > data; j--) {
                arr[j + 1] = arr[j];
            }

            arr[j + 1] = data;

        }

    }

}
```

<br/>
<br/>

## 🏷 병합 정렬 (Merge Sort)

분할 정복 (Divide and Conquer) 기법을 활용한 안정적인 알고리즘

### ⚙ 정렬 방식

1. 분할 (Divide) : 주어진 배열을 반으로 나눈다.

2. 정복 (Conquer) : 각 부분 배열을 재귀적으로 병합 정렬을 사용해 정렬한다.

3. 병합 (Combine) : 정렬된 부분 배열들을 합쳐 전체 배열을 정렬한다.

### ⚙ 시간 복잡도

- O(NlogN)

### ⚙ 제한 사항

- 추가적인 공간이 필요하기 때문에, 퀵 정렬에 비해 메모리를 많이 차지한다.

### ⚙ 기본 코드

```java
public class Main {

	static int[] arr = {7, 5, 13, 2, 79, 12, 35, 42};

	static int N = arr.length; // 배열의 크기

	static int[] temp = new int[N];

	public static void main(String[] args) {

		mergeSort(0, N - 1);

	}

	// left: 구간의 시작 위치, right: 구간의 끝
	static void mergeSort(int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;

			mergeSort(left, mid);
			mergeSort(mid + 1, right);

			merge(left, mid, right);
		}
	}

	// left: 시작 구간, right: 끝 구간, mid: 왼쪽 끝 구간
	static void merge(int left, int mid, int right) {
		int L = left; //왼쪽 구간의 시작 포인트
		int R = mid + 1; //오른쪽 구간의 시작 포인트

		int idx = left; // temp 배열의 인덱스

		while (L <= mid && R <= right) {
			if (arr[L] <= arr[R]) temp[idx++] = arr[L++];
			else temp[idx++] = arr[R++];
		}

		// 남은 숫자 넣기
		if (L <= mid) {
			for (int i = L; i <= mid; i++) {
				temp[idx++] = arr[i];
			}
		} else {
			for (int i = R; i <= right; i++) {
				temp[idx++] = arr[i];
			}
		}

		// 원본 배열에 반영
		for (int i = left; i <= right; i++) {
			arr[i] = temp[i];
		}
	}

}
```

<br/>
<br/>

## 🏷 퀵 정렬 (Quick Sort)

분할 정복 (Divide and Conquer) 기법을 활용한 효율적인 알고리즘

### ⚙ 정렬 방식

1. Pivot 결정 (선정하는 방법이 여러 개 존재)

2. 분할 (Divide) : Pivot보다 작은 요소는 왼쪽에, 큰 요소는 오른쪽에 위치하도록 배열 나누기

3. 정복 (Conquer) : 분할된 배열을 다시 재귀적으로 정복한다.

### ⚙ 기본 코드 (Hoare Partition)

```java
public class Main {

	static int[] arr = {7, 5, 13, 2, 79, 12, 35, 42};

	static int N = arr.length; // 배열의 크기

	public static void main(String[] args) {

		quickSort(0, N - 1);

	}

	static void quickSort(int left, int right) {
		if (left < right) {
			int pivot = partition(left, right);

			quickSort(left, pivot - 1);
			quickSort(pivot + 1, right);
		}
	}

	static int partition(int left, int right) {
		int pivot = arr[left];

		int L = left + 1, R = right;

		while (L <= R) {

			// L: pivot보다 큰 값을 찾을 때까지 이동
			while (L <= R && arr[L] <= pivot) L++;

			// R: pivot보다 작거나 같은 값을 찾을 때까지 이동
			while (arr[R] > pivot) R--;

			if (L < R) {
				int temp = arr[L];
				arr[L] = arr[R];
				arr[R] = temp;
			}
		}

		int temp = arr[left];
		arr[left] = arr[R];
		arr[R] = temp;

		return R; // pivot의 위치 반환
	}

}
```

### ⚙ 기본 코드 (Lomuto Partition)

```java
public class Main {

	static int[] arr = {7, 5, 13, 2, 79, 12, 35, 42};

	static int N = arr.length; // 배열의 크기

	public static void main(String[] args) {

		quickSort(0, N - 1);

	}

	static void quickSort(int left, int right) {
		if (left < right) {
			int pivot = partition(left, right);

			quickSort(left, pivot - 1);
			quickSort(pivot + 1, right);
		}
	}

	static int partition(int left, int right) {
		int pivot = arr[right];

		int i = left - 1; // 작은 값들의 경계

		for (int j = left; j < right; j++) {
			if (arr[j] <= pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		int temp = arr[i + 1];
		arr[i + 1] = arr[right];
		arr[right] = temp;

		return i + 1;
	}

}
```
