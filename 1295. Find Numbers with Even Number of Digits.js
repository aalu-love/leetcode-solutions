/**
 * @param {number[]} nums
 * @return {number}
 */
var findNumbers = function(nums) {
    if(nums.length == 0){
        return 0;
    }
    let count = 0;
    for(let i of nums) {
        if(i.toString().length % 2 == 0) {
            count++;
        }
    }
    return count;
};