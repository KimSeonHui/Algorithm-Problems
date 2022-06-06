/**
 * @param {number[][]} mat
 * @return {number[][]}
 */
// bfs
var updateMatrix = function(mat) {
    const queue = [];
    const dis = new Array(mat.length).fill().map(() => Array(mat[0].length));
    const direction = [[-1,0], [1,0], [0,-1], [0,1]];

    for(let i = 0; i < mat.length; i++) {
        for(let j = 0; j < mat[i].length; j++) {
            if(mat[i][j] === 0) {
                dis[i][j] = 0;
                queue.push([i, j]);
            }
            else dis[i][j] = -1;
        }
    }
    
    while(queue.length > 0) {
        const [row, col] = queue.shift();
        
        for(let [dx, dy] of direction) {
            const r = row + dx;
            const c = col + dy;
            
            if(r < 0 || r >= mat.length || c < 0 || c >= mat[0].length) continue;
            
            if(dis[r][c] === 0) continue;
            if(dis[r][c] === -1) {
                dis[r][c] = dis[row][col] + 1;
                queue.push([r,c]);
            }
        }
    }

    return dis;
};


