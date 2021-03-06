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
 * @param {number} val
 * @return {TreeNode}
 */
var insertIntoBST = function(root, val) { 
    if(root === null) return new TreeNode(val);
    
    if(root.val < val) {
        if(root.right) root.right =  insertIntoBST(root.right, val);
        else root.right = new TreeNode(val);
    } 
    if(val < root.val) {
        if(root.left) root.left = insertIntoBST(root.left, val);
        else root.left = new TreeNode(val);
    } 
        
    return root;
};

//다른 사람 풀이 - iterative
const insertIntoBST = (root, val) => {
  const Node = new TreeNode(val);
  let current = root;

  if (!root) return Node;

  while (current) {
    if (val < current.val) {
      if (!current.left) {
        current.left = Node;
        return root;
      }
      current = current.left;
	  

    } 
    else if (current.val < val) {
      if (!current.right) {
        current.right = Node;
        return root;
      }

      current = current.right;
    }
  }

  return root;
};
