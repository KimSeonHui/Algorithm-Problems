/**
 * @param {number[][]} image
 * @param {number} sr
 * @param {number} sc
 * @param {number} newColor
 * @return {number[][]}
 */
var floodFill = function(image, sr, sc, newColor) {
    const connected = [[sr, sc]];
    const value = image[sr][sc];
    
    if(value === newColor) return image;
    
    while(connected.length > 0) {
        const [row, col] = connected.shift();
        
        if(image[row][col] !== newColor) image[row][col] = newColor;
        
        if(row > 0 && image[row-1][col] === value) connected.push([row-1, col]); 
        
        if(row+1 < image.length && image[row+1][col] === value) connected.push([row+1, col]); 
        
        if(col > 0 && image[row][col-1] === value) connected.push([row, col-1]); 
        
        if(col+1 < image[0].length && image[row][col+1] === value) connected.push([row, col+1]); 
    }
    
    return image;
};




