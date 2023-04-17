// axios is a framework for doing RESTful API calls from JavaScript
//       (we used RestTemplate in Java to do RESTful API calls)
//
import axios from 'axios';  // Give me access to axios framework

// Instantiate an axios object and tell it the baseURL for the server
const theApiServer = axios.create({
  baseURL: "http://localhost:3000"
});

export default {

  // go to the API server with an HTTP GET request for the path '/boards'
  //    and return the data (an array of board objects)
  // axios uses asyncronous calls to the API server
  //    it returns immediately after issuing the request
  //    the request may not have completed when it returns
  //    somewhere we have to wait for the request to complete to be sure we have the data
  getBoards() {
    return theApiServer.get('/boards');// issue the HTTP GET request and return
  },
    // Note use of interpolation to create the path string for the API call
    // interpolation code what you want inside `` using ${variable} for variables
    //    ${} is called an EL Expression (Expression Language Expression)
  getCards(boardID) {
    // issue the HTTP GET to API server with the path '/boards/board-id'
    return theApiServer.get(`/boards/${boardID}`)
  },

  getCard(boardID, cardID) {
    // Note use of interpolation to create the path string for the API call
    // interpolation code what you want inside `` using ${variable} for variables
    //    ${} is called an EL Expression (Expression Language Expression)
    return theApiServer.get(`/boards/${boardID}`)
                       .then((response) => {  // wait for the API call to complete
                                           const cards = response.data.cards;
                                           return cards.find(card => card.id == cardID);
    })
  }

}
