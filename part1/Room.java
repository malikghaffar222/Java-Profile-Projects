/*
 * Class that stores the positions of all the entities
 * Methods to add entities, display the room, display information are not implemented
 */

import java.util.ArrayList;

public class Room {
 // List with all the entities
   


 /**
  * Set up a new room with entities in random places
  * first the room, must be clear of entities
  */
    public void resetRoom() {
        clearRoom();
   }
   
    /**
     * method that adds a new entity into a position
     * PRE: position (x,y) must be empty
     * @param e The entity 9<=x<9 and 0<=y<9
     *
     */
    public void addNewEntityinRoom(Entity e, int x, int y ) {
        
    }

    /**
     * Empty the list of entities
     */
    public void clearRoom() {
        
    } 



    /**
     *  Method that tell us if a cell is occupied by an entity
     * @param x  row 0 <= x <= 9
     * @param y column 0 <= y <= 9
     * @return true is cell occupied
     */
    public boolean isFree(int x, int y) {
        
        return true;

    }

    /**
     *  Method that returns the position  occupied by an entity 
     * given its coordinates
     * @param x  row 0 <= x <= 9
     * @param y column 0 <= y <= 9
     * @return position in the list or -1 if the cell is free
     */
    private int getPosition (int x, int y) {
        return -1;
        
    }

    /**
     * Display all the properties of an entity that occupies a particular cell
     * PRE: Cell must not be empty
     * @param x row 0<= x <=9
     * @param y column 0<=y<=9
     * @return String with the properties of the entity or
	 *  	
     */
    public String displayEntity (int x, int y) {
        return ("");
    }
    
    
    /**
     * method that moves all the entities 
     */
    public void move() {
    
}

    /**
     * Display the room in ASCII 
     */
    
    
    public String toString() {
       return ("");
    }
}

