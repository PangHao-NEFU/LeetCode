let i = "[1, [2, [3, 4]]]";
let ans = JSON.parse(i);
console.log(ans, typeof ans);
function flat(arr) {
	let ans = [];
	for (let i of arr) {
		if (Array.isArray(i)) {
			ans.push(...flat(i));
		} else {
			ans.push(i);
		}
	}
	return ans;
}
console.log(flat(ans));
