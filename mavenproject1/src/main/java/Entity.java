/*
 * Abstract Class Entity
 * 
 */

public abstract class Entity {
 private String symbol; // symbol that represents the entity
 private String type; // every entity is of a type
 private int x; // x coordinate in the room
 private int y; // y coordinate in the room
 private String name;
 
 public Entity () {
     type = "entity";
     symbol = "E";
     
          
 }

 public String getSymbol() {
     return symbol;
 }
 
 public void setSymbol(String s) {
     symbol = s;
 }

 public int getX() {
     return x;
 }
 
 public int getY() {
     return y;
 }
 public void move (int x, int y) {
    this.x=x;
    this.y=y;
 }

 public String getType() {
     return type;
 }
 
 public void setType(String type) {
     this.type = type;
 }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

 
/**
 * 
 * @return string with information about an abstract entity 
 */
   public String toString() {      
       String st = "Entity Properties \n";
       st = st + "TYPE:  " + type + "Name " + name;
       return st;
   }

}
