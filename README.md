# treeUtils
将List<Object>类型的数据构造成父子结构，children的结构。

### 使用方法
将对应TreeNodeId，TreeNodeName，TreeNodeParentId，TreeNodeOrder，TreeNodeLevel对应到我们的对象中
```java
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
}
```
然后
```java
Tree tree = new Tree(List对象);
// 获取完整树型
List<TreeNode> treeNode1 = tree.getRoot();
```