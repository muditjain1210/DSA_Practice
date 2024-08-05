package binaarySearch;

class FindPeakElement {
    private static int findPeak(int[] nums, int st, int end) {
        if (st == end) {
            return st;
        }
        if (nums[st + 1] < nums[st]) {
            return st;
        }
        if (nums[end - 1] < nums[end]) {
            return end;
        }

        int middle = (st + end) / 2;

        if (middle - 1 < 0 || middle + 1 >= nums.length) {
            return -1;
        }

        if (nums[middle - 1] < nums[middle] && nums[middle + 1] < nums[middle]) {
            return middle;
        }

        if (nums[middle] < nums[middle + 1]) {
            return findPeak(nums, middle + 1, end - 1);
        }

        if (nums[middle] < nums[middle - 1]) {
            return findPeak(nums, st + 1, middle - 1);
        }

        return -1;
    }

    public int findPeakElement(int[] nums) {
        return findPeak(nums, 0, nums.length - 1);
    }
}
