function solution(input) {
	let number = Number(input);
    let count = 1
    let d = 0
    for (i = 0; i < number; i++) {
        d += count
        count++
    }
    console.log(d)
};

const readline = require("readline")

const rl = readline.createInterface({ 
  input: process.stdin, 
  output: process.stdout 
})

rl.on("line", (line) => { 
  input = line 
  rl.close() 
}).on("close", () => { 
  solution(input) 
  process.exit() 
})