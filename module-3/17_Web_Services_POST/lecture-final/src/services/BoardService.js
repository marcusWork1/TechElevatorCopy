// This handle all API calls to a resource server
//
// This will retrieve, add, update and delete data on the resource


import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:3000"
});

export default {

  getBoards() {
    return http.get('/boards');
  },

  getCards(boardID) {
    return http.get(`/boards/${boardID}`)
  },

  getCard(cardID) {
    return http.get(`/cards/${cardID}`)
  },

  // add a card to a board using tehobject passed
  addCard(card) {
    // HTTP POST requires data to be added to the resource in the request body
    // for axios .post, just include the object you want added as a parameter
    //         .post('path  ', object-to-added-to-resource)
    return http.post('/cards', card);
  },

   // HTTP PUT requires data to be update in the resource in the request body
    // for axios .post, just include the object you want added as a parameter
    //         .put('path  ', object-to-added-to-resource)
  updateCard(card) {
    return http.put(`/cards/${card.id}`, card);
  },

  deleteCard(cardID) {
    return http.delete(`/cards/${cardID}`);
  }

}
