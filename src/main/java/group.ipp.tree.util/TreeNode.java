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
    @JSONField(ordinal=1)
    private String nodeId;
    /**
     * 树节点名称
     */
    @JSONField(ordinal=2)
    private String nodeName;
    /**
     * 父节点ID
     */
    @JSONField(ordinal=3)
    private String parentNodeId;
    /**
     * 节点在树中的排序号
     */
    @JSONField(ordinal=4)
    private int orderNum;
    /**
     * 节点所在的层级
     */
    @JSONField(ordinal=5)
    private int level;
    /**
     * 最子节点的数量
     */
    private int lastNodeNum;
    private boolean lastNode;
    private TreeNode parent;
    /**
     * 当前节点的儿子节点
     */
    @JSONField(ordinal=6)
    private List<TreeNode> children = new ArrayList<>();
    /**
     * 当前节点的子孙节点
     */
    private List<TreeNode> allChildren = new ArrayList<>();
    private String id;
    private String name;
    private String text;
    private String state;
    private String pid;

    public String getPid() {
        return pid;
    }
    public void setPid(String pid) {
        this.pid = pid;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getText() {
        return name;
    }
    public void setText(String text) {
        this.text = text;
    }
    public String getState() {
        return "open";
    }
    public void setState(String state) {
        this.state = state;
    }
    public TreeNode(ITreeNode obj){
        this.nodeId = obj.getNodeId();
        this.id =  obj.getNodeId();
        this.nodeName = obj.getNodeName();
        this.name = obj.getNodeName();
        this.parentNodeId = obj.getNodeParentId();
        this.orderNum = obj.getOrderNum();
        this.level = obj.getNodeLevel();
        this.pid = obj.getNodeParentId();
    }
    public TreeNode(TreeNode obj){
        this.id =  obj.getNodeId();
        this.name = obj.getName();
        this.orderNum = obj.getOrderNum();
        this.level = obj.getLevel();
        this.pid = obj.getParentNodeId();
        this.lastNodeNum = obj.getLastNodeNum();
    }
    public TreeNode(){
    }
    public void addChild(TreeNode treeNode){
        this.children.add(treeNode);
    }
    public void removeChild(TreeNode treeNode){
        this.children.remove(treeNode);
    }
    public String getNodeId() {
        return nodeId;
    }
    public void setNodeId(String nodeId) {
        this.id = nodeId;
    }
    public String getNodeName() {
        return nodeName;
    }
    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
        this.name = nodeName;
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
        if(this.allChildren.isEmpty()){
            for(TreeNode treeNode : this.children){
                this.allChildren.add(treeNode);
                this.allChildren.addAll(treeNode.getAllChildren());
            }
        }
        return this.allChildren;
    }
}