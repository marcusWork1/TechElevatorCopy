<template>
<!-- when this box is clicked, update the filter value to teh number of stars-->
  <div class="well">
    <span class="amount" v-on:click="updateFilter()">{{ numberOfReviews }}</span>
    {{ rating }} Star Review{{ numberOfReviews === 1 ? '' : 's' }}
  </div>
</template>

<script>
export default {
  name: "star-summary",
  props: ["rating"],  // the value for rating property will come from outside this component
  methods: {
    updateFilter() { // This will update the value of filter in data store to the rating number
    // We need to call a Vuex data store mutation to make the change
    this.$store.commit("UPDATE_FILTER", parseInt(this.rating))
    }
  },
  // anything in the computed section will be automatically executed when any data on the page changes
  // anything in the methods section will be executed when called
  computed: {
    numberOfReviews() {
      // this is the array containing the reviews
      const reviews = this.$store.state.reviews   // retreive the reviews from the data store
      return reviews.reduce((currentCount, review) => {
        // Note: use of parseInt to convert rating to an int from a string
        return currentCount + (review.rating === parseInt(this.rating) ? 1 : 0);
      }, 0);
    }
  }
};
</script>

