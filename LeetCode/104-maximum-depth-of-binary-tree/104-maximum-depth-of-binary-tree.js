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
 * @return {number}
 */
//DFS
var maxDepth = function(root) {
    if(!root) return 0;
    
    let depth = 1;
    let leftDepth = 0;
    let rightDepth = 0;
    
    if(root.left) leftDepth = maxDepth(root.left);
    if(root.right) rightDepth = maxDepth(root.right);
    
    return depth + Math.max(leftDepth, rightDepth);
 };



//BFS - level order traversal
// var maxDepth = function(root) {
//     if(!root) return 0;
//     let depth = 0;
//     let queue = [root];
    
//     while(queue.length > 0) {
//         const children = [];
        
//         for(const node of queue) {
//             if(!node) continue;
//             children.push(node.left);
//             children.push(node.right);
//         }
        
//         if(children.length > 0) {
//             depth++;
//         }
//         queue = children;
//     }
//     return depth;    
//  };