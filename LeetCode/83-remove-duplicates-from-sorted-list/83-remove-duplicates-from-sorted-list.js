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
    let currentNode = head;
    let nextNode = head;
    
    while(currentNode !== null && currentNode.next !== null) {
        nextNode = currentNode.next;
        if(currentNode.val === nextNode.val) {
            currentNode.next = nextNode.next;
            nextNode.next = null;
        }
        else {
          currentNode = currentNode.next;
        }
    }
    
    return head;
};