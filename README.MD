## Qn1 :

between two digrams is the distance between the first letter of the first digram and the first letter of the second
digram. For example, in string S = "akcmz" the distance between digrams "kc" and "mz" is 2. We want to find the distance
between the furthest identical digrams inside string S.

Write a function:

def solution(S)

that, given a string S consisting of N letters, returns the distance between the two identical digrams in the string
that lie furthest away from each other. If there are no two identical digram inside S, your function should return -1.

Examples:

1. Given S = "aakmaakmakda" your function should return 7. The furthest identical digrams are "ak"s, starting in
   positions 2 and 9 (enumerating from 1): "aakmaakmakda".
2. Given S = "aaa" your function should return 1. The furthest identical digrams are "aa"s starting at positions 1 and
    2.
3. Given S = "solidity" your function should return -1. There are no two identical digrams in S.

Write an efficient algorithm for the following assumptions:

* N is an integer within the range [2..300,000];
* string S consists only of lowercase letters (a-z).

### Solution

1. tokenize the string forward/backward at the same time
2. use hash map to capture the existence
3. for duplicate elements, calculate the distance

### Implementation

[DigramsDistance maxDistance(String content)](./src/main/java/com/xceder/algorithms/Digrams.java)

## Qn2:

You have just rolled a dice several times. The N roll results that you remember are described by an array A. However,
there are F rolls whose results you have forgotten. The arithmetic mean of all of the roll results (the sum of all the
roll results divided by the number of rolls) equals M. What are the possible results of the missing rolls? Write a
function:

def solution(A, F, M)

that, given an array A of length N, an integer F and an integer M, returns an array containing the possible results of
the missed rolls. The returned array should contain F integers from 1 to 6 (valid dice rolls). If such an array does not
exist then the function should return (0].

Examples:

1. Given A = [3, 2, 4, 31], F = 2, M = 4, your function should return [6, 6]. The arithmetic mean of all the rolls is (3
    + 2 + 4 + 3 + 6 + 6) / 6 = 24 / 6 = 4.
2. Given A = [1, 5, 6], F = 4, M = 3, your function may return [2, 1, 2, 4] or [6, 1,1, 1] (among others).
3. Given A = [1, 2, 3, 4], F = 4, M = 6, your function should return [0]. It is not possible to obtain such a mean.
4. Given A = [6, 1], F = 1, M = 1, your function should return [0]. It is not possible to obtain such a mean.

Write an efficient algorithm for the following assumptions:

* N and F are integers within the range [1..100,000];
* each element of array A is an integer within the range [1.6];
* M is an integer within [1, 6]

### Solution

## Qn 3:

A warehouse supervisor has a stock of various electronic parts, which are stored in many boxes. There are various sizes
of boxes, lined up along a wall. There can be multiple boxes of the same size.

The supervisor has to ensure that the boxes are stored in the warehouse in nondecreasing order according to their sizes.
One day, due to an error on the part of the shipping company, the boxes were placed in the wrong order.

The supervisor must return a subsequence of consecutive boxes to the shipping company in such a way that the remaining
sequence of boxes is arranged in nondecreasing order. The number of removed boxes should be as small as possible.

You are given an array A consisting of N integers which represent box sizes. If the supervisor decides to return boxes
numbered from P to Q to the shipping company (which results in removing Q - P + 1 boxes), the sequence of sizes A[0],
A[1], ..., A[P-1], A[Q+1], A[Q+2], ..., A[N-1] must be in nondecreasing order. For example, given array A:

```java 
A[0] = 1
A[1] = 2
A[2] = 3
A[3] = 1
A[4] = 1
A[5] = 5
```

there are two possibilities when removing two boxes: by removing boxes 1 and 2 the sequence [1, 1, 1, 5] would remain;
similarly, by removing boxes 3 and 4 the sequence [1, 2, 3, 5] would remain. There is no possible way of removing just
one or zero boxes to obtain a nondecreasing sequence.

Write a function:

def solution(A)

that, given an array A consisting of N integers representing box sizes, returns the length of the shortest subsequence
of consecutive boxes such that, after it is removed, the remaining sequence of boxes is in nondecreasing order. For
example, given array A as described above, the function should return 2, as explained above. For inputs that are already
in nondecreasing order, like the following array A:
A[0] = 1 the function should return 0

Write an efficient algorithm for the following assumptions:

* N is an integer within the range [0..100,000];
* each element of array A is an

### Solution