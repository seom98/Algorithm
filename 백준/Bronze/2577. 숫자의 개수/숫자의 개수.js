function solution(input) {
    let input0 = String(input[0]*input[1]*input[2]);
    let number = input0.split('');
    let count = ''
    let cou = 0
    for (let i = 0; i <= 9; i++) {
        for (j of number) {
            if (i == j) {
                cou++
            }
        }
        count += `${cou}`
        if (i < 9) {count += `\n`}
        cou = 0
    }
    console.log(count)
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