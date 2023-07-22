function solution(input) {
    let num1 = Number(input[0]);
    let num2 = Number(input[1]);

    let a = num2 % 10
    let b = (num2 % 100 - a) / 10
    let c = (num2 - (num2 % 100)) / 100

    console.log(num1 * a)
    console.log(num1 * b)
    console.log(num1 * c)
    console.log(num1 * a + num1 * b * 10 + num1 * c * 100)
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