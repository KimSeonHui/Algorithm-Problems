
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
    if(this.front.length === 0) this.front.push(x);
    else this.rear.push(x);
    this.size++;
};

/**
 * @return {number}
 */
MyQueue.prototype.pop = function() {
    if(this.front.length > 0 ) {
        const ele = this.front.pop();
        
        if(this.front.length === 0 && this.rear.length > 0) {
            this.front.push(this.rear[0]);
            
            for(let i = 0; i < this.rear.length; i++) {
                if(i !== this.rear.length - 1) this.rear[i] = this.rear[i+1];
                else this.rear.pop();
            }
        }
        
        this.size--;
        
        return ele;
    }
    else return undefined;
};

/**
 * @return {number}
 */
MyQueue.prototype.peek = function() {
    if(this.front.length > 0) return this.front[0];
    else return undefined;
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