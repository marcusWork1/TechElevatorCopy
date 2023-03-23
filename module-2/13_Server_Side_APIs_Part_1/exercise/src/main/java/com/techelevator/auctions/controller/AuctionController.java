package com.techelevator.auctions.controller;

import com.techelevator.auctions.dao.AuctionDao;
import com.techelevator.auctions.dao.MemoryAuctionDao;
import com.techelevator.auctions.model.Auction;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.text.DecimalFormat;
import java.util.List;

@RestController // this tells the server the class has controllers to handle RESTful
// http requests
// the contorllers need to be in same package as server
//@RequestMapping("/auctions")
public class AuctionController {

    // defined references to any DAOS used by the controller in this class

    private AuctionDao dao;


    // Constructor for class containing servers instantiate DAOS and
    // assign them to their references

    public AuctionController() {
        this.dao = new MemoryAuctionDao();
    }


    // return list of all auctions
    @RequestMapping(path = "/auctions", method = RequestMethod.GET)
    public List<Auction> list(@RequestParam(required = false, defaultValue = " ") String title_like,
                              @RequestParam(required = false, defaultValue = "0.0") double currentBid_lte) {
        System.out.println("List completed");
        if (title_like != null && currentBid_lte > 0) {
            return dao.searchByTitleAndPrice(title_like, currentBid_lte);
        }
        if (title_like != null) {
            return dao.searchByTitle(title_like);
        }
        if (currentBid_lte > 0.0 ) {
            return dao.searchByPrice(currentBid_lte);
        }

        return dao.list();

    }

    // get action for specific values
    // the request mapping tells server which url path and http request
    // this method will handle any http requests with the path /auctions
    @RequestMapping(path = "/auctions/{id}", method = RequestMethod.GET)
    public Auction get(@PathVariable int id) {
        System.out.println("GET for /hotels/" + id + " Was received");
        return dao.get(id);

    }


    /*  public List<Auction> get(@RequestParam(defaultValue = " ") String title_like, @RequestParam(defaultValue = " ")
              Double currentBid_lte) { // controller method name is never used
          System.out.println("GET for /auction was recieved"); // log request
          if (title_like != null && currentBid_lte > 0) {
              return dao.searchByTitleAndPrice(title_like, currentBid_lte);
          }
          if (title_like != null) {
              return dao.searchByTitle(title_like);
          }
          if (currentBid_lte > 0) {
              return dao.searchByPrice(currentBid_lte);
          }
          return dao.list();

      }*/
    //@ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path ="/auctions", method = RequestMethod.POST)
    public Auction create(@RequestBody Auction auction) {
        System.out.println("Created auction");

        if (auction != null) {

           dao.create(auction);
           return auction;
        }
        return null;



      /*  Auction newAuction;
        newAuction = dao.create(auction);
       if (newAuction == null) {
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Auction not found");
       }*/
    }
} // end of controller
