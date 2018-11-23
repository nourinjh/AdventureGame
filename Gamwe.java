/**
 * 
 * @author  Nourin Abd El Hadi
 * @version 1.8 (final)
 * @since June 8th, 2018
 */

class Game{
    
	//instantiating variables
	private static Parser parser;
    private static Room currentRoom;
    public static int counter = 0;
    
    public static Backpack[] thing = new Backpack[9];
    		
	
    //initializes the map 
    public Game(){
    		createRooms();
    		parser = new Parser();
    }

    //instantiates all the room objects in the 'room' array and 'thing' array
    private void createRooms(){
	
	Room[] room = new Room[10];

	// create the rooms
	room[1] = new Room("at Nathan Phillips Square in Toronto, Canada. There is an ice skating rink and a large sign that spells 'Toronto'.", 1, "Toronto", false,  
			"There aren't that many people out, but the ones that are seem to be enjoying themselves on the ice rink. \nYou take a closer look at the ice rink notice"
			+ " a bacterium named coldeium.");
	
	room[2] = new Room("at the Lincoln Memorial in Washington D.C., U.S.A. The Lincoln Memorial has a relecting pool in front of it.", 2, "Washington", false,
			"Many people crowd around the memorial building, but the glisening pool catches your attention. \nThe reflecting pool looks clean, but you observe a bacterium named coughtous in it." );
	
	room[3] = new Room("at a beach in Kingston, Jamaica. The turquoise ocean and the white sand glisen under the sun's rays.", 3, "Kingston", false,  
			"Looking out on the sand, you see a coconut tree. \nThere is a coconut that contains the bacterium infectious." );
	
	room[4] = new Room("at the 'Christ the Redeemer' Statue in Rio de Janeiro, Brazil.", 4, "Rio de Janeiro", false, 
			"The 'Christ the Redeemer' towers over your small body, but you notice next to the statue there are some garbage cans, where you see a mosquito." );
	
	room[5] = new Room("at Bondi Beach in Sydney, Austrialla. You start to feel a little nervouse because you know that Australlia is known for its dangerous creatures.", 5, "Sydeny", false, 
			"You look out to the shore and notice how busy it is. Near the water, you spot a peculiar object. It looks like a transporter!" );
	
	room[6] = new Room("at Namsan Tower in Seoul, South Korea. There is a large tower and a small building.", 6, "Seoul", false, 
			"There seems to be nothing of use here..." );
	
	room[7] = new Room("at the Egyptian Museum in Cairo, Egypt. Inside the massive building, you take in all the different artifacts.", 7, "Cairo", false, 
			"You observe the artifacts carefully and you notice something interesting on Tutankhamun's bust. There is a bacteria called activia!" );
	
	room[8] = new Room("at the Red Square in Moscow, Russia. It's really cold this time of year and you start to feel a little cold...", 8, "Moscow", false, 
			"You look around and notic a sheild in the cracks of the pavement." );
	
	room[9] = new Room("at the London Eye in London, England. There is a ferris wheel and a sewer lid.", 9, "London", false, 
			"The sewer lid contains the bacteria lethelous that begins the apocolypse." );
	
	// Initialize room exits
	room[1].setExits(null, null, room[2], null);
	room[2].setExits(room[1], null, room[3], null);
	room[3].setExits(room[2], room[4], null, null);
	room[4].setExits(room[5], null, null, room[3]);
	room[5].setExits(room[6], null, room[4], null);
	room[6].setExits(null, room[7], room[5], null);
	room[7].setExits(null, null, room[8], room[6]);
	room[8].setExits(room[7], null, room[9], null);
	room[9].setExits(null, room[7], null, room[4]);

	//starts the game in Toronto
	currentRoom = room[1];  
	
	
	//instantiating the items in the backpack object 
	thing[1] = new Backpack("coldeium", false, false, "Coldeium helps you become more immune to the cold, perfect for Moscow!", 1, 9);
	thing[2] = new Backpack("coughtous", false, false, "Coughtous helps you spread through coughing, perfect for crowded places like Bondi Beach in Australlia!", 2, 5);
	thing[3] = new Backpack("infectious", false, false, "Infectious allows you to spread through food easily. It could be useful in South America!", 3, 4);
	thing[4] = new Backpack("mosquito", false, false, "Mosquitos allow you to navigate through humid countries and helps to infect more people. Could be useful in Jamaica!", 4, 3);
	thing[5] = new Backpack("activia", false, false, "Activia turns on all the other bacteria that were collected and it should be used as soon as possible.", 7, 7);
	thing[6] = new Backpack("sheild", false, false, "This sheild gives you protection from any other creatures that might harm you! Using it would be wise.", 8, 8);

   }
    

