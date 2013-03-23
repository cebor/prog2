/*
 * Created on 29.02.2004 
 * @author FdR/ Hue / BrM
 * Zweck: Hello mit einer kleinen Erweiterung durch eine Methode
 */
package ro.inf.p2.uebung01;

public class Hello2 {
	static int add(int a, int b) {
		return (a + b);
	}

	public static void main(String[] args) {
		int c;
		System.out.println("Hello World 2");
		c = add(11, 13);
		System.out.println("11 + 13 = " + c);
		System.out.println(" 5 + 7 = " + add(5, 7));
	}
}