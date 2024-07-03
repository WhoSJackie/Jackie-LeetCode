package com.wang.learning;

public class No1646 {
    public int getMaximumGenerated(int n) {
        if(n<1){
            return 0;
        }
        int[] nums=new int[n+1];
        nums[0]=0;
        nums[1]=1;
        int max=1;
        for (int i = 2; i <= n; i++) {
            if(i%2==0){
                nums[i]=nums[i/2];
            }
            else{
                nums[i]=nums[i/2]+nums[i/2+1];
            }
            max=Math.max(nums[i],max);
        }

        return max;
    }
}
