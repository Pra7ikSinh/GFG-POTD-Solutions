/***************************************************************************************************************************************

Dev : Pra7iksinh Parmar
Date : 06/01/2024
Problem : Techfest and the Queue
Problem Link : https://www.geeksforgeeks.org/problems/techfest-and-the-queue1044/1

********************************************************************************************************************************/


class Solution {
    public static long sumOfPowers(long a, long b) {
        // code here
        long sum = 0;
        
        for(int i=(int)a; i<=(int)b; i++){
            int x = i;
            for(int j=2; j*j<=x; j++){
                while(x%j==0){
                    sum++;
                    x=x/j;
                }
            }
            if(x>=2) sum++;
        }
        return sum;
    }
}
  