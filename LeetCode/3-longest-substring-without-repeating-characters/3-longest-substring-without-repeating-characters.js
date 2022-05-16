/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {
    let str = '';
    let maxLength = 0;
    
    for(let i = 0; i < s.length; i++) {
        const ch = s[i];
        if(!str.includes(ch)) {
            maxLength = Math.max(maxLength, (str + ch).length);
            str += ch;
        }
        else{
            const index = str.indexOf(ch);
            str =  str.slice(index+1) + ch;
        }
    }
    
    return maxLength;    
};

//sliding window solution
// var lengthOfLongestSubstring = function(s) {
//     const hash = {};
//     let maxLength = 0;
//     let start = 0;
//     let end = 0;
    
//     while(end < s.length) {
//         if(hash[s[end]] === undefined) {
//             hash[s[end]] = end;
//         }
//         else {     
//             start = Math.max(hash[s[end]] + 1, start);
//             hash[s[end]] = end;
//         }
//         maxLength = Math.max(maxLength, end - start + 1);
//         end++;
//     }
    
//     return maxLength;    
// };