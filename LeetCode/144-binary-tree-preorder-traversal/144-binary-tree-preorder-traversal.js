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
var preorderTraversal = function(root) {
    if(!root) return [];
    
    let order = [];
    order.push(root.val);
    if(root.left) order = order.concat(preorderTraversal(root.left));
    if(root.right) order = order.concat(preorderTraversal(root.right));
    
    return order;
};