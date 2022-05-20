/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} list1
 * @param {ListNode} list2
 * @return {ListNode}
 */
var mergeTwoLists = function(list1, list2) {
    if(!list1) return list2;
    if(!list2) return list1;
    
    let l1 = list1;
    let l2 = list2;
    
    while(l1 !== null && l2 !== null) {
        if(l1.val < l2.val) {
            const temp = l1.next;
            if(temp !== null) l1.next = (temp.val < l2.val) ? temp : l2;
            else l1.next = l2;
            
            l1 = temp;
        }
        else {
            const temp = l2.next;
            if(temp !== null) l2.next = (temp.val <= l1.val) ? temp : l1;
            else l2.next = l1;

            l2 = temp;
        }
    }
    
   return list1.val < list2.val ? list1 : list2;
};





















// var mergeTwoLists = function(list1, list2) {
//     if(list1 === null) return list2;
//     else if(list2 === null) return list1;
    
//     while(list1 !== null && list2 !== null) {
//         if(list1.val < list2.val) {
//             list1.next =  mergeTwoLists(list1.next, list2);
            
//             return list1;
//         }
//         else {
//             list2.next =  mergeTwoLists(list1, list2.next);
            
//             return list2;
//         }
//     }
    
   
// };