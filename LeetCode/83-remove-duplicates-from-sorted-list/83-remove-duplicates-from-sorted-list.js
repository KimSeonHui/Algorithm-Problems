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
    if(!head) return null;
    if(!head.next) return head;
    
    let currentNode = head;
    let nextNode = head.next;
    
    while(currentNode !== null && currentNode.next !== null) {
        if(currentNode.val === nextNode.val) {
            currentNode.next = nextNode.next;
            nextNode.next = null;
        }
        else {
          currentNode = currentNode.next;
        }
        nextNode = currentNode.next;
    }
    
    return head;
};