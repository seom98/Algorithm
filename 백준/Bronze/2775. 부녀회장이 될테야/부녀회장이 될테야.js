function solution(input) {
    let arr = Array.from(Array(16), () => new Array(16))
    arr[0].fill(1)
    for (let i = 0; i < 16; i++) {
        arr[i][0] = 1
    }
    for (let i = 1; i < 16; i++) {
        for (let j = 1; j < 16; j++) {
            arr[i][j] = arr[i-1][j] + arr[i][j-1]
        }
    }
    for (let i = 0; i < input[0]; i++) {
        console.log(arr[1+ Number(input[i * 2 + 1])][Number(input[i * 2 + 2])-1])
    }

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