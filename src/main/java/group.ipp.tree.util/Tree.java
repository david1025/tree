package group.ipp.tree.util;

import java.util.*;

import org.apache.commons.lang3.StringUtils;

/**
 * 构建树形建构
 *
 * @author David
 */
public class Tree implements ITree {
    /**
     * 用于存放treeNode的Map
     */
    private LinkedHashMap<String, TreeNode> treeNodesMap = new LinkedHashMap<>();
    /**
     * 用于存放treeNode的list
     */
    private List<TreeNode> treeNodesList = new ArrayList<>();

    /**
     * 构造方法
     *
     * @param list
     */
    public Tree(List<ITreeNode> list) {
        initTreeNodeMap(list);
        initTreeNodeList();
    }

    /**
     * 将List对象数据转为TreeNodeMap
     *
     * @param list
     */
    private void initTreeNodeMap(List<ITreeNode> list) {
        TreeNode treeNode;
        for (ITreeNode item : list) {
            treeNode = new TreeNode(item);
            treeNode.setLastNodeNum(1);
            treeNodesMap.put(treeNode.getNodeId(), treeNode);
        }
        Iterator<TreeNode> iterator = treeNodesMap.values().iterator();
        TreeNode parentTreeNode;
        while (iterator.hasNext()) {
            treeNode = iterator.next();
            if (StringUtils.isEmpty(treeNode.getParentNodeId())) {
                continue;
            }
            parentTreeNode = treeNodesMap.get(treeNode.getParentNodeId());
            if (parentTreeNode != null) {
                treeNode.setParent(parentTreeNode);
                parentTreeNode.addChild(treeNode);
                // 按照orderNum排序
                Collections.sort(parentTreeNode.getChildren(), new OrdNamComparator());
                // 判断这个节点是否是最子节点
                if (treeNode.getChildren().size() == 0) {
                    treeNode.setLastNode(true);
                }
                // 计算每一个节点的最子节点的数量
                List<TreeNode> children = parentTreeNode.getChildren();
                if (children.size() > 0) {
                    int sum = 0;
                    for (TreeNode treeNode2 : children) {
                        sum += treeNode2.getLastNodeNum();
                    }
                    parentTreeNode.setLastNodeNum(sum);
                }
            }
        }
    }

    /**
     * 根据treeNodesMap转为treeNodesList
     */
    private void initTreeNodeList() {
        if (treeNodesList.size() > 0) {
            return;
        }
        if (treeNodesMap.size() == 0) {
            return;
        }
        Iterator<TreeNode> iterator = treeNodesMap.values().iterator();
        TreeNode treeNode;
        while (iterator.hasNext()) {
            treeNode = iterator.next();
            if (treeNode.getParent() == null) {
                this.treeNodesList.add(treeNode);
                this.treeNodesList.addAll(treeNode.getAllChildren());
            }
        }
    }

    @Override
    public List<TreeNode> getTree() {
        return this.treeNodesList;
    }

    @Override
    public List<TreeNode> getRoot() {
        List<TreeNode> rootList = new ArrayList<>();
        if (this.treeNodesList.size() > 0) {
            for (TreeNode node : treeNodesList) {
                if (node.getParent() == null) {
                    rootList.add(node);
                    Collections.sort(rootList, new OrdNamComparator());
                }
            }
        }
        return rootList;
    }

    @Override
    public TreeNode getTreeNode(String nodeId) {
        return this.treeNodesMap.get(nodeId);
    }
}

/**
 * 自定义排序，按照orderNum排序
 */
class OrdNamComparator implements Comparator<TreeNode> {
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