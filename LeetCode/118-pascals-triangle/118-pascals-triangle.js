/**
 * @param {number} numRows
 * @return {number[][]}
 */
var generate = function(numRows) {
    const arr = [];
    const pascal = new Array(numRows);
    
    for(let i = 1; i <= numRows; i++) {
        pascal[i-1] = new Array(i);
    }
    
   
    for(let i = 0; i < numRows; i++) {
        for(let j = 0; j < pascal[i].length; j++) {
            if(j == 0 || j == pascal[i].length -1) {
                arr.push(1);
                pascal[i][j] = 1;  
            }
            else {
                pascal[i][j] = calculatePascal(i+1, arr);
                arr.push(pascal[i][j]);
            }
        }
    }
    
    return pascal;
};

function calculatePascal(row, arr) { 
    return arr[arr.length-(row-1)] + arr[arr.length-row];
}