package bonusaufgabe;

/**
 * @author Maximilian Kreutz
 * @author Jan Fenau
 */

public class Vektor3D {
	// Attribute
	private double x;
	private double y;
	private double z;
	private static final double Epsilon = 10E-9;
	
	
	// Getter & Setter
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
	public final double getZ() {
		return z;
	}
	public void setZ(double z) {
		this.z = z;
	}
	
	
	// Konstruktoren
	public Vektor3D() {
		this.x =0;
		this.y = 0;
		this.z = 0;
	}
	public Vektor3D(Vektor3D a, Vektor3D b) {
		this(a.x+b.x, a.y+b.y, a.z+b.z);
	}
	public Vektor3D(Vektor3D copy) {
		this(copy.x, copy.y, copy.z);
	}
	public Vektor3D(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public Vektor3D(Punkt3D a, Punkt3D b) {
		this( (b.getX()-a.getX()), (b.getY()-a.getY()), (b.getZ()-a.getZ()));
	}
	
	
	// ObjektMethoden
	public void addiere(Vektor3D a) {
		this.x +=a.x;
		this.y +=a.y;
		this.z +=a.z;
	}
	public void subtrahiere(Vektor3D a) {
		this.x -=a.x;
		this.y -=a.y;
		this.z = a.z;
	}
	public void SkalaresVielfaches(double lambda) {
		this.x *=lambda;
		this.y *=lambda;
		this.z *= lambda;
	}
	public double SkalarProdukt(Vektor3D a) {
		 return SkalarProdukt(this,a);
	}
	public boolean LinearAbh‰ngig(Vektor3D a) {
		return LinearAbh‰ngig(this,a);
	}
	public double dist() {
		return dist(this);
	}
	public Vektor3D OrthogonalProjektion(Vektor3D v) {
		return OrthogonalProjektionVon1Auf2(this, v);
	}
	public double berechneWinkel(Vektor3D a) {
		return berechneWinkel(this,a);
	}
	public double berechneWinkelBogenMaﬂ(Vektor3D v) {
		return berechneWinkelBogenMaﬂ(v, this);
	}
	public Vektor3D VektorProdukt(Vektor3D a) {
		return VektorProdukt(this, a);
	}
	
	
	// Klassenmethoden
	public static Vektor3D SkalaresVielfaches(Punkt3D a, double lambda) {
		return new Vektor3D(a.getX()*lambda, a.getY()*lambda, a.getZ()*lambda);
	}
	public static double berechneWinkelBogenMaﬂ(Vektor3D v, Vektor3D u) {
		return Math.acos(SkalarProdukt(u, v)/ (dist(u)+dist(v)));
	}
	public static double SkalarProdukt(Vektor3D a, Vektor3D b) {
		return a.x*b.x+a.y*b.y+ a.z*b.z;
	}
	public static Vektor3D  addiere(Vektor3D a, Vektor3D b) {
		return new Vektor3D(a.x+b.x, a.y+b.y,a.z*b.z);
	}
	public static Vektor3D VektorProdukt(Vektor3D u, Vektor3D v) {
		return new Vektor3D(u.y*v.z-u.z*v.y, u.z*v.x-u.x*v.z, u.x * v.y - u.y * v.x);
	}
	public static Vektor3D  subtrahiere(Vektor3D a, Vektor3D b) {
		return new Vektor3D(a.x-b.x, a.y-b.y, a.z-b.z);
	}
	public static double dist(Vektor3D a) {
		return Math.abs(Math.sqrt((a.x*a.x)+(a.y*a.y)+(a.z*a.z)));
	}
	public static double berechneWinkel(Vektor3D a, Vektor3D b) {
		return Math.toDegrees(Math.acos( (SkalarProdukt(a,b))/ (a.dist()+b.dist())));
	}
	public static boolean LinearAbh‰ngig (Vektor3D a, Vektor3D b) {
		double skalar = a.x/b.x;
		return ((Math.abs( a.x - (skalar * b.x )) < Epsilon && Math.abs(a.y - (skalar * b.y )) < Epsilon && (Math.abs(a.z -( skalar*b.z)) < Epsilon)) ? true : false);
	}
	public static Vektor3D OrthogonalProjektionVon1Auf2(Vektor3D a, Vektor3D b) {
		return SkalaresVielfaches(a, SkalarProdukt(a, b)/(dist(a) * dist(a)));
	}
	public static Vektor3D SkalaresVielfaches(Vektor3D a, double lambda) {
		return new Vektor3D(a.x*lambda, a.y*lambda, a.z*lambda);
	}
	public static double SpatProdukt(Vektor3D u, Vektor3D v, Vektor3D w) {
		return SkalarProdukt(u, (VektorProdukt(v, w)));
	}
	public static double SpatVolumen(Vektor3D u, Vektor3D v, Vektor3D w) {
		double a = SkalarProdukt(u, (VektorProdukt(v, w)));
		return (a<0?-a:a);
	}
	
	
	// ToStringMethode
	public String toString() {
		return "( " + this.x + " , " + this.y + " , " + this.z +" )";
 	}
	
}
