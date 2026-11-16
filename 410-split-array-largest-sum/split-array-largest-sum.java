class Solution {
    public int splitArray(int[] nums, int k) {
         int n = nums.length;

        
        if (k > n) {
            return -1;
        }

        int left = 0;  
        int right = 0;  

        for (int pages : nums) {
            left = Math.max(left, pages);
            right += pages;
        }

        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isPossible(nums, k, mid)) {
                ans = mid;
                right = mid - 1; 
            } else {
                left = mid + 1;  
            }
        }

        return ans;
    }

    private boolean isPossible(int[] nums, int k, int maxPages) {
        int students = 1;
        int pagesSum = 0;

        for (int pages : nums) {

            if (pagesSum + pages <= maxPages) {
                pagesSum += pages;
            } else {
                students++;
                pagesSum = pages;

                if (students > k) {
                    return false;
                }
            }
        }

        return true;
    }
}