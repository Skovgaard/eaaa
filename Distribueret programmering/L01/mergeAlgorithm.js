let numberList1 = [1, 3, 5, 7, 8];
let numberList2 = [2, 4, 6, 9];

let stringList1 = ["a", "c", "d"];
let stringList2 = ["b", "e", "f"];

console.log(mergeTwoLists(numberList1, numberList2));
console.log(mergeTwoLists(stringList1, stringList2));

function mergeTwoLists(list1, list2) {
    let result = [];

    let i1 = 0; i2 = 0;

    while (i1 < list1.length && i2 < list2.length) {
        if (list1[i1] <= list2[i2]) {
            result.push(list1[i1]);
            i1++;
        }
        else {
            result.push(list2[i2]);
            i2++;
        }
    }

    while (i1 < list1.length) {
        result.push(list1[i1]);
        i1++;
    }

    while (i2 < list2.length) {
        result.push(list2[i2]);
        i2++;
    }

    return result;
}