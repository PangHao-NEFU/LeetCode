const Pending = "pending";
const Fulfilled = "fullfilled";
const Rejected = "rejected";

class MyPromise {
	status = Pending;
	value: any;
  reason: any;
  //为了解决executer中异步resolve或者reject的情况
	onResolveCallbacks: Function[] = [];
  onRejectCallbacks: Function[] = [];
  
  constructor(executer: Function) {
    this.value = undefined
    this.reason=undefined
    const resolve = (data: any)=>{
      if (this.status == Pending) {
        this.status = Fulfilled
        this.value = data
        this.onResolveCallbacks.forEach((callbackfn)=>{callbackfn()})
      }
    }
    const reject = (reason: any)=>{
      if (this.status == Pending) {
        this.status = Rejected;
        this.reason = reason
        this.onRejectCallbacks.forEach((callbackfn)=>{callbackfn()})
      }
    }

    try {
      executer(resolve,reject)
    } catch(e) {
      reject(e)
    }
  }

  then(onResolve?: Function, onReject?: Function) {
		//1.解决值的穿透问题,如果没有传onResolve,onReject,需要给其一个初始值,就是拿到什么就返回什么
    onResolve = typeof onResolve == 'function' ? onResolve : (data) => data
    onReject =
      typeof onReject === "function" ? onReject : (err) => { throw err; };
    
    //2.每次调用.then返回一个新promise,并且.then中的回调是异步调用的
    let promise2 = new MyPromise((resolve, reject) => {
      //2.1 调用then时已经fulfilled
      if (this.status == Fulfilled) {
        queueMicrotask(() => {
          try {
            let rp = onResolve(this.value);
						if (rp instanceof MyPromise) {
							return rp;
						} else {
							resolve(rp);
						}
          } catch(e) {
            reject(e)
          }
            
        })
				
			}
      if (this.status == Rejected) {
        queueMicrotask(() => {
          try {
            let rp = onReject(this.reason);
						if (rp instanceof MyPromise) {
							return rp;
						} else {
							resolve(rp);
						}
          } catch (e) {
            reject(e)
          }
        })
				
			}
      if (this.status == Pending) {
        
				this.onResolveCallbacks.push(() => {
          queueMicrotask(() => {
            try {
              let rp = onResolve(this.value);
              if (rp instanceof MyPromise) {
                return rp
              } else {
                resolve(rp);
              }
            } catch (e) {
              reject(e)
            }
					});
        });
        
				this.onResolveCallbacks.push(() => {
          queueMicrotask(() => {
            try {
              let rp = onReject(this.reason);
							if (rp instanceof MyPromise) {
								return rp;
							} else {
								resolve(rp);
							}
            } catch (e) {
              reject(e)
            }
						
					});
				});
			}
    })

    return promise2
  }
  
}
