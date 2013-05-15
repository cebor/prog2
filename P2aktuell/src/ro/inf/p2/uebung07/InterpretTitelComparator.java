package ro.inf.p2.uebung07;

import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: felix
 * Date: 5/15/13
 * Time: 3:35 PM
 * InterpretTitelComparator
 */
public class InterpretTitelComparator implements Comparator<CompactDisc> {
    @Override
    public int compare(CompactDisc compactDisc, CompactDisc compactDisc2) {
        int ret = compactDisc.compareTo(compactDisc2);

        if (ret == 0)
            return compactDisc.getTitle().compareTo(compactDisc2.getTitle());

        return ret;
    }
}
