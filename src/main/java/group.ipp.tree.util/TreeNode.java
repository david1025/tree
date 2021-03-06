package group.ipp.tree.util;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author David
 */
public class TreeNode {

    /**
     * 树节点ID
     */
    @JSONField(ordinal = 1)
    private String nodeId;
    /**
     * 树节点名称
     */
    @JSONField(ordinal = 2)
    private String nodeName;
    /**
     * 父节点ID
     */
    @JSONField(ordinal = 3)
    private String parentNodeId;
    /**
     * 节点在树中的排序号
     */
    @JSONField(ordinal = 4)
    private int orderNum;
    /**
     * 节点所在的层级
     */
    @JSONField(ordinal = 5)
    private int level;
    /**
     * 最子节点的数量
     */
    @JSONField(ordinal = 6)
    private int lastNodeNum;

    /**
     * 是否是最子节点
     */
    @JSONField(ordinal = 7)
    private boolean lastNode;

    private Object data;

    /**
     * 当前节点的儿子节点
     */
    @JSONField(ordinal = 8)
    private List<TreeNode> children = new ArrayList<>();

    /**
     * 当前节点的完整路径
     */
    @JSONField(ordinal = 9)
    private String completeName;

    /**
     * 当前节点的父级节点
     * 转json的时候忽略此属性，因为此属性到前端无作用
     */
    @JSONField(serialize = false)
    private TreeNode parent;

    /**
     * 当前节点的子孙节点
     * 转json的时候忽略此属性，因为此属性到前端无作用
     */
    @JSONField(serialize = false)
    private List<TreeNode> allChildren = new ArrayList<>();

    public TreeNode(TreeNode obj) {
        this.orderNum = obj.getOrderNum();
        this.level = obj.getLevel();
        this.lastNodeNum = obj.getLastNodeNum();
    }

    public TreeNode() {
    }

    public void addChild(TreeNode treeNode) {
        this.children.add(treeNode);
    }

    public void removeChild(TreeNode treeNode) {
        this.children.remove(treeNode);
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getParentNodeId() {
        return parentNodeId;
    }

    public void setParentNodeId(String parentNodeId) {
        this.parentNodeId = parentNodeId;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public int getLastNodeNum() {
        return lastNodeNum;
    }

    public void setLastNodeNum(int lastNodeNum) {
        this.lastNodeNum = lastNodeNum;
    }

    public boolean isLastNode() {
        return lastNode;
    }

    public void setLastNode(boolean lastNode) {
        this.lastNode = lastNode;
    }

    public List<TreeNode> getAllChildren() {
        if (this.allChildren.isEmpty()) {
            for (TreeNode treeNode : this.children) {
                this.allChildren.add(treeNode);
                this.allChildren.addAll(treeNode.getAllChildren());
            }
        }
        return this.allChildren;
    }

    public String getCompleteName() {
        return completeName;
    }

    public void setCompleteName(String completeName) {
        this.completeName = completeName;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}