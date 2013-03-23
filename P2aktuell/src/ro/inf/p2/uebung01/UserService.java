/*
 * Created on 	29.02.2004
 * @author  	FdR/ Hue
 * Zweck:		kleines Muster einer Mainmethode, die eine Serviceklasse nutzt
 */
package ro.inf.p2.uebung01;

public class UserService {

	public static void main(String[] args) {
		Service service = new Service();
		int result = service.add(5, 6);
		System.out.print("Ergebnis in User: " + result);
	}
}
