/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function (nums) {
  let temp = [];
  for (let i of nums) {
    if (!temp.includes(i)) {
      temp.push(i);
    }
  }
  for (let i = 0; i < temp.length; i++) {
    nums[i] = temp[i];
  }
  return temp.length;
};
