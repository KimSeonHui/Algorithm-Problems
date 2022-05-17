/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

/**
 * @param {ListNode} head
 * @return {boolean}
 */
// two pointers
var hasCycle = function(head) {
    let slow = head;
    let fast = head;
    
    while(fast !== null && fast.next !== null) {
        slow = slow.next;
        fast = fast.next.next;
        
        if(slow === fast) return true;
    }
    
    return false;
};


// set
// var hasCycle = function(head) {
//     const set = new Set();
//     let currentNode = head;
    
//     while(currentNode !== null && currentNode.next !== null) {
//         if(!set.has(currentNode)) {
//             set.add(currentNode);
//         } 
//         else return true;
        
//         currentNode = currentNode.next;
//     }
    
//     return false;
// };