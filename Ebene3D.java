package bonusaufgabe;
/**
 * @author Maximilian Kreutz
 * @author Jan Fenau
 */
public class Ebene3D {
	// Attribute
	private double a;
	private double b;
	private double c;
	private double d;
	private Vektor3D u;
	private Vektor3D v;
	private Vektor3D normale;
	private Punkt3D p;
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
	public final double getD() {
		return d;
	}
	public double getAHesseNF() {
		return (this.a/Vektor3D.dist(this.normale));
	}
	public double getBHesseNF() {
		return this.b/Vektor3D.dist(this.normale);
	}
	public double getCHesseNF() {
		return this.c/Vektor3D.dist(this.normale);
	}
	public double getDHesseNF() {
		return this.d/Vektor3D.dist(this.normale);
	}
	public final Vektor3D getRichungsVektorU() {
		return u;
	}
	public final Vektor3D getRichtungsVektorV() {
		return v;
	}
	public final Vektor3D getNormale() {
		return normale;
	}
	public final Punkt3D getP() {
		return p;
	}
	
	
	// Konstruktoren
	public Ebene3D() throws Exception {
		this(new Punkt3D(), new Vektor3D(), new Vektor3D());
	}
	public Ebene3D(Punkt3D auf, Vektor3D r1, Vektor3D r2) throws Exception {
		if (!r1.LinearAbhängig(r2)) {
		this.p = auf;
		this.u = r1;
		this.v = r2;
		this.a = u.getY()*v.getZ() - u.getZ() * v.getY();
		this.b = u.getZ() * v.getX() - u.getX() * v.getZ();
		this.c = u.getX() * v.getY() - u.getY()*v.getX();
		this.d = -(this.a*p.getX()+ this.b*p.getY() + this.c*p.getZ() );
		this.normale = new Vektor3D(this.a, this.b, this.c);
		}
		else	
			throw new Exception("Richtungsvektoren sind linear abhängig!");
	}
	public Ebene3D(Punkt3D P1, Punkt3D P2, Punkt3D P3) throws Exception {
		this(P1,new Vektor3D(P1,P2), new Vektor3D(P1, P3));
	}
	public Ebene3D(Ebene3D copy) {
		this.a = copy.a;
		this.b = copy.b;
		this.c = copy.c;
		this.d = copy.d;
		this.p = copy.p;
		this.u = copy.u;
		this.v = copy.v;
		this.normale = copy.normale;
	}
	public Ebene3D(double a, double b, double c, double d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.normale = new Vektor3D(a, b, c);
		/*
		 * a*X + b*Y + c*Z + d = 0;s
		 * 
		 * P1:		z = -d/c;
		 * P2:		x = -d/a,
		 * P3: 		y = -d/b;
		*/
		Punkt3D P1 = new  Punkt3D (0,0, -d/c);
		Punkt3D P2 = new Punkt3D(-d/a, 0,0);
		Punkt3D P3 = new Punkt3D(0, -d/b,0);
		this.p = P1;
		this.v = new Vektor3D(P1, P2);
		this.u = new Vektor3D(P1, P3);
	}
	
	
	// Objektmethoden
	public Gerade3D berechneSchnittGerade(Ebene3D f)  throws Exception{
		return berechneSchnittGerade(this, f);
	}
	public double getDist_p(Punkt3D t) {
		return Math.abs(getDistOrientated(t));
	}
	public double getDistOrientated(Punkt3D t) {
		return Vektor3D.SkalarProdukt(new Vektor3D(p, t), this.normale)/Vektor3D.dist(normale);
	}
	public boolean pruefePunkt(Punkt3D t) {
		return (Math.abs(this.a*t.getX()
				+this.b*t.getY()
				+this.c*t.getZ()
				+d) < EPSILON)?true:false;
	}
	public double berechneSchnittWinkel(Ebene3D f) {
		return Ebene3D.berechneSchnittWinkel(this, f);
	}

	// Klassenmethoden
	public static double berechneSchnittWinkel(Ebene3D e, Ebene3D f) {
		Vektor3D a = new Vektor3D (e.a,e.b,e.c);
		Vektor3D b = new Vektor3D (f.a,f.b,f.c);
		return Vektor3D.berechneWinkel(a,b);
	}
	public static Gerade3D berechneSchnittGerade(Ebene3D e,Ebene3D f) throws Exception {
		
		if(e.normale.LinearAbhängig(Vektor3D.VektorProdukt(f.u, f.v))) {
			if (e.pruefePunkt(f.p) || f.pruefePunkt(e.p))
				throw new Exception("Ebenen sind gleich");
			throw new Exception("Ebenen sind parallel !");
		}
		/* x = f.p.getX() + r*e.v.getX() + s*e.u.getX()
		 * y = f.p.getY() + r*e.v.getY() + s*e.u.getY()
		 * z = f.p.getZ() + r*e.v.getZ() + s*e.u.getZ()
		 * 
		 * e.a * x + e.b * y + e.c * z + d = 0
		 * 		e.a*(f.p.getX() + r*f.v.getX() + s*f.u.getX() ) 
		 * + 	e.b*(f.p.getY() + r*f.v.getY() + s*f.u.getY() )
		 * +	e.c*(f.p.getZ() + r*f.v.getZ() + s*f.u.getZ() ) = -e.d
		 * 
		 * e.a* f.p.getX() + e.b* f.p.getY() + e.c* f.p.getZ()
		 * r *=(e.a*f.v.getX()+ e.b*f.v.getY() + e.c* f.v.getZ())
		 * s *= (e.a.f.u.getX() + e.b*f.u.getY() + e.c* f.u.getZ() 
		 */
		double s = 1;
		s *= (e.a*f.v.getX()+ e.b*f.v.getY() + e.c* f.v.getZ());
		double r = 1;
		r *=(e.a * f.u.getX() + e.b*f.u.getY() + e.c* f.u.getZ() );
		double d = 1;
		d = -e.d - (e.a* f.p.getX() + e.b* f.p.getY() + e.c* f.p.getZ());
		// s = d -r;
		r /=s;
		d /=s;
		s/=s;
		Vektor3D kombi = new Vektor3D(	f.u, Vektor3D.SkalaresVielfaches(f.v, -r)	);
		// System.out.println(kombi);
		Punkt3D auf = new Punkt3D (	f.p.getX() + d*f.v.getX(),
									f.p.getY() + d*f.v.getY(),
									f.p.getZ() + d*f.v.getZ());
		return new Gerade3D(auf, kombi);
	}
		
	// To-String Methode
	public String toString() {
		return (this.a + " *X + " + this.b + " *Y + " + this.c + " *Z + " + this.d + " = 0\n"
				+ this.p + " + r* " + this.v + " + s* " + this.u);
	}
	
	
}
