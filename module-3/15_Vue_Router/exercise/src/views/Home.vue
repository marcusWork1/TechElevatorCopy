<template>
  <div>
    <best-seller-list />
    <new-releases-list />
  </div>
</template>

<script> // JS
import NewReleasesList from '../components/NewReleasesList.vue';
import BestSellerList from '../components/BestSellerList.vue';
  export default { // Export data
    components: { // list of vue components used
        BestSellerList,
        NewReleasesList
    },
    computed: {}
  }
</script>
<style scoped>
</style>