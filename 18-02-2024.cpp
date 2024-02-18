/***********************************************************************************************************************************************************************************************************

Dev : Pra7iksinh Parmar
Date : 18/02/2024
Problem : Find element occuring once when all other are present thrice
Problem Link : https://www.geeksforgeeks.org/problems/find-element-occuring-once-when-all-other-are-present-thrice/1

************************************************************************************************************************************************************************/


class Solution
{
    public:
        int sum=0;
        
        void traversal(Node* root){
            if(root==NULL) return;
            if(root->left==NULL && root->right==NULL){
                sum+=root->data;
                return;
            }
            
            traversal(root->right);
            traversal(root->left);
            
            return ;
            
        }
        
        /*You are required to complete below method */
        int sumOfLeafNodes(Node *root ){
            /*Your code here */
            traversal(root);
            return sum;
        }
};