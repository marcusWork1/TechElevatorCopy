import Vue    from 'vue'       // give me access to Vue studd
import App    from './App.vue' // give me access to the main vue component for this project
import store  from './store'   // give me access to Vuex data store support
import router from './router'  // give me access to Vue router support

Vue.config.productionTip = false

new Vue({                // Instantiate a Vue object for the application
  store,                 // We are using Vuex data store
  router,                // We are using Vue router to switch pages
  render: h => h(App)    // Use the App,vue component when you start the application
}).$mount('#app')        // Put all Vue generated coded in the element with class="app"
