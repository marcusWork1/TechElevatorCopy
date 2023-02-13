package com.techelevator;

public class Exercise03_ShippingTotal {

    /*
     * Scamper Shipping Company specializes in small, local deliveries.
     * The problems below ask you to implement the logic to calculate a shipping
     * amount for a package.
     */

    // You can use these constants in your solutions.
    private final int MAX_WEIGHT_POUNDS = 40;
    private final double UP_TO_40_LB_RATE = 0.50;
    private final double OVER_40_LB_RATE = 0.75;

    /*
     * Scamper Shipping Company charges $0.50 per pound for items up to and
     * including 40 pounds. It charges $0.75 per pound for items over 40 pounds.
     * Return the shipping rate when provided a weight in pounds.
     * 
     * Examples:
     * calculateShippingRate(10) ➔ 0.50
     * calculateShippingRate(25) ➔ 0.50
     * calculateShippingRate(40) ➔ 0.50
     * calculateShippingRate(45) ➔ 0.75
     */
    public double calculateShippingRate(int weightPounds) {
        return 0.0;
    }

    /*
     * Scamper Shipping Company charges $0.50 per pound for items up to and
     * including 40 pounds. It charges $0.75 per pound for items over 40 pounds.
     * Implement the logic needed to calculate the shipping cost when provided a
     * weight in pounds.
     * 
     * You may use calculateShippingRate() in your solution.
     * 
     * Examples:
     * calculateShippingTotal(10) ➔ 5.0
     * calculateShippingTotal(25) ➔ 12.5
     * calculateShippingTotal(40) ➔ 20.0
     * calculateShippingTotal(45) ➔ 33.75
     */
    public double calculateShippingTotal(int weightPounds) {
        return 0.0;
    }

    /*
     * Scamper Shipping Company now allows customers to provide a discount code to
     * give them 10% off of their order.
     * Implement the logic to calculate the correct shipping rate when provided a
     * weight in pounds and a boolean value for hasDiscount.
     * 
     * You may use any previous methods in your solution.
     * 
     * Examples:
     *                     weight hasDiscount   cost
     * calculateShippingTotal(10, false)      ➔ 5.0
     * calculateShippingTotal(10, true)       ➔ 4.5
     * calculateShippingTotal(25, false)      ➔ 12.5
     * calculateShippingTotal(25, true)       ➔ 11.25
     * calculateShippingTotal(40, false)      ➔ 20.0
     * calculateShippingTotal(40, true)       ➔ 18.0
     * calculateShippingTotal(45, false)      ➔ 33.75
     * calculateShippingTotal(45, true)       ➔ 30.375
     *
     * is there anything I need to do regardless of discount status?
     *    yes - calculate shipping cost
     *
     * if they get a discount, apply discount to cost
     */
    public double calculateShippingTotal(int weightPounds, boolean hasDiscount) {
        // Define a variable to hold the return value
        double shippingCost = 0;   // The value returned from the function

        // calculate shipping cost regardless of discount status
        //   weight is 40 pounds or less   - .50 per pound
        //   weight greater than 40 pounds - .75 per pound

        if(weightPounds > 40) {
            shippingCost = weightPounds * .75;
        }
        else {  // we get here if weight <= 40
            shippingCost = weightPounds * .50;
        }

        // apply the discount if they get one
        if(hasDiscount == true) {
            //shippingCost = shippingCost - (shippingCost * .10);
            //shippingCost = shippingCost * .90;
            shippingCost *= .90;
        }

        return shippingCost;  // return the variable holding the shipping cost
    }

}
