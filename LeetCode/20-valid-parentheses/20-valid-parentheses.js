/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {
    if(s.length === 1) return false;
    
    const stack = [];
    const type = {')' : '(',  
                  '}' : '{', 
                  ']' : '['};
    
    for(let ch of s) {        
        if(type[ch]) {
            if(stack.length > 0 && type[ch] === stack[stack.length - 1]) stack.pop();
            else return false;
        }
        else {
            stack.push(ch);
        }
    }
    
    return stack.length > 0 ? false : true;
};