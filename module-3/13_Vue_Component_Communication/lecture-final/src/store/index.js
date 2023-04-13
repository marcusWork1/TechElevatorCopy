/****************************************************************************************
 * This is the one an donly Vuex data store for this application
 ***************************************************************************************/
/* a skeleton of this file is created when you select Vuex as an option on V=vue create    */ 

import Vue  from 'vue'   // Include the Vue support code
import Vuex from 'vuex'  // Include the Vuex support code

Vue.use(Vuex)  // Tell the Vue object I want to use Vuex to manage my shared data

// export makes the Vues data store accessible external processes
export default new Vuex.Store({ // Create a new Vuex data storte and expose it to outside processes
  state: {  // the state object holds all the data in the data store
    name: 'Cigar Parties for Dummies',
    description: 'Host and plan the perfect cigar party for all of your squirrelly friends.',
    filter: 0,
    reviews: [
      {
        reviewer: 'Malcolm Gladwell',
        title: 'What a book!',
        review:
          "It certainly is a book. I mean, I can see that. Pages kept together with glue and there's writing on it, in some language.",
        rating: 3,
        favorited: false
      },
      {
        reviewer: 'Tim Ferriss',
        title: 'Had a cigar party started in less than 4 hours.',
        review:
          "It should have been called the four hour cigar party. That's amazing. I have a new idea for muse because of this.",
        rating: 4,
        favorited: false
      },
      {
        reviewer: 'Ramit Sethi',
        title: 'What every new entrepreneurs needs. A door stop.',
        review:
          "When I sell my courses, I'm always telling people that if a book costs less than $20, they should just buy it. If they only learn one thing from it, it was worth it. Wish I learned something from this book.",
        rating: 1,
        favorited: false
      },
      {
        reviewer: 'Gary Vaynerchuk',
        title: 'And I thought I could write',
        review:
          "There are a lot of good, solid tips in this book. I don't want to ruin it, but prelighting all the cigars is worth the price of admission alone.",
        rating: 3,
        favorited: false
      }
    ],
  },  // end of state object
  // Only mutations in the data store are allowed to change any data in the data store
  //      like setters in Java objects
  mutations: {                      // methods to change data in the data store - called by components
                                    // Mutation names: All UPPERCASE with _ between words
    ADD_REVIEW(state, review) {     // Add a review to the data store
      state.reviews.unshift(review);// add a review to the reviews array in the state object 
    },
    UPDATE_FILTER(state, filter) {  // Set the filter value in the data store to the value passed
      state.filter = filter;
    },
    FLIP_FAVORITED(state, reviewToChange) {  // Change favorited from true to false or vice verse 
                                             //     in the review it is passed
      reviewToChange.favorited = !reviewToChange.favorited;  // apply ! to a boolean flips its value
    }
  },
  actions: {
  },
  modules: {
  },
  // Strict should not be used in production code. It is used here as a
  // learning aid to warn you if state is modified without using a mutation.
  // Strict tells Vuex whether to enforce the rule that only mutations can change data in data store
  
  strict: true  // enfore the rule that only mutations can change data in data store
                // false - allows components to direct change data in data store
                //           (violates Single Responsible rule)
})
