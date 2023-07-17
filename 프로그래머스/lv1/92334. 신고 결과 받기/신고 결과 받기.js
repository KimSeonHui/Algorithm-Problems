function solution(id_list, report, k) {
    var answer = [];
    const data = {};
    report = [...new Set(report)];
    
    for(let i = 0; i < id_list.length; i++) {
        answer[i] = 0;
        data[id_list[i]] = [];
    }
    
    report.map((val) => {
        let user = val.split(' ')[0];
        let reported = val.split(' ')[1];
        
        data[reported].push(user);
    })
    
    // console.log('data', data)

    Object.entries(data).forEach((val) => {
        if(val[1].length >= k) {
           for(let i = 0; i < val[1].length; i++) {
               answer[id_list.indexOf(val[1][i])]++;
           }
            
        }
    })

     
    return answer;
}