package bonusaufgabe;
/**
 * @author Maximilian Kreutz
 * @author Jan Fenau
 */
public class Aufgabe2Test {
	public static void main(String[] args) throws Exception {
		/*Punkt2D  P1 = new Punkt2D();
		Punkt2D  P2 = new Punkt2D(1,0);
		Punkt2D  P3 = new Punkt2D(1,1);
		Vektor2D v1 = new Vektor2D(1,1);
		Gerade2D G1 = new Gerade2D(P2,v1); //allgemeiner Konstruktor für Gerade in Parameterform, wird intern zusätzlich in impliziter Form gespeichert
		Gerade2D G2 = new Gerade2D(); //Standardkonstruktor, alle Werte 0
		Gerade2D G3 = new Gerade2D(P2,P3); //
		Gerade2D G4 = new Gerade2D(G3);
		Gerade2D G5 = new Gerade2D(new Punkt2D(0, 0), new Vektor2D(0,1));
		System.out.println(G1);
		System.out.println(	G1.getA());
		System.out.println(	G1.getB());
		System.out.println(	G1.getC());
		System.out.println(	G1.getP());
		System.out.println(	G1.getV());
		System.out.println(	G1.getAHesseNF());
		System.out.println(	G1.getBHesseNF());
		System.out.println(	G1.getCHesseNF());
		System.out.println(	G1.PunktAufGerade(P1));
		System.out.println(	G1.dist_p(P1));
		System.out.println(	G1.dist_p(P2));
		System.out.println(	G3.getNormale());
		System.out.println(	G4.getNormale());
		System.out.println(	G2.getV());
		System.out.println(	G2.getP());
		System.out.println(	Gerade);*/
		
		
		/* public final double getA() {
		public final double getB() {
		public final double getC() {
		public final Vektor2D getV() {
		public final Punkt2D getP() {
		public double getAHesseNF() {

		public double getBHesseNF() {
	
		public double getCHesseNF() {
		
		public Vektor2D getNormale() {
	
		// Konstruktoren
		public Gerade2D()
		public Gerade2D(Punkt2D p, Vektor2D v)
		public Gerade2D (Punkt2D p, Punkt2D q)
		public Gerade2D(double a, double b, double c)
		public Gerade2D(Gerade2D copy)
		
		
		
		// Objektmethoden
		public boolean PunktAufGerade(Punkt2D p) {
		
		public double dist_p(Punkt2D p) {
		
		public double distOrientated(Punkt2D x) {
		
		public Punkt2D berechneSchnittpunkt(Gerade2D g) throws Exception
		
		
		berechneSchnittpunkt(Gerade2D g, Gerade2D h)
		*/
		
		
		
		
		/*
		 * public final Vektor3D getV() {
		 *
		public final Punkt3D getP() {
	
		public Vektor3D getNormale()
	
		

		public Gerade3D() {
	
		public Gerade3D(Punkt3D p, Vektor3D v) 
		public Gerade3D (Punkt3D p, Punkt3D v) 
		public Gerade3D(Gerade3D copy)
		
		
		// Objektmethoden
		public boolean PunktAufGerade(Punkt3D p) {
	
		public double dist_p(Punkt3D p) {
		
		public double distOrientated(Punkt3D x) {
		public Punkt3D berechneSchnittpunkt(Gerade3D g) throws Exception 
		
		// Klassenemthoden
		public static Punkt3D berechneSchnittpunkt(Gerade3D g, Gerade3D h) throws Exception {
		*/
	
		Punkt3D gp = new Punkt3D(1, 0, 1);
		Vektor3D gv = new Vektor3D(1,1,-2);
		Gerade3D g = new Gerade3D(gp,gv);
		System.out.println(g);
		Punkt3D kp = new Punkt3D(1,0,0);
		Vektor3D kv = new Vektor3D(2,2,-3);
		Gerade3D k = new Gerade3D(kp,kv);
		System.out.println(k);
		System.out.println(Gerade3D.berechneSchnittpunkt(g, k));
	}
}
