package io.github.fpure.admin.model;

import java.util.List;

public class Menu {
    
    // ID
    Long id;
    // 父ID
    Long pid;
    // 菜单名
    String name;
    // 排序
    Integer seq;
    // 是否启用(0禁用1启用)
    Integer isEnable;
    // 是否叶子节点(0否1是)
    Integer isLeafNode;
    // 是否有子节点(0否1是)
    Integer isHasSubNode;
    // 子节点列表
    List<Menu> subNodeList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Integer getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
    }

    public Integer getIsLeafNode() {
        return isLeafNode;
    }

    public void setIsLeafNode(Integer isLeafNode) {
        this.isLeafNode = isLeafNode;
    }

    public List<Menu> getSubNodeList() {
        return subNodeList;
    }

    public void setSubNodeList(List<Menu> subNodeList) {
        this.subNodeList = subNodeList;
    }

    public boolean isEnable() {
        return this.isEnable == 1;
    }

    public boolean isLeafNode() {
        return this.isLeafNode == 1;
    }

    public boolean isHasSubNode() {
        return this.isHasSubNode == 1;
    }

    public Integer getIsHasSubNode() {
        return isHasSubNode;
    }

    public void setIsHasSubNode(Integer isHasSubNode) {
        this.isHasSubNode = isHasSubNode;
    }
}