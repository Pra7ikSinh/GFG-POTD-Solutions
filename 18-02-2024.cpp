/***********************************************************************************************************************************************************************************************************

Dev : Pra7iksinh Parmar
Date : 18/02/2024
Problem : Sum of leaf nodes in BST
Problem Link : https://www.geeksforgeeks.org/problems/sum-of-leaf-nodes-in-bst/1

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