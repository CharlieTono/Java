console.log("Hello world!");
let name = "AA";

let lastName = "BB";

let isSomething = true;
isSomething = false;

function fullName(name, lastName) {
    return name + " " + lastName;
}

console.log(fullName(name, lastName));

let sum = function (x, y) {
    return x + y;
}

let anotherFunc = sum;
anotherFunc(2,5);



