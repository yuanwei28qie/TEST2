package com.microsilver.mrcard.cloud.finance.test;

import com.alibaba.fastjson.JSON;
import com.microsilver.mrcard.cloud.finance.calc.Commission;
import com.microsilver.mrcard.cloud.finance.dto.BounsDto;
import com.microsilver.mrcard.cloud.finance.dto.CommissionDto;
import com.microsilver.mrcard.cloud.finance.dto.CustomerDto;
import com.microsilver.mrcard.cloud.finance.dto.ProportionDto;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2017/7/25 0025.
 */
public class CommissionTest {

    @Test
    public void DoubleArrayTest(){
        String args = "1_0_1_0_1";
        String[] arr = args.split("_");
        String[] prr = new String[]{"a","b","c","d","e"};
        String[] crr = new String[arr.length];
        for(int i = 0;i<arr.length;i++){
            if("1".equals(arr[i])){
                crr[i] = prr[i];
            }
        }
        System.out.println(JSON.toJSONString(crr));

        for(int j = 0;j<crr.length;j++){
            System.out.println(crr[j]);
        }
    }

    @Test
    public void BigDecimalTest(){

        BigDecimal div = new BigDecimal(0).subtract(new BigDecimal(-5));
        System.out.println(div);
        Short num = 6;
        BigDecimal dev = new BigDecimal(100);
        BigDecimal part = new BigDecimal(num).divide(dev);
        System.out.println(part);
        System.out.printf("==========================");
        //截取超过2位的值
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        decimalFormat.setRoundingMode(RoundingMode.FLOOR);
        for(int i = 0;i <10 ; i++) {
            BigDecimal b1 = new BigDecimal(Double.toString(25.012*i));
            BigDecimal bf = new BigDecimal(decimalFormat.format(b1));
            System.out.println(b1 + " ---> " + bf);
        }

    }

//    /**
//     * 平台测试
//     */
//    @Test
//    public void platformTest(){
//
//        CommissionStrategy comm = new PlatformStrategy();
//
//        Commission commission = new Commission(comm);
//
//        CommissionDto customer = initCommissionData();
//
//        ProportionDto prop = new ProportionDto((short)80,(short)100);
//        try {
//            commi(commission, customer,prop);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 平台测试Double
//     */
//    @Test
//    public void platformDoubleTest(){
//
//        CommissionStrategy comm = new PlatformStrategy();
//
//        Commission commission = new Commission(comm);
//
//        CommissionDto customer = initCommissionData();
//
//        ProportionDto prop = new ProportionDto((short)80,(short)100);
//
//        try {
//            doubleTest(commission, customer,prop);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 营销测试
//     */
//    @Test
//    public void provinceTest(){
//
//        CommissionStrategy comm = new ProvinceStrategy();
//
//        Commission commission = new Commission(comm);
//
//        CommissionDto customer = initCommissionData();
//        ProportionDto prop = new ProportionDto((short)80,(short)40,(short)60);
//        try {
//            commi(commission, customer ,prop);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 营销测试Double
//     */
//    @Test
//    public void provinceDoubleTest(){
//
//        CommissionStrategy comm = new ProvinceStrategy();
//
//        Commission commission = new Commission(comm);
//
//        CommissionDto customer = initCommissionData();
//        ProportionDto prop = new ProportionDto((short)80,(short)40,(short)60);
//        try {
//            doubleTest(commission, customer,prop);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    /**
//     * 勇士测试
//     */
//    @Test
//    public void WarriorTest(){
//
//        CommissionStrategy comm = new WarriorStrategy();
//
//        Commission commission = new Commission(comm);
//
//        CommissionDto customer = initCommissionData();
//
//        customer.setParent("1_1_1_1_1");
//
//        //全部都在
//        ProportionDto prop = new ProportionDto(
//                (short)80,
//                (short)40,
//                (short)10,
//                (short)6,
//                (short)4,
//                (short)40
//        );
//        //缺县代
//        ProportionDto prop_country = new ProportionDto(
//                (short)80,
//                (short)44,
//                (short)10,
//                (short)6,
//                (short)0,
//                (short)40
//        );
//        //缺市代
//        ProportionDto prop_city = new ProportionDto(
//                (short)80,
//                (short)46,
//                (short)10,
//                (short)0,
//                (short)4,
//                (short)40
//        );
//
//        //缺省代
//        ProportionDto prop_province = new ProportionDto(
//                (short)80,
//                (short)50,
//                (short)0,
//                (short)6,
//                (short)4,
//                (short)40
//        );
//        //province and city
//        ProportionDto prop_pro_city = new ProportionDto(
//                (short)80,
//                (short)56,
//                (short)0,
//                (short)0,
//                (short)4,
//                (short)40
//        );
//        //province and country
//        ProportionDto prop_pro_country = new ProportionDto(
//                (short)80,
//                (short)54,
//                (short)0,
//                (short)6,
//                (short)0,
//                (short)40
//        );
//        //city and country
//        ProportionDto prop_city_county = new ProportionDto(
//                (short)80,
//                (short)40,
//                (short)20,
//                (short)0,
//                (short)0,
//                (short)40
//        );
//        //only warriors
//        ProportionDto prop_warrior = new ProportionDto(
//                (short)80,
//                (short)60,
//                (short)0,
//                (short)0,
//                (short)0,
//                (short)40
//        );
//        try {
//            customer.setParent("1_1_1_1_1");
//            commi(commission, customer ,prop);
//
//            customer.setParent("1_1_1_0_1");
//            commi(commission, customer ,prop_country);
//
//            customer.setParent("1_1_0_1_1");
//            commi(commission, customer ,prop_city);
//
//            customer.setParent("1_0_1_1_1");
//            commi(commission, customer ,prop_province);
//
//            customer.setParent("1_0_0_1_1");
//            commi(commission, customer ,prop_pro_city);
//
//            customer.setParent("1_0_1_0_1");
//            commi(commission, customer ,prop_pro_country);
//
//            customer.setParent("1_1_0_0_1");
//            commi(commission, customer ,prop_city_county);
//
//            customer.setParent("1_0_0_0_1");
//            commi(commission, customer ,prop_warrior);
//            customer.setKeyWord("2_3_0_0_6");
//            commi(commission, customer ,prop);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    private void commi(Commission commission, CommissionDto customer, ProportionDto prop ) throws Exception {

