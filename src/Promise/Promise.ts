const Pending = "pending";
const Fulfilled = "fullfilled";
const Rejected = "rejected";

class MyPromise{
  value: any
  status: string
  reason: any

  onFulfilledCallbacks:Function[]
  onRejectedCallbacks: Function[]
 

  constructor(excecutor: (resolve: Function, reject: Function) => void) {
    this.value = undefined;
    this.reason = undefined;
    this.status = Pending;
    this.onFulfilledCallbacks= [] as Function[]
    this.onRejectedCallbacks = [] as Function[]
    
    const resolve = (data:any) => {
      if (this.status === Pending) {
        this.status = Fulfilled;
        this.value = data;
        this.onFulfilledCallbacks.forEach(fn => fn());
      }
    }

    const reject = (reason:any) => {
      if (this.status === Pending) {
        this.status = Rejected;
        this.reason = reason;
        this.onRejectedCallbacks.forEach(fn => fn());
      }
    }

    try {
      excecutor(resolve, reject);
    } catch (e) {
      reject(e);
    }
  }

  then(onFulfilled: Function, onRejected: Function) {
    //值的穿透处理,当一个then没有处理,还可以在接下来的.then中处理
    if (typeof onFulfilled !== 'function') {
      onFulfilled = (value:any) => value;
    }
    if (typeof onRejected !== "function") {
      onRejected=(reason:any)=>{throw reason}
    }

    //核心:返回一个新的promise对象
    let promise2 = new MyPromise((resolve, reject) => {

      if (this.status == Fulfilled) {
        //then的回调在微任务队列中执行
        queueMicrotask(() => {
          try {
            let res = onFulfilled(this.value);
            //返回的可能是promise
            if (res instanceof MyPromise) {
              res.then((data)=>resolve(data), (reason)=>reject(reason))
            }else  resolve(res)
          } catch (e) {
            reject(e)
          }
        })
      }
      

      if (this.status == Pending) {
        this.onFulfilledCallbacks.push(() => {
          queueMicrotask(() => {
            try {
              let x = onFulfilled(this.value)
              if(x instanceof MyPromise){
                x.then((data)=>resolve(data), (reason)=>reject(reason))
              }else
              resolve(x)
            } catch (e) { 
              reject(e)
            }

          })
        })

        this.onRejectedCallbacks.push(() => {
          queueMicrotask(() => {
            try {
              let y = onRejected(this.reason)
              //同上面一样的逻辑,就不重复写了
              resolve(y)
            
            } catch (e) {
              reject(e)
            }

          })
        })
      }
    })
      
      
    return promise2;
  }
}


Promise.resolve(3).then(() => {
  return new Promise((resolve, reject) => {
    resolve(5)
  })
}).then((data)=>console.log(data))