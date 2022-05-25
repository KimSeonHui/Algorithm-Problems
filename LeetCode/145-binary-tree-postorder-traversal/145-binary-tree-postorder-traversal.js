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
var postorderTraversal = function(root) {
    return post(root, []);
};

function post(root, order) {
    if(!root) return [];
    
    if(root.left) post(root.left, order);
    if(root.right) post(root.right, order);
    order.push(root.val);
    
    return order;
}

// 다른 사람 풀이
var postorderTraversal = function(root) {
    if (!root) return [];
    let ans = [];
    let traverse = node => {
        if (node.left) traverse(node.left)
        if (node.right) traverse(node.right)
        ans.push(node.val)
    }

    traverse(root);
    return ans;
};
