package ro.inf.p2.uebung05;

import junit.framework.TestCase;

import java.util.Arrays;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: felix
 * Date: 4/26/13
 * Time: 8:58 AM
 * Test StringUtil
 */
public class TestStrUtil extends TestCase {

    private static Logger logger =
            Logger.getLogger(TestStrUtil.class.getName());

    public void testStrings() {

        String s1 = "test/gaga/123/blubb/456";
        String s2 = "test gaga 123 blubb 456";

        String[] arr1 = StrUtil.strtokenToArray(s1, "/");
        s1 = StrUtil.strarryToString(arr1);
        String[] arr2 = StrUtil.strtokenToArray(s1, " ");

        assertEquals(s1, s2);
        assertTrue(Arrays.equals(arr1, arr2));

        logger.info("Test erfolgreich!");
    }
}
