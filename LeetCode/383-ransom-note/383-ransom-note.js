/**
 * @param {string} ransomNote
 * @param {string} magazine
 * @return {boolean}
 */
var canConstruct = function(ransomNote, magazine) {
    const magazineWords = {};
    
    for(let ch of magazine) {
        magazineWords[ch] = (magazineWords[ch] || 0) + 1;
    }
    
    for(let i = 0; i < ransomNote.length; i++) {
        if(magazineWords[ransomNote[i]] === undefined) return false;
        if(magazineWords[ransomNote[i]] > 0) {
            magazineWords[ransomNote[i]]--;
        }
        else {
            return false;
        }
    }
    
    return true;
};