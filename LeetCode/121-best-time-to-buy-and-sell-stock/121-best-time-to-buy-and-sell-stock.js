/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
    let maxProfit = 0;
    let buy = 0;
    let sell = 1;
    
    while(sell < prices.length) {
        let profit = prices[sell] - prices[buy];
        maxProfit = Math.max(maxProfit, profit);
        if(profit < 0) buy = sell;
        sell++;
    }
    
    return maxProfit;
};