<template>
  <div>
    <reading-list />
    <router-link v-bind:to="{name: 'add-book'}">Add Book to Reading List</router-link>
  </div>
</template>

<script> // JS
import ReadingList from '../components/ReadingList.vue';
  export default { // export data
    components: { // list of vue components used 
        ReadingList
    }
  }
</script>
<style scoped>
</style>