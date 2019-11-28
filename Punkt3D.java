package bonusaufgabe;
/**
 * @author Maximilian Kreutz
 * @author Jan Fenau
 */
public class Punkt3D {
		// Attribute
		private double x;
		private double y;
		private double z;
		
		
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
		public final double getZ() {
			return z;
		}
		public void setZ(double z) {
			this.z = z;
		}
		

		// Konstruktoren
		public Punkt3D() {
			this.x=0;
			this.y=0;
			this.z=0;
		}
		public Punkt3D(double a, double b, double c) {
			this.x=a;
			this.y=b;
			this.z = c;
		}
		public Punkt3D (Punkt3D copy) {
			this(copy.x, copy.y, copy.z);
		}
		
		
		// Objektmethoden
		public double dist(Punkt3D a) {
			return dist(this,a);
		}
		public Vektor3D Ortsvektor() {
			return new Vektor3D(new Punkt3D(), this);
		}
		public Vektor3D VektorMitDiesemPunkt(Punkt3D a) {
			return new Vektor3D(this,a);
		}
		public static Vektor3D VektorAusZweiPunkten(Punkt3D a, Punkt3D b) {
			return new Vektor3D(a,b);
		}
		public static double dist(Punkt3D a, Punkt3D b) {
			return Math.sqrt((b.x-a.x)*(b.x-a.x)+(b.y-a.y)*(b.y-a.y)+(b.z-a.z)*(b.z-a.z));
		}
		
		
		// ToString Methode
		public String toString() {
			return "( " + this.x + " , " + this.y + " , " + this.z + " )";
	 	}
}