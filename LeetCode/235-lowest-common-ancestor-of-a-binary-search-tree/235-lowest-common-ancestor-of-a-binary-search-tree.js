/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */

/**
 * @param {TreeNode} root
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @return {TreeNode}
 */
// dfs - recursion
var lowestCommonAncestor = function(root, p, q) {
    if(!root) return root;
    
    let lca = root;
    
    if(p.val < root.val && q.val < root.val) lca = lowestCommonAncestor(root.left, p,q);
    else if(root.val < p.val && root.val < q.val)  lca = lowestCommonAncestor(root.right, p,q);
    else return root;
    
    return lca;
};

//다른 사람 풀이 - iterative
var lowestCommonAncestor = function(root, p, q) {
    while(true){
        if(p.val < root.val && q.val < root.val) root = root.left;

        else if(p.val > root.val && q.val > root.val) root = root.right;

        else return root;
    }
}
