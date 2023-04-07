/**
 * All named functions will have the function keyword and
 * a name followed by parentheses.
 * 
 * @returns {number} 1
 */
function returnOne() {
  return 1;
}

/**
 * Functions can also take parameters. These are just variables that are filled
 * in by whoever is calling the function.
 *
 * Also, we don't *have* to return anything from the actual function.
 *
 * @param {any} value the value to print to the console
 */
function printToConsole(value) {
  console.log(value);
}

/**
 * Write a function called multiplyTogether that multiplies two numbers together. But 
 * what happens if we don't pass a value in? What happens if the value is not a number?
 *
 * @param {number} firstParameter the first parameter to multiply
 * @param {number} secondParameter the second parameter to multiply
 */
function multiplyTogether(firstParameter, secondParameter) {
  return firstParameter * secondParameter;
}


/**
 * This version makes sure that no parameters are ever missing. If
 * someone calls this function without parameters, we default the
 * values to 0. However, it is impossible in JavaScript to prevent
 * someone from calling this function with data that is not a number.
 * Call this function multiplyNoUndefined
 *
 * @param {number} [firstParameter=0] the first parameter to multiply
 * @param {number} [secondParameter=0] the second parameter to multiply
 */
 function multiplyNoUndefined(firstParameter=0, secondParameter=0) {
   /*************************************************
   console.log(`firstParm=${firstParameter}`)
   console.log(`secondParm=${secondParameter}`)
   **************************************************/
  return firstParameter * secondParameter;
}

 
/**
 * Functions can return earlier before the end of the function. This could be useful
 * in circumstances where you may not need to perform additional instructions or have to
 * handle a particular situation.
 * In this example, if the firstParameter is equal to 0, we return secondParameter times 2.
 * Observe what's printed to the console in both situations.
 * 
 * @param {number} firstParameter the first parameter
 * @param {number} secondParameter the second parameter
 */
function returnBeforeEnd(firstParameter, secondParameter) {
  console.log("This will always fire.");

  if (firstParameter == 0) {
    console.log("Returning secondParameter times two.");
    return secondParameter * 2;
  }

  //this only runs if firstParameter is NOT 0
  console.log("Returning firstParameter + secondParameter.");
  return firstParameter + secondParameter;
}

/**
 * Scope is defined as where a variable is available to be used.
 * (Same as Java)
 *
 * If a variable is declare inside of a block, it will only exist in
 * that block and any block underneath it. Once the block that the
 * variable was defined in ends, the variable disappears.
 */
function scopeTest() {
  // This variable will always be in scope in this function
  let inScopeInScopeTest = true;

  {
    // this variable lives inside this block and doesn't
    // exist outside of the block
    let scopedToBlock = inScopeInScopeTest;
  }

  // scopedToBlock doesn't exist here so an error will be thrown
  if (inScopeInScopeTest && scopedToBlock) {
    console.log("This won't print!");
  }
}

function createSentenceFromUser(name, age, listOfQuirks = [], separator = ', ') {
  let description = `${name} is currently ${age} years old. Their quirks are: `;
  return description + listOfQuirks.join(separator);
}


/**
 *  Use the .forEach of JavaScript to proess all elements in an array
 *  by an anonymous functions
 */

function forEachExample(arrayToProcess = []) { // make an empty array as default

  // .forEach() will process all elements in an array by giving them one at a time to a function
  //
  // .forEach(function-that-receives-one-parameter)  - function may be named or anonymous
  //
  //          (paramters)        => {processing-the-processing-performs}
  // .forEach((name-for-element) => {process-using-name-for-element})
  //

  arrayToProcess.forEach((keith) => {console.log(keith)})

}


/**
 * Takes an array and, using anonymous functions, generates
 * their sum.
 *
 * @param {number[]} numbersToSum numbers to add up
 * @returns {number} sum of all the numbers
 */
function sumAllNumbers(numbersToSum) {
  /*****************************************************************
   * .reduce(call-back-function) will call the callback-function for
   * each element in the array to convert the array to a single value
   * 
   * The callback function processing is how the array is reduced to 
   *      as single value
   *****************************************************************/
  // reduce the values in the array to a single sum
  return numbersToSum.reduce((sum, anElem) => {return sum + anElem});
}

/**
 * Takes an array and returns a new array of only numbers that are
 * multiples of 3
 * 
 * Take an array and convert it to another array of numbers multiples of 3
 *
 * The filter - find values in some data structures
 * 
 * @param {number[]} numbersToFilter numbers to filter through
 * @returns {number[]} a new array with only those numbers that are
 *   multiples of 3
 */
function allDivisibleByThree(numbersToFilter) {
  // return numbersToFilter.filter((currElem) => {
  //                                              if(currElem % 3 === 0) {  // if evenly divisble by 3
  //                                               return true; // it should be in new array
  //                                              }
  //                                              else {
  //                                               return false; // it should not be in new array
  //                                              }                                     
  //                                             }) // end of .filter function call
 
  /* alternate solution */
  return numbersToFilter.filter((currElem) => {return currElem % 3 ===0} )

}  // end of allDivisbleByThree function
/**************************************************************************
 * Example of above processing using a named function
 **************************************************************************/
function divisbleBy3UsingNamedFunction(numbersToFilter) {
  return numbersToFilter.filter(isDivisibleBy3)
}

function isDivisibleBy3(aValue) { // return true if value is divisible by 3 false if not
  return aValue % 3 === 0
}

/******************************************************************************************
 * This example was added by Frank - no tests in the test html
 * 
 * To test this code: use Inspect in the browser
 * 
 * .map() will return an array of elements returned from a callback function (anon or named)
 *  
 */
// Create an array of all the values squared in a array
function mapArrayFunctionToSquareValuesInAnArray(numbersToSquare=[1,2,3,4]){
  return numbersToSquare.map((currElem) => {return currElem * currElem})
}