class Person {
    constructor(firstName, lastName, birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
    }

    print() {
        /*
        console.log(`
            firstname : ${this.firstName}
            lastName : ${this.lastName}
            birthday : ${this.birthday}
        `);
        */
    //    const firstName = this.firstName;
    //    const lastName = this.lastName;
        const { firstName, lastName, birthday } = this;
        console.log(`
            firstname : ${firstName}
            lastName : ${lastName}
            birthday : ${birthday}
        `);

    }
}

const p = new Person('ahmed', 'janati', '12/10/2001');

p.print();