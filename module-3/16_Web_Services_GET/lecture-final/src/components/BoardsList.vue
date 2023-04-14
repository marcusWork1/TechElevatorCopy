<template>
  <div>
    <h1>My Kanban Boards</h1>
    <div class="boards">
      <!-- display an progress image while page is loading                      -->
      <!-- Using a variable called isLoading to tell us if page is being loaded -->
      <!-- only display this <div> if isLoading is true                         -->
      <div class="loading" v-if="isLoading">
        <img src="../assets/squirrel.gif" />
      </div>
      <!-- display all the names of all Kanban boards                                  -->
      <!-- data for board is in array called boards                                    -->
      <!-- we need to be sure we have data for the board before this <div is created   -->
      <!-- v-else say show this element only if the previous v-if is false             -->
      <!--     if the data is being loaded, display this <div>                         -->
       <!-- wait for isLoading to be false before displaying this <div>                -->
      <div
        class="board"
        v-for="board in boards"
        v-bind:key="board.id"
        v-bind:style="{ 'background-color': board.backgroundColor }"
        v-else
      >
      <!-- make the board title clickable and display a new page when it is clicked    -->
      <!-- go to the page defined in the router path named 'Board'                     -->
      <!--                and send it the board.id as a path variable called 'id'      -->
      <!-- router/index.js file has all path definitions for he Vue Router             -->
        <router-link v-bind:to="{ name: 'Board', params: { id: board.id } }">
          {{ board.title }}
        </router-link>
      </div>
    </div>
  </div>
</template>

<script>
// Gain access to processes in boardsService
import boardsService from '../services/BoardService';

export default {
  data() {
    return {
      boards: [],
      isLoading: true  // indicate if the page is being loaded or not
    };
  },
  created() { // Do this stuff before Vue creates the page (generates the html)
    // Go get the data for the boards before Vue generates the html
    // Use a service to get the data
    // The service uses asyncronous processing, so we need wait for it to complete
    //     before we can process the data
    
    boardsService.getBoards()         // Go to service and start the getBoards() process
                 .then(response => {  // .then says wait for the getBoards() to complete (response is populated)
                         this.boards = response.data; // copy the data from repsonse to our boards array
                         // Once we have all the data for page set loading indicator to false
                         this.isLoading = false;    // Once we have all the data for page set loading indicator to false
                     });
  }
};
</script>

<style scoped>
.boards {
  display: flex;
  justify-content: space-between;
  align-items: center;
}
.board {
  background-color: #f7fafc;
  border-radius: 10px;
  padding: 40px;
  flex: 1;
  margin: 0 20px;
  text-align: center;
}
.loading {
  flex: 3;
}
.board a:link,
.board a:visited {
  color: rgb(243, 243, 243);
  text-decoration: none;
}
</style>
