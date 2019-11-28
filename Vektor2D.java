package bonusaufgabe;

/**
 * @author Maximilian Kreutz
 * @author Jan Fenau
 */

public class Vektor2D {
	// Attribute
	private double x;
	private double y;
	private static final double Epsilon = 10E-9;
	
	
	//getter & Setter
	public final double getX() {
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
	
	
	//Konstruktoren
	public Vektor2D() {
		this.x =0;
		this.y = 0;
	}
	public Vektor2D(Vektor2D a, Vektor2D b) {
		this(a.x+b.x, a.y+b.y);
	}
	public Vektor2D(Vektor2D copy) {
		this(copy.x, copy.y);
	}
	public Vektor2D(double a, double b) {
		this.x = a;
		this.y = b;
	}
	public Vektor2D(Punkt2D a, Punkt2D b) {
		this( (b.getX()-a.getX()), (b.getY()-a.getY()));
	}
	
	
	// ObjektMethoden
	public void addiere(Vektor2D a) {
		this.x +=a.x;
		this.y +=a.y;
	}
	public void subtrahiere(Vektor2D a) {
		this.x -=a.x;
		this.y -=a.y;
	}
	public void SkalaresVielfaches(double lambda) {
		this.x *=lambda;
		this.y *=lambda;
	}
	public double SkalarProdukt(Vektor2D a) {
		 return SkalarProdukt(this,a);
	}
	public boolean LinearAbh‰ngig(Vektor2D a) {
		return LinearAbh‰ngig(this,a);
	}
	public double dist() {
		return dist(this);
	}
	public Vektor2D OrthogonalProjektion(Vektor2D v) {
		return OrthogonalProjektionVon1Auf2(this, v);
	}
	public double berechneWinkel(Vektor2D a) {
		return berechneWinkel(this,a);
	}
	public double berechneWinkelBogenMaﬂ(Vektor2D v) {
		return berechneWinkelBogenMaﬂ(v, this);
	}
	
	
	// Klassenmethoden
	public static Vektor2D SkalaresVielfaches(Punkt2D a, double lambda) {
		return new Vektor2D(a.getX()*lambda, a.getY()*lambda);
	}
	public static double berechneWinkelBogenMaﬂ(Vektor2D v, Vektor2D u) {
		return Math.acos(SkalarProdukt(u, v)/ (dist(u)+dist(v)));
	}
	public static double SkalarProdukt(Vektor2D a, Vektor2D b) {
		return a.x*b.x+a.y*b.y;
	}
	public static Vektor2D  addiere(Vektor2D a, Vektor2D b) {
		return new Vektor2D(a.x+b.x, a.y+b.y);
	}
	public static Vektor2D  subtrahiere(Vektor2D a, Vektor2D b) {
		return new Vektor2D(a.x-b.x, a.y-b.y);
	}
	public static double dist(Vektor2D a) {
		return Math.sqrt((a.x)*(a.x)+(a.y)*(a.y));
	}
	public static double berechneWinkel(Vektor2D a, Vektor2D b) {
		return Math.toDegrees((Math.acos(SkalarProdukt(a, b)/ (dist(a)+dist(b)))));
	}
	public static boolean LinearAbh‰ngig (Vektor2D a, Vektor2D b) {
		double skalar = a.x/b.x;
		return (a.y - skalar * b.y < Epsilon ? true : false);
	}
	public static Vektor2D OrthogonalProjektionVon1Auf2(Vektor2D a, Vektor2D b) {
		return SkalaresVielfaches(a, SkalarProdukt(a, b)/(dist(a) * dist(a)));
	}
	public static Vektor2D SkalaresVielfaches(Vektor2D a, double lambda) {
		return new Vektor2D(a.x*lambda, a.y*lambda);
	}
	
	
	// toString Methode
	public String toString() {
		return "( " + this.x + " , " + this.y + " )";
 	}
}
