const bookName = 'Cigar Parties for Dummies';
const description = 'Host and plan the perfect cigar party for all of your squirrelly friends.';
const reviews = [  // array of reviews to be displayed
  {                // each element in the array is an Object
    reviewer: 'Malcolm Madwell',
    title: 'What a book!',
    review:
    "It certainly is a book. I mean, I can see that. Pages kept together with glue and there's writing on it, in some language. Yes indeed, it is a book!",
    rating: 3
  },
  {
    reviewer: 'Tim Ferriss',
    title: 'Had a cigar party started in less than 4 hours.',
    review:
      "It should have been called the four hour cigar party. That's amazing. I have a new idea for muse because of this.",
    rating: 4
  },
  {
    reviewer: 'Ramit Sethi',
    title: 'What every new entrepreneurs needs. A door stop.',
    review:
      "When I sell my courses, I'm always telling people that if a book costs less than $20, they should just buy it. If they only learn one thing from it, it was worth it. Wish I learned something from this book.",
    rating: 1
  },
  {
    reviewer: 'Gary Vaynerchuk',
    title: 'And I thought I could write',
    review:
      "There are a lot of good, solid tips in this book. I don't want to ruin it, but prelighting all the cigars is worth the price of admission alone.",
    rating: 3
  }
];

/***************************************************************************************
 * Each of DOM manipulations will be in a function - enacapsulate each one
 * 
 * At the end of this file, we call each function of our main functions to 
 *                          to manipulate the DOM (change what user sees in browser)
 ***************************************************************************************/


/**
 * Add the product name to the page title before the page is shown to the user
 * Get the page title by the id and the query the .name selector
 * once you have the element you can add the product name to the span.
 */
function setPageTitle() {
  //  Get the page title by the id and the query the .name selector
  //  .getElementById() - returns a reference to the element with the id given
  const thePageTitle = document.getElementById('page-title') // get me to the element with id='page-title'
  //                           .querySelector('#id') is OK too (uses css notation for id-#)
  
  // get to the span in the element to add the productname (stored in bookName variable)
  // .querySelector(CSS-notation-for-id-or-class)  # === id,  . === class
  const theSpan = thePageTitle.querySelector('.name') // find the elements with class='name'

  // Set the text for the span with the productname (bookName variable)
  theSpan.innerText = bookName  // innerText references the text/words in an element
                                // innerHtml will also reference the text/words in an element
                                //       BUT SHOULD NEVER BE USED! (Hacker prone)
} // end of setPageTitle

/**
 * Add the product description to the page.
 */
function setPageDescription() {
  // Get to the <p> for the description (class='descrtiption')
  const theDescription = document.querySelector('.description')

  // set the text/words to the content of the description variable
  theDescription.innerText = description
  // alternate solution:
  //     document.querySelector('.description').innerText = description
}

/**
 * Display all of the reviews defined in the array with code on the page.
 * Loop over the array of reviews and use some helper functions (addXXXXXX functions)
 * to create the elements needed for the display and add them to the DOM.
 */
function displayReviews() {

  // get a reference to the <div id='main' where the reviews will be placed
  const theDiv = document.getElementById('main')

  // Loop over the array of reviews - adding an element to the DOM for each element in the array
  // Use a .forEach() array function with an anonymouse function to add an array element to DOM
  //
  //      arrayName.forEach(anon-func -or- named-function)
  //      the anon-func: (name-for-element) => {process-element}

  reviews.forEach((aReview) => {  // send an element to anonymous function called aReview
    // create an html <div> element with the class name 'review'
    const newReview = document.createElement('div')  // create a <div>
    newReview.setAttribute('class', 'review')        // add class="review" to the new div

    // call each helper function to add the other elements to the DOM
    // each helper function takes two parameters:
    //    1. It's parent element (newReview in this example)
    //    2. data to be included in the new element it creates (attribute in an array element)

    //          parent-elem,data-for-elem
    addReviewer(newReview  ,aReview.reviewer)  // add an <h2> element
    addRating(newReview    ,aReview.rating)    // add a <div> with <img>
    addTitle(newReview     ,aReview.title)     // add an <h3> element
    addReview(newReview    ,aReview.review)    // add a <p> element
   
    // Now that we have the new <div> element created for the review
    //     we need to add it to the DOM
    //    .insertAdjacentElement(where-it-goes, element-to-insert)
    theDiv.insertAdjacentElement('beforeend'  , newReview)
  })  // end of anonymous function
}

/**
 * Create a new h2 element with the name of the reviewer and append it to
 * the parent element that is passed to me.
 *
 * @param {HTMLElement} parent: The element to append the reviewer to
 * @param {string} name The name of the reviewer
 */
function addReviewer(parent, name) {
  // create the <h2> element to hold the reviewer information
  const header = document.createElement('h2')
  // set the text/words to the reviewer name
  header.innerText = name

  // add the new element to DOM using the parent element we were given
  parent.appendChild(header)
}

/**
 * Add the rating div along with a star image for the number of ratings 1-5
 * @param {HTMLElement} parent
 * @param {Number} numberOfStars
 */
function addRating(parent, numberOfStars) {
  // Create the div to hold the rating with class="rating"
  const theRating = document.createElement('div')
  theRating.setAttribute('class', 'rating')

  // Create on <img> tag in the <div> based on numberOfStars parameter given to us
  for(let i=0; i < numberOfStars; i++) { // loop for the numberOfStars time
    const starImage = document.createElement('img')
    starImage.setAttribute('class', 'ratingStar')
    starImage.src='img/star.png'
    theRating.appendChild(starImage) // add the <img> to the rating <div>
  }
  // Add the Rating div to the parent in theDOM
  parent.appendChild(theRating)

}

/**
 * Add an h3 element along with the review title
 * @param {HTMLElement} parent
 * @param {string} title
 */
function addTitle(parent, title) {  // add an <h3> element
  const aTitle = document.createElement('h3')
  aTitle.innerText = title
  parent.appendChild(aTitle)
}

/**
 * Add the product review
 * @param {HTMLElement} parent
 * @param {string} review
 */
function addReview(parent, review) {
  const aReview = document.createElement('p')
  aReview.innerText = review
  parent.appendChild(aReview)
}

/********************************************************************************************
 * These statements call the DOM manipulation functions we wrote above 
 *       when page is loaded before the page is rendered/displayed to user
 ********************************************************************************************/
// set the product reviews page title
setPageTitle();
// set the product reviews page description
setPageDescription();
// display all of the product reviews on the page
displayReviews();
