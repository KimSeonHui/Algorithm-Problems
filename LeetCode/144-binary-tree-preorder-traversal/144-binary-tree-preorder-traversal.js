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
    return traversal(root, []);
};

function traversal(root, order) {
    if(!root) return [];
    
    order.push(root.val);
    if(root.left) order =  traversal(root.left, order);
    if(root.right) order = traversal(root.right, order);
    
    return order;
}