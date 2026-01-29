class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int arr[] = new int[l1+l2];
        int i1 = 0;
        int i2 = 0;
        int i = 0;
        while(i1<l1 && i2<l2){
            if(nums1[i1]<nums2[i2]){
                arr[i]=nums1[i1];
                i1++;
            }else{
                arr[i]=nums2[i2];
                i2++;
            }
            i++;
        }
        while(i1<l1){
            arr[i++]=nums1[i1++];
        }
        while(i2<l2){
            arr[i++]=nums2[i2++];
        }
        int mid = arr.length/2;
        if(arr.length%2 == 0){
            double d1 = arr[mid-1];
            double d2 = arr[mid];
            double d = (d1+d2)/2;
            return d;
        }else{
            return arr[mid];
        }
    }
}