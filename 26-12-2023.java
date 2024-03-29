/***************************************************************************************************************************************

Dev : Pra7iksinh Parmar
Date : 26/12/2023
Problem : Largest rectangular sub-matrix whose sum is 0
Problem Link : https://www.geeksforgeeks.org/problems/largest-rectangular-sub-matrix-whose-sum-is-0/1

********************************************************************************************************************************/


//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];
        
        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }
        
        return mat;
    }
    
    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
    
    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int[] nm = IntArray.input(br, 2);
            
            
            int[][] a = IntMatrix.input(br, nm[0], nm[1]);
            
            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> res = obj.sumZeroMatrix(a);
            
            if(res.size() == 0) {
                System.out.println(-1);
                
            } else {
            
                IntMatrix.print(res);
            }        
        }
    }
}

// } Driver Code Ends



class Solution {
    public static ArrayList<ArrayList<Integer>> sumZeroMatrix(int[][] a) {
        // code here
         int n = a.length, m = a[0].length;
        
        int r1=0,r2=0,c1=0,c2=0,maxArea=-10000;
        
        for(int i=0; i<m; i++){
            int arr[] = new int[n];
            for(int j=i; j<m; j++){
                for(int k=0; k<n; k++){
                    arr[k]+=a[k][j];
                }
                
                int s[] = {0};
                int e[] = {0};
                
                int len = maxLen(arr,s,e);
                int area = (e[0]-s[0]+1)*(j-i+1);
                
                if(len>0 && area>maxArea){
                    r1=s[0];
                    r2=e[0];
                    c1=i;
                    c2=j;
                    maxArea = area;
                }
            }
        }
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=r1; i<=r2; i++){
            ArrayList<Integer> x = new ArrayList<>();
            for(int j=c1; j<=c2; j++){
                x.add(a[i][j]);
            }
            list.add(x);
        }
        return list;
    }
    
    static int maxLen(int[] arr, int s[], int e[]){
        int mLen = 0;
        int sum = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            sum+=arr[i];
            
            if(arr[i]==0 && mLen==0){
                mLen = 1;
                s[0] = i;
                e[0] = i;
            }
            if(sum==0){
                if(mLen<i+1){
                    s[0] = 0;
                    e[0] = i;
                }
                mLen = i+1;
            }
            if(hm.containsKey(sum)){
                int prevLen = mLen;
                mLen = Math.max(mLen,i-hm.get(sum));
                
                if(prevLen<mLen){
                    s[0] = hm.get(sum)+1;
                    e[0] = i;
                }
            }
            else{
                hm.put(sum,i);
            }
        }
        return mLen;
    }
}
        
