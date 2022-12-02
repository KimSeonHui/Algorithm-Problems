/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var searchMatrix = function(matrix, target) {    
    for(let i = 0; i < matrix.length; i++) {
        let j = matrix[i].length-1;
        while(j >= 0) {
            if(matrix[i][j] === target) return true;
            else if(matrix[i][j] < target) break;
            j--;
        }
        if(j < matrix[i].length-1) return false;
    }
    return false;
};
