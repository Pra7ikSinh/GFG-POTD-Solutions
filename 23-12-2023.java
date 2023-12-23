/*******************************************************************

Author : Pra7iksinh Parmar
Date : 23/12/2023
Problem : Count More than n/k Occurrences
Problem Link : https://www.geeksforgeeks.org/problems/count-element-occurences/1

************************************************************************/

//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Driverclass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int k = sc.nextInt();

            System.out.println(new Solution().countOccurence(arr, n, k));
        }
    }
}

// } Driver Code Ends


class Solution 
{
    //Function to find all elements in array that appear more than n/k times.
    public int countOccurence(int[] arr, int n, int k) 
    {
        // your code here,return the answer
          // your code here,return the answer
        HashMap<Integer,Integer> hm = new HashMap<>();
        k = n/k;
        HashSet<Integer> set = new HashSet<>();
        for(int x : arr){
            hm.put(x,hm.getOrDefault(x,0)+1);
            if(hm.get(x)>k) set.add(x);
        }
        return set.size();
    }
}
