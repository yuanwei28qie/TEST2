package com.microsilver.mrcard.serviceplatform.model.enums;

public enum EEmployeeRole {
	Staff("工作人员",26),
	Finance("财务",27),
	Manager("店长",28);
	
	
	protected String name;
    protected int value;

    private EEmployeeRole(String name, int value){
        this.name=name;
        this.value=value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
	
}
