
var MyQueue = function() {
    this.front = [];
    this.rear = [];
    this.size = 0;
};

/** 
 * @param {number} x
 * @return {void}
 */
MyQueue.prototype.push = function(x) {
    this.rear.push(x);
    this.size++;
};

/**
 * @return {number}
 */
MyQueue.prototype.pop = function() {
    if(this.front.length === 0) {
        while(this.rear.length > 0) {
            this.front.push(this.rear.pop());
        }
    }

    this.size--;
        
    return this.front.pop();
};

/**
 * @return {number}
 */
MyQueue.prototype.peek = function() {
    if(this.front.length > 0) return this.front[this.front.length - 1];
    else return this.rear[0];
};

/**
 * @return {boolean}
 */
MyQueue.prototype.empty = function() {
    return this.size === 0;
};


//다른 사람 풀이
function MyQueue() {
  const stack1 = [], stack2 = [];
  return {
    push: (val) => stack1.push(val),
    pop: () => {
      if (!stack2.length) {
        while (stack1.length) stack2.push(stack1.pop())
      }
      return stack2.pop()
    },
    peek: ()=> stack2.length ? stack2[stack2.length - 1] : stack1[0],
    empty: ()=> !stack1.length && !stack2.length
  }
}
/** 
 * Your MyQueue object will be instantiated and called as such:
 * var obj = new MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */
