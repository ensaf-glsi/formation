
const tab = [1, 4, 8, 10];
/*
for (let i = 0; i < tab.length; i++) {
    console.log(tab[i]);
}
*/

for (let e of tab) {
    console.log(e);
}

for (let e in tab) {
    console.log(e);
}

tab.forEach(v => {
    console.log(v);
});

tab.forEach((v, idx/*, t*/) => {
    console.log(`tab[${idx}] : ${v}`);
    // console.table(t)
});

const tabp2 = [];
tab.forEach(v => {
    tabp2.push(v * v);
});
console.table(tabp2);

/*
const puiss3 = v => {
    return Math.pow(v, 3);
}
*/
const puiss3 = v => Math.pow(v, 3);

const tabp3 = tab.map(puiss3); 
console.table(tabp3);

/*
const tabp3v2 = [];
tab.forEach(v => {
    tabp3v2.push(puiss3(v));
});
*/