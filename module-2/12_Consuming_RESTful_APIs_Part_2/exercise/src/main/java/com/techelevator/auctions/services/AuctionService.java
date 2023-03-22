package com.techelevator.auctions.services;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.techelevator.auctions.App;
import com.techelevator.util.BasicLogger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.techelevator.auctions.model.Auction;

public class AuctionService {

    public static String API_BASE_URL = "http://localhost:3000/auctions/";
    private RestTemplate theApiServer = new RestTemplate();


    public Auction add(Auction newAuction) {
        // place code here
        // define the object to be returned so we dont change the auction given
        Auction auctionAdded = null;


        // define a HTTP general header to be included w request

        HttpHeaders theRequestHeader = new HttpHeaders();

        // set data type
        // set content ype to mediatype.application JSON
        // tell rest template to convert java object to json

        theRequestHeader.setContentType(MediaType.APPLICATION_JSON);

        // add entity headaer to request to connect data with header
        // entity header, data type, name,                      converts object to JSON
        HttpEntity<Auction> anEntityHeader = new HttpEntity<>(newAuction, theRequestHeader);

        // send the request ot the server to add object to resource
        // postForObject(server-url-path, entity, class-of-object-to-be-returned)
        try {
            auctionAdded = theApiServer.postForObject(API_BASE_URL, anEntityHeader, Auction.class);

        } catch (RestClientResponseException e) {
            System.out.println("Unable to create new auction item");
        } catch (ResourceAccessException e) {
            System.out.println("Unable to create new auction item");
        }
        return auctionAdded;
    }

    public boolean update(Auction updatedAuction) {
        // place code here

        boolean didUpdateWork = false;

            HttpHeaders aHeader = new HttpHeaders();
            aHeader.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<Auction> newEntity = new HttpEntity<>(updatedAuction, aHeader);

            try {
                theApiServer.put(API_BASE_URL + updatedAuction.getId(), newEntity);
            didUpdateWork = true; // if no exception happened, assume update worked
        }
        catch (RestClientResponseException e) {
                BasicLogger.log(e.getRawStatusCode() + e.getStatusText());
                System.out.println("unable to update auction");
        }
            catch (ResourceAccessException e) {
                BasicLogger.log(e.getMessage());
                System.out.println("unable to update auction");
            }

        return didUpdateWork;
    }

    public boolean delete(int auctionId) {
        // place code here
        boolean didDeleteWork = false;

        try {
            theApiServer.delete(API_BASE_URL + auctionId);
            didDeleteWork = true;
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + e.getStatusText());
            System.out.println("unable to delete auction");
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
            System.out.println("unable to delete auction");
        }


        return didDeleteWork;
    }

    public Auction[] getAllAuctions() {
        Auction[] auctions = null;
        try {
            auctions = theApiServer.getForObject(API_BASE_URL, Auction[].class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return auctions;
    }

    public Auction getAuction(int id) {
        Auction auction = null;
        try {
            auction = theApiServer.getForObject(API_BASE_URL + id, Auction.class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return auction;
    }

    public Auction[] getAuctionsMatchingTitle(String title) {
        Auction[] auctions = null;
        try {
            auctions = theApiServer.getForObject(API_BASE_URL + "?title_like=" + title, Auction[].class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return auctions;
    }

    public Auction[] getAuctionsAtOrBelowPrice(double price) {
        Auction[] auctions = null;
        try {
            auctions = theApiServer.getForObject(API_BASE_URL + "?currentBid_lte=" + price, Auction[].class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return auctions;
    }

    private HttpEntity<Auction> makeEntity(Auction auction) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(auction, headers);
    }

}
