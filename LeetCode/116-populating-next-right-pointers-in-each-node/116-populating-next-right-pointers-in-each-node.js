/**
 * // Definition for a Node.
 * function Node(val, left, right, next) {
 *    this.val = val === undefined ? null : val;
 *    this.left = left === undefined ? null : left;
 *    this.right = right === undefined ? null : right;
 *    this.next = next === undefined ? null : next;
 * };
 */

/**
 * @param {Node} root
 * @return {Node}
 */
var connect = function(root) {
    if(!root) return root;
    return setNextPointer(null, root, '');    
};

function setNextPointer(parentNode, root, subTree) {
    if(parentNode !== null) {
        if(subTree === 'left') {
            root.next = parentNode.right;
        }
        else {
            root.next = (parentNode.next !== null) ? parentNode.next.left : null;
        }
    }

    if(root.left !== null) root.left = setNextPointer(root, root.left, 'left');
    if(root.right !== null) root.right = setNextPointer(root, root.right, 'right');
    
    return root;
}

//다른 사람 풀이
var connect = function(root) {
    let ptr = root;
    while(root && root.left){
        let temp = root;
        while(temp) {
            temp.left.next = temp.right;
            temp.right.next = temp.next ? temp.next.left : null;
            temp = temp.next;
        }
        root = root.left;
    }
    return ptr;
}

