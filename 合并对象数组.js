function mergeArray(arr1, arr2) {
	for (let i of arr1) {
		for (let j of arr2) {
			if (i.id === j.id) {
				i = Object.assign(i, j);
			}
		}
	}
	for (let j of arr2) {
		let flag = false;
		for (let k of arr1) {
			if (j.id === k.id) {
				flag = true;
			}
		}
		if (!flag) {
			arr1.push(JSON.parse(JSON.stringify(j)));
		}
	}
	return arr1.sort((a, b) => a.id - b.id);
}

let arr1 = [
	{ id: 1, name: "a" },
	{ id: 2, name: "b" },
	{ id: 3, name: "c" },
];
let arr2 = [{ id: 1, age: 19 }];
mergeArray(arr1, arr2);
