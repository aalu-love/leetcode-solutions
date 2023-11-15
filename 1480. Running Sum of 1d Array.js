/**
 * @param {number[]} nums
 * @return {number[]}
 */
var runningSum = function (nums, sum = 0) {
	return nums.map(x => x + sum);
};
