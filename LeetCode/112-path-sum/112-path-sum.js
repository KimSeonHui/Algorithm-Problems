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
    if(root === null) return false;   
    
    const dfs = (root, sum) => {
        if(root === null) return false;
     
        if(!root.left && !root.right) {
            return targetSum === sum + root.val;
        }
        
        sum += root.val;
        
        return dfs(root.left, sum) || dfs(root.right, sum);
    }
    
    return dfs(root, 0);
};

// 다른 사람 풀이
var hasPathSum = function(root, targetSum) {
    return dfs(root, targetSum);
    // T.C: O(N)
    // S.C: O(H)
};

const dfs = (root, target) => {
    if (!root) {
        return false;
    }
    if (!root.left && !root.right) {
        return target - root.val === 0;
    }
    return dfs(root.left, target - root.val) || 
        dfs(root.right, target - root.val);
}
