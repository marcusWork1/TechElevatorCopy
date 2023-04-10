const bookName = 'Cigar Parties for Dummies';
const description = 'Host and plan the perfect cigar party for all of your squirrelly friends.';
const reviews = [ // an array of reviews to display
  {
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

/**
 * Each of DOM manipulation will be in function - encapsulate each one
 * 
 * At the end of this file, we call each function of our main functions to 
 *                                            to manipulate the DOM (change what user sees in browser)
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Add the product name to the page title
 * Get the page title by the id and the query the .name selector
 * once you have the element you can add the product name to the span.
 */
function setPageTitle() {
    // get page title by id
    const thePageTitle = document.getElementById('page-title') // get me to element with id=page-title
    // get to the span in the element to add the productName(stored in bookName)
    const theSpan = thePageTitle.querySelector('.name')
    
    // set the text for the span(bookName variable)
    theSpan.innerText = bookName // inner text references the text/words in an eelement
    
}

/**
 * Add the product description to the page.
 */
function setPageDescription() {
  // get to <p that is holding description
const theDescription = document.querySelector('.description')

// set the text/words to the content of description
theDescription.innerText = description
}

/**
 * Display all of the reviews on the page.
 * Loop over the array of reviews and use some helper functions
 * to create the elements needed for the markup and add them to the DOM.
 */
function displayReviews() {

  const theDiv = document.getElementById('main')
// loop throuh array to display reviews -
// use a .forEach() array function with an anonymous function to add element

// arrayname.forEach(anon-func -or- named-function)
// the anon-func:(name-for-element) => {process-element}
reviews.forEach((aReview) => { // send an element to anonymous function called a review
// create an html div element with the name review
const aNewReview = document.createElement('div') // create div
aNewReview.setAttribute('class', 'review') // add a review class to new div

// call each helper function to add the other elements to the dom 
// each helper function takes two parameters
//            1. parent element
//            2. Data to be included in new element
//        parent elem, data-for-elem
// whichever order you code these, that order will be processed. so rating(stars) is between name and title
addReviewer(aNewReview, aReview.reviewer) // add an h2 element
addRating(aNewReview, aReview.rating) // add a <div> element
addTitle(aNewReview, aReview.title) // add an h3 element
addReview(aNewReview, aReview.review) // add a <p element

// still need to insert into DOM
theDiv.insertAdjacentElement('beforeend', aNewReview)
}) // end of anonymous function

}

/**
 * Create a new h2 element with the name of the reviewer and append it to
 * the parent element that is passed to me.
 *
 * @param {HTMLElement} parent: The element to append the reviewer to
 * @param {string} name The name of the reviewer
 */
function addReviewer(parent, name) {
const header = document.createElement('h2')
header.innerText = name

// add element to dom using parent element
parent.appendChild(header)

}

/**
 * Add the rating div along with a star image for the number of ratings 1-5
 * @param {HTMLElement} parent
 * @param {Number} numberOfStars
 */
function addRating(parent, numberOfStars) {
  // create a div
  const newRating = document.createElement('div')
  // set attribute class to be rating 
  newRating.setAttribute('class','rating')
  // create an img tag in the div based on numberOfStars parameter given to us
  for(let i=0; i<numberOfStars; i++) { // loop for numberOfStars times
    const starImage = document.createElement('img')
    starImage.setAttribute('class', 'ratingStar')
    starImage.src = 'img/star.png'
    newRating.appendChild(starImage) // add the img to the rating div

  }
  // add the rating dive to the parent in the dom
  parent.appendChild(newRating)
}

/**
 * Add an h3 element along with the review title
 * @param {HTMLElement} parent
 * @param {string} title
 */
function addTitle(parent, title) {

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

// these statements call the DOM manipulation functions we wrote
// page is loaded

// set the product reviews page title
setPageTitle();{}

// set the product reviews page description
setPageDescription();

// display all of the product reviews on the page
displayReviews();

