/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
    if(s.length !== t.length) return false;
    
    const arr1 = [];
    const arr2 = [];
    
    for(let i = 0; i < s.length; i++) {
        arr1.push(s[i]);
        arr2.push(t[i]);
    }
    
    arr1.sort();
    arr2.sort();
    
    if(arr1.toString() === arr2.toString()) return true;
    else return false;
};