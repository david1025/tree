package group.ipp.tree.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * tree工具类单元测试类
 */
public class TreeTest {

    @Test
    public void treeTest1() {
        String json = "{\"id\":\"77e599c007d848779d9d91b4741af2e5\",\"name\":\"Safety(安全性)\",\"unit\":\"\",\"children\":[{\"id\":\"f48e25ebb126451bbf493b9fb8bd6410\",\"name\":\"Steady state cornering(稳态回转)\",\"unit\":\"\",\"children\":[{\"id\":\"ae37bdc20c3c4d24a84305c9c8d7fa98\",\"name\":\"Handling balance:understeer/oversteer dry/wet(平衡度)\",\"unit\":\"\",\"children\":[{\"id\":\"91d0a04ef2014d949c3f4cf52a1fe5ac\",\"name\":\"方向盘总圈数\",\"unit\":\"\"},{\"id\":\"bfb7f0e9e715451c9b87112f3f39922b\",\"name\":\"原地静止平均力矩水平（Average Parking Effort ）\",\"unit\":\"\"}]},{\"id\":\"2f09e70d2d7140ce9061697357f1d313\",\"name\":\"Progressive behavior with change lateral acceleration(渐进性)\",\"unit\":\"\",\"children\":[{\"id\":\"5ee19e5588444feda06885ab47b5d6fc\",\"name\":\"初始回正速度（左，两人载）\",\"unit\":\"\"},{\"id\":\"e74dade75c2042458ee179d48109dde2\",\"name\":\"方向盘残留角（左，两人载）\",\"unit\":\"\"}]},{\"id\":\"fe6e07e20db74f249b4a1399041620ed\",\"name\":\"Degree of body roll(车身侧倾量)\",\"unit\":\"\"}]},{\"id\":\"67de8cad485c43e9a4ac51cda0d4f57c\",\"name\":\"Tramsient cornering(瞬态转向)\",\"unit\":\"\",\"children\":[{\"id\":\"1ceb649aba5d4350880c5ee6877096b4\",\"name\":\"Turn\",\"unit\":\"in response on smooth surface(转向反馈)\"},{\"id\":\"5057ed6ea6164317afb83eaf7aaa9844\",\"name\":\"Response linearity(反馈线性度)\",\"unit\":\"\"},{\"id\":\"7b48f525e42543999d40c5a2839178d0\",\"name\":\"Body roll/pitch control (车身翻滚/点头控制)\",\"unit\":\"\"},{\"id\":\"b0c5d1ed2f104583a0236d56d4a5db3f\",\"name\":\"Immediacy/steering delay (转向延迟)\",\"unit\":\"\"},{\"id\":\"98df0f526cf943c7836c52239d08569d\",\"name\":\"Turning/steering precision(精度)\",\"unit\":\"\"}]},{\"id\":\"94736f3132a84b66bb05a2a275919454\",\"name\":\"Cornering(转弯)\",\"unit\":\"\",\"children\":[{\"id\":\"01627cbb37934c6ba49d229e634a4c79\",\"name\":\"cornering behaviour at max acceleration/over\",\"unit\":\"/under steer(最大加速度的不足转向特性)\"},{\"id\":\"22ebdc0a7cb2498dbb43f2691ef89160\",\"name\":\"Behaviour at the end of cornering (驶出弯道特性)\",\"unit\":\"\"},{\"id\":\"de9c3b61371a481d89499be4250227db\",\"name\":\"Behaviour at star of cornering/ willingness to turn in(进入弯道特性)\",\"unit\":\"\"},{\"id\":\"3a96b02fc78f4719ac0d0d1d7dca949d\",\"name\":\"Power change(acceleration/release drift) US/OS (弯道加减速不足转向特性)\",\"unit\":\"\"}]},{\"id\":\"0bed2a68d2e248bc82d946cbb1be79f8\",\"name\":\"Dynamic behaviour(动态特性)\",\"unit\":\"\",\"children\":[{\"id\":\"1cacdf9a2bd8423bbf2770f5b79d2633\",\"name\":\"Turn in reponse(转向反馈)\",\"unit\":\"\"},{\"id\":\"e9ca40a60f0245c59965a3e0f685f2f9\",\"name\":\"Recover(恢复)\",\"unit\":\"\"},{\"id\":\"8d102de1836140b88b191fd45456b910\",\"name\":\"control(控制)\",\"unit\":\"\"},{\"id\":\"d2dcdf7b7a3c4dc0a2fdef13082a1efb\",\"name\":\"Roll/yaw stability(侧倾/横摆稳定性)\",\"unit\":\"\"}]},{\"id\":\"03b09d907f5b4fd288949461b42d70a4\",\"name\":\"Slalom(蛇形)\",\"unit\":\"\",\"children\":[{\"id\":\"6d91ce017dcc4423af01c14b4da8e3cb\",\"name\":\"Slalom with small steering input(蛇形/小转向)\",\"unit\":\"\"},{\"id\":\"b4edd9708822458c913e75bdde713b09\",\"name\":\"Small fast step input on the steering(roll motion and damping(小角度阶跃转向的侧倾与回覆阻尼)\",\"unit\":\"\"},{\"id\":\"051076ad552d4e1fb53487fd527e16e6\",\"name\":\"Slalom (普通蛇形)\",\"unit\":\"\"}]},{\"id\":\"4185e79e1e7e4231ae2e12d00b1006c9\",\"name\":\"Straight line (stability linearity)\",\"unit\":\"\",\"children\":[{\"id\":\"8c372a5d5b774caa8b0d09a66000604d\",\"name\":\"straight line even road>120 km/hr (环路直行性）\",\"unit\":\"\"},{\"id\":\"c33a9e0c8f334cb9a95ca32c31c9cd0d\",\"name\":\"straight line transtion\",\"unit\":\"lacking precision (直线制动车辆点头及摇晃)\"}]},{\"id\":\"16c7e06c0a5248138c57eb30e33fc901\",\"name\":\"Brake in turn\",\"unit\":\"\",\"children\":[{\"id\":\"ebef8bb488de4f169f1d9fda32b1b739\",\"name\":\"Brake in turn US/OS (max. and min.) (最大及中度弯道制动下的不足转向特性\",\"unit\":\"\"},{\"id\":\"32054c2410c948b79e8e24fe0462f7a8\",\"name\":\"Brake in straight line Pitch/weave (直线制动车辆点头及摇晃)\",\"unit\":\"\"}]}]}";
        TreeNode node = JSONArray.parseObject(json, TreeNode.class);
        System.out.println(node);

        long t1 = System.currentTimeMillis();
        // 将查询回来的父子结构list构建成Tree结构
        Tree tree = new Tree(data());
        // 获取完成树型
        List<TreeNode> treeNode1 = tree.getRoot();
        long t2 = System.currentTimeMillis();
        System.out.println("构建树形并获取根树形需要的时间：" + (t2 - t1) + "ms");
        TreeNode tn = treeNode1.get(0);
        List<TreeNode> lastTreeNodeList = new ArrayList<>();
        findLastChildList(tn, lastTreeNodeList);

        List<String> treeNodeHoleNames;
        for (TreeNode t : lastTreeNodeList) {
            System.out.println(t.getNodeName());
            treeNodeHoleNames = new ArrayList<>();
            findParents(t, treeNodeHoleNames);
            // 反转lists
            Collections.reverse(treeNodeHoleNames);
            String holeName = "";
            for(String name : treeNodeHoleNames) {
                holeName += name + " > ";
            }
            if(holeName.length() > 0) {
                holeName = holeName.substring(0, holeName.length() - 2);
            }
            t.setCompleteName(holeName);
            System.out.println(holeName);
        }

        long t3 = System.currentTimeMillis();
        String data1 = JSONObject.toJSONString(treeNode1);
        long t4 = System.currentTimeMillis();
        System.out.println("fastJson转成json需要的时间：" + (t4 - t3) + "ms");
        System.out.println(data1);

        //获取指定节点
        long t5 = System.currentTimeMillis();
        TreeNode treeNode = tree.getTreeNode("21");
        String data = JSONObject.toJSONString(treeNode);
        long t6 = System.currentTimeMillis();
        System.out.println("fastJson转成json需要的时间：" + (t6 - t5) + "ms");
        System.out.println(data);


        long t7 = System.currentTimeMillis();
        // 获取完成树型
        List<TreeNode> treeNode2 = tree.getTree();
        String data2 = JSONObject.toJSONString(treeNode2);
        long t8 = System.currentTimeMillis();
        System.out.println("fastJson转成json需要的时间：" + (t8 - t7) + "ms");
        System.out.println(data2);
    }

    private void findLastChildList(TreeNode treeNode, List<TreeNode> treeNodeList) {
        if(!treeNode.isLastNode()) {
            for(TreeNode tn : treeNode.getChildren()) {
                findLastChildList(tn, treeNodeList);
            }
        } else {
            treeNodeList.add(treeNode);
        }
    }

    private void findParents(TreeNode treeNode, List<String> parentNames) {
        parentNames.add(treeNode.getNodeName());
        if(treeNode.getParent() != null) {
            findParents(treeNode.getParent(), parentNames);
        }
    }

    /**
     * 模拟从数据库中查出父子结构的List
     *
     * @return
     */
    public List<ITreeNode> data() {
        List<ITreeNode> list = new ArrayList<>();


        CustomerObject c1 = new CustomerObject("11", "根节点1", "0", 1, 1);


        CustomerObject c3 = new CustomerObject("21", "一级节点1", "11", 3, 2);

        CustomerObject c4 = new CustomerObject("22", "一级节点2", "11", 4, 2);

        CustomerObject c5 = new CustomerObject("23", "一级节点3", "11", 5, 2);

        CustomerObject c7 = new CustomerObject("31", "二级节点1", "21", 7, 3);

        CustomerObject c8 = new CustomerObject("32", "二级节点2", "21", 8, 3);

        CustomerObject c9 = new CustomerObject("33", "二级节点3", "23", 9, 3);

        CustomerObject c10 = new CustomerObject("34", "二级节点4", "23", 10, 3);

        CustomerObject c13 = new CustomerObject("41", "三级节点1", "31", 13, 4);

        CustomerObject c14 = new CustomerObject("42", "三级节点2", "31", 14, 4);
        list.add(c14);
        list.add(c13);
        list.add(c10);
        list.add(c9);
        list.add(c8);
        list.add(c7);
        list.add(c5);
        list.add(c4);
        list.add(c3);
        list.add(c1);

        return list;
    }

}
