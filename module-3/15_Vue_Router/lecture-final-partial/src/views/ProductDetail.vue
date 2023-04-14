<template>
   <!-- data for page is stored a product object   -->
   <div id='app' class='main'>
       <h1> {{product.name}}</h1>
       <p class="description">{{product.description}}</p>    
   </div> 
</template>
<script>
    export default {
        name: 'product-detail',

     // We need to get th product info for the seleted product
     // BEFORE the page eis displayed
     // the created() section of a Vue component is done before Vue creates the page
     //   put processing in the created() section when you need to do something 
     //       before the html for the page is created
     created() {
         // we need to retrieve the data from the data store for product id we are displaying 
         // product id is being sent as path variable called id
         // $route.params.path-variable-name - $route is an object containing route info
         // define a variable to hold the data in the path variable id
         const currentProductId = this.$route.params.id

         // Because we need the current product id to be shared with other components
         // we need to store the currentProductId in the Vue data store activeProduct
         // Use SET_ACTIVE_PRODUCT mutation to do this
         this.$store.commit("SET_ACTIVE_PRODUCT", currentProductId)
     },
     computed: { // RUn these methods when data changes on the page 
                 // (like initial display and a review is added)
        // copy the reviews for the requested product id into the page
        product() {  // name used in html to reference the data
            // We only want the data for requested product
            // .find() will search an array and return only specified elements
            return this.$store.state.products.find((aProduct) => 
                                             {return aProduct.id == this.$store.state.activeProduct})
        }


     } // end of computed section
    } // end of export
    
</script>
<style scoped>

</style>