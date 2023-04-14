<!-- Router view for displaying the list of products on a page -->
<template> <!-- html goes here-->
    <div class='products'> <!-- this is the one only <div> allowed in the template -->
        <h1>Products</h1>
        <products-list /> <!-- Vue component associated with this router view-->
    </div>
</template>

<script> // JavaScript goes here
    //                    ./src/components/ProductsList would be OK too  
    import ProductsList from '@/components/ProductsList'  // gain access to ProductsList component

    export default {
        components: {
            ProductsList
        }
    }
</script>

<style scoped> /* CSS goes here */
</style>
