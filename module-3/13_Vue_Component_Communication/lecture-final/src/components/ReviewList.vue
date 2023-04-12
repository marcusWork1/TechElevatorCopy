<template>
  <div class="reviews">
    <!-- include one ReviewDisplay component                              -->
    <!-- for each element in the filertered review array (v-for)          -->
    <!-- pass the current review to ReviewDisplay as a props named review -->
    <!-- v-bind:review="review"                                           -->
    <!--      v-bind:review= - connect the attributes/props named review  -->
    <!--     "reviews" to name of the current element in the array        -->
    <review-display
      v-for="theCurrentReview in filteredReviews"
      v-bind:key="theCurrentReview.title"
      v-bind:review="theCurrentReview"
    />
  </div>
</template>

<script>
import ReviewDisplay from "./ReviewDisplay";

export default {
  name: "review-list",
  components: {
    ReviewDisplay
  },
  computed: {
    filteredReviews() {  // are reviews that match the current value in reviewsFilter value
      // Controls which array elements are included in the filteredReviews
      // The filter value stored in the data store so we need to retrieve it to use it
      const reviewsFilter = this.$store.state.filter
      // array with reviews we want to filter
      // We need to get the reviews from this application's data store
      const reviews = this.$store.state.reviews;

      return reviews.filter(review => {
        return reviewsFilter === 0 ? true : reviewsFilter === review.rating;
      });
    }
  }
};
</script>

<style>
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

div.main div.well-display div.well {
  cursor: pointer;
}
</style>
