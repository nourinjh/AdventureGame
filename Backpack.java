
public class Backpack {
	
	//instantiating variables
	String item;
    public boolean taken;
    public boolean wasUsed;
    public String itemDescription;
    public int num;
    public int useNum;
    
    /**
     * constructor for the backpack object
     * 
     * @param item - Stores the item's name.
     * @param taken - checks whether the item has been taken or not.
     * @param wasUsed - checks if the item was used before.
     * @param itemDescription - Stores the item's description
     * @param num - The room number that the item can be found in.
     * @param useNum - The room number that the item can be used in.
     */
    public Backpack(String item,  boolean taken, boolean wasUsed, String itemDescription, int num, int useNum) {
    		this.item = item;
    		this.taken = taken;
    		this.wasUsed = wasUsed;
    		this.itemDescription = itemDescription;
    		this.num = num;
    		this.useNum = useNum;
    }
    
    //accessors and mutators
    public String getItem() {
    		return item;
    }
    public void setItem(String i) {
    		i = item;
    }
   
    public boolean getTaken(){
        return taken;
    }
    public void setTaken(boolean t) {
    		t = taken;
    }
    
    public boolean getWasUsed(){
        return wasUsed;
    }
    public void setWasUsed(boolean w) {
    		w = wasUsed;
    }
    
    public String getItemDescription() {
		return itemDescription;
    }
    public void setItemDescription(String id) {
    		id = itemDescription;
    }
    
    public int getNum() {
    		return num;
    }
    public void setNum(int nu) {
    		nu = num;	
    }
    
    public int getUseNum() {
		return useNum;
    }
    public void setUseNum(int un) {
		un = useNum;	
    }
    
}
