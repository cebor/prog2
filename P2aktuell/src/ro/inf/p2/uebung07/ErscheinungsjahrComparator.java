package ro.inf.p2.uebung07;

import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: felix
 * Date: 5/15/13
 * Time: 1:58 PM
 * ErscheinungsjahrComparator
 */
public class ErscheinungsjahrComparator implements Comparator<CompactDisc> {

    @Override
    public int compare(CompactDisc compactDisc, CompactDisc compactDisc2) {
        if (compactDisc.equals(compactDisc2)) return 0;

        Integer year = compactDisc.getYear();
        Integer year2 = compactDisc2.getYear();

        return year.compareTo(year2);
    }
}
