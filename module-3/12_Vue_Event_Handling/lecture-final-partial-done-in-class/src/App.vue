<template> <!-- contains the html for the page       -->
  <div id="app">
    <img alt="Vue logo" src="./assets/cigarpartylogo.png" />
    <!-- code the component as an html tag to use in the web page -->
    <!-- component names is coded in kabob case                   -->
    <product-review></product-review>
  </div>
</template>

<script>   /* contains the JavaScript for the page    */
/* import the Vue component files used as html tags in the template   */
import ProductReview from "./components/ProductReview.vue";

export default {
  name: "app",
  components: { /* list of Vue components used in the template - must match import name */ 
    ProductReview
  }
};
</script>

<style scoped> /* contains the styling for the page - scoped limits CSS to this page */
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  max-width: 800px;
  margin: 60px auto 0 auto;
}
</style>
