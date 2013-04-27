package ro.inf.p2.uebung05;

import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: felix
 * Date: 4/24/13
 * Time: 2:24 PM
 * StrUtil
 */
public class StrUtil {

    public static String[] strtokenToArray(String val, String del) {
        StringTokenizer tok = new StringTokenizer(val, del);

        String[] s = new String[tok.countTokens()];

        int i = 0;

        while (tok.hasMoreTokens()) {
            s[i] = tok.nextToken();
            i++;
        }

        return s;
    }

    public static String strarryToString(String[] val) {
        StringBuffer s = new StringBuffer();

        for (int i = 0; i < val.length; i++) {
            s.append(val[i]);
            if (i != (val.length - 1))
                s.append(" ");
        }

        return new String(s);
    }
}
