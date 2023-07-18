const input = require("fs").readFileSync("/dev/stdin").toString().trim().split(" ").map(Number);

let x = input[0]
let y = input[1]
let w = input[2]
let h = input[3]

console.log(Math.min(w - x, x, h - y, y))