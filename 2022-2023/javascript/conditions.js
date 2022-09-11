const x = 12;

if (x > 10) {
    console.log('x sup a 10');
}


if (x > 10) {
    console.log('x sup a 10');
} else {
    console.log('x inf a 10');
}

const note = 14;

if (x < 12) {
    console.log('passable');
} else if (x < 14) {
    console.log('ab');
} else if (x < 16) {
    console.log('bien');
} else {
    console.log('tres bien');
}

const expr = "Pommes";
switch (expr) {
    case "Oranges":
        console.log("Oranges : 0.59 € le kilo.");
        break;
    case "Pommes":
        console.log("Pommes : 0.32 € le kilo.");
        break;
    case "Bananes":
        console.log("Bananes : 0.48 € le kilo.");
        break;
    case "Cerises":
        console.log("Cerises : 3.00 € le kilo.");
        break;
    case "Mangues":
    case "Papayes":
        console.log("Mangues et papayes : 2.79 € le kilo.");
        break;
    default:
        console.log("Désolé, nous n'avons plus de " + expr + ".");
}


