package com.microsilver.mrcard.cloud.finance.controller;

import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceMerchShareConfig;
import com.microsilver.mrcard.cloud.finance.service.impl.MrcardFinanceMerchConfigService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Jade
 * @Description 商户分润比例配置
 * @create 2017-07-28 下午 1:51
 * @Copyright Micro Silver
 **/

@RestController
@RequestMapping("/finance/merch/")
public class FinanceMerchShareController {

    @Resource
    MrcardFinanceMerchConfigService imerchConfigService;

    @PostMapping("addMerchconfig")
    public boolean addMerchConfig(@RequestBody MrcardFinanceMerchShareConfig agentConfig){
        return imerchConfigService.addMerchConfig(agentConfig);
    }

    @PostMapping("updateMerchconfig")
    public boolean updateMerchConfig(@RequestBody MrcardFinanceMerchShareConfig agentConfig){
        return imerchConfigService.updateMerchConfig(agentConfig);
    }
    @PostMapping("delMerchconfig")
    public boolean deleteMerchConfig(@RequestParam long id){
        return imerchConfigService.deleteMerchConfig(id);
    }

    @PostMapping("getMerchconfig")
    public List<MrcardFinanceMerchShareConfig> getMerchConfig(@RequestBody MrcardFinanceMerchShareConfig agentConfig){
        return imerchConfigService.getMerchConfig(agentConfig);
    }

    @GetMapping("getMerchconfigById")
    public MrcardFinanceMerchShareConfig getMerchConfig(@RequestParam Long id){
        return imerchConfigService.getMerchConfigById(id);
    }
}
