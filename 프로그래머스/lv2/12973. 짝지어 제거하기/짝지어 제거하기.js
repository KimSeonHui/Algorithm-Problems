function solution(s)
{
    const str = [];
    for(let ch of s) {
        if(str.length === 0 || str[str.length-1] !== ch) {
            str.push(ch);
        }
        else if(str[str.length-1] === ch) str.pop();
    }
    return str.length === 0 ? 1 : 0;
}