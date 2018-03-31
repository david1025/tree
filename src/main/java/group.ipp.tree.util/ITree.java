package group.ipp.tree.util;

import java.util.List;

/**
 * 操作树的接口类
 * @author david
 */
public interface ITree {
    /**
     * 获取树，因为根节点可能不止一个，所有返回List
     * @return
     */
	List<TreeNode> getTree();

    /**
     * 获取根节点树结构，因为根节点可能不止一个，所有返回List
     * @return
     */
    List<TreeNode> getRoot();

    /**
     * 获取指定节点数据
     * @param nodeId
     * @return
     */
    TreeNode getTreeNode(String nodeId);
}
