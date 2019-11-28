package bonusaufgabe;
/**
 * @author Maximilian Kreutz
 * @author Jan Fenau
 */
public class Gerade3D {
	// Attribute
	private Vektor3D v;
	private Punkt3D p;
	private static final double EPSILON = 10E-9;
	
	
	// Getter&Setter
	public final Vektor3D getV() {
		return v;
	}
	public final Punkt3D getP() {
		return p;
	}
	public Vektor3D getNormale() {
		return new Vektor3D(0, -this.getV().getZ(), this.getV().getY());
	}
	
	
	// Konstruktoren
	public Gerade3D() {
		this(new Punkt3D(),new Vektor3D());
	}
	public Gerade3D(Punkt3D p, Vektor3D v) {
		this.p = p;
		this.v = v;
	}
	public Gerade3D (Punkt3D p, Punkt3D v) {
		this.p = p;
		this.v = new Vektor3D(p, v);
	}
	public Gerade3D(Gerade3D copy) {
		this.p = copy.p;
		this.v = copy.v;
	}
	
	
	
	// Objektmethoden
	public boolean PunktAufGerade(Punkt3D p) {
		return (Math.abs(this.dist_p(p)) < EPSILON)?true:false;
	}
	public double dist_p(Punkt3D p) {
		return Math.abs(distOrientated(p));
	}
	public double distOrientated(Punkt3D x) {
		return Vektor3D.SkalarProdukt(new Vektor3D(this.p, x), this.getNormale())/Vektor3D.dist((this.getNormale()));
	}
	public Punkt3D berechneSchnittpunkt(Gerade3D g) throws Exception {
		return berechneSchnittpunkt(this, g);
	}
	
	
	// Klassenemthoden
	public static Punkt3D berechneSchnittpunkt(Gerade3D g, Gerade3D h) throws Exception {
		if (Vektor3D.LinearAbhängig(g.v, h.v)) {
			if (g.PunktAufGerade(h.p)) {
				throw new Exception("Die Geraden sind identisch! ");
			}
			throw new Exception("Linear abhängig! Parallele Geraden");
		}
		/*	|  g.p + s* g.v = h.p + r* h.v  	|
		 * 	
		 *	| g.p.x + r*g.v.x = h.p.x +s*h.v.x	|
		 *	| g.p.y + r*g.v.y = h.p.y +s*h.v.y	|
		 *	| g.p.z + r*g.v.z = h.p.z +s*h.v.z	|
		 *	
		 * 
		 */
		double [] [] lgs = {	{g.v.getX(), h.v.getX(), g.p.getX()-h.p.getX(),},
								{g.v.getY(), h.v.getY(),g.p.getY()-h.p.getY() },
								{g.v.getZ(), h.v.getZ(), g.p.getZ()-h.p.getZ() },
		};
		double r = solveLGS(lgs);
		Punkt3D schnitt = new Punkt3D(	g.p.getX()+r*g.v.getX(),
										g.p.getY()+r*g.v.getY(),
										g.p.getZ()+r*g.v.getZ());
		return schnitt;
		
		
	}
	private static double solveLGS(double[][] lgs) {
		// Source: https://www.virtual-maxim.de/losen-linearer-gleichungssysteme-mit-gaus-jordan-algorithmus/
		printLGS(lgs);
		// Nutze alle 3 Zeilen bei 2 Unbekanten
	
		if (Math.abs(lgs[0][0])< EPSILON && Math.abs(lgs[1][0]) > EPSILON) {
			ChangeRow(lgs, 2, 1);
			// Wechsle Zeile falls erste Zeile, erste Spalte != 0 ist
		}
		multiplyRow(lgs, 1, lgs[0][0]);
		multiplyRow(lgs, 2, lgs[1][0]/lgs[0][0]);
		SubRow(lgs,1,2 );
		multiplyRow(lgs, 3, lgs[0][0]/lgs[2][0]);
		SubRow(lgs, 1,3);
		// Jetzt ist in der zweiten Zeile und dritten Zeile die erste Spalte 0
		if (Math.abs(lgs[1][1])< EPSILON && Math.abs(lgs[2][1]) > EPSILON) {
			ChangeRow(lgs, 3, 2);
		}
		multiplyRow(lgs, 2, 1/lgs[1][1]);
		
		double s = lgs[1][1]/lgs[1][2];
		double r=- ((lgs[0][2]-lgs[0][1]*s)/ lgs[0][0]);
		
		if (Math.abs(r*lgs[2][0] + s*lgs[2][1] - lgs[2][0] )<EPSILON ) {
			printLGS(lgs);
			System.out.print("\nr = " + r +"\t s = " + s+"\n");
		} return r;
	}
	
	private static void multiplyRow(double[][] lgs, int r, double faktor) {
		for (int j=0; j<3 ; j++) {
				lgs[r-1][j] *= faktor;
		}
	}
	
	private static void SubRow(double[][] lgs, int q, int z) {
		for (int j=0; j<3 ; j++) {
			double temp = lgs[q-1][j];
			lgs[z-1][j] -= temp;
		}
	}
	
	private static void ChangeRow(double[][] lgs, int q, int z) {
		for (int j=0; j<3 ; j++) {
			double temp = lgs[q-1][j];
			lgs[q-1][j] = lgs[z-1][j];
			lgs[z-1][j] = temp;
		}
	}
	
	private static void printLGS(double[][] lgs) {
		for (int i = 0; i<3 ; i++) {
			for (int j=0; j<3; j++) {
				if (j==0) {
					System.out.print("\nr*" + lgs[i][j]);
				}
				if (j==1) {
					System.out.print("\ts*" + lgs[i][j]);
				}
				if (j==2)
					System.out.print("\t|"+ lgs[i][j]);
				
			}
		}System.out.println();
	}
	
	
	// ToString Methode
	public String toString() {
		return ( this.p + " + r* " + this.v);
	}
}
