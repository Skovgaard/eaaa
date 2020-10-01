// Udskriv en liste over studerende i en fiktiv klasseliste – hentet i Outlook. 
// For hver studerende skal deres navn og e-mail vises. Tag udgangspunkt i opgave9.3.js 
// og løs opgaven med brug af RegExp og exec() metoden.

const outlook = "Anders Jensen (EAAAANJE) <eaaaanje@students.eaax.dk>; Bodil Pedersen (EAAABOPE) <eaaabope@students.eaax.dk>; Åse Andersen (EAAAIDAN) <eaaaasan@students.eaax.dk>; Mühl Svendsen (EAAAPESV) <eaaamusv@students.eaax.dk>";

// const regexp = /\p{Letter}+\s\p{Letter}+|<(.*?)>/gui;
const regexp = /\p{Letter}+\s\p{Letter}+|\p{Letter}+@\p{Letter}+\.eaax.dk/gui;

let matched;
while ((matched = regexp.exec(outlook)) !== null) {
    console.log(matched[0]);
}