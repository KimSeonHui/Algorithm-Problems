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
    const addSum = (root, sum) => {
        if(!root) return false;
        
        sum += root.val;
        if(!root.left && !root.right)  {
            return sum === targetSum;
        }

        return addSum(root.left, sum) || addSum(root.right, sum);
    }

    return addSum(root, 0);
};
