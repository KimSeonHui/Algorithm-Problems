/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root1
 * @param {TreeNode} root2
 * @return {TreeNode}
 */
//DFS
var mergeTrees = function(root1, root2) {    
    if(!root1) return root2;
    if(!root2) return root1;
    
    const merge = root1;
    if(merge && root2) merge.val += root2.val;
    
    if(merge.left && root2.left) merge.left = mergeTrees(merge.left, root2.left);
    else if(!merge.left && root2.left) merge.left = root2.left;
    
    if(merge.right && root2.right) mergeTrees(merge.right, root2.right);
    else if(!merge.right && root2.right) merge.right = merge.right = root2.right;
    
    return merge;    
};

//BFS
// var mergeTrees = function(root1, root2) {    
//     if(root1 === null) return root2;
//     if(root2 === null) return root1;
    
//     const queue = [];
//     const merge = root1;
    
//     queue.push({v1 : merge, v2 : root2});
    
//     while(queue.length > 0) {
//         const {v1, v2} = queue.shift();
//         v1.val += v2.val;
    
//         if(v1.left && v2.left) queue.push({v1 : v1.left, v2 : v2.left});
//         if(!v1.left && v2.left) v1.left = v2.left;
        
//         if(v1.right && v2.right) queue.push({v1 : v1.right, v2 : v2.right});
//         if(!v1.right && v2.right) v1.right = v2.right;
//     }
    
//     return merge;
    
// };