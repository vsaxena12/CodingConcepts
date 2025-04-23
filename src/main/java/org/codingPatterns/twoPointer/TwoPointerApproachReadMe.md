# Two Pointer Approach
- Efficiently traverse or manipulate sequential data structure (arrays/ lists)
- Maintains two dynamic pointers usually starting from two different positions to traverse the data structure in coordinated manner

## Two pointer matches these pattern (Runs usually from opposite directions):
1. Linear data structure: The input data can be traversed in a linear fashion, such as an array, linked list, or string.
2. Process pairs: Process data elements at two different positions simultaneously.
3. Dynamic pointer movement: Both pointers move independently of each other according to certain conditions or criteria. In addition, both pointers might move along the same or two different data structures.

## When to Use Two Pointers:
- When you’re working with sorted arrays.
- When you need to reduce time complexity from O(n²) to O(n).
- When searching for pairs, sub-arrays, or palindromes.

## Real world problems:
- Merge two sorted lists
- Data duplication
- Memory management
- Finance
- Text processing
- Scheduling etc.

## Common Two Pointer Problems:
- Pair with target sum
- Reverse array/string
- Merge sorted arrays
- Remove duplicates from sorted array

---

# Sliding Window Approach
- If the distance between pointers is fixed or conditionally growing/shrinking, and you’re processing a window of elements, it’s likely a Sliding Window problem.
- Sliding Window is just a special case of Two Pointer where you’re managing a sub-range of the array/string.

## Common Sliding Window Problems:
- Maximum sum sub-array of size k
- Longest substring without repeating characters
- Minimum window substring
- Count anagrams or distinct elements in a window

---

# Slow and Fast Pointers Approach
- Fast and Slow Pointer (also called Tortoise and Hare) is a variant of the Two Pointer approach, used for a specific class of problems — usually involving cycles or repeated patterns.

## How Fast and Slow Pointers Work:
1. You use two pointers:
2. Slow moves one step at a time.
3. Fast moves two steps at a time.
4. If there’s a cycle, fast will eventually “lap” slow (they meet).
5. If no cycle, fast will hit the end.

## Common Fast & Slow Pointer Problems:
- Detect cycle in linked list
- Find the start of a cycle
- Find middle of linked list
- Linked list palindrome

---

# Time Complexity Insights
- Two Pointer: Often reduces from O(n²) → O(n)
- Sliding Window: Maintains O(n) by avoiding repeated work
- Fast & Slow: O(n) time and O(1) space for cycle detection

---

# Common Pitfalls
- Forgetting to move one or both pointers inside the loop
- Missing base or edge cases (e.g., null/empty input)
- Infinite loop in cycle detection if condition checks are incorrect
- Mismanaging window size or boundaries in sliding window

---

# Technique Comparison Table

| Technique         | Pointer Speed                           | Use Case                                |
|-------------------|-----------------------------------------|-----------------------------------------|
| Two Pointer       | Usually same speed                      | Find pairs, move inward or across       |
| Sliding Window    | Both move right, maintaining a window   | Subarrays, substrings                   |
| Fast & Slow       | Different speeds                        | Cycles, loops, patterns                 |

---

# Summary
- **Two Pointer** = umbrella term for many techniques.
- **Sliding Window** = two pointers managing a "window".
- **Fast & Slow Pointer** = two pointers at different speeds, used for cycle detection and pattern recognition.
