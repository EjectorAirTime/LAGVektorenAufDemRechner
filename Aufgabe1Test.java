package bonusaufgabe;

/**
 * @author Maximilian Kreutz
 * @author Jan Fenau
 */

import bonusaufgabe.Punkt2D;
import bonusaufgabe.Punkt3D;
import bonusaufgabe.Vektor2D;
import bonusaufgabe.Vektor3D;

public class Aufgabe1Test {
	public static void main(String[] args) {
		//Punkt2D Test:
		System.out.println("Punkt2D Test:");
		Punkt2D origin = new Punkt2D();										
		Punkt2D a = new Punkt2D(3, 3); 									//allgemeiner Konstruktor
		Punkt2D copy_a = new Punkt2D(a);	 							//Copy-Konstruktor
		System.out.println(copy_a); 									//to-String Methode, soll (3.0,3.0) ausgeben
		System.out.println(a.getX()); 									//getter, setter
		System.out.println(a.getY()); 									//zuerst wird 3.0 3.0 ausgegeben 
		a.setX(10);							 							//dann wird a auf (10.0, 5.0) gesetzt
		a.setY(5);
		System.out.println(a.getX());									//und ausgegeben
		System.out.println(a.getY());
		System.out.println(a);
		System.out.println(a.dist(origin)); 							//Abstand von (0.0,0.0) zu (10.0,5.0) -> Wurzel aus ((10 - 0)^2 + (5 - 0)^2) = 11.180339887498949
		Punkt2D d = new Punkt2D(9, 9);
		Vektor2D v = a.Ortsvektor();									 //Umwandlung von Punkt in Vektor von Ursprung zu diesem Punkt
		Vektor2D nullV = a.VektorMitDiesemPunkt(new Punkt2D(a)); 		//Vektor zwischen a und a ergibt Nullvektor
		System.out.println(nullV); 										//sollte (0.0,0.0) ausgeben
		System.out.println(v); 											//gibt Vektor zu a aus (10.0,5.0)
		System.out.println(Punkt2D.dist(origin,a)); 					//static Methode f¸r den Abstand, Wurzel aus ((10 - 0)^2 + (5 - 0)^2) = 11.180339887498949 wird berechnet
		Vektor2D z = Punkt2D.VektorAusZweiPunkten(a, d); 				//Umwandlung von zwei Punkten in einen Verbindungsvektor
		System.out.println(z); 											//Ausgabe des Verbindungsvektors (9 - 10, 9 - 5) = (-1.0,4.0)
		System.out.println("\n//Vektor2D Test:");
		
		
		
		//Vektor2D Test:
		System.out.println("Vektor2D Test:");
		Vektor2D x = new Vektor2D(); 									//Standardkonstruktor
		Vektor2D y = new Vektor2D(5,8); 								//allgemeiner Konstruktor
		Vektor2D copy_x = new Vektor2D(x); 								//copy-Konstruktor
		Vektor2D w = new Vektor2D(x,y); 								//Vektor aus zwei Vektoren
		Vektor2D u = new Vektor2D(a,d); 								//Vektor aus zwei Punkten, entspricht y, weil x der Nullvektor ist
		System.out.println(u); 											//Ausgabe des Verbindungsvektors (9 - 10, 9 - 5) = (-1.0,4.0)
		y.setX(8); 														//y auf (8.0,9.0) setzen
		y.setY(9);
		System.out.println(y.getX()); 									//y ausgeben
		System.out.println(y.getY());
		w.addiere(copy_x); 												//copy_x zu w addieren, w = (5.0 + 0.0,8.0 + 0.0)
		System.out.println(w);											//(5.0,8.0) ausgeben
		w.subtrahiere(copy_x); 											//Nullvektor, copy_x wieder abziehen
		System.out.println(w); 											//(5.0,8.0) ausgeben
		Vektor2D add = Vektor2D.addiere(w, copy_x);
		System.out.println(add); 										//die selbe Addition wie oben wird in Ergebnisvektor gespeichert und ausgegeben
		Vektor2D sub = Vektor2D.subtrahiere(add, copy_x);
		System.out.println(sub); 										//die selbe Subtraktion wie oben wird in Ergebnisvektor gespeichert und ausgegeben
		w.SkalaresVielfaches(5); 										//w wird mit 5 skaliert
		System.out.println(w); 											//w = (5 * 5.0, 5 * 8.0) = (25.0, 40.0)
		Vektor2D sv = Vektor2D.SkalaresVielfaches(w, 5); 				//w wird erneut mit 5 skaliert, aber diesmal nicht ver‰ndert, sondern das Ergebnis wird in sv gespeichert
		System.out.println(sv); 										//sv = (25.0 * 5,40.0 * 5) = (125.0,200.0)
		System.out.println(w.SkalarProdukt(y)); 						//Skalarprodukt ausgeben (25 * 8 + 40 * 9) = 200 + 320 = 560
		System.out.println(w.LinearAbh‰ngig(sv)); 						//sv ist 5 * w, ist deshalb linear abh‰ngig zu w
		System.out.println(y.dist()); 									//L‰nge von y = Wurzel aus (8 * 8 + 9 * 9) = Wurzel aus 145 = 12.041594578792296
		Vektor2D op = Vektor2D.OrthogonalProjektionVon1Auf2(w, u);		//Orthogonalprojektion wird mit Funktionsaufrufen der Formel berechnet
		System.out.println(op); 										//to-String Ausgabe der Orthogonalprojektion von w auf u
		Vektor2D w1 = new Vektor2D(1,0);
		Vektor2D w2 = new Vektor2D(0,1);
		System.out.println(Vektor2D.berechneWinkel(w1,w2)); 			//Winkel im Gradmaﬂ wird berechnet =  90∞
		System.out.println(w1.berechneWinkel(w2)); 						//Winkel im Gradmaﬂ wird berechnet, dies sind 90∞
		Vektor2D sv2 = Vektor2D.SkalaresVielfaches(w1, 5); 				//w1 wird mit 5 skaliert -> (1.0 * 5,0.0 * 5)
		System.out.println(sv2);										//Ausgabe von w1 =  (5.0,0.0)
		System.out.println(w1.berechneWinkelBogenMaﬂ(w2));				//Winkel wird im Bogenmaﬂ berechnet, entspricht 90∞
		System.out.println(Vektor2D.berechneWinkelBogenMaﬂ(w1, w2)); 	//Winkel wird im Bogenmaﬂ berechnet, entspricht 90∞
		System.out.println("\n//Punkt3D Test:");
		
		
		
		//Punkt3D Test:
		System.out.println("Punkt3D Test:");
		Punkt3D origin3 = new Punkt3D(); 								//Standardkonstruktor
		Punkt3D a3 = new Punkt3D(3, 3, 3); 								//allgemeiner Konstruktor
		Punkt3D copy_a3 = new Punkt3D(a3);								//Copy-Konstruktor
		System.out.println(copy_a3); 									//to-String Methode, soll (3.0,3.0,3.0) ausgeben
		System.out.println(a3.getX()); 									//getter, setter
		System.out.println(a3.getY()); 									//zuerst wird 3.0 3.0 3.0 ausgegeben 
		System.out.println(a3.getZ());
		a3.setX(10); 													//dann wird a3 auf (10.0, 5.0, 8.0) gesetzt
		a3.setY(5);
		a3.setZ(8);
		System.out.println(a3.getX()); 									//und ausgegeben
		System.out.println(a3.getY());
		System.out.println(a3.getZ());
		System.out.println(a3);
		System.out.println(a3.dist(origin3)); 							//Abstand von (0.0,0.0) zu (10.0,5.0) -> Wurzel aus ((10 - 0)^2 + (5 - 0)^2 + (8 - 0)^2) = 13.74772708486752
		Punkt3D d3 = new Punkt3D(9, 9, 9);
		Vektor3D v3 = a3.Ortsvektor(); 									//Umwandlung von Punkt in Vektor von Ursprung zu diesem Punkt
		Vektor3D nullV3 = a3.VektorMitDiesemPunkt(new Punkt3D(a3)); 	//Vektor zwischen a3 und a3 ergibt Nullvektor
		System.out.println(nullV3); 									//sollte (0.0,0.0,0.0) ausgeben	
		System.out.println(v3); 										//gibt Vektor zu a3 aus (10.0,5.0,8.0)
		System.out.println(Punkt3D.dist(origin3,a3)); 					//static Methode f¸r den Abstand, Wurzel aus ((10 - 0)^2 + (5 - 0)^2 + (8 - 0)^2) = 13.74772708486752 wird berechnet
		Vektor3D z3 = Punkt3D.VektorAusZweiPunkten(a3, d3); 			//Umwandlung von zwei Punkten in einen Verbindungsvektor
		System.out.println(z3); 										//Ausgabe des Verbindungsvektors (9 - 10, 9 - 5, 9 - 8) = (-1.0,4.0,1.0)
		System.out.println("\n//Vektor3D Test:");
		
		
		
		//Vektor3D Test:
		System.out.println("Vektor3D Test:");
		Vektor3D x3 = new Vektor3D(); 									//Standardkonstruktor
		Vektor3D y3 = new Vektor3D(5,8,10); 							//allgemeiner Konstruktor
		Vektor3D copy_x3 = new Vektor3D(x3); 							//copy-Konstruktor
		Vektor3D w3 = new Vektor3D(x3,y3); 								//Vektor aus zwei Vektoren
		Vektor3D u3 = new Vektor3D(a3,d3); 								//Vektor aus zwei Punkten, entspricht y3, weil x3 der Nullvektor ist
		System.out.println(u3); 										//Ausgabe des Verbindungsvektors u3 (9 - 10, 9 - 5, 9 - 8) = (-1.0,4.0,1.0)
		y3.setX(8); 													//y3 auf (8.0,9.0,8.0) setzen
		y3.setY(9);
		y3.setZ(8);
		System.out.println(y3.getX()); 									//y3 ausgeben
		System.out.println(y3.getY());
		System.out.println(y3.getZ());
		w3.addiere(copy_x3); 											//copy_x3 zu w3 addieren, w3 = (5.0 + 0.0,8.0 + 0.0,0.0 + 0.0)
		System.out.println(w3); 										//(5.0,8.0,0.0) ausgeben
		w3.subtrahiere(copy_x3);										//Nullvektor, copy_x wieder abziehen
		System.out.println(w3); 										//(5.0,8.0,0.0) ausgeben
		Vektor3D add3 = Vektor3D.addiere(w3, copy_x3);
		System.out.println(add3); 										//die gleiche Addition wie oben wird in Ergebnisvektor gespeichert und ausgegeben
		Vektor3D sub3 = Vektor3D.subtrahiere(add3, copy_x3);
		System.out.println(sub3); 										//die gleiche Subtraktion wie oben wird in Ergebnisvektor gespeichert und ausgegeben
		w3.SkalaresVielfaches(5); 										//w3 wird mit 5 skaliert
		System.out.println(w3); 										//w3 = (5 * 5.0, 5 * 8.0, 5 * 0.0) = (25.0, 40.0, 0.0)
		Vektor3D sv3 = Vektor3D.SkalaresVielfaches(w3, 5); 				//w3 wird erneut mit 5 skaliert, aber diesmal nicht ver‰ndert, sondern das Ergebnis wird in sv gespeichert
		System.out.println(sv3); 										//sv3 = (25.0 * 5,40.0 * 5,0.0 * 5) = (125.0,200.0,0.0)
		System.out.println(w3.SkalarProdukt(y3)); 						//Skalarprodukt ausgeben (25 * 8 + 40 * 9 + 0 * 8) = 200 + 360 + 0 = 560
		System.out.println(w3.LinearAbh‰ngig(sv3)); 					//sv3 ist 5 * w3, ist deshalb linear abh‰ngig zu w3
		System.out.println(y3.dist()); 									//L‰nge von y3 = Wurzel aus (8 * 8 + 9 * 9 + 8 * 8) = Wurzel aus 209 = 14.45683229480096
		Vektor3D op3 = Vektor3D.OrthogonalProjektionVon1Auf2(w3, u3); 	//Orthogonalprojektion wird mit Funktionsaufrufen wie in der Formel berechnet
		System.out.println(op3); 										//to-String Ausgabe der Orthogonalprojektion von w3 auf u3
		Vektor3D w13 = new Vektor3D(1,0,0);
		Vektor3D w23 = new Vektor3D(0,1,0);
		System.out.println(Vektor3D.berechneWinkel(w23, w13));			//Winkel im Gradmaﬂ wird berechnet =  90∞
		System.out.println(w13.berechneWinkel(w23)); 					//Winkel im Gradmaﬂ wird berechnet =  90∞
		Vektor3D sv23 = Vektor3D.SkalaresVielfaches(w13, 5); 			//w13 wird mit 5 skaliert -> (1.0 * 5,0.0 * 5,0.0 * 5)
		System.out.println(sv23); 										//Ausgabe von w1 =  (5.0,0.0,0.0)
		System.out.println(w13.VektorProdukt(w23)); 					//Vektorprodukt nach Formel berechnet, ergibt (0.0,0.0,1.0)
		Vektor3D vp = Vektor3D.VektorProdukt(w13, w23); 				//Das gleiche Vektorprodukt durch static-Methode um Ergebnis zu speichern
		System.out.println(vp); 										//Ausgabe des Vektorproduktes
		System.out.println(w13.berechneWinkelBogenMaﬂ(w23));			//Winkel wird im Bogenmaﬂ berechnet, entspricht 90∞
		System.out.println(Vektor3D.berechneWinkelBogenMaﬂ(w23, w13)); 	//Winkel wird im Bogenmaﬂ berechnet, entspricht 90∞
		System.out.println(Vektor3D.SpatProdukt(Vektor3D.SkalaresVielfaches(w3,-1), w23, u3));//Das SpatProdukt aus dem Skalarprodukt von -w3 und w23xu3
		System.out.println(Vektor3D.SpatVolumen((Vektor3D.SkalaresVielfaches(w3,-1)), w23, u3)); // Der Betrag der vorherigen Zeile
	}
}