/***************************************************************************************************************************************

Dev : Pra7iksinh Parmar
Date : 01/01/2024
Problem : Word Break
Problem Link : https://www.geeksforgeeks.org/problems/word-break1352/1

********************************************************************************************************************************/

class Solution
{
public:
bool solve(string A, unordered_map<string,int>&mp, int ind){
        if(ind>=A.length()){
            return true;
        }
        
        for(int i=ind;i<A.length();i++){
            string s=A.substr(ind, i-ind+1);
            if(mp.find(s)!=mp.end()){
                if(solve(A, mp, i+1)){
                    return true;
                }
            }
        }
        return false;
    }
    
    
    int func(string A, vector<string> &B) {
        //code here
        unordered_map<string,int>mp;
        for(int i=0;i<B.size();i++){
            mp[B[i]]++;
        }
        
        if(solve(A, mp, 0)){
            return true;
        }
        else{
            return false;
        }
    }
    int wordBreak(int n, string s, vector<string> &dictionary) {
        //code here
        return func(s, dictionary);
    }
};