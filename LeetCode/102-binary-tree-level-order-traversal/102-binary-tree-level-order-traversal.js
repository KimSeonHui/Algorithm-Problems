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
 * @return {number[][]}
 */
var levelOrder = function(root) {
    if(!root) return [];
    
    const order = [];
    const queue = [];
    let levelArr = [];
    let prevNode = {'root' : root, 'level' : 0};
    queue.push({'root' : root, 'level' : 0});
    
    while(queue.length > 0) {
        const node = queue.shift();
        if(prevNode.level !== node.level) {
            order.push(levelArr);
            levelArr = [];
        }
        
        if(node.root.left) queue.push({'root' : node.root.left, 'level' : node.level + 1});
        if(node.root.right) queue.push({'root' : node.root.right, 'level' : node.level + 1});
        levelArr.push(node.root.val);
        
        prevNode = node;
    }
    
    order.push(levelArr);   
    return order;
};