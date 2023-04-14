import Vue from 'vue'
import VueRouter from 'vue-router'
import  Products from '@/views/Products.vue'
import ProductDetail from '@/views/ProductDetail.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/', // path for vue router to handle
    name: 'products', // optional name for the path
    component: Products // name of the router view to associate with path
  },
  {
    path: '/product/:id', // path to display details about a product
    name: 'product-detail', // optional name for the path
    component: ProductDetail // name of the router view to associate with path


  }

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
