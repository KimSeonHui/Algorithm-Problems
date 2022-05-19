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
//recursion
var reverseList = function(head) {
    return reverse(null, head);
};

function reverse(prevNode, node) {
    if(node === null) return prevNode;
    
    let nextNode = node.next;
    node.next = prevNode;
    return reverse(node, nextNode);
}


//iterative
// var reverseList = function(head) {
//     let prevNode = null;
//     let currentNode = head;
//     let nextNode = head;
    
//     while(currentNode !== null) {
//         nextNode = currentNode.next;
//         currentNode.next = prevNode;
//         prevNode = currentNode;
//         currentNode = nextNode;
//     }
    
//     return prevNode;
// };


