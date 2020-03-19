package group.ipp.tree.util;

import java.util.Comparator;

/**
 * List 排序 Comparator
 * @author david
 */
public class OrdNamComparator implements Comparator<TreeNode> {

    @Override
    public int compare(TreeNode t1, TreeNode t2) {
        if (t1.getOrderNum() > t2.getOrderNum()) {
            return 1;
        }
        if (t1.getOrderNum() < t2.getOrderNum()) {
            return -1;
        }
        return t1.getNodeName().compareTo(t2.getNodeName());
    }
}
