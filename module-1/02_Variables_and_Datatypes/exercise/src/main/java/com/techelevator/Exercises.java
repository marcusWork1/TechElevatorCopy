package com.techelevator;

public class Exercises {

	public static void main(String[] args) {

        /* Exercise 1
        1. 4 birds are sitting on a branch. 1 flies away. How many birds are left on
        the branch?
        */
		// ### EXAMPLE:
		int birdsOnABranch = 4;
		int birdsThatFlyAway = 1;
		int birdsRemaining = birdsOnABranch - birdsThatFlyAway;
System.out.println(birdsRemaining);
        /* Exercise 2
        2. There are 6 birds and 3 nests. How many more birds are there than
        nests?
        */
		// ### EXAMPLE:
		int numberOfBirds = 6;
		int numberOfNests = 3;
		int numberOfExtraBirds = numberOfBirds - numberOfNests;
		System.out.println(numberOfExtraBirds);
        /* Exercise 3
        3. 3 raccoons are playing in the woods. 2 go home to eat dinner. How
        many raccoons are left in the woods?
        */
		int numberOfRaccoons = 3;
		int raccoonsGoHome = 2;
		int remainingRaccoons = numberOfRaccoons - raccoonsGoHome;
		System.out.println(remainingRaccoons);
        /* Exercise 4
        4. There are 5 flowers and 3 bees. How many less bees than flowers?
        */
		int numberOfFlowers = 5;
		int numberOfBees = 3;
		int numberOfLessBees = numberOfFlowers - numberOfBees;
		System.out.println(numberOfLessBees);
        /* Exercise 5
        5. 1 lonely pigeon was eating breadcrumbs. Another pigeon came to eat
        breadcrumbs, too. How many pigeons are eating breadcrumbs now?
        */
		int numberOfPigeonsEating = 1;
		int numberOfJoiningPigeons = 1;
		int numberOfTotalPigeons = numberOfJoiningPigeons + numberOfPigeonsEating;
		System.out.println(numberOfTotalPigeons);
        /* Exercise 6
        6. 3 owls were sitting on the fence. 2 more owls joined them. How many
        owls are on the fence now?
        */
		int numberOfOwlsSitting = 3;
		int joiningOwls = 2;
		int totalOwls = numberOfOwlsSitting + joiningOwls;
		System.out.println(totalOwls);
        /* Exercise 7
        7. 2 beavers were working on their home. 1 went for a swim. How many
        beavers are still working on their home?
        */
		int beavers = 2;
		int beaversLeaving = 1;
		int remainingBeavers = beavers - beaversLeaving;
		System.out.println(remainingBeavers);
        /* Exercise 8
        8. 2 toucans are sitting on a tree limb. 1 more toucan joins them. How
        many toucans in all?
        */
		int toucansOnTree = 2;
		int joiningToucans = 1;
		int totalToucans = toucansOnTree + joiningToucans;
		System.out.println(totalToucans);
        /* Exercise 9
        9. There are 4 squirrels in a tree with 2 nuts. How many more squirrels
        are there than nuts?
        */
		int squirrels = 4;
		int nuts = 2;
		int moreSquirrels = squirrels - nuts;
		System.out.println(moreSquirrels);
        /* Exercise 10
        10. Mrs. Hilt found a quarter, 1 dime, and 2 nickels. How much money did
        she find?
        */
		double quarter = .25;
		double dime = .10;
		double nickel = .05;
		double totalAmount = quarter + dime + (nickel * 2);
		System.out.println(totalAmount);
        /* Exercise 11
        11. Mrs. Hilt's favorite first grade classes are baking muffins. Mrs. Brier's
        class bakes 18 muffins, Mrs. MacAdams's class bakes 20 muffins, and
        Mrs. Flannery's class bakes 17 muffins. How many muffins does first
        grade bake in all?
        */
		int briersMuffins = 18;
		int macadamsMuffins = 20;
		int flanneryMuffins = 17;
		int totalMuffins = briersMuffins + macadamsMuffins + flanneryMuffins;
		System.out.println(totalMuffins);
        /* Exercise 12
        12. Mrs. Hilt bought a yoyo for 24 cents and a whistle for 14 cents. How
        much did she spend in all for the two toys?
        */
		double hiltYoyo = .24;
		double total = hiltYoyo + 0.14;
		System.out.println(total );

        /* Exercise 13
        13. Mrs. Hilt made 5 Rice Krispies Treats. She used 8 large marshmallows
        and 10 mini marshmallows.How many marshmallows did she use
        altogether?
        */
		int largeMarsh = 8;
		int smallMarsh = 10;
		int totalMarsh = largeMarsh + smallMarsh;
		System.out.println(totalMarsh);


        /* Exercise 14
        14. At Mrs. Hilt's house, there was 29 inches of snow, and Brecknock
        Elementary School received 17 inches of snow. How much more snow
        did Mrs. Hilt's house have?
        */
		int inchesOfSnow = 29;
		int hiltSnow = inchesOfSnow - 17;
		System.out.println(hiltSnow);


        /* Exercise 15
        15. Mrs. Hilt has $10. She spends $3 on a toy truck and $2.50 on a pencil
        case. How much money does she have left?
        */
		int money = 10;
		double moneyLeft = money - 3 - 2.5;
		System.out.println( moneyLeft);


        /* Exercise 16
        16. Josh had 16 marbles in his collection. He lost 7 marbles. How many
        marbles does he have now?
        */
		int marblesHave = 16;
		int marblesLeft = marblesHave - 7;
		System.out.println(marblesLeft);


        /* Exercise 17
        17. Megan has 19 seashells. How many more seashells does she need to
        find to have 25 seashells in her collection?
        */
		int seashells = 19;
		int totalShells = 25 - seashells;
		System.out.println(totalShells);

        /* Exercise 18
        18. Brad has 17 balloons. 8 balloons are red and the rest are green. How
        many green balloons does Brad have?
        */
		int balloons = 17;
		int greenBalloons = balloons - 8;
		System.out.println(greenBalloons);

        /* Exercise 19
        19. There are 38 books on the shelf. Marta put 10 more books on the shelf.
        How many books are on the shelf now?
        */
		int books = 38;
		int totalBooks = books + 10;
		System.out.println(totalBooks);

        /* Exercise 20
        20. A bee has 6 legs. How many legs do 8 bees have?
        */
		int legs = 6;
		int eightBees = legs * 8;
		System.out.println(eightBees);

        /* Exercise 21
        21. Mrs. Hilt bought an ice cream cone for 99 cents. How much would 2 ice
        cream cones cost?
        */
		double conePrice = .99;
		double totalCost = conePrice * 2;
		System.out.println(totalCost);


        /* Exercise 22
        22. Mrs. Hilt wants to make a border around her garden. She needs 125
        rocks to complete the border. She has 64 rocks. How many more rocks
        does she need to complete the border?
        */
		int hiltRocks = 64;
		int neededRocks = 125 - hiltRocks;
		System.out.println(neededRocks);

        /* Exercise 23
        23. Mrs. Hilt had 38 marbles. She lost 15 of them. How many marbles does
        she have left?
        */
		int marblesS = 38;
		int marblesLeftS = marblesS - 15;
		System.out.println(marblesLeftS);


        /* Exercise 24
        24. Mrs. Hilt and her sister drove to a concert 78 miles away. They drove 32
        miles and then stopped for gas. How many miles did they have left to drive?
        */
		int hiltMiles = 78;
		int milesLeft = hiltMiles - 32;
		System.out.println(milesLeft );

        /* Exercise 25
        25. Mrs. Hilt spent 1 hour and 30 minutes shoveling snow on Saturday
        morning and 45 minutes shoveling snow on Saturday afternoon. How
        much total time (in minutes) did she spend shoveling snow?
        */
		int hiltMinutes = 90;
		int  totalMinutes = hiltMinutes + 45;
		System.out.println(totalMinutes);

        /* Exercise 26
        26. Mrs. Hilt bought 6 hot dogs. Each hot dog cost 50 cents. How much
        money did she pay for all of the hot dogs?
        */
		int hiltDogs = 6;
		double price = hiltDogs * 0.5;
		System.out.println( price );


        /* Exercise 27
        27. Mrs. Hilt has 50 cents. A pencil costs 7 cents. How many pencils can
        she buy with the money she has?
        */
		int hiltMoney = 50;
		int totalPrice = hiltMoney / 7;
		System.out.println(totalPrice);

        /* Exercise 28
        28. Mrs. Hilt saw 33 butterflies. Some of the butterflies were red and others
        were orange. If 20 of the butterflies were orange, how many of them
        were red?
        */
		int hiltButterfly = 33;
		int redButterfly = hiltButterfly - 20;

		System.out.println(redButterfly);
        /* Exercise 29
        29. Kate gave the clerk $1.00. Her candy cost 54 cents. How much change
        should Kate get back?
        */
		double kateToClerk = 1.0;
		double getBack = kateToClerk - 0.54;
		System.out.println(getBack);

        /* Exercise 30
        30. Mark has 13 trees in his backyard. If he plants 12 more, how many trees
        will he have?
        */
		int markTree = 13;
		int totalTree = markTree + 12;
		System.out.println(totalTree);

        /* Exercise 31
        31. Joy will see her grandma in two days. How many hours until she sees
        her?
        */
		int seeGrandma = 2;
		int totalHours = seeGrandma * 24;
		System.out.println(totalHours);

        /* Exercise 32
        32. Kim has 4 cousins. She wants to give each one 5 pieces of gum. How
        much gum will she need?
        */
		int cousins = 4;
		int gumToCousins = cousins * 5;
		System.out.println(gumToCousins );

        /* Exercise 33
        33. Dan has $3.00. He bought a candy bar for $1.00. How much money is
        left?
        */
		double danMoney = 3.0;
		double moneyLeftS = danMoney - 1.0;
		System.out.println(moneyLeftS);

        /* Exercise 34
        34. 5 boats are in the lake. Each boat has 3 people. How many people are
        on boats in the lake?
        */
		int boatInLake = 5;
		int totalPeople = boatInLake * 3;
		System.out.println(totalPeople );

        /* Exercise 35
        35. Ellen had 380 legos, but she lost 57 of them. How many legos does she
        have now?
        */
		int legos = 380;
		int totalLegos = legos - 57;
		System.out.println(totalLegos);

        /* Exercise 36
        36. Arthur baked 35 muffins. How many more muffins does Arthur have to
        bake to have 83 muffins?
        */
		int muffinsBaked = 35;
		int muffinsNeeded = 83 - muffinsBaked;
		System.out.println(muffinsNeeded );

        /* Exercise 37
        37. Willy has 1400 crayons. Lucy has 290 crayons. How many more
        crayons does Willy have then Lucy?
        */
		int crayons = 1400;
		int moreCrayons = crayons - 290;
		System.out.println(moreCrayons);

        /* Exercise 38
        38. There are 10 stickers on a page. If you have 22 pages of stickers, how
        many stickers do you have?
        */
		int stickers = 10;
		int stickersTotal = stickers * 22;
		System.out.println(stickersTotal);

        /* Exercise 39
        39. There are 100 cupcakes for 8 children to share. How much will each
        person get if they share the cupcakes equally?
        */
		double cupcakes = 100;
		double cupcakesPer = cupcakes / 8;
		System.out.println(cupcakesPer);

        /* Exercise 40
        40. She made 47 gingerbread cookies which she will distribute equally in
        tiny glass jars. If each jar is to contain six cookies, how many
        cookies will not be placed in a jar?
        */
		int gingerbreadCookies = 47;
		int noJar = gingerbreadCookies % 6;
		System.out.println(noJar);



        /* Exercise 41
        41. She also prepared 59 croissants which she plans to give to her 8
        neighbors. If each neighbor received an equal number of croissants,
        how many will be left with Marian?
        */
		int croissants = 59;
		int remainingC = croissants % 8;
		System.out.println(remainingC);

        /* Exercise 42
        42. Marian also baked oatmeal cookies for her classmates. If she can
        place 12 cookies on a tray at a time, how many trays will she need to
        prepare 276 oatmeal cookies at a time?
        */
		int oatmeal = 12;
		int neededO = 276 / oatmeal;
		System.out.println(neededO);

        /* Exercise 43
        43. Marian’s friends were coming over that afternoon so she made 480
        bite-sized pretzels. If one serving is equal to 12 pretzels, how many
        servings of bite-sized pretzels was Marian able to prepare?
        */
		int pretzels = 480;
		int servings = pretzels / 12;
		System.out.println(servings);

        /* Exercise 44
        44. Lastly, she baked 53 lemon cupcakes for the children living in the city
        orphanage. If two lemon cupcakes were left at home, how many
        boxes with 3 lemon cupcakes each were given away?
        */
		int baked = 53;
		int totalB = baked / 3;
		System.out.println(totalB);

        /* Exercise 45
        45. Susie's mom prepared 74 carrot sticks for breakfast. If the carrots
        were served equally to 12 people, how many carrot sticks were left
        uneaten?
        */
		int prepared = 74;
		int leftC = prepared % 12;
		System.out.println(leftC);

        /* Exercise 46
        46. Susie and her sister gathered all 98 of their teddy bears and placed
        them on the shelves in their bedroom. If every shelf can carry a
        maximum of 7 teddy bears, how many shelves will be filled?
        */
		int preparedTB = 98;
		int shelvesFilled = preparedTB / 7;
		System.out.println(shelvesFilled);

        /* Exercise 47
        47. Susie’s mother collected all family pictures and wanted to place all of
        them in an album. If an album can contain 20 pictures, how many
        albums will she need if there are 480 pictures?
        */
		int familyPics = 480;
		int album = familyPics / 20;
		System.out.println(album);

        /* Exercise 48
        48. Joe, Susie’s brother, collected all 94 trading cards scattered in his
        room and placed them in boxes. If a full box can hold a maximum of 8
        cards, how many boxes were filled and how many cards are there in
        the unfilled box?
        */
		int tradingCards = 94;
		int boxesFilled = tradingCards / 8;
		int cardsLeft = tradingCards % 8;
		System.out.println("there are" + boxesFilled + "boxes filled and" + cardsLeft + "cards left");

        /* Exercise 49
        49. Susie’s father repaired the bookshelves in the reading room. If he has
        210 books to be distributed equally on the 10 shelves he repaired,
        how many books will each shelf contain?
        */
		int bookNumber = 210;
		int shelvesNeeded = bookNumber / 10;
		System.out.println(shelvesNeeded);
        /* Exercise 50
        50. Cristina baked 17 croissants. If she planned to serve this equally to
        her seven guests, how many will each have?
        */
		double croissantsBaked = 17;
		double eachGuest = croissantsBaked / 7;
		System.out.println(eachGuest);

	    /* Exercise 51
	    51. Bill and Jill are house painters. Bill can paint a standard room in 2.15 hours, while Jill averages
	    1.90 hours. How long will it take the two painters working together to paint 5 standard rooms?
	    Hint: Calculate the rate at which each painter can complete a room (rooms / hour), combine those rates, 
	    and then divide the total number of rooms to be painted by the combined rate.
	    */
		double roomPerHourBill = (1 / 2.15);
		double roomPerHourJill = (1 / 1.90);
		double oneRoomTime = 5 / (roomPerHourBill + roomPerHourJill);
		System.out.println(oneRoomTime);

	    /* Exercise 52
	    52. Create and assign variables to hold a first name, last name, and middle initial. Using concatenation,
		build an additional variable to hold the full name in the order of last name, first name, middle initial. The
		last and first names should be separated by a comma followed by a space, and the middle initial must end
		with a period. Use "Grace", "Hopper, and "B" for the first name, last name, and middle initial.
		Example: "John", "Smith, "D" —> "Smith, John D."
	    */
		String firstName = " Grace";
		String lastName = "Hopper,";
		String middleInitial = " B.";
		String fullName = (lastName + firstName + middleInitial);
		System.out.println(fullName);




	    /* Exercise 53
	    53. The distance between New York and Chicago is 800 miles, and the train has already travelled 537 miles.
	    What percentage of the trip as a whole number has been completed?
	    */
		int distanceNewYorkChicago = 800;
		int distanceTraveled = 537;
		double percentageOfDistanceTravels = (distanceTraveled / (double) distanceNewYorkChicago) * 100;
		int value = (int)percentageOfDistanceTravels;
		System.out.println(value);
	}

}
