/***************************************************************************************************************************************

Dev : Pra7iksinh Parmar
Date : 19/02/2023
Problem : Game with String
Problem Link : https://www.geeksforgeeks.org/problems/game-with-string4100/1

********************************************************************************************************************************/


class Solution{
public:
    int minValue(string s, int k){
        // code here
        unordered_map<char,int>mp;
        for(int i=0;i<s.length();i++){
            mp[s[i]]++;
        }
        priority_queue<int>pq;
        for(auto it:mp){
            if(it.second!=0){
                pq.push(it.second);
            }
        }
        for(int i=0;i<k;i++){
            int a=pq.top(); pq.pop();
            a--;
            if(a>0){
                pq.push(a);
            }
        }
        int ans=0;
        while(!pq.empty()){
            ans=ans+ pq.top()*pq.top();
            pq.pop();
        }
        return ans;
    }
};