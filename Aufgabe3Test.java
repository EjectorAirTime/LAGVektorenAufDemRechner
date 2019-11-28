package bonusaufgabe;
/**
 * @author Maximilian Kreutz
 * @author Jan Fenau
 */
public class Aufgabe3Test {
	public static void main(String[] args) throws Exception {			
			//Ebene3D Test:
			Ebene3D allgemein = new Ebene3D();				//Standardkonstruktor mit Nullvektoren und Ursprung
			System.out.println(allgemein);					//Ausgabe in impliziter und expliziter Darstellung
			Ebene3D E1 = new Ebene3D(2,3,-1,-6);			//Konstruktor für implizite Darstellung (a,b,c,d)
			System.out.println(E1+"\n");					//Ausgabe in impliziter und expliziter Darstellung
			System.out.println(E1.getA());					//Abfrage des Parameters a der impliziten Darstellung
			System.out.println(E1.getB());					//Abfrage des Parameters b der impliziten Darstellung
			System.out.println(E1.getC());					//Abfrage des Parameters c für der impliziten Darstellung
			System.out.println(E1.getD()+"\n");				//Abfrage des Parameters d für der impliziten Darstellung
			
			Punkt3D a = new Punkt3D(4,2,1);					
			Punkt3D b = new Punkt3D(3,5,1);
			Punkt3D c = new Punkt3D(0,0,4);
			Ebene3D E3Punkte = new Ebene3D(a,b,c);			//Konstruktor aus 3 Punkten mit a als Aufpunkt
			System.out.println(E3Punkte);
			Punkt3D aufpunkt = new Punkt3D(1,1,1);
			Vektor3D r1 = new Vektor3D(1,0,0);
			Vektor3D r2 = new Vektor3D(0,0,5);
			Ebene3D E2 = new Ebene3D(aufpunkt, r1,r2);		//Konstruktor aus 1 Punkt und 2 linear unabhängigen Vektoren
			Ebene3D E3 = new Ebene3D(E2);					//Copy-Konstruktor, E2 = E3
			System.out.println(E3);							//Ausgabe E3/E2
			System.out.println(E3.getP());					//Gibt den Aufpunkt der Ebene E3 zurück
			System.out.println(E3.getRichtungsVektorV());	//Gibt den ersten Richtungsvektor zurück
			System.out.println(E3.getRichungsVektorU());	//Gibt den zweien Richtungsvektor zurück
			
			Vektor3D n = E3.getNormale();					//Normalenvektor aus a,b,c  
			System.out.println("\n"+n);
			System.out.println(n.dist());					//Länge des Normalenvektors für Kontrolle
			System.out.println(E3.getAHesseNF());			//Ausgabe des Koeffizienten a/euklidLänge von n, also die Hesse'sche Normalenform
			System.out.println(E3.getBHesseNF());			// -5/5 = -1 Ausgabe des Koeffizienten b in HNF
			System.out.println(E3.getCHesseNF());			//Ausgabe des Koeffizienten c in HNF
			System.out.println(E3.getDHesseNF());			// 5/5 = 1 Ausgabe des Koeffizienten d in HNF
			double s = E3.getAHesseNF()+E3.getBHesseNF()+E3.getCHesseNF();
			System.out.println("|a+c+b| ~= " + Math.abs(s));// Kontrolle des Betrags der Summe aHNF + bHNF + cHNF = 1	
			
			
			System.out.println("\n"+E3.pruefePunkt(aufpunkt));// Der Aufpunkt der Ebene liegt logischerweise in der Ebene
			Punkt3D test = new Punkt3D(3,3,3);
			System.out.println(E3.pruefePunkt(test));		//Der Punkt test liegt nicht auf der Ebene
			System.out.println(E3.getDistOrientated(test));	//Punkt test hat den orientierten Abstand -2
			System.out.println(E3.getDist_p(test));			//Der absolute Abstand ist demnach 2
			
			Ebene3D EbeneE = new Ebene3D(4,3,6,-36);		// Aus Mathebuch E: 4x+3y+6z-36 = 0
			Punkt3D aufF = new Punkt3D(0,0,3);
			Vektor3D v = new Vektor3D(3, 2, -1);
			Vektor3D u = new Vektor3D(3, 0, -1);
			Ebene3D EbeneF = new Ebene3D(aufF,u,v);			// Aus Mathebuch F: (0)     ( 3)     ( 3)
															//					(0) + r*( 2) + s*( 0)
															//					(3)     (-1		 (-1)
			System.out.println("\n"+EbeneE.berechneSchnittGerade(EbeneF));
															// Aus Mathebuch: Gerade aus EbeneE und EbeneF:
															//	  (9)     (-3)		  ( 1.5)													  (4.5)		
															// g: (0) + r*( 2) mit  r*(-1.0) und r = 3 kommt man auf den errechneten Aufpunkt bei (3.0)
															// 	  (0)     ( 1)		  (-0.5)													  (1.5)
			
			System.out.println(Ebene3D.berechneSchnittGerade(EbeneF, EbeneE));
			System.out.println("Kontrolle laut Buch:\n( 9.0 , 0.0 , 0.0 ) + r* (- 3.0 , 2.0 , 1.0 )\n");
			
			System.out.println(Ebene3D.berechneSchnittWinkel(E2, E3Punkte)); 	// E2 und E3Punkte schneiden sich mit ~133,2°
			System.out.println(E3Punkte.berechneSchnittWinkel(E1));				// E3Punkte und E1 schneiden sich mit ~50.99°
			}	
}
