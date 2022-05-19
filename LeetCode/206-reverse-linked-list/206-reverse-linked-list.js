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
    let currentNode = head;
    let reverseNode = null;
    let nextNode = head;
    
    while(currentNode !== null) {
        nextNode = currentNode.next;
        reverseNode = reverse(reverseNode, currentNode);
        currentNode = nextNode;
    }
    
    return reverseNode;
};

function reverse(prevNode, node) {
    node.next = prevNode;
    return node;
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


