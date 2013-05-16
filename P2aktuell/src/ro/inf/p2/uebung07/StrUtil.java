package ro.inf.p2.uebung07;

/**
 * Created with IntelliJ IDEA.
 * User: felix
 * Date: 5/15/13
 * Time: 9:30 PM
 * StrUtil
 */
public class StrUtil {
    public static String[][] transpose(String[][] matrix) {

        final int rows = matrix[0].length;
        final int cols = matrix.length;

        String[][] ret = new String[rows][cols];

        int i, j;
        i = 0;
        for (String[] col : matrix) {
            j = 0;
            for (String entry : col) {
                ret[j][i] = entry;
                j++;
            }
            i++;
        }

//        for (int i = 0; i < matrix.length; i++)
//             for (int j = 0; j < matrix[i].length; j++)
//                 ret[j][i] = matrix[i][j];

        return ret;
    }

    public static String matrixToString(String[][] matrix) {

        StringBuffer ret = new StringBuffer();

        for (String[] col : matrix) {
            for (String entry : col) {
                ret.append(entry);
                ret.append(" ");
            }
            ret.append("\n");
        }

        return String.valueOf(ret);
    }
}
