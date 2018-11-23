/**
 * Class Room - a room in an adventure game.
 * The main class where all the constructors, accessors and mutators are
 * 
 * @author  Nourin Abd El Hadi
 * @version 1.8 (final)
 * @since June 8th, 2018
 **/

class Room{
    public String description;
    public Room northExit;
    public Room southExit;
    public Room eastExit;
    public Room westExit;
    public int num;
    public String name;
    public boolean visited;
    public String looking;

    

   /**
    * The 'room' constructor
    * 
    * @param description - Stores the description of the room when the player enters it.
    * @param num - The number of the room.
    * @param name - Name of the room.
    * @param visited - Boolean to see if the room has been visited before or not.
    * @param looking - Stores the detailed description of a room and is shown when the 'look' command is used.
    * @param newLook - Stores the detailed description of a room when the item is taken.
    */
    public Room(String description, int num, String name, boolean visited, String looking){
       
    		this.description = description;
    		this.num = num;
    		this.name = name;
    		this.visited = visited;
    		this.looking = looking;

    }

    /**
     * Initializing the 4 possible exits
     * 
     * @param north - North exit
     * @param east - East exit
     * @param south - South exit
     * @param west - West exit
     */
    public void setExits(Room north, Room east, Room south, Room west) {
        if(north != null) {
            northExit = north;
        }if(east != null) {
            eastExit = east;
        }if(south != null) {
            southExit = south;
        }if(west != null) {
            westExit = west;
        }
    }

    //All accessors and mutators 
    public String getDescription(){
        return description;
    }
    public void setDescription(String d) {
    		d = description;
    }
    
    public int getNum(){
        return num;
    }
    public void setNum(int nu) {
    		nu = num;
    }
    
    public String getName(){
        return name;
    }
    public void setName(String na) {
    		na = name;
    }
    
    public boolean getVisited(){
        return visited;
    }
    public void setVisited(boolean v) {
    		v = visited;
    }
    
    public String getLooking() {
    		return looking;
    }
    public void setLooking(String l) {
    		l = looking;
    }
    
    
}
    