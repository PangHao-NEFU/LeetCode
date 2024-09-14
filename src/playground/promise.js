const asyncf = async () => {
	return new Promise((resolve, reject) => {
		setTimeout(() => {
			resolve(1);
		}, 5000);
	});
};

async function test() {
	for (let i = 0; i < 10; i++) {
		console.log("haha");
		await asyncf();
		console.log(i);
	}
}
test();
