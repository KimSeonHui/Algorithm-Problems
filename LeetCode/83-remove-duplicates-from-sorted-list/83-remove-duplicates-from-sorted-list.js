/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var deleteDuplicates = function(head) {
    if(head === null) return null;
    
    let curNode = head;
    let nextNode = head;
    
    while(curNode.next !== null) {
        nextNode = curNode.next;
        if(curNode.val === nextNode.val)  curNode.next = nextNode.next;
        else  curNode = nextNode;
        
        nextNode = nextNode.next;
    }
    
    return head;
};
