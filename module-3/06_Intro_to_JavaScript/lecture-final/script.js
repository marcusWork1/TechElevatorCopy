/*
    Example of a multi-line comment just like in C#/Java
*/

// Single line comment - like in Java/C#

/**
 * Functions start with the word function.
 * They don't have a return type and the naming convention is camel-case.
 */
function variables() {
  // Declares a variable where the value cannot be changed
  const DAYS_PER_WEEK = 7;

  /* console.log() is the JavaScript version of System.out.println() in Java
  
    1. Enclose what you want to display in back-ticks (`)
    2. Put any variables to be displayed in ${variable-name}

    Semi-colons at end of a statement are optional in JavaScript
  */

  console.log(`There are ${DAYS_PER_WEEK} days in a week`)
  
  // Declares a variable those value can be changed
  let days_per_month = 31;

  console.log(`Number of days per month: ${days_per_month}`)

  days_per_month = 30;

  console.log(`Number of days per month: ${days_per_month}`)

  // Declares a variable that will always be an array
  // To declare an array in JavaScript code name= []

  const WEEKDAYS = [
                    "Monday",
                    "Tuesday",
                    "Wednesday",
                    "Thursday",
                    "Friday",
                    "Saturday",
                    "Sunday"
  ]

  console.log(`The days of the week are: ${WEEKDAYS}`)
  console.table(WEEKDAYS)  // display an array as a table
}

/**
 * Functions can also accept parameters just like Java functins
 * Notice the parameters do not have types.
 * @param {Number} param1 The first number to display
 * @param {Number} param2 The second number to display
 */
function printParameters(param1, param2) {
  console.log(`The value of param1 is ${param1}`);
  console.log(`The value of param2 is ${param2}`);
}

/**
 * Compares two values x and y.
 * == is loose equality   - the values match, datatypes may differ
 * === is strict equality - the values match and datatypes match
 * 
 * 1 ==  '1'  - true  - both represent a value of 1
 * 1 === '1'  - false - values match, different types (numeric === string)
 * 1 == 'one' - false - values differ  
 *
 * @param is JavaDoc to tell it something is a parameter and it's type
 *  
 * @param {Object} x
 * @param {Object} y
 */
function equality(x, y) {
  // typeof operator returns the type of the data in the variable
  console.log(`x is ${typeof x}`);
  console.log(`y is ${typeof y}`);

  console.log(`x == y  : ${x == y}`);  // true if values match
  console.log(`x === y : ${x === y}`); // false if either values or datatypes differ
}

/**
 * Each value is inherently truthy or falsy.
 * 
 * Every value in JavaScript will be true or false when used in a condition
 * 
 * false, 0, '', null, undefined, and NaN are always false
 * everything else is always true
 * 
 * @param {Object} x The object to check for truthy or falsy,
 */
function falsy(x) {
  if (x) {   // if the x is truthy...
    console.log(`${x} is truthy`); // display its truthy
  } else {                         // otherwise
    console.log(`${x} is falsy`);  // display its falsy
  }
  // if you want to check equality: ==   or  === NOT =
  // Potential hard to troubleshoot coding error
  if(x = 1) {  // assignment inside if is valid in JavaScript
    console.log(`${x} is equal to 1`)
  }
  else{
    console.log`${x} is not equal to 1`  
  }
}

/**
 * JavaScript Objects ARE NOT the same as Java Objects
 *  
 * In JavaScript an object is a collection of data items
 * In Java and object is an instance of class containing 
 *                                   related data and methods
 * 
 * Objects are simple key-value pairs (like a Map in Java)
    - values can be primitive data types
    - values can be arrays
    - or they can be functions

    JSON - JavaScript Object Notation

    JavaScript objects and JSON are very similar 
                                   (JSON does not allow functions)
    JavaScript object values are enclosed in {}
    Each item in the object is defined:   name : value
    Multiple items in a JavaScript object are separated by commas
*/
function objects() {
  const person = {        // Start of JavaScript object
    firstName: "Bill",    // a variable/attribute in the object
    lastName: "Lumbergh",
    age: 42,
    employees: [          // an array can embedded in a JavaScript objects
      "Peter Gibbons",
      "Milton Waddams",
      "Samir Nagheenanajar",
      "Michael Bolton"
    ],
    laura : function() {  // a function in a JavaScript:  function-name : function {}
      // this.  references the current object (like this. in a Java class)
      return `${this.lastName}, ${this.firstName}, ${this.age}`
      // `` are used to Stringify variables like .format() in Java
    }
  };                      // End of JavaScript object

  // Log the object
  console.log(person);
  console.table(person);
  console.log(person.laura())  // call the function in the object 
                               //     & display what it returns

  // to access individual values in an object:  objectName.variable-name
  // Log the first and last name
  console.log(`The person's first name: ${person.firstName} last name: ${person.lastName}`)

  // Log each employee
  // Loop through the employee array in the person object
  // We us a for-loop just like in Java
  //
  // for(let i=0; i < array.length; i++ )

  for(let i=0; i < person.employees.length; i++){
    console.log(`Employee #${i+1}: ${person.employees[i]}`)
  }

}

