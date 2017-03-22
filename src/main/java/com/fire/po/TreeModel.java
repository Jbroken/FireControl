package com.fire.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TreeModel implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;// id

//	private Long pid;// 节点

	private String text;// 要显示的文本

	private String state;//节点状态，'open' 或 'closed'。默认closed
	

	//private int seq;
    
	//private String iconCls;//显示的节点图标CSS类ID
	
	//private boolean isEndLeaf = false;
	
	private boolean checked  = false;//节点是否被选中，默认否
	
	private  String attributes;// 绑定到节点的自定义属性
    
//	private List<TreeModel> children = new ArrayList<TreeModel>();//子节点

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public String getAttributes() {
		return attributes;
	}

	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}







	
}
