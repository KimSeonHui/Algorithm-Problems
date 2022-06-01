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
 * @param {number} k
 * @return {boolean}
 */
var findTarget = function(root, k) {
    const set = new Set();
    
    const find = (root, set, k) => {
        if(root === null) return false;

        if(set.has(root.val)) return true;
        set.add(k - root.val);
        
        return find(root.left, set, k) || find(root.right, set, k);
    }
    
    return find(root, set, k);
};