
public interface Moveable {
    public void move(double  time);
    public double getX();
    public double getY();
    public void setVelocity(double vx, double vy);
    public double getContactRadius();
    public double getMass();
}
