<template>
  <div>
    <a
      id="show-form-button"
      href="#"
      v-if="showForm === false"
      v-on:click.prevent="showForm = true"
    >Show Form</a>

    <!-- v-on:submit.prevent - tells browser to NOT perform default action for the submit of this form -->
    <!-- submit for a form will normally send an HTTP GET to a API URL specified in the form           -->
    <!-- we want to handle submit with the addNewReview method                                         -->
    <form v-on:submit.prevent="addNewReview" v-if="showForm === true">
      <div class="form-element">
        <label for="reviewer">Name:</label>
        <input id="reviewer" type="text" v-model="newReview.reviewer" />
      </div>
      <div class="form-element">
        <label for="title">Title:</label>
        <input id="title" type="text" v-model="newReview.title" />
      </div>
      <div class="form-element">
        <label for="rating">Rating:</label>
        <select id="rating" v-model.number="newReview.rating">
          <option value="1">1 Star</option>
          <option value="2">2 Stars</option>
          <option value="3">3 Stars</option>
          <option value="4">4 Stars</option>
          <option value="5">5 Stars</option>
        </select>
      </div>
      <div class="form-element">
        <label for="review">Review:</label>
        <textarea id="review" v-model="newReview.review"></textarea>
      </div>
      <input type="submit" value="Save" />
      <input type="button" value="Cancel" v-on:click="resetForm" />
    </form>
  </div>
</template>

<script>
export default {
  name: "add-review",
  data() {
    return {
      showForm: false,
      newReview: {
        favorited: false,
      },
    };
  },
  methods: {
    addNewReview() {
      // add the newReview to the reviews array in the data store
      // only way to change data in the data store is to use a mutation
      //
      // this.$store - indicates this application Vuex data store
      // .commit()   - execute a mutation in the data store
      // ("mutation-name", data-to-used-by-mutation)
      this.$store.commit("ADD_REVIEW", this.newReview)
      this.resetForm();   // reset the form values
    },
    resetForm() {
      this.showForm = false;
      this.newReview = {
        favorited: false
      };
    },
  },
};
</script>

<style>
div.form-element {
  margin-top: 10px;
}
div.form-element > label {
  display: block;
}
div.form-element > input,
div.form-element > select {
  height: 30px;
  width: 300px;
}
div.form-element > textarea {
  height: 60px;
  width: 300px;
}
form > input[type="button"] {
  width: 100px;
}
form > input[type="submit"] {
  width: 100px;
  margin-right: 10px;
}
</style>
