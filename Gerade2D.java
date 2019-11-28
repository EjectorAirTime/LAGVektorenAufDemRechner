package bonusaufgabe;
/**
 * @author Maximilian Kreutz
 * @author Jan Fenau
 *
 */
public class Gerade2D {
	// Attribute
	private double a;
	private double b;
	private double c;
	private Vektor2D v;
	private Punkt2D p;
	private Vektor2D normale;
	private static final double EPSILON = 10E-6;
	
	
	// Getter & Setter
	public final double getA() {
		return a;
	}
	public final double getB() {
		return b;
	}
	public final double getC() {
		return c;
	}
	public final Vektor2D getV() {
		return v;
	}
	public final Punkt2D getP() {
		return p;
	}
	public double getAHesseNF() {
		return (this.a/Vektor2D.dist(this.getNormale()));
	}
	public double getBHesseNF() {
	return this.b/Vektor2D.dist(this.getNormale());
	}
	public double getCHesseNF() {
		return this.c/Vektor2D.dist(this.getNormale());
	}
	public Vektor2D getNormale() {
		return new Vektor2D(v.getY(), -v.getX());
	}
	
	// Konstruktoren
	public Gerade2D() {
		this(new Punkt2D(),new Vektor2D());
	}
	public Gerade2D(Punkt2D p, Vektor2D v) {
		this.p = p;
		this.v = v;
		this.normale = this.getNormale();
		if (Math.abs(v.getY())> EPSILON) {
			this.a = 0;
			this.b = -(v.getX()-v.getY());
			this.c = v.getX()/v.getY()*p.getY()-p.getX();
			}
		if (Math.abs(v.getY()) < EPSILON && Math.abs(v.getX()) > EPSILON ){
			this.a = 0.0;
			this.b = 1;
			this.c = - p.getY();
		}
	}
	public Gerade2D (Punkt2D p, Punkt2D q) {
		this.p = p;
		this.v = new Vektor2D(p, q);
		this.normale = this.getNormale();
		if (Math.abs(v.getY())> EPSILON) {
			this.a = 0;
			this.b = -(v.getX()-v.getY());
			this.c = v.getX()/v.getY()*p.getY()-p.getX();
			}
		if (Math.abs(v.getY()) < EPSILON && Math.abs(v.getX()) > EPSILON ){
			this.a = 0.0;
			this.b = 1;
			this.c = - p.getY();
		}
	}
	public Gerade2D(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
		if (Math.abs(this.a) > EPSILON) {
			this.p.setX(-this.c/this.a);
			this.p.setY(0);
			this.v.setX(-this.b/this.a);
			this.v.setY(1);
		}
		if (Math.abs(this.a) < EPSILON && Math.abs(this.b) > EPSILON) {
			this.p.setX(0);
			this.p.setY(-this.c/this.b);
			this.v.setX(1);
			this.v.setY(0);
		}
		this.normale = this.getNormale();
	}
	public Gerade2D(Gerade2D copy) {
		this.a = copy.a;
		this.b = copy.b;
		this.c= copy.c;
		this.p = copy.p;
		this.v = copy.v;
		this.normale = copy.normale;
	}
	
	
	// Objektmethoden
	public boolean PunktAufGerade(Punkt2D p) {
		return (Math.abs(this.a*p.getX()+this.b*p.getY()+this.c) < EPSILON)?true:false;
	}
	public double dist_p(Punkt2D p) {
		return Math.abs(distOrientated(p));
	}
	public double distOrientated(Punkt2D x) {
		return (Vektor2D.SkalarProdukt(new Vektor2D(this.p, x), this.getNormale()))/Vektor2D.dist((this.getNormale()));
	}
	public Punkt2D berechneSchnittpunkt(Gerade2D g) throws Exception {
		return berechneSchnittpunkt(this, g);
	}
	
	
	// Klassenmethoden
	public static Punkt2D berechneSchnittpunkt(Gerade2D g, Gerade2D h) throws Exception{
		double test1;
		test1 = g.v.getX() / h.v.getX();
		double test2;
		test2 = g.v.getY() / h.v.getY();
		
		
		if (Math.abs(g.v.getY()- test1* h.v.getY()) < EPSILON
				|| Math.abs(g.v.getX()- test2* h.v.getX()) < EPSILON ) {
			throw new Exception("Linear abhängig. Es gibt keinen echten Schnittpunkt!");
		}
		else {
			System.out.println("Linear unabhängig");
			double length = g.dist_p(h.p);
			return new Punkt2D(h.p.getX()-length*h.v.getX(),
					h.p.getY()-length*h.v.getY());
			}		
	}
	
	
	// ToString Methode
	public String toString() {
		return ("( " + this.p.getX() + " , " + this.p.getY() + " ) + s* ( " +this.v.getX()+" , " + this.v.getY() + " )");
	}
}