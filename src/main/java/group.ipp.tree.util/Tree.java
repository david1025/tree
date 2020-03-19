package group.ipp.tree.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import group.ipp.tree.util.annotation.TreeNodeId;
import group.ipp.tree.util.annotation.TreeNodeLevel;
import group.ipp.tree.util.annotation.TreeNodeName;
import group.ipp.tree.util.annotation.TreeNodeOrder;
import group.ipp.tree.util.annotation.TreeNodeParentId;
import org.apache.commons.lang3.StringUtils;

/**
 * 构建树形建构
 *
 * @author David
 */
public class Tree<T> {
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
    public Tree(List<T> list) {
        initTreeNodeMap(list);
        initTreeNodeList();
    }

    /**
     * 将List对象数据转为TreeNodeMap
     *
     * @param list
     */
    private void initTreeNodeMap(List<T> list) {
        TreeNode treeNode;
        for (Object item : list) {
            treeNode = new TreeNode();
            treeNode.setNodeId(getFieldValue(item, "TreeNodeId"));
            treeNode.setNodeName(getFieldValue(item, "TreeNodeName"));
            treeNode.setParentNodeId(getFieldValue(item, "TreeNodeParentId"));
            if(StringUtils.isEmpty(getFieldValue(item, "TreeNodeLevel"))) {
                treeNode.setLevel(0);
            } else {
                treeNode.setLevel(Integer.parseInt(getFieldValue(item, "TreeNodeLevel")));
            }
            if(StringUtils.isEmpty(getFieldValue(item, "TreeNodeOrder"))) {
                treeNode.setOrderNum(0);
            } else {
                treeNode.setOrderNum(Integer.parseInt(getFieldValue(item, "TreeNodeOrder")));
            }
            treeNode.setLastNodeNum(1);
            treeNode.setData(item);
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

    private String getFieldValue(Object obj, String type) {
        Class clz = obj.getClass();
        Field[] fields = clz.getDeclaredFields();
        String value = null;
        try {
            for(Field field : fields){
                field.setAccessible(true);
                switch (type){
                    case "TreeNodeId":
                        if(field.isAnnotationPresent(TreeNodeId.class)) {
                            value = String.valueOf(field.get(obj));
                        }
                        break;
                    case "TreeNodeParentId":
                        if(field.isAnnotationPresent(TreeNodeParentId.class)) {
                            value = String.valueOf(field.get(obj));
                        }
                        break;
                    case "TreeNodeName":
                        if(field.isAnnotationPresent(TreeNodeName.class)) {
                            value = String.valueOf(field.get(obj));
                        }
                        break;
                    case "TreeNodeOrder":
                        if(field.isAnnotationPresent(TreeNodeOrder.class)) {
                            value = String.valueOf(field.get(obj));
                        }
                        break;
                    case "TreeNodeLevel":
                        if(field.isAnnotationPresent(TreeNodeLevel.class)) {
                            value = String.valueOf(field.get(obj));
                        }
                        break;
                    default:
                        break;
                }
            }
        } catch (IllegalAccessException e) {
                e.printStackTrace();
        }
        return value;
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

    public List<TreeNode> getTree() {
        return this.treeNodesList;
    }

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

    public TreeNode getTreeNode(String nodeId) {
        return this.treeNodesMap.get(nodeId);
    }
}