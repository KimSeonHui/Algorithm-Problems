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
// var hasCycle = function(head) {
//     let slow = head;
//     let fast = head;
    
//     while(fast !== null && fast.next !== null) {
//         slow = slow.next;
//         fast = fast.next.next;
        
//         if(slow === fast) return true;
//     }
    
//     return false;
// };


//hashmap
var hasCycle = function(head) {
    const map = new Map();
    let currentNode = head;
    
    while(currentNode !== null && currentNode.next !== null) {
        map.set(currentNode, (map.get(currentNode) || 0) + 1);
        if(map.get(currentNode) > 1) return true;
        
        currentNode = currentNode.next;
    }
    
    return false;
};