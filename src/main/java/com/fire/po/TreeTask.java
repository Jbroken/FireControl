package com.fire.po;

/**
 * Created by BZhao on 2017/4/16.
 */
public class TreeTask {

    private int id;     //节点ID

    private String name;    //节点名称

    private Integer _parentId;  //父节点id

    private String state;   //状态    默认为open

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer get_parentId() {
        return _parentId;
    }

    public void set_parentId(Integer _parentId) {
        this._parentId = _parentId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "TreeTask{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", _parentId=" + _parentId +
                ", state='" + state + '\'' +
                '}';
    }
}
