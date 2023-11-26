/**
 * @param {number[]} nums
 * @param {number} val
 * @return {number}
 */
var removeElement = function (nums, val) {
  let newarr = [];
  for (let i of nums) {
    if (i != val) {
      newarr.push(i);
    }
  }
  for (let a in newarr) {
    nums[a] = newarr[a];
  }
  return newarr.length;
};
