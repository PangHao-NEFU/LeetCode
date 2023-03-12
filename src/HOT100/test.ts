function test1(par: number): string
function test1(par:string):string
function test1(par: number | string): string {
    if (typeof par === 'number') {
        return String(par);
    }
    if (typeof par === 'string') {
        return par;
    }
}

console.log(test1(1));
console.log(test1("hello"));