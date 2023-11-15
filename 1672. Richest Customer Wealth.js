/**
 * @param {number[][]} accounts
 * @return {number}
 */
var maximumWealth = function (accounts) {
	let maxWealth = 0;
	for (let c of accounts) {
		let currentC = 0;
		for (let i of c) {
			currentC = currentC + i;
			maxWealth = Math.max(currentC, maxWealth);
		}
	}
	return maxWealth;
};
