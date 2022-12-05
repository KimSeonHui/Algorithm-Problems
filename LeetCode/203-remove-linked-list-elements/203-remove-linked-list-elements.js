/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} val
 * @return {ListNode}
 */
var removeElements = function(head, val) {
    let curNode = head;
    let prevHead = {next : head};
    let prevNode = prevHead;
    
    while(curNode !== null) {
        if(curNode.val === val)  prevNode.next = curNode.next;
        else  prevNode = curNode;
        
        curNode = curNode.next;
    }
    
    return prevHead.next;
};
