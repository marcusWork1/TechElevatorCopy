<template>
  <div class="main">
    <!-- {{ }} expression allows JavaScript variables to be displayed on the page -->
    <h2>Product Reviews for {{ name }}</h2>

    <p class="description">{{ description }}</p>

    <div class="well-display">
      <div class="well">
        <span class="amount">{{ averageRating }}</span>
        Average Rating
      </div>

      <div class="well">
        <span class="amount">{{ numberOfOneStarReviews }}</span>
        <!-- if there is more the 1 reviews, add an 's' to the descrtiption -->
        <!--                  condition              ? value-if-true : value-if-false -->
        1 Star Review{{ numberOfOneStarReviews === 1 ?    ''         : 's' }}
      </div>

      <div class="well">
        <span class="amount">{{ numberOfTwoStarReviews }}</span>
        2 Star Review{{ numberOfTwoStarReviews === 1 ? '' : 's' }}
      </div>

      <div class="well">
        <span class="amount">{{ numberOfThreeStarReviews }}</span>
        3 Star Review{{ numberOfThreeStarReviews === 1 ? '' : 's' }}
      </div>

      <div class="well">
        <span class="amount">{{ numberOfFourStarReviews }}</span>
        4 Star Review{{ numberOfFourStarReviews === 1 ? '' : 's' }}
      </div>

      <div class="well">
        <span class="amount">{{ numberOfFiveStarReviews }}</span>
        5 Star Review{{ numberOfFiveStarReviews === 1 ? '' : 's' }}
      </div>
    </div>
    <!-- link to display the form and set showForm variable to true when clicked   -->
    <!-- stop the browser from handling click processing as we are doing something -->                       
    <a href="#" v-on:click.prevent="showForm=true">Show Form</a>
    
    <!-- add a form to collect a new review                                       -->
    <!-- tell form to run the addNewReview() method when submit button is clicked -->
    <!-- v-on specifies processing to done when events occur in the component     -->
    <!-- v-on:event = "what to do"                                                -->
    <!-- v-on:submit when a submit is clicked, do something                       -->  
    <!-- The default behavior for a form is to issue and HTTP GET to a API URL    -->
    <!-- we want handle what the submit does ourselves, disable default behavior  -->
    <!-- submit.prevent suppesses the default behavior of issuing an HTTP GET     -->
    <!-- tell form to only display when showForm is equal true                    -->
    <!--    v-if allows a condition if true, add the element to the DOM (show it) -->
    <form v-if="showForm === true" v-on:submit.prevent=addNewReview> <!-- run the addNewReview method when submitis clicked--> 
      <div class="form-element"> <!-- collect the name of the Reviewer from the user and store it using v-model    -->
        <label for="reviewer"> Name: </label>
        <!-- connect the input box for reviewer to the JavaScript variable newReview.reviewer -->
        <input  id="reviewer"  type="text" v-model="newReview.reviewer"/> 
      </div>
      <div class="form-element"> <!-- collect the title of the Review -->
       <label for="title"> Title: </label>
       <input  id="title" type="text" v-model="newReview.title" />
      </div>
      <div class="form-element">
        <label for="rating">Rating:</label>
        <!-- ensure the value coming back is a number      -->
        <select id="rating" v-model.number="newReview.rating">
          <!-- value=1 says to return a 1 of they this option  -->
          <option value=1>1 Star</option>
          <option value=2>2 Stars</option>
          <option value=3>3 Stars</option>
          <option value=4>4 Stars</option>
          <option value=5>5 Stars</option>
        </select>  
      </div>
      <div class="form-element">
        <label   for="review">Review</label>
        <textarea id="review" v-model="newReview.review"></textarea>
      </div>
      <!-- add a submit button to the form so the data is submitted using form processing -->
      <input type="submit" value="Save">
      <!-- define a simple button to cancel the review and reset the form when clicked                                  -->
      <input type="button" value="Cancel" v-on:click="resetForm">
    </form>


    <div
      class="review"
      v-bind:class="{ favorited: review.favorited }"
      v-for="review in reviews"
      v-bind:key="review.id"
    >
      <h4>{{ review.reviewer }}</h4>
      <div class="rating">
        <!-- v-bind - one-way binding to aa JavaScript variable - like {{ }}                      -->
        <!-- use v-bind when {{ }} can't be used to reference a JavaScript variable               -->
        <!-- v-bind is typically used to assign a JavaScript variable to an html attribute        -->
        <!-- v-bind:title="review.rating"                                                         -->
        <!-- set the title attribute of the html tag to value in JavaScript var "review.rating    -->
        <!-- the title attribute of an <img> is the words displayed with the image                -->
        <!--  "# Star Review" displayed with the star image                                       -->
        <!-- v-for coded with an html tag generates the tag for whatever value controls the v-for -->
        <img src="../assets/star.png" v-bind:title="review.rating + ' Star Review'" 
             class="ratingStar" v-for="n in review.rating" v-bind:key="n" />
      </div>

      <h3>{{ review.title }}</h3>

      <p>{{ review.review }}</p>

      <p>
        Favorite?
        <!-- v-model does 2-way binding with a JavaScript variables             -->
        <!-- connect a checkbox with the "review.favorited" JavaScript variable -->
        <input type="checkbox" v-model="review.favorited" />
      </p>
    </div>
  </div>
</template>

<script>
export default { /* Expose data to external processes, like Vue */
  name: "product-review", /* name attribute is used by Vue to get data for a component           */
  data() {                /* provides data to Vue - Vue calls data() for component when its data */
    return {              /* any data to be shared with Vue should be in the return of data()    */
      name: "Cigar Parties for Dummies",
      description:
        "Host and plan the perfect cigar party for all of your squirrelly friends.",
      newReview: {},   /* an object to hold a new review entered in the form on our page  */
      showForm: false, /* control whether the new review form is displayed or now       */
     reviews: [
        {
          reviewer: "Malcolm Gladwell",
          title: "What a book!",
          review:
            "It certainly is a book. I mean, I can see that. Pages kept together with glue and there's writing on it, in some language.",
          rating: 3,
          favorited: false
        },
        {
          reviewer: "Tim Ferriss",
          title: "Had a cigar party started in less than 4 hours.",
          review:
            "It should have been called the four hour cigar party. That's amazing. I have a new idea for muse because of this.",
          rating: 4,
          favorited: false
        },
        {
          reviewer: "Ramit Sethi",
          title: "What every new entrepreneurs needs. A door stop.",
          review:
            "When I sell my courses, I'm always telling people that if a book costs less than $20, they should just buy it. If they only learn one thing from it, it was worth it. Wish I learned something from this book.",
          rating: 1,
          favorited: false
        },
        {
          reviewer: "Gary Vaynerchuk",
          title: "And I thought I could write",
          review:
            "There are a lot of good, solid tips in this book. I don't want to ruin it, but prelighting all the cigars is worth the price of admission alone.",
          rating: 3,
          favorited: false
        }
      ]
    };
  },  // End of data() function
  computed: { /* anything in here is computed/run whenever any data on the web page changes   */
    averageRating() {  /* calculate the averageRating whenever the data on the page changes   */ 
      let sum = this.reviews.reduce((currentSum, review) => {
        return currentSum + review.rating;
      }, 0);
      return (sum / this.reviews.length).toFixed(2); /* toFixed() rounds to a number of decimal places */ 
    },
    numberOfOneStarReviews() {
      return this.reviews.reduce((currentCount, review) => {
        return currentCount + (review.rating === 1);
      }, 0);
    },
    numberOfTwoStarReviews() {
      return this.reviews.reduce((currentCount, review) => {
        return currentCount + (review.rating === 2);
      }, 0);
    },
    numberOfThreeStarReviews() {
      return this.reviews.reduce((currentCount, review) => {
        return currentCount + (review.rating === 3);
      }, 0);
    },
    numberOfFourStarReviews() {
      return this.reviews.reduce((currentCount, review) => {
        return currentCount + (review.rating === 4);
      }, 0);
    },
    numberOfFiveStarReviews() {
      return this.reviews.reduce((currentCount, review) => {
        return currentCount + (review.rating === 5);
      }, 0);
    }
  },   // End of computed: section with more to follow in the export (,)

  methods: { /* funtions that called when needed */
    /* method to add a review when the submit button is clicked on the form  */
    addNewReview() {  // add a newReview to the start of the reviews array holding all reviews
      // Note the use of this. to specify the data is in this component
      this.reviews.unshift(this.newReview)
      this.resetForm()  // call method to reset form after adding newReview to array
    }, 

    resetForm(){ /* called to reset the form data to be empty */
      this.newReview = {}    // set object that holds new review to empty
      this.showForm = false; // hide the form
    }

  } // End of methods section

}; // End of export
</script>

<style scoped>
div.main {
  margin: 1rem 0;
}

div.main div.well-display {
  display: flex;
  justify-content: space-around;
  margin-bottom: 1rem;
}

div.main div.well-display div.well {
  display: inline-block;
  width: 15%;
  border: 1px black solid;
  border-radius: 6px;
  text-align: center;
  margin: 0.25rem;
  padding: 0.25rem;
}

div.main div.well-display div.well span.amount {
  color: darkslategray;
  display: block;
  font-size: 2.5rem;
}

div.main div.review {
  border: 1px black solid;
  border-radius: 6px;
  padding: 1rem;
  margin: 10px;
}

div.main div.review.favorited {
  background-color: lightyellow;
}

div.main div.review div.rating {
  height: 2rem;
  display: inline-block;
  vertical-align: top;
  margin: 0 0.5rem;
}

div.main div.review div.rating img {
  height: 100%;
}

div.main div.review p {
  margin: 20px;
}

div.main div.review h3 {
  display: inline-block;
}

div.main div.review h4 {
  font-size: 1rem;
}

div.form-element {
  margin-top: 10px;
}
div.form-element > label {
  display: block;
}
div.form-element > input, div.form-element > select {
  height: 30px;
  width: 300px;
}
div.form-element > textarea {
  height: 60px;
  width: 300px;
}
form > input[type=button] {
  width: 100px;
}
form > input[type=submit] {
  width: 100px;
  margin-right: 10px;
}
</style>

