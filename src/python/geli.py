def read_and_sort(logname):
    map={}
    with open(logname,'r') as f:
        while True:
            line = f.readline()
            if  not  line  :
                break
            elog=line.strip()
            if not map.has(elog):
                map.set(elog, 1)
            else:
                map.set(elog, map.get(elog)+1)

        sorted_arr=sorted(map.items(),key=lambda x:x[1],reverse=False)
        result={}
        for s in sorted_arr:
            result.set[s[0]]=s[1]
        return result

if __name__ == '__main__':
    read_and_sort('run.log')
