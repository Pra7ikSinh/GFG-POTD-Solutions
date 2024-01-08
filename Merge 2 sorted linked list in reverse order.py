"""
*******************************************************************

Author : Pra7iksinh Parmar
Date :  08/01/2024
Problem : Merge 2 sorted linked list in reverse order 
Problem Link : https://www.geeksforgeeks.org/problems/merge-2-sorted-linked-list-in-reverse-order/1
************************************************************************
"""



class Solution:
  def mergeResult(self, node1, node2):
    if node1 is None and node2 is None:
        return None
    present = None
    while node1 is not None and node2 is not None:
        if node1.data <= node2.data:
            temp = node1.next
            node1.next = present
            present = node1
            node1 = temp
        else:
            temp = node2.next
            node2.next = present
            present = node2
            node2 = temp
    while node1 is not None:
        temp = node1.next
        node1.next = present
        present = node1
        node1 = temp
    while node2 is not None:
        temp = node2.next
        node2.next = present
        present = node2
        node2 = temp
    return present