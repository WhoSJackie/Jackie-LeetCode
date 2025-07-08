package com.wang.java_Learning.algorithm.tree;


import cn.hutool.core.date.StopWatch;
import cn.hutool.core.util.ObjectUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.wang.common.utils.JsonUtil;
import com.wang.java_Learning.sql.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import java.util.stream.Collectors;

public class BuildOrgTree {
    public List<SysOrgNode> streamToTree(List<SysOrg> orgList, String parentId){
        // 找到父节点是指定节点id的节点
        List<SysOrgNode> res = new ArrayList<>();
        for (SysOrg org : orgList) {
            if (Objects.equals(parentId,org.getParentorgid())){
                // 找到orgId为parentId的orgNode
                SysOrgNode cnode = new SysOrgNode();
                cnode.setOrgid(org.getOrgid());
                cnode.setParentorgid(org.getParentorgid());
                cnode.setChildren(new ArrayList<>());
                res.add(cnode);
            }
        }
        for (SysOrgNode p : res) {
            p.setChildren(streamToTree(orgList,p.getOrgid()));
        }
        return res;
    }

    public List<SysOrgNode> streamToTree1(List<SysOrg> treeList, String parentId) {
        List<SysOrgNode> list = treeList.stream()
                // 转为node对象，精简字段
                .map(sysOrg ->{
                    SysOrgNode node = new SysOrgNode();
                    node.setOrgid(sysOrg.getOrgid());
                    node.setParentorgid(sysOrg.getParentorgid());
                    node.setChildren(new ArrayList<>());
                    return node;
                })
                // 过滤父节点
                .filter(parent -> Objects.equals(parent.getParentorgid(), parentId))
                // 把父节点children递归赋值成为子节点
                .map(child -> {
                    child.setChildren(streamToTree1(treeList,child.getOrgid()));
                    return child;
                })
                .collect(Collectors.toList());
        return list;
    }
    //
    public void streamToTree2(List<SysOrg> orgList, SysOrgNode node){
        List<SysOrgNode> tree = new ArrayList<>();
        String pid = node.getOrgid();
        for (SysOrg sysOrg : orgList) {
            if (ObjectUtil.equal(sysOrg.getParentorgid(),pid)){
                SysOrgNode cnode = new SysOrgNode();
                cnode.setOrgid(sysOrg.getOrgid());
                cnode.setParentorgid(sysOrg.getParentorgid());
                cnode.setOrgname(sysOrg.getOrgname());
                cnode.setChildren(new ArrayList<>());
                tree.add(cnode);
            }
        }
//        List<SysOrgNode> store = new ArrayList<>();
        // 递归处理子节点
        for (int i=0;i<tree.size();i++) {
            streamToTree2(orgList,tree.get(i));
        }
        node.setChildren(tree);
    }

    public List<SysOrg> queryAllTree(){
        List<SysOrg> orgList = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtil.getGaussConn("jdbc:postgresql://10.201.69.42:30100/macbs_db","macbs_217comm","SZtest30");
            ps = conn.prepareStatement("select * from sys_org");
            rs = ps.executeQuery();
            SysOrg org = new SysOrg();
            orgList = JdbcUtil.getObjList(org, rs);
        } catch (Exception e){
            e.printStackTrace();
        } finally{
            try{
                rs.close();
                ps.close();
                conn.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return orgList;
    }

    public static void main(String[] args) throws JsonProcessingException {
        StopWatch watch = new StopWatch("监控1");
        BuildOrgTree treeFunc = new BuildOrgTree();
        watch.start("查询机构节点");
        List<SysOrg> sysOrgs = treeFunc.queryAllTree();
        watch.stop();
        System.out.println(watch.getLastTaskTimeMillis());

//        watch.start("优化前建树");
//        treeFunc.streamToTree1(sysOrgs, null);
//        watch.stop();
//        System.out.println(watch.getLastTaskTimeMillis());

//        watch.start("优化后建树");
//        treeFunc.streamToTree(sysOrgs, null);
//        watch.stop();
//        System.out.println(watch.getLastTaskTimeMillis());

        watch.start("优化后建树");
        SysOrgNode parent = new SysOrgNode();
        treeFunc.streamToTree2(sysOrgs, parent);
        System.out.println(JsonUtil.writeValueAsString(parent.getChildren()));
        watch.stop();
        System.out.println(watch.getLastTaskTimeMillis());

    }
}
