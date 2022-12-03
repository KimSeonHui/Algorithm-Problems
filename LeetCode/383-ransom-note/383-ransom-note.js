/**
 * @param {string} ransomNote
 * @param {string} magazine
 * @return {boolean}
 */
var canConstruct = function(ransomNote, magazine) {    
    for(let note of ransomNote) {
        const index = magazine.indexOf(note);
        if(index !== -1) {
            magazine = magazine.slice(0, index) + magazine.slice(index+1);  
        }
        else return false;
    }
    
    return true;
};