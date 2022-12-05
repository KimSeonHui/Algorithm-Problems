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
var reverseList = function(head) {
    if(head === null) return null;
    
    let curNode = head;
    let nextNode = head.next;
    let prevNode = null;
    
    while(curNode.next !== null) {
        curNode.next = prevNode;
        prevNode = curNode;
        curNode = nextNode;
        nextNode = nextNode.next;
    }
    
    curNode.next = prevNode;
    prevNode = curNode;
    
    return prevNode;
};

