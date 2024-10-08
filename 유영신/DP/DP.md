
# 동적 계획법(DP) 알고리즘

동적 계획법(Dynamic Programming, DP)은 복잡한 문제를 더 작은 하위 문제로 나누어 해결하는 방법이다.
이 방법은 특히 문제가 **중복되는 부분 문제(Overlapping Subproblems)**와 **최적 부분 구조(Optimal Substructure)**를 가질 때 활용할 수 있다.
즉, 문제의 해결 방법이 그 하위 문제들의 해결 방법으로 구성될 수 있을 때 적용할 수 있다.

## DP의 주요 개념

1. **중복되는 부분 문제(Overlapping Subproblems)**:
    - 문제가 더 작은 하위 문제들로 나누어질 수 있고, 이 하위 문제들이 여러 번 해결되는 경우를 말한다.
    - 예를 들어, 피보나치 수열을 구할 때, F(2), F(3) 같은 값들이 재귀적인 방법으로 여러 번 계산되는 경우가 있다.

2. **최적 부분 구조(Optimal Substructure)**:
    - 문제의 최적해가 그 하위 문제들의 최적해로부터 도출될 수 있다는 특성을 말다.
    - 예를 들어, 최단 경로 문제에서는 A에서 B로 가는 최단 경로와 B에서 C로 가는 최단 경로를 알고 있다면, A에서 C로 가는 최단 경로를 계산할 수 있다.

3. **메모이제이션(Memoization) vs. 테뷸레이션(Tabulation)**:
    - **메모이제이션**: 이는 상향식(top-down) 접근 방식으로, 하위 문제의 해를 미리 계산하고 저장해 두어 이후에 다시 계산하지 않도록 한.
    - **테뷸레이션**: 하향식(bottom-up) 접근 방식으로, 가장 작은 하위 문제부터 차례로 계산하여 테이블에 값을 채워나가는 방식다.

## DP를 사용하는 문제 해결 과정

1. **문제 정의**:
    - 문제를 부분 문제로 나눌 수 있는지 확인한다. 일반적으로 이 부분 문제들은 독립적이지 않고 서로 겹치게 된다.
    
2. **재귀 관계식(점화식) 도출**:
    - 각 하위 문제 간의 관계를 수립하고, 이를 바탕으로 문제를 해결하기 위한 재귀 관계식을 만든다.
    
3. **메모이제이션 또는 테뷸레이션 사용**:
    - 재귀적으로 하위 문제를 해결할 때 이미 계산한 결과를 저장하여 중복 계산을 방지하거나, 작은 하위 문제부터 순차적으로 계산하여 테이블을 채운다.

## DP 문제 예시: 0-1 배낭 문제

- 주어진 물건들이 있고, 각 물건은 무게와 가치가 있습니다. 배낭이 수용할 수 있는 최대 무게를 넘기지 않으면서, 물건들의 총 가치를 최대화하는 문제다.
- DP를 이용해 해결할 수 있으며, 배낭의 무게에 따라 최적의 물건 선택을 점차적으로 계산한다.

```java
for (int i = 1; i <= N; i++) {
    for (int w = 1; w <= W; w++) {
        if (weights[i] <= w) {
            dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w - weights[i]] + values[i]);
        } else {
            dp[i][w] = dp[i-1][w];
        }
    }
}
```

위 코드는 각 물건에 대해 배낭에 넣을 수 있는지 여부를 판단하고, 최대 가치를 계산하는 과정이다.

## 동적 계획법을 사용하는 대표적인 문제들

1. 피보나치 수열
2. 배낭 문제 (0-1 Knapsack Problem)
3. 최단 경로 문제 (Shortest Path Problem)
4. 문자열 매칭 (String Matching)
5. 최소 편집 거리 (Edit Distance)