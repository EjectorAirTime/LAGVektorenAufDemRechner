package bonusaufgabe;
import bonusaufgabe.Vektor2D;
/**
 * @author Maximilian Kreutz
 * @author Jan Fenau
 */
public class Punkt2D {
	// Attribute
	private double x;
	private double y;
	
	
	// Getter & Setter
	public final double getX(){
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public final double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	
	
	// Kosntruktoren
	public Punkt2D() {
		this.x=0;
		this.y=0;
	}
	public Punkt2D(double a, double b) {
		this.x=a;
		this.y=b;
	}
	public Punkt2D (Punkt2D copy) {
		this(copy.x, copy.y);
	}
	
	
	// Objektmethoden
	public double dist(Punkt2D a) {
		return dist(this,a);
	}
	public Vektor2D Ortsvektor() {
		return new Vektor2D(new Punkt2D(), this);
	}
	public Vektor2D VektorMitDiesemPunkt(Punkt2D a) {
		return new Vektor2D(this,a);
	}
	
	
	// Klassenmethoden
	public static Vektor2D VektorAusZweiPunkten(Punkt2D a, Punkt2D b) {
		return new Vektor2D(a,b);
	}
	public static double dist(Punkt2D a, Punkt2D b) {
		return Math.sqrt((b.x-a.x)*(b.x-a.x)+(b.y-a.y)*(b.y-a.y));
	}
	
	
	// To String-Methode
	public String toString() {
		return "( " + this.x + " , " + this.y + " )";
 	}
}
