package group.ipp.tree.util;

import group.ipp.tree.util.annotation.*;

public class CustomerObject1 {

    @TreeNodeId
    private String id;

    @TreeNodeName
    private String name;

    @TreeNodeParentId
    private String parentId;

    @TreeNodeOrder
    private Integer orderNum;

    @TreeNodeLevel
    private Integer level;

    private String test1;

    private String test2;

    public CustomerObject1() {

    }

    public CustomerObject1(String id, String name, String parentId, int orderNum, int level) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
        this.orderNum = orderNum;
        this.level = level;
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

    public String getTest1() {
        return test1;
    }

    public void setTest1(String test1) {
        this.test1 = test1;
    }

    public String getTest2() {
        return test2;
    }

    public void setTest2(String test2) {
        this.test2 = test2;
    }
}
