/**
 * @param {number[][]} mat
 * @param {number} r
 * @param {number} c
 * @return {number[][]}
 */
var matrixReshape = function(mat, r, c) {
    if(r*c !== mat.length * mat[0].length) return mat;
    
    const reshape = new Array(r);
    for(let i = 0; i < r; i++) {
        reshape[i] = new Array(c);
    }
    
    let row = 0; 
    let col = 0;
    for(let i = 0; i < mat.length; i++) {
        for(let j = 0; j < mat[0].length; j++) {
            if(col >= c) {
                row++;
                col = 0;
            }
            reshape[row][col] = mat[i][j];
            col++;
        }
    }
    
    return reshape;
};