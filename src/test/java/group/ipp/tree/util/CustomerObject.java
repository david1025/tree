package group.ipp.tree.util;

public class CustomerObject implements ITreeNode {

    private String id;

    private String name;

    private String parentId;

    private Integer orderNum;

    private Integer level;

    public CustomerObject() {

    }

    public CustomerObject(String id, String name, String parentId, int orderNum, int level) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
        this.orderNum = orderNum;
        this.level = level;
    }

    @Override
    public String getNodeId() {

        return this.id;
    }

    @Override
    public String getNodeName() {
        return this.name;
    }

    @Override
    public String getNodeParentId() {

        return this.parentId;
    }

    @Override
    public Integer getOrderNum() {
        return this.orderNum;
    }

    @Override
    public Integer getNodeLevel() {
        return this.level;
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

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }


}
