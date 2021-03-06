/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var inorderTraversal = function(root) {
    return inorder(root, []);
};

function inorder(root, order) {
    if(!root) return [];
    
    if(root.left) inorder(root.left, order);
    order.push(root.val);
    if(root.right) inorder(root.right, order);
    
    return order;
}