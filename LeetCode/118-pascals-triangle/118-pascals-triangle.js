/**
 * @param {number} numRows
 * @return {number[][]}
 */
var generate = function(numRows) {
    const arr = [];
    const pascal = [];
    let index = 0;
   
    for(let i = 1; i <= numRows; i++) {
        const row = [];
        for(let j = 0; j < i; j++) {
            if(j == 0 || j == i -1) {
                arr.push(1);
                row.push(1);  
            }
            else {
                arr.push(calculatePascal(index-i, index-i+1, arr));
                row.push(arr[index]);
            }
            index++;
        }
        pascal.push(row);
    }
    
    return pascal;
};

function calculatePascal(left, right, arr) { 
    return arr[left] + arr[right];
}