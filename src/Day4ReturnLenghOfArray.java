/*
Given a sorted array consisting of duplicate elements.
If we remove the duplicates what will be the length of the array?
Expected
Time Complexity: O(n)
Space Complexity: O(1)
 */
public class Day4ReturnLenghOfArray{
    static void main() {
     int[] arr = {1,1,2,2,2,2,2,3,3,4,4,4,4,5,6};
     int n = arr.length;
     int i=0;
     int j=1;
     int count = 1;
     while(j<n){
         if(arr[i]!=arr[j]){
             count++;
             i=j;
         }
         j++;
     }
        System.out.println(count);
    }
}