        for(int i=1;i<=100;i++){
            customer.setTotalAmount(new BigDecimal(i));
            List<BounsDto> bounsList = commission.getBounds(customer,prop);

            for(BounsDto d : bounsList){
                System.out.println(JSON.toJSON(d));
            }
            System.out.println("----"+i+"-------------------------------");
        }
    }

    private void doubleTest(Commission commission, CommissionDto customer, ProportionDto prop ) throws Exception {
        Double dl = 0.9;
        for(int i=1;i<=100;i++){
            customer.setTotalAmount(new BigDecimal(i).multiply(new BigDecimal(Double.toString(dl))));
            List<BounsDto> bounsList = commission.getBounds(customer,prop);

            for(BounsDto d : bounsList){
                System.out.println(JSON.toJSON(d));
            }
            System.out.println("----"+i*dl+"-------------------------------");
        }
    }

    /**
     * 组装客户数据
     * @return
     */
    private CommissionDto initCommissionData() {
        CommissionDto customer = new CommissionDto();
        customer.setKeyWord("1_0_0_0_1");
        CustomerDto cd = new CustomerDto();
        cd.setFinanceId(UUID.randomUUID().getLeastSignificantBits());
        cd.setIdentity((short)1);
        cd.setMemberName("商户");
        customer.setMerchInfo(cd);

        customer.setOrderSn(UUID.randomUUID().toString());
        customer.setKeyWord(UUID.randomUUID().toString());
        customer.setTotalAmount(new BigDecimal(100));

        CustomerDto [] dtos = new CustomerDto[5];

        CustomerDto c0 = new CustomerDto();
        c0.setFinanceId(UUID.randomUUID().getLeastSignificantBits());
        c0.setIdentity((short)2);
        c0.setMemberName("平台");
        dtos[0] = c0;

        CustomerDto c1 = new CustomerDto();
        c1.setFinanceId(UUID.randomUUID().getLeastSignificantBits());
        c1.setIdentity((short)3);
        c1.setMemberName("省代");
        dtos[1] = c1;

        CustomerDto c2 = new CustomerDto();
        c2.setFinanceId(UUID.randomUUID().getLeastSignificantBits());
        c2.setIdentity((short)4);
        c2.setMemberName("市代");
        dtos[2] = c2;

        CustomerDto c3 = new CustomerDto();
        c3.setFinanceId(UUID.randomUUID().getLeastSignificantBits());
        c3.setIdentity((short)5);
        c3.setMemberName("县代");
        dtos[3] = c3;

        CustomerDto c4 = new CustomerDto();
        c4.setFinanceId(UUID.randomUUID().getLeastSignificantBits());
        c4.setIdentity((short)6);
        c4.setMemberName("勇士");
        dtos[4] = c4;

        customer.setParentCustomer(dtos);
        return customer;
    }


}
