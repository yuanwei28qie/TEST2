package com.microsilver.mrcard.serviceplatform.model.enums;

public enum EVIPType {
	VIP_MEMBER("VM",10,"VIP会员"),
	START_PANTER("VP",1,"创业合伙人"),
	SENIOR_PANTER("SP",2,"高级合伙人"),
	SUPER_PANTER("SVP",3,"超级合伙人");
	
	
	protected String name;
    protected int value;
    protected String cname;

    private EVIPType(String name, int value,String cname){
        this.name=name;
        this.value=value;
        this.cname = cname;
    }
    
    public static EVIPType getEnumValue(int index){
    	EVIPType eunm;
    	switch(index) {
    		case 1:eunm = START_PANTER;break;
    		case 2:eunm = SENIOR_PANTER;break;
    		case 3:eunm = SUPER_PANTER;break;
    		case 10:eunm = VIP_MEMBER;break;
    		default: eunm = SUPER_PANTER;break;
    	}
    	return eunm;
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

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}
	
    
}
