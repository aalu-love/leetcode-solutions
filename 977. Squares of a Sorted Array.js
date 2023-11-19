/**
 * @param {number[]} nums
 * @return {number[]}
 */
var sortedSquares = function (nums) {
	const res = new Array(nums.length);
	let l = 0,
		r = nums.length - 1;

	for (let i = nums.length - 1; i >= 0; i--) {
		if (Math.abs(nums[l]) < Math.abs(nums[r])) {
			res[i] = nums[r] ** 2;
			r--;
		} else {
			res[i] = nums[l] ** 2;
			l++;
		}
	}
	return res;
};
