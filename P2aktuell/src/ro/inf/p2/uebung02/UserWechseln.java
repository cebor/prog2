package ro.inf.p2.uebung02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: felix
 * Date: 3/29/13
 * Time: 10:34 AM
 * Cents to Coins Calculator.
 */
public class UserWechseln {
    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Cents > Coins: Enter '0' to exit!");

        int cents;

        do {
            System.out.print("Cents: ");
            cents = Integer.parseInt(in.readLine());

            if (cents != 0) {
                int[] array = Wechseln.anzahl(cents);

                for (int i = 0; i < 8; i++)
                    System.out.print(array[i] + " ");

                System.out.println();
            }
        } while (cents != 0);
    }
}
