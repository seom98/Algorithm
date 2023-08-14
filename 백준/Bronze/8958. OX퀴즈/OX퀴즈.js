function solution(input) {
    let input0 = Number(input[0]);
    let result = ""
    let total = 0
    let count = 0
    for (let i = 1; i <= input0; i++) {
        let arr = input[i].split("");
        for (let j = 0; j < arr.length; j++) {
            if (arr[j] == "O") {
                count++
                total += count
            } else {
                count = 0
            }
        }
        console.log(total)
        total = 0
        count = 0
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