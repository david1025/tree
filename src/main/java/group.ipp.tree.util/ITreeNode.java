package group.ipp.tree.util;

/**
 * 需要实现树的实体类需要实现的接口，获取关键数据
 * @author david
 */
public interface ITreeNode {
    /**
     * TreeNode获取nodeId
     * @return
     */
	String getNodeId();
    /**
     * TreeNode获取nodeName
     * @return
     */
    String getNodeName();
    /**
     * TreeNode获取nodeParentId（父id）
     * @return
     */
    String getNodeParentId();
    /**
     * TreeNode获取orderNum(排序字段用于排序)
     * @return
     */
    Integer getOrderNum();

    /**
     * TreeNode获取nodeLevel(当前属于第几层级)
     * @return
     */
    Integer getNodeLevel();
}
