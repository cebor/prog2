package ro.inf.p2.uebung03;

/**
 * Created with IntelliJ IDEA.
 * User: felix
 * Date: 4/12/13
 * Time: 11:44 AM
 * StringUtil
 */
public class StringUtil {

    public static char[] string2CharArray(String s) {

        char[] arr = new char[s.length()];

        for (int i = 0; i < s.length(); i++)
            arr[i] = s.charAt(i);

        return arr;

        // return s.toCharArray();  // alternative
    }

    public static String charArray2String(char[] arr) {

        StringBuffer s = new StringBuffer(arr.length);

        for (char entry : arr)
            s.append(entry);

        return s.toString();

        // return new String(arr);  // alternative
    }

}
