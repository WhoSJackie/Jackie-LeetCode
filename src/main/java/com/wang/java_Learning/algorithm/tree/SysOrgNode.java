package com.wang.java_Learning.algorithm.tree;

import java.util.List;

/**
 * 机构表组装的树节点
 */
public class SysOrgNode extends SysOrg {

    private List<SysOrgNode> children;

    public List<SysOrgNode> getChildren() {
        return children;
    }

    public void setChildren(List<SysOrgNode> children) {
        this.children = children;
    }
}
