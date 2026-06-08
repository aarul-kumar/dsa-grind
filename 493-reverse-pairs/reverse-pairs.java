class Solution {
    int count;
    private void mergeSort(int arr[], int si, int ei){
        if(si>=ei){
            return;
        }
        int mid = si+(ei-si)/2;
        mergeSort(arr,si,mid);
        mergeSort(arr,mid+1,ei);
        int i=si;
        int j=mid+1;
        while(i<=mid && j<=ei){
            if(arr[i]<=2L*arr[j]){
                i++;
            }else{
                count+=mid-i+1;
                j++;
            }
        }
        merge(arr,si,mid,ei);
    }
    private void merge(int arr[], int si, int mid, int ei){
        int temp[]=new int[ei-si+1];
        int i=si;
        int j=mid+1;
        int k=0;
        while(i<=mid && j<=ei){
            if(arr[i]>arr[j]){
                temp[k]=arr[j];
                j++;
            }else{
                temp[k]=arr[i];
                i++;
            }
            k++;
        }
        while(i<=mid){
            temp[k++]=arr[i++];
        }
        while(j<=ei){
            temp[k++]=arr[j++];
        }
        for(k=0, i=si; k<temp.length; k++, i++){
            arr[i]=temp[k];
        }
    }
    public int reversePairs(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return count;
    }
}