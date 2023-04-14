<template>
  <table>
    <thead>
      <tr>
        <th>ID</th>
        <th>Name</th>
        <th># Reviews</th>
      </tr>
    </thead>
    <tbody>
      <!-- we need to link to a new page when each table row is clicked     -->
      <!-- we need to add a <router-link< to each row                       -->
      <!-- <router-link defines a link to a router path in router/index.js  -->
      <!-- v-bind:to={""} identifies the router path this link connects to  -->  
      <!-- v-bind:to={"name: router-path-name"}                             -->
      <!-- if the router path requires a path variable use params attribute -->
      <!-- params: {"path-variable-name : value"}                           -->
      <tr v-for="product in $store.state.products" v-bind:key="product.id">                
        <td>{{ product.id }}</td>
        <td> <!-- start of product name column in the table -->
          <!-- define a router link to path named 'product-detail             -->
          <!--     with the product id as a path variable name is in the path -->
          <router-link v-bind:to="{name: 'product-detail', params:{id: product.id}}">   
            {{ product.name }}
          </router-link>   
        </td> <!-- end of product name column in the table   -->
        <td>{{ product.reviews.length }}</td>
      </tr>
    </tbody>
  </table>
</template>

<script>
export default {
  name: "products-list"  // Assigns a name to the this exports
};
</script>

<style style="scoped">
th,
td {
  text-align: left;
}
td {
  padding-right: 10px;
  vertical-align: top;
}
tr:nth-child(even) {
  background-color: rgb(238, 238, 238);
}
</style>
