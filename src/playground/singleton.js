class MyClass{
  static instance;
  constructor() {
    //类上没有这个单例就创建
    if (!MyClass.instance) {
      MyClass.instance=this
    }
    return MyClass.instance
  }
}

let myClass = new MyClass()
let instance = new MyClass()
console.log(myClass === instance)
// MyClass.prototype.constructor.hello = 'hello'
// console.log(MyClass.hello===MyClass.prototype.constructor.hello)
console.log(myClass.constructor === MyClass)


// function hello() {
//   return {hello: 'world'}
// } 
// console.log(new hello())