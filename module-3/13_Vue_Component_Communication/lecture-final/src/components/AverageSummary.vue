<template>
  <div class="well">
    <span class="amount" v-on:click="updateFilter()">{{ averageRating }}</span>
    Average Rating
  </div>
</template>

<script>
export default {
  name: "average-summary",
  methods: {
     updateFilter() { // This will update the value of filter in data store to 0
    // We need to call a Vuex data store mutation to make the change
    this.$store.commit("UPDATE_FILTER", 0)
    }
  },
  computed: {
    averageRating() {
      // Copy the reviews from the data store into  this component for processing
      const reviews = this.$store.state.reviews;
      let sum = reviews.reduce((currentSum, review) => {
        return currentSum + review.rating;
      }, 0);
      return (sum / reviews.length).toFixed(2);
    }
  }
};
</script>
