package heap;

import java.util.*;

public class Heapify {

    public static void swap(int a, int b, int[] arr) {
        int temp = arr[b];
        arr[b] = arr[a];
        arr[a] = temp;
    }


    public static void heapify(int[] arr) {
        int end = arr.length - 1;
        int non_leaf = arr.length / 2 - 1;
        for (int i = non_leaf; i >= 0; i--) {
            maintainMaxHeap(i, arr, end);
        }
    }

    public static int deleteFromHeap(int[] arr, int end) {
        int result = arr[0];
        //swap first and last element
        swap(0, end, arr);
        end = end - 1; //after swap(delete) end is reduced..
        maintainMaxHeap(0, arr, end);
        return result;
    }

    public static int findMaxKthElement(int arr[], int k) {
        heapify(arr);
        int result = 0;
        for (int i = 1; i <= k; i++) {
            result = deleteFromHeap(arr, arr.length - i);
        }
        return result;
    }

    public static void maintainMaxHeap(int rootIndex, int[] arr, int end) {
        boolean swap = true;
        while (swap) {
            int leftChildIndex = 2 * rootIndex + 1;
            int rightChildIndex = 2 * rootIndex + 2;
            if (rightChildIndex <= end && arr[rightChildIndex] > arr[leftChildIndex] && arr[rightChildIndex] > arr[rootIndex]) {
                //Swap with right child
                swap(rootIndex, rightChildIndex, arr);
                rootIndex = rightChildIndex;
                continue;
            }
            if (leftChildIndex <= end && arr[leftChildIndex] > arr[rootIndex]) {
                //Swap with left child
                swap(rootIndex, leftChildIndex, arr);
                rootIndex = leftChildIndex;
                continue;
            }
            swap = false;
        }
    }

    public static void swap(int a, int b, List<List<Integer>> arr) {
        List<Integer> temp = arr.get(b);
        arr.set(b, arr.get(a));
        arr.set(a, temp);
    }

    public static int getSum(List<Integer> arr) {
        int sum = 0;
        for (Integer a : arr) {
            sum = sum + a;
        }
        return sum;
    }

    public static void minHeapify(List<List<Integer>> arr) {
        int end = arr.size() - 1;
        int non_leaf = arr.size() / 2 - 1;

        for (int i = non_leaf; i >= 0; i--) {
            boolean swap = true;
            int j = i;

            while (swap) {
                int node = getSum(arr.get(j));

                if (2 * j + 2 <= end) {
                    int leftChild = getSum(arr.get(2 * j + 1));
                    int rightChild = getSum(arr.get(2 * j + 2));
                    if (rightChild < leftChild && rightChild < node) {
                        // Swap with right child
                        swap(j, 2 * j + 2, arr);
                        j = 2 * j + 2;
                        continue;
                    }
                }
                if (2 * j + 1 <= end) {
                    int leftChild = getSum(arr.get(2 * j + 1));
                    if (leftChild < node) {
                        // Swap with left child
                        swap(j, 2 * j + 1, arr);
                        j = 2 * j + 1;
                        continue;
                    }
                }

                swap = false;
            }
        }
    }

    public static List<Integer> deleteFromHeap(List<List<Integer>> arr, int end) {
        List<Integer> result = arr.get(0);
        // swap first and last element
        swap(0, end, arr);

        boolean swap = true;
        int j = 0;
        end = end - 1; // after swap(delete) end is reduced..

        while (swap) {
            int node = getSum(arr.get(j));
            if (2 * j + 2 <= end) {
                int leftChild = getSum(arr.get(2 * j + 1));
                int rightChild = getSum(arr.get(2 * j + 2));
                if (rightChild < leftChild && rightChild < node) {
                    // Swap with right child
                    swap(j, 2 * j + 2, arr);
                    j = 2 * j + 2;
                    continue;
                }
            }
            if (2 * j + 1 <= end) {
                int leftChild = getSum(arr.get(2 * j + 1));
                if (leftChild < node) {
                    // Swap with left child
                    swap(j, 2 * j + 1, arr);
                    j = 2 * j + 1;
                    continue;
                }
            }

            swap = false;
        }
        return result;
    }

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        Set<String> visitedIndices = new HashSet<>();

        pq.add(new int[]{nums1[0] + nums2[0], 0, 0});
        visitedIndices.add("0,0");

        while (k > 0 && !pq.isEmpty()) {

            int[] pair = pq.poll();
            int i = pair[1];
            int j = pair[2];

            result.add(Arrays.asList(nums1[i], nums2[j]));

            String key = i + 1 + "," + j;
            if (i + 1 < nums1.length && !visitedIndices.contains(key)) {
                pq.add(new int[]{nums1[i + 1] + nums2[j], i + 1, j});
                visitedIndices.add(key);
            }

            String key2 = i + "," + (j + 1);
            if (j + 1 < nums2.length && !visitedIndices.contains(key2)) {
                pq.add(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
                visitedIndices.add(key2);
            }
            k--;
        }
        return result;

    }

    public static void main(String[] args) {
        int[] n1 = {1, 1, 2};
        int[] n2 = {1, 2, 3};

        System.out.println(kSmallestPairs(n1, n2, 4));
    }
}


