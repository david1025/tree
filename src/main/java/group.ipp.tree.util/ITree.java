package group.ipp.tree.util;

import java.util.List;

/**
 * 操作树的接口类
 *
 * @author david
 */
public interface ITree {
    /**
     * 获取构建数的list，因为根节点可能不止一个，所有返回List
     * 获取的结构与getRoot基本一致，但是后边增加了另外的数据，不建议调用
     *
     * @return
     */
    List<TreeNode> getTree();

    /**
     * 获取根节点树结构，因为根节点可能不止一个，所有返回List
     *
     * @return
     */
    List<TreeNode> getRoot();

    /**
     * 获取指定节点数据
     *
     * @param nodeId
     * @return
     */
    TreeNode getTreeNode(String nodeId);
}
