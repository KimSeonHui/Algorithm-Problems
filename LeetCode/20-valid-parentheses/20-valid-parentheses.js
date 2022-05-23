/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {
    if(s.length === 1) return false;
    
    const close = [];
    const stack = s.split('');
    const type = {'(' : 'small', ')' : 'small', 
                  '{' : 'medium', '}' : 'medium', 
                  '[' : 'large', ']' :'large'};
    
    while(stack.length > 0) {
        const bracket = stack.pop();
        
        if(bracket === ')' || bracket === ']' || bracket === '}' ) {
            close.push(bracket);
        }
        else {
            const closeBracket = close.pop();
            if(type[bracket] !== type[closeBracket]) return false;
        }
    }
    
    return close.length > 0 ? false : true;
};