/**
 * @param {character[][]} board
 * @return {boolean}
 */
var isValidSudoku = function(board) {
    const size = 9;
    
    const box = {};
    for(let i = 0; i < size; i++) {
        const row = {};
        const col = {};
        for(let j = 0; j < size; j++) {
            //check column
            if(board[i][j] !== '.') {
                if(col[board[i][j]] !== undefined) return false;
                col[board[i][j]] = 1;
                
                if(box[[Math.floor(i/3), Math.floor(j/3)]] !== undefined) {
                    if(box[[Math.floor(i/3), Math.floor(j/3)]].includes(board[i][j])) {
                        console.log(box);
                        return false;
                    }
                    else box[[Math.floor(i/3), Math.floor(j/3)]].push(board[i][j]);
                }
                else {
                    box[[Math.floor(i/3), Math.floor(j/3)]] = [board[i][j]];
                }
            }
            //check row
            if(board[j][i] !== '.') {
                if(row[board[j][i]] !== undefined) return false;
                row[board[j][i]] = 1;
            }         
        }
    }
    
    return true;
};
