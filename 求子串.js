let path = [];
let ans = new Set();

function childString(str, start) {
	if (str.length == 0) {
		return;
	}
	let current = path.join("");
	if (!ans.has(current) && path.length > 0) {
		// debugger;
		ans.add(current);
	}
	for (let i = start; i < str.length; i++) {
		if (path.length == 0 || path[path.length - 1] == str[i - 1]) {
			path.push(str[i]);
			childString(str, i + 1);
			path.pop();
		}
	}
}
childString("ABCD", 0);
console.log(ans);