    /**
     *  Main play routine.  Loops until end of play.
     */
    public static void play(){            
	
    		printWelcome();

    		// Enter the main command loop where the program reads the commands and executes them repeatedly
    		
    		boolean finished = false;
	
    		while (! finished) {
    			Command command = parser.getCommand();
    			finished = processCommand(command);

    		}
	
    
    }


    private static void printWelcome(){
        	
        	//printing out the welcome message to the player
    		System.out.println();
    		System.out.println("Welcome Virus!");
    		System.out.println("You are a dormant virus on a tourist that wants to travel the world, your goal is to infect the world!");
    		System.out.println("Your command words are: go ~ look ~ take ~ use ~ quit ~ help ~ inventory ");
    		System.out.println("Type 'help' if you need help.");
    		System.out.println();
    		System.out.println("You are " + currentRoom.getDescription() + "\n");
    		System.out.print("Exits: south");
    		System.out.println();
    }

    /**
     * 
     * @return wantToQuit
     **/
    private static boolean processCommand(Command command) {
	
    		boolean wantToQuit = false;

    		if(command.isUnknown()) {
    			System.out.println("I don't know what you mean...");
    			return false;
    		}

    		String commandWord = command.getCommandWord();
	
    		if(commandWord.equals("help")){
    			printHelp();
    		}else if(commandWord.equals("go")) {
    			goRoom(command);
    		}else if(commandWord.equals("quit")) {
    			wantToQuit = quit(command);
    		}else if(commandWord.equals("look")) {
    			look(command);
    		}else if(commandWord.equals("take")) {
    			take(command);
    		}else if(commandWord.equals("use")) {
    			use(command);
    		}else if(commandWord.equals("inventory")) {
    			inventory(command);
    		}
    		
    		return wantToQuit;
    }

    
    private static void printHelp(){
    	
    		//Printing out information in case the user gets stuck
    		System.out.println("You need to find something to either increase your lethality or protect you from being cured! ");
    		System.out.println("Remember, the more points you get, the more likely you are to win!");
    		System.out.println();
		System.out.println("Your command words are:");
		System.out.println("   go ~ quit ~ help ~ take ~ look ~ inventory");
		
    }

   /**
    * Checks if the room has exits, and if it does, it prints out all possibilities.
    * If user asks to go to an exit that doesn't exist, they'll be told.
    * Checks and prints out if the user has visited that room before.
    * 
    * @param command - uses the command word 'go'
    */
    private static void goRoom(Command command){
    		
    		//checking if there's a second word
    		if(!command.hasSecondWord()) {
    			System.out.println("Go where?");
    			return;
    		}

    		String direction = command.getSecondWord();

	    //checking which direction the user inputed and then checking if that exit exists
		Room nextRoom = null;
		if(direction.equals("north"))
			nextRoom = currentRoom.northExit;
			currentRoom.visited = true;
		if(direction.equals("east"))
			nextRoom = currentRoom.eastExit;
			currentRoom.visited = true;
		if(direction.equals("south"))
			nextRoom = currentRoom.southExit;
			currentRoom.visited = true;
		if(direction.equals("west"))
			nextRoom = currentRoom.westExit;
			currentRoom.visited = true;

		if (nextRoom == null) {
			System.out.println("You can't go that way!");
		}else {
			
			currentRoom = nextRoom;
			System.out.println("You are " + currentRoom.getDescription() + "\n");
			System.out.println("Exits: ");
			
			if(currentRoom.northExit != null) {
				System.out.println("~north");
			}
			if(currentRoom.eastExit != null) {
				System.out.println("~east");
			}
			if(currentRoom.southExit != null) {
				System.out.println("~south");
			}
			if(currentRoom.westExit != null) {
				System.out.print("~west");
				System.out.println();
			}
			if(currentRoom.visited == true) {
	    			System.out.print("\nYou've been here before!");
	    			System.out.println();
			}
			
			//checking if the player has enough points to win once they enter the last room
			if(currentRoom.getNum() == 9) {
				if(counter >= 2500) {
					System.out.println("Congratulations, you infected the world! You got " +counter+ " points! Thank you for playing Virus! Good bye!");
					System.exit(0);
				}else if(counter<2500) {
					System.out.println("You didn't find enough bacteria to infect the world! You lost!");
					System.exit(0);
				}
			}
		}
    }
    
