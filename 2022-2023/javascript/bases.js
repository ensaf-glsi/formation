//int x;
//int y = 12;

function variables() {
    var x;
    var y = 12;


    const a = 100; // number

    let b;
    let c = 'hello'; // string

    b = true; // boolean

    let e;

    b = undefined;

    console.log(typeof (a));
    console.log(typeof (b));
    console.log(typeof (c));
    console.log(typeof (e));

}
// variables

function objets() {
    let obj = {
        nom: "hanafi",
        age: 38
    }
    
    console.log('nom ? ', obj.nom);
    
    obj.age = 40;
    
    console.log('age ? ', obj.age)
    
    
    obj.prenom = 'zouhir';
    console.log('prenom ? ', obj.prenom);
}
// objets();
/*

*/


function tableau() {
    const tab = [];
    tab.push('v1'); // ajouter un elt a la fin
    tab.push(2);
    tab.push(true);
    
    console.table(tab);
    
    console.log(tab.pop()) // recupere et supprime le dernier element
    console.table(tab);
    
    console.log(tab.shift()); // recupere et supprime le premier element
    console.table(tab);
    tab.unshift('1er'); // ajouter un elt au debut de tableau
    console.table(tab);
}
// tableau();


// fonctions
function add(v1, v2) {
    return v1 + v2;
}

const f2 = function (v1, v2) {

}

const result = add(10, 12);
console.log(result);

const substract = (v1, v2) => { // arrow function
    return v1 - v2;
}