package com.techelevator;

public class Exercise01_StoreOrders {

    /*
    Sally's Pizza is bringing its pizza ordering system into the digital age
    to get better customer insights.

    They've encoded each of Sally's pizzas and other dishes as an integer:
	 * 10: small, cheese       20: medium, cheese       30: large, cheese
	 * 11: small, pepperoni    21: medium, pepperoni    31: large, pepperoni
	 * ---
	 * 40: calzone
	 * 41: spaghetti pie
	 * 42: baked ziti
     */

    // You can use these constants in your solutions.
    private final int SMALL_CHEESE = 10;
    private final int SMALL_PEPPERONI = 11;

    private final int MEDIUM_CHEESE = 20;
    private final int MEDIUM_PEPPERONI = 21;

    private final int LARGE_CHEESE = 30;
    private final int LARGE_PEPPERONI = 31;

    private final int CALZONE = 40;
    private final int SPAGHETTI_PIE = 41;
    private final int BAKED_ZITI = 42;

    /*
    Each customer order, consisting of one or more pizzas, is represented as an array
    where each value represents an item in that order.

    Create an "order" that contains the following items:
	 * - small, cheese (SMALL_CHEESE)
	 * - calzone (CALZONE)
	 * - large, pepperoni (LARGE_PEPPERONI)
	 * - spaghetti pie (SPAGHETTI_PIE)

	 Examples:
	 createOrder() → [10, 40, 31, 41]
     */
    public int[] createOrder() {

//        int[] order = new int[4];
//        order[0] = 10;
//        order[1] = 40;
//        order[2] = 31;
//        order[3] = 41;

//        int[] order = {10, 40, 31, 41};  // size of array is the number  of value you give it

        int numberOfElements = 4;
        int[] order = new int[numberOfElements];

        order[0] = 10;
        order[1] = 40;
        order[2] = 31;
        order[3] = 41;

        return order;
    }

    /*
    Sally realized that she needed to know how many calzones her shop sells per day.

    Implement the logic to count the number of calzones sold per day when given an
    array representing each item that her customers ordered that day.

    Examples:
    getCalzoneSales([CALZONE, LARGE_CHEESE, LARGE_PEPPERONI, CALZONE, SMALL_CHEESE]) → 2
    which is the same as:
    getCalzoneSales([40, 30, 31, 40, 10]) → 2

    getCalzoneSales([LARGE_CHEESE, LARGE_PEPPERONI, SMALL_CHEESE]) → 0
    getCalzoneSales([]) → 0

    1. Go through the order one item at a time to find the CALZONES
          if its a CALZONE - count it
    2. return the count of CALZONES

     */
    public int getCalzoneSales(int[] orders) {
        // Define a variable to hold whatever is returned
        int calzoneCount = 0;

        // Go through the order one item at a time to find the CALZONES
        for(int i=0; i < orders.length; i++) {
            // if its a CALZONE - count it
            if (orders[i] == CALZONE) { // check the order-item in teh array indicated by i
                calzoneCount++; // count the CALZONE
                // calzoneCount = calzoneCount + 1;
                // returnValue += 1;
            }
        }
        return calzoneCount;
    }

    /*
    Sally also needs to know the total revenue for all cheese pizzas sold on any given day.
        * Each small cheese pizza costs $8.
        * Each medium cheese pizza costs $11.
        * Each large cheese pizza costs $14.

    Implement the logic to return the total revenue of all cheese pizzas when given
    an array representing each item that her customers ordered that day.

    Examples:
    getCheesePizzaRevenue([SMALL_CHEESE]) → 8
    getCheesePizzaRevenue([SMALL_CHEESE, SMALL_PEPPERONI, MEDIUM_CHEESE]) → 19
    getCheesePizzaRevenue([SMALL_PEPPERONI, MEDIUM_PEPPERONI]) → 0
     */
    public int getCheesePizzaRevenue(int[] orders) {
        return 0;
    }
}
