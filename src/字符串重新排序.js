/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * 语句排序
 * @param text string字符串
 * @return string字符串
 */
function arrangeWords(text) {
	// write code here
	let arr = text.split(" ");
	arr.sort((a, b) => {
		if (a.length != b.length) return a.length - b.length;
		let len = Math.min(a.length, b.length);
		for (let i = 0; i < len; i++) {
			if (a[i] != b[i]) return a[i].charCodeAt(0) - b[i].charCodeAt(0);
		}
		return arr.indexOf(a) - arr.indexOf(b);
	});
	let ans = arr.map((s) => s.toLowerCase()).join(" ");
	ans = ans.charAt(0).toUpperCase() + ans.slice(1);
	// console.log("🚀 ~ file: snippet.js:15 ~ arrangeWords ~ ans:", ans);
	return ans;
}

module.exports = {
	arrangeWords: arrangeWords,
};
arrangeWords("Welcome to join the HundSun family");
