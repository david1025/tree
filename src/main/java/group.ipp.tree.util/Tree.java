package group.ipp.tree.util;

import java.util.*;

import org.apache.commons.lang3.StringUtils;
/**
 * @author David
 */
public class Tree implements ITree {
    private LinkedHashMap<String, TreeNode> treeNodesMap = new LinkedHashMap<>();
    private List<TreeNode> TreeNodesList = new ArrayList<>();
    public Tree(List<ITreeNode> list) {
        initTreeNodeMap(list);
        initTreeNodeList();
    }
    private void initTreeNodeMap(List<ITreeNode> list) {
        TreeNode TreeNode = null;
        for (ITreeNode item : list) {
            TreeNode = new TreeNode(item);
            TreeNode.setLastNodeNum(1);
            treeNodesMap.put(TreeNode.getNodeId(), TreeNode);
        }
        Iterator<TreeNode> iter = treeNodesMap.values().iterator();
        TreeNode parentTreeNode;
        while (iter.hasNext()) {
            TreeNode = iter.next();
            if (StringUtils.isEmpty(TreeNode.getParentNodeId())) {
                continue;
            }
            parentTreeNode = treeNodesMap.get(TreeNode.getParentNodeId());
            if (parentTreeNode != null) {
                TreeNode.setParent(parentTreeNode);
                parentTreeNode.addChild(TreeNode);
                Collections.sort(parentTreeNode.getChildren(), new OrdNamComparator());
                if(TreeNode.getChildren().size() == 0) {
                    TreeNode.setLastNode(true);
                }
                //计算每一个节点的最子节点的数量
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
    private void initTreeNodeList() {
        if (TreeNodesList.size() > 0) {
            return;
        }
        if (treeNodesMap.size() == 0) {
            return;
        }
        Iterator<TreeNode> iter = treeNodesMap.values().iterator();
        TreeNode TreeNode;
        while (iter.hasNext()) {
            TreeNode = iter.next();
            if (TreeNode.getParent() == null) {
                this.TreeNodesList.add(TreeNode);
                this.TreeNodesList.addAll(TreeNode.getAllChildren());
            }
        }
    }
    @Override
    public List<TreeNode> getTree() {
        return this.TreeNodesList;
    }
    @Override
    public List<TreeNode> getRoot() {
        List<TreeNode> rootList = new ArrayList<>();
        if (this.TreeNodesList.size() > 0) {
            for (TreeNode node : TreeNodesList) {
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