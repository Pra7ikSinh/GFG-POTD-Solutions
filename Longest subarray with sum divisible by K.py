"""
*******************************************************************

Author : Pra7iksinh Parmar
Date :  09/01/2024
Problem : Longest subarray with sum divisible by K
Problem Link : https://www.geeksforgeeks.org/problems/longest-subarray-with-sum-divisible-by-k1259/1
************************************************************************
"""

def longSubarrWthSumDivByK(self, arr, n, k): 
	  ans = 0 
		mp = {}
		rem = 0
		for i in range(n):
		    rem = (rem + arr[i]%k + k)%k
		    if rem == 0:
		        ans = max(ans, i + 1)
		    elif rem not in mp:
		        mp[rem] = i
		    else:
		        ans = max(ans, i - mp[rem])
		return ans