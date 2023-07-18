const input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');
let arr = []
let ans = ""
for (i = 1; i <= input[0]; i++) {
    let case0 = input[i]
    switch (case0) {
        case "pop":
            if (arr.length === 0) { ans += `-1\n` }
            else { ans += `${arr[arr.length - 1]}\n`; arr.pop() }
            break;
        case "size":
            ans += `${arr.length}\n`
            break;
        case "empty":
            if (arr.length === 0) { ans += `1\n` }
            else { ans += `0\n` }
            break;
        case "top":
            if (arr.length === 0) { ans += `-1\n` }
            else { ans += `${arr[arr.length - 1]}\n` }
            break;
        default:
            arr.push(case0.split(" ")[1])
            break;
    }
}
console.log(ans)