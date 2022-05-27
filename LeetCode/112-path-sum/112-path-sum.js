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
 * @param {number} targetSum
 * @return {boolean}
 */
var hasPathSum = function(root, targetSum) {
    let hasPath = false;
    
    const dfs = (root, sum) => {
        if(!root) return 0;        
        
        sum += root.val;
        
        if(sum === targetSum && (root.left === null && root.right === null)) {
            hasPath = true;
        }
        
        if(root.left && !hasPath) dfs(root.left, sum);
        if(root.right && !hasPath) dfs(root.right, sum);
    }
    
    dfs(root, 0);
    return hasPath;

};