package ro.inf.p2.uebung02;

/**
 * Created with IntelliJ IDEA.
 * User: felix
 * Date: 3/29/13
 * Time: 10:34 AM
 * To change this template use File | Settings | File Templates.
 */
public class UserWechseln {
    public static void main(String[] args) {

        int[] array = Wechseln.anzahl(783);

        for (int i = 0; i < 8; i++)
            System.out.print(array[i] + " ");

    }
}
