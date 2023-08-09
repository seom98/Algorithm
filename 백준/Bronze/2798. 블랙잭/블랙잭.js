function solution(input) {
    let input0 = input[0].split(" ").map(Number)
    let num = input0[0];
    let total = input0[1]
    let arr = input[1].split(" ").map(Number).sort((a,b)=>b-a);
    let ans = 0
    for (let i = 0; i < num-2; i++) {
        for (let j = i+1; j < num-1; j++) {
            for (let k = j+1; k < num; k++) {
                if (arr[i]+arr[j]+arr[k] <= total && ans < arr[i]+arr[j]+arr[k]) {
                    ans = arr[i]+arr[j]+arr[k]
                }
            }
        }
    }
    console.log(ans)
}

const readline = require("readline")

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
})

let input = []

rl.on("line", (line) => {
    if (!line) {
        rl.close()
    } else {
        input.push(line)
    }
}).on("close", () => {
    solution(input)
    process.exit()
})