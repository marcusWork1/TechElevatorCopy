// This is autonmatically generated by vue create when the Vue router option is selected
// Tell the Vue router which paths it will handle 
//        and connect a path to a router view

import Vue           from 'vue'        // Gain access to Vue stuff
import VueRouter     from 'vue-router' // Gain access to Vue router stuff
// @ is shorthand for the project root folder (usually the src folder)
import Products      from '@/views/Products.vue'       // Gain access to Products.vue router view
import ProductDetail from '@/views/ProductDetail.vue'  // Gain access to Products.vue router view


Vue.use(VueRouter)    // Tell Vue we are using the router stuff imported as VueRouter

// The routes array is where we define paths and associate them with router views
const routes = [
  { // Each path/router view connection is an object in the routes array
    path: '/',        // this a path you want Vue router to handle
    name: 'products', // Optional name for the path - path names are strongly recommmended
    component: Products // name of router view to associate with the path - stored in views folder
  },
  {
    // :name in a path represents a path variable (just like {name} in controller paths)
    // connect /product/id path to a router view
    // handle: /product/3 - where 3 is the id of a product
    path: '/product/:id',     // the path to display details about a specific product
    name: 'product-detail',   // name of this path
    component: ProductDetail  //name of router view for path - stored in the views folder
  }
]  // End of routes array

// instantiate a Vue router object for the app and connect to array of paths/router views
const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes      // Tell the router that this array contains paths and associated router view
})

export default router
