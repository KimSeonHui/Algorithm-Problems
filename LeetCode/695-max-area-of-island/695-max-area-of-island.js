/**
 * @param {number[][]} grid
 * @return {number}
 */
var maxAreaOfIsland = function(grid) {
    let maxArea = 0;
    
    for(let i = 0; i < grid.length; i++) {
        for(let j = 0; j < grid[i].length; j++) {
            if(grid[i][j] === 1) {
                maxArea = Math.max(maxArea,  DFS(i, j, grid));
            }
        }
    }
    
    return maxArea;
};

function DFS(row, col, grid) {
    if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] !== 1) return 0;
        
    let count = 0;
    const countedIsland = 2;
        
    if(grid[row][col] !== countedIsland){
        grid[row][col] = countedIsland;
        count++;
    } 
        
    if(row > 0 && grid[row-1][col] === 1) count += DFS(row-1, col, grid);
        
    if(row+1 < grid.length && grid[row+1][col] === 1) count += DFS(row+1, col, grid); 
        
    if(col > 0 && grid[row][col-1] === 1) count += DFS(row, col-1, grid);
        
    if(col+1 < grid[0].length && grid[row][col+1] === 1) count += DFS(row, col+1, grid);
    
    return count;
}