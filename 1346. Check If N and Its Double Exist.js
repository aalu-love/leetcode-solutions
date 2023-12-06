/**
 * @param {number[]} arr
 * @return {boolean}
 */
var checkIfExist = function (arr) {
  const hash = new Map();
  for (let i = 0; i < arr.length; i++) {
    hash.set(arr[i], i);
  }
  for (let j = 0; j < arr.length; j++) {
    if (hash.has(arr[j] * 2) && j !== hash.get(arr[j] * 2)) {
      return true;
    }
  }
  return false;
};
