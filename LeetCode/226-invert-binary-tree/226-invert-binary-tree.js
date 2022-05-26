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
 * @return {TreeNode}
 */
//DFS
var invertTree = function(root) {
    if(!root) return root;
    
    return invert(root);  
};

function invert(root) {
    const temp = root.left;
    root.left = root.right;
    root.right = temp;
 
    if(root.left) invert(root.left);
    if(root.right) invert(root.right);
    
    return root;
}


//BFS
// var invertTree = function(root) {
//     let queue = [root];
    
    
//     while(queue.length > 0) {
//         const child = [];
        
//         for(const node of queue) {
//             if(!node) continue;
            
//             const temp = node.left;
//             node.left = node.right;
//             node.right = temp;
            
//             child.push(node.left);
//             child.push(node.right);
//         }
        
//         queue = child;
//     }
//     return root;
// };