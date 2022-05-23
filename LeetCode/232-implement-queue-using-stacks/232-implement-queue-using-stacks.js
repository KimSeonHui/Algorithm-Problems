
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

/** 
 * Your MyQueue object will be instantiated and called as such:
 * var obj = new MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */