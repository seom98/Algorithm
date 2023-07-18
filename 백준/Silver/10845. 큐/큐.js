const input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');

// push X: 정수 X를 큐에 넣는 연산이다.
// pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
// size: 큐에 들어있는 정수의 개수를 출력한다.
// empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
// front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
// back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.

let arr = []
let ans = ""
for (i = 1; i <= input[0]; i++) {
    let case0 = input[i]
    switch (case0) {
        case "pop":
            if (arr.length === 0) { ans += `-1\n` }
            else { ans += `${arr[0]}\n`; arr.shift() }
            break;
        case "size":
            ans += `${arr.length}\n`
            break;
        case "empty":
            if (arr.length === 0) { ans += `1\n` }
            else { ans += `0\n` }
            break;
        case "front":
            if (arr.length === 0) { ans += `-1\n` }
            else { ans += `${arr[0]}\n` }
            break;
        case "back":
            if (arr.length === 0) { ans += `-1\n` }
            else { ans += `${arr[arr.length - 1]}\n` }
            break;
        default:
            arr.push(case0.split(" ")[1])
            break;
    }
}
console.log(ans)