package ro.inf.p2.uebung07;

import junit.framework.TestCase;

/**
 * Created with IntelliJ IDEA.
 * User: felix
 * Date: 5/16/13
 * Time: 8:22 PM
 * TestStrUtil
 */
public class TestStrUtil extends TestCase {

    public void testStrUtil() {

        String[][] m1 = {{"A", "B"}, {"C", "D"}, {"E", "F"}};

        assertTrue(StrUtil.transpose(m1)[0][0] == "A");
        assertTrue(StrUtil.transpose(m1)[0][1] == "C");
        assertTrue(StrUtil.transpose(m1)[0][2] == "E");

        assertTrue(StrUtil.transpose(m1)[1][0] == "B");
        assertTrue(StrUtil.transpose(m1)[1][1] == "D");
        assertTrue(StrUtil.transpose(m1)[1][2] == "F");


        System.out.println(StrUtil.matrixToString(m1));
        System.out.println(StrUtil.matrixToString(StrUtil.transpose(m1)));
    }

}