/*
########################
Function Overloading
########################

Function Overloading is not available in Javascript. If you declare a
function with the same name, more than one time in a script file, the
earlier ones are overriden and the most recent one will be used.

The last function with same name is the one JavaScript uses
*/

function Add(num1, num2) {
  return num1 + num2;
}
// This version of Add replaces any earlier versions
function Add(num1, num2, num3) {
  return num1 + num2 + num3;
}

/*
########################
Math Library
########################

A built-in `Math` object has properties and methods for mathematical constants and functions.
*/

function mathFunctions() {
  console.log("Math.PI : " + Math.PI);
  console.log("Math.LOG10E : " + Math.LOG10E);
  console.log("Math.abs(-10) : " + Math.abs(-10));
  console.log("Math.floor(1.99) : " + Math.floor(1.99));
  console.log("Math.ceil(1.01) : " + Math.ceil(1.01));
  console.log("Math.random() : " + Math.random());
  console.log("Math.round(19.9993) : " + Math.round(19.9993));
}

/*
########################
String Methods
########################

The string data type has a lot of properties and methods similar to strings in Java/C#
*/

function stringFunctions(value) {
  console.log(`.length -  ${value.length}`);
  console.log(`.endsWith('World') - ${value.endsWith("World")}`);
  console.log(`.startsWith('Hello') - ${value.startsWith("Hello")}`);
  console.log(`.indexOf('Hello') - ${value.indexOf("Hello")}`);
  console.log(`.substring(2,3) - ${value.substring(2,3)}`) // substring(start, end) - like Java substring
                                                           //    return from start up to but not including the end
  console.log(`.substr(2,3)  - ${value.substr(2,3)}`)      // substr(start, length)
                                                           //    return from start for the length
  /*
    Other Methods
        - split(string)
        - substr(number, number)
        - substring(number, number)
        - toLowerCase()
        - trim()
        - https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String
    */
}  // End of String functions

  /*
  ########################
  Array Processing Examples
  ########################

  JavaScript has some great array processing functions
  */
  function arrayFunctions() {

    let stooges = ["Moe", "Larry", "Curly"]
    
    console.table(stooges)

    stooges.push("Shemp")        //  Add an element to end of the array
    stooges.unshift("Curly Joe") //  Add an element to start of the array
    console.table(stooges)

    stooges.splice(3,0,"Groucho", "Chico", "Harpo") // insert elements at element #3
                                                    // go to element #3 and don't remove anything
    console.table(stooges)

    stooges.splice(3,1)  // go to element #3 and remove 1 element
    console.table(stooges)

    stooges.splice(3,2)  // go to element #3 and remove 2 elements
    console.table(stooges)

    console.log(stooges.shift()) // shift returns the first element and removes it
    console.table(stooges)

    console.log(stooges.pop())   // pop returns the last element and removes it
    console.table(stooges)

    stooges.reverse();           // reverse the element order of the array
    console.table(stooges)

    stooges.splice(stooges.indexOf("Larry"),1) // Remove Larry (we don't know his position)
    console.table(stooges)
  
    let marxBrothers = ["Groucho", "Chico", "Harpo"] // define new array

    let oldFunnyGuys = stooges.concat(marxBrothers) // Concatenate two arrays
    console.table(oldFunnyGuys)
  
    stooges.reverse();
    console.table(stooges)

    console.log(`That's all folks!`)
}
