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
 * @return {boolean}
 */
var isSymmetric = function(root) {
    const left = getLeftTree(root.left, []);
    const right = getRightTree(root.right, []);

    if(JSON.stringify(left) === JSON.stringify(right)) return true;
    else return false;
};

const getLeftTree = (root, leftTree) => {
    if(!root) return [];

    leftTree.push(root.val);

    if(root.left) leftTree = getLeftTree(root.left, leftTree);
    if(!root.left) leftTree.push(null);
    if(root.right) leftTree = getLeftTree(root.right, leftTree);
    if(!root.right) leftTree.push(null);

    return leftTree;
}

const getRightTree = (root, rightTree) => {
    if(!root) return [];

    rightTree.push(root.val);

    if(root.right) rightTree = getRightTree(root.right, rightTree);
    if(!root.right) rightTree.push(null);
    if(root.left) rightTree = getRightTree(root.left, rightTree);
    if(!root.left) rightTree.push(null);

    return rightTree;
}
