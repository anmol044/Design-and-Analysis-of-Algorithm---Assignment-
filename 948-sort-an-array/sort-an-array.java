class Solution {
    public int[] sortArray(int[] nums) {
        int[] temp = new int[nums.length];
        mergeSort(nums, temp, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] a, int[] temp, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        mergeSort(a, temp, lo, mid);
        mergeSort(a, temp, mid + 1, hi);

        int i = lo, j = mid + 1, k = lo;
        while (i <= mid && j <= hi)
            temp[k++] = a[i] <= a[j] ? a[i++] : a[j++];
        while (i <= mid) temp[k++] = a[i++];
        while (j <= hi) temp[k++] = a[j++];
        for (k = lo; k <= hi; k++) a[k] = temp[k];
    }
}