<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png" />
    <!-- include the hello world  vue component in the page
    using a Vue component is exactly like using an HTML tag
    <html-tag attributes="value"></end-html-tag> 
   the vue component must be specified as an export in the JavaScript -->
    <HelloWorld msg="Welcome to Your Vue.js App" />
    <!-- add our new Vue component to the App -->
    <!-- Vue component is named ProductReview.vue 
    we need to import the file containing the component that's in our JS
    we have to tell Vue it can access the component
    by exporting it
    we code it like an html tag where we want it in this dib-->

<product-review/>
  </div>
</template>

<script> // this is where JS goes
// must import the Vue component into the app
import HelloWorld from "./components/HelloWorld.vue";
import ProductReview from "./components/ProductReview.vue";

export default { // make these data items visible outside this file(like vue)
  name: "App", // name(used by Vue to access data)
  components: { // defines Vue components used in this file 
    HelloWorld, // name of component
    ProductReview,
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
