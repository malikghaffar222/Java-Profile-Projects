
import java.util.List;
import java.util.LinkedList;
import java.util.Observable;

public class BounceModel extends Observable {
    
    private List<Shape> shapes  = new LinkedList<Shape>();
    private List<Wall> walls = new LinkedList<Wall>();
    
    public void addShape(Shape shape){
        shapes.add(shape);
    }
    
    public void addWall(Wall wall) {
        walls.add(wall);
    }
    
    public void moveShapes(double time) {
        int first = 1;
        int size = shapes.size();
        for (Shape s:shapes) {
            for (Wall w: walls) {
                s.interactWall(w);
            }
            for(Shape s2: shapes.subList(first, size)) {
                s.interactShape(s2);
            }
            first++;
        }
        for (Shape s:shapes) {
            s.move(time);
        }
       setChanged();
        notifyObservers();
    }
}
