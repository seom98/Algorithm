const input = require('fs').readFileSync('/dev/stdin').toString().split('\n');

let input0 = Number(input[0]);
let arr = Array.from(Array(100), () => Array(100).fill(0))
let count = 0;
for (let i = 1; i <= input0; i++) {
    let square = input[i].split(" ").map(Number);
    for (let j = square[0]; j < square[0]+10; j++) {
        for (let k = square[1]; k < square[1]+10; k++) {
            if (arr[j][k]==0) {
                arr[j][k]++
            }
        }
    }
}
for (let i = 0; i < 100; i++) {
    for (let j = 0; j < 100; j++) {
        if (arr[i][j] == 1) {
            count++
        }
    }
}
console.log(count)
