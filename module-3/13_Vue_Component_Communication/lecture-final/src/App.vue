<template>
  <div id="app" class="main">
    <h1>Product Reviews for {{ $store.state.name }}</h1>
    <p class="description">{{ $store.state.description }}</p>
    <!-- have html tags in kabob case for each Vue components in order to be displayed    -->
    <div class="well-display">
      <average-summary />  
      <!-- we need to tell each StarSummary what rating is should handle (props in StarSummary) -->
      <star-summary rating="1" /> <!-- pass a value to the props called rating in StarSummary   -->
      <star-summary rating="2" /> <!-- pass a value to the props called rating in StarSummary   -->
      <star-summary rating="3" /> <!-- pass a value to the props called rating in StarSummary   -->
      <star-summary rating="4" /> <!-- pass a value to the props called rating in StarSummary   -->
      <star-summary rating="5" /> <!-- pass a value to the props called rating in StarSummary   -->
    </div>
    <add-review />
    <review-list />
  </div>
</template>

<script>
// Every Vue component used in this file must be imported
import AverageSummary from "./components/AverageSummary.vue";
import StarSummary    from "./components/StarSummary.vue";
import AddReview      from "./components/AddReview.vue";
import ReviewList     from "./components/ReviewList.vue";

export default {
  name: "app",
  components: {     // Provide a list of Vue components used in the App
    AverageSummary,
    StarSummary,
    AddReview,
    ReviewList
  }
};
</script>

<style>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  max-width: 800px;
  margin: 60px auto 0 auto;
}
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
