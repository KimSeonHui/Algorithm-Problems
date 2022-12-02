/**
 * @param {character[][]} board
 * @return {boolean}
 */
var isValidSudoku = function(board) {
    const size = 9;
    
    const hash = {};
    for(let i = 0; i < size; i++) {
        for(let j = 0; j < size; j++) {
            if(board[i][j] !== '.') {
                const boxNum = calculateBox(i, j);
                if(hash[board[i][j]] === undefined) {
                    hash[board[i][j]] = [[i, j, boxNum]];
                }
                else {
                    for(let k = 0; k < hash[board[i][j]].length; k++) {
                        const [row, col, box] = hash[board[i][j]][k];
                        if(row === i || col === j) return false;
                        else if(box === boxNum) return false;
                    }
                    hash[board[i][j]].push([i, j, boxNum]);
                }
            }
        }
    }
    
    return true;
    
};

function calculateBox(row, col) {
    return Math.floor(row/3) * 3 + Math.floor(col/3);
}
