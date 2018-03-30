package com.microsilver.mrcard.serviceplatform.model.enums;

/**
 * 
 * @Name com.microsilver.mrcard.serviceplatform.model.enums.EMerchType
 * @Description 商家类型
 * 
 * @Author bruce
 * @Version 2017年6月30日 上午10:18:51
 * @Copyright Micro Silver
 *
 */
public enum EBusinessType {
	Merchant("商户",1), Agent("代理商",2), Knight("骑士",3),
	Employee("员工",11),Courier("快递员",12);

    protected String name;
    protected int value;

    private EBusinessType(String name, int value){
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

    public static EBusinessType valueOf(int value){
        switch (value) {
            case 1:
                return Merchant ;
            case 2:
                return Agent ;
            case 3:
                return Knight ;
            default:
                return Merchant ;
        }
    }
}
