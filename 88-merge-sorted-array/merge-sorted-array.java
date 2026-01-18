class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int temp[] = new int[m+n];
        int i1=0;
        int i2=0;
        int k=0;
        while(i1<m && i2<n){
            if(nums1[i1]<nums2[i2]){
                temp[k]=nums1[i1];
                i1++;
            }
            else{
                temp[k]=nums2[i2];
                i2++;
            }
            k++;
        }
        while(i1<m){
            temp[k++]=nums1[i1++];
        }
        while(i2<n){
            temp[k++]=nums2[i2++];
        }
        for(k=0; k<temp.length; k++){
            nums1[k]=temp[k];
        }
        return;
    }
}