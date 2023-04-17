<template>
  <div>
    <h1>{{ title }}</h1>
    <div class="loading" v-if="isLoading">
      <img src="../assets/ping_pong_loader.gif" />
    </div>
    <!-- $route.params.name - retrieve the path varaible with the name   -->
    <!-- in this example the Board id is passes as a path variable       -->
    <!-- v-else say show this element only if the previous v-if is false -->
    <!--     if the data is being loaded, display this <div>             -->
    <!-- wait for isLoading to be false before displaying this <div>     -->  
    <div class="boards" v-else>
      <!-- props expected by BoardColumn are included in the html tag    -->
      <!--      title is the word "Planned"                              -->
      <!--      cards is the result from the planned method              -->
      <!--      boardID is the path variable "id"                        -->
      <board-column
        title="Planned"
        v-bind:cards="planned"
        v-bind:boardID="this.$route.params.id"
      />
      <board-column
        title="In Progress"
        v-bind:cards="inProgress"
        v-bind:boardID="this.$route.params.id"
      />
      <board-column
        title="Completed"
        v-bind:cards="completed"
        v-bind:boardID="this.$route.params.id"
      />
    </div>
    <!-- display this <div> is data is not loading (isLoading == false)   -->
    <div class="board-actions" v-if="!isLoading">
      <router-link to="/">Back to Boards</router-link>
    </div>
  </div>
</template>

<script>
import boardsService from '../services/BoardService';
import BoardColumn   from '../components/BoardColumn';

export default {
  name: 'cards-list',
  components: {
    BoardColumn
  },
  data() {
    return {
      title: '',
      cards: [],
      isLoading: true
    };
  },
  // Load the data to be displayed before Vue processes the html (we need data for the html)
  created() {
    boardsService.getCards(this.$route.params.id)  // get the cards for current board id
                 .then(response => {               // wait for the cards to be gottend
                          this.title = response.data.title; // copy the title from response to our attibute
                          this.cards = response.data.cards; // copy the cards array from response to our attibute
                          this.isLoading = false;  // indicate we are done loading data
                  });
  },
  computed: {
    planned() {
      return this.cards.filter(card => card.status === 'Planned');
    },
    inProgress() {
      return this.cards.filter(card => card.status === 'In Progress');
    },
    completed() {
      return this.cards.filter(card => card.status === 'Completed');
    }
  }
};
</script>

<style>
.boards {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  gap: 20px;
}
.board-actions {
  text-align: center;
  padding: 20px 0;
}
.board-actions a:link,
.board-actions a:visited {
  color: blue;
  text-decoration: none;
}
.board-actions a:hover {
  text-decoration: underline;
}
</style>
