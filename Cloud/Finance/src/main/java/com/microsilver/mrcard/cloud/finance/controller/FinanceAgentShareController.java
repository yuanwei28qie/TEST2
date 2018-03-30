package com.microsilver.mrcard.cloud.finance.controller;

import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceAgentShareConfig;
import com.microsilver.mrcard.cloud.finance.service.impl.MrcardFinanceAgentConfigService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/7/27 0027.
 * 代理商分润比例配置
 */
@RestController
@RequestMapping("/finance/agent/")
public class FinanceAgentShareController {

    @Resource
    MrcardFinanceAgentConfigService agentConfigService;

    @PostMapping("addAgentconfig")
    public boolean addAgentConfig(@RequestBody MrcardFinanceAgentShareConfig agentConfig){
        return agentConfigService.addAgentConfig(agentConfig);
    }

    @PostMapping("updateAgentconfig")
    public boolean updateAgentConfig(@RequestBody MrcardFinanceAgentShareConfig agentConfig){
        return agentConfigService.updateAgentConfig(agentConfig);
    }
    @PostMapping("delAgentconfig")
    public boolean deleteAgentConfig(@RequestParam long id){
        return agentConfigService.deleteAgentConfig(id);
    }

    @PostMapping("getAgentconfig")
    public List<MrcardFinanceAgentShareConfig> getAgentConfig(@RequestBody MrcardFinanceAgentShareConfig agentConfig){
        return agentConfigService.getAgentConfig(agentConfig);
    }

    @GetMapping("getAgentconfigById")
    public MrcardFinanceAgentShareConfig getAgentConfig(@RequestParam Long id){
        return agentConfigService.getAgentConfigById(id);
    }
}
