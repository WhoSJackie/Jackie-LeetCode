/*
 * <p>文件名称: SysOrg.java</p>
 * <p>项目描述: 金证财富多资产清算簿记平台 V2.0.0</p>
 * <p>公司名称: 深圳市金证科技股份有限公司</p>
 * <p>版权所有: 版权所有(C)2019-2022</p>
 */

package com.wang.java_Learning.algorithm.tree;

/**
*
* 对应表. sys_org
* 机构信息.
* (工具生成不允许覆盖).
* @author tool
* @since 1.0.0
*/
public class SysOrg {

    /**
    * 机构编号
    */
    private String orgid;

    /**
    * 机构名称
    */
    private String orgname;

    /**
    * 机构全称
    */
    private String orglongname;

    /**
    * 机构级别
    */
    private Integer orglevel;

    /**
    * 父机构编号
    */
    private String parentorgid;

    /**
    * 投资部门标志
    */
    private String investorg;



    public String getOrgid() {
        return this.orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid;
    }

    public String getOrgname() {
        return this.orgname;
    }

    public void setOrgname(String orgname) {
        this.orgname = orgname;
    }

    public String getOrglongname() {
        return this.orglongname;
    }

    public void setOrglongname(String orglongname) {
        this.orglongname = orglongname;
    }

    public Integer getOrglevel() {
        return this.orglevel;
    }

    public void setOrglevel(Integer orglevel) {
        this.orglevel = orglevel;
    }

    public String getParentorgid() {
        return this.parentorgid;
    }

    public void setParentorgid(String parentorgid) {
        this.parentorgid = parentorgid;
    }

    public String getInvestorg() {
        return this.investorg;
    }

    public void setInvestorg(String investorg) {
        this.investorg = investorg;
    }

}