    /**
     * Once the user uses the command 'look', a more detailed description (with items) gets printed.
     * 
     * @param command - uses the command word 'look'
     */
    private static void look(Command command) {
    		
    		System.out.println(currentRoom.getLooking());
    		
    }
    
    /**
     * Checks if the input after the command 'take' is the same as the item in that room's name.
     * Checks if there is a second word.
     * Checks if the object was taken before.
     * The program crashes at this point if the item is spelled incorrectly.
     * 
     * @param command - represents the 'take' command.
     */
    private static void take(Command command) {
    		
    		String taking = command.getSecondWord();
    		
    		if(!command.hasSecondWord()) {
    			System.out.println("Take what?");
  
    		}else {
    			int compare = 0;
    			//for loop to run through all the items in the thing array until one of them matches
    			for(int i = 1; i<7; i++) {
    				if(command.getSecondWord().equals(thing[i].getItem())) {
    					compare = i;
    				}
    			}
        			//if statements to check if item can be taken or if it was taken before
    				if(taking.equals(thing[compare].getItem()) && currentRoom.getNum() == (thing[compare].getNum())) {
        				if(thing[compare].getTaken() == true) {
        					System.out.println("You already have that!");
        				}else {
        					System.out.print(thing[compare].getItem() + " was taken! " + thing[compare].getItemDescription());
        					System.out.println();
        				}
        				thing[compare].taken = true;
    				}else if(!command.hasSecondWord()) {
    					System.out.println("Take what?");
    					System.out.println();
    				}else if(!taking.equals(thing[compare].getItem())) {
    					System.out.println("You can't take that!");
    					System.out.println();
    				}
    			}
    			
    		}
	
    /**
     * Allows the user to use the item they picked up if it is in the right room.
     * If the user uses the item in the right room, they get 500 points.
     * There is a transporter but it does not work at the moment
     * 
     * @param command
     */
    private static void use(Command command) {
    			
    			//making sure there is a second word
    			if(command.getSecondWord().equals("transporter") && currentRoom.getNum() == 5){  		
    				currentRoom = parseInt(Math.random()*9);
    			}
    			
    			if(!command.hasSecondWord()) {
    				System.out.print("Uses what?");
    				System.out.println();
    			}else {
    				
    				int compare = 0;
    				//for loop to run through all the items in the thing array until one of them matches
    				for(int j = 1; j<7; j++) {
    					if(command.getSecondWord().equals(thing[j].getItem())) {
    						compare = j;
    					}
    				}
    			
    				//checking if the item can be used in the current room, if they have it or if it was already used
    				if(currentRoom.getNum() == thing[compare].getUseNum()) {
    					if(thing[compare].wasUsed == false) {
    						System.out.print(thing[compare].getItem() + " was used!");
    						System.out.println();
    						counter += 500;
    						System.out.println("Points: " +counter);
    					}else {
    						System.out.print(thing[compare].getItem() + " was already used!");
    						System.out.println();
    					}
    					thing[compare].wasUsed = true;
    					}else if(currentRoom.getNum() != thing[compare].getUseNum()){
    						System.out.print("You can't use this here!");
    						System.out.println();
    					}else if(thing[compare].taken == false) {
    						System.out.print("You don't have this item!");
    						System.out.println();
    					}
    			}
    			
    }
    
    /**
     * Inventory command allows users to view the items they have collected.
     * 
     * @param command - inventory
     */
    private static void inventory(Command command) {
    		
    		if(command.hasSecondWord()) {
    			System.out.println("I don't know what you mean...");
    		}else{
    			int l;
    			for(l = 1; l<7; l++) {
    			
    				if(thing[l].getTaken() == true && thing[l].getWasUsed() == false) {
    					System.out.println("~" + thing[l].getItem());
    					System.out.println("     -" + thing[l].getItemDescription());
    				}else if(thing[l].getWasUsed() == true) {
    					System.out.println("");
    				}
    			}

    		}
    }

	private static Room parseInt(double random) {
		return null;
	}

	/** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game. Return true, if this command
     * quits the game, false otherwise.
     */
    private static boolean quit(Command command){
    		if(command.hasSecondWord()) {
    			System.out.println("Quit what?");
    			return false;
    		}else {
    			return true;  // signal that we want to quit
    		}
    	}	
}
