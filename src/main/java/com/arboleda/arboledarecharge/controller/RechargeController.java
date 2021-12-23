package com.arboleda.arboledarecharge.controller;

import com.arboleda.arboledarecharge.dto.CreateRechargeDto;
import com.arboleda.arboledarecharge.dto.ListCompaniesDto;
import com.arboleda.arboledarecharge.model.TelecomProvider;
import com.arboleda.arboledarecharge.model.Recharge;
import com.arboleda.arboledarecharge.service.RechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping//("/recharges")
public class RechargeController {
    @Autowired
    private RechargeService rechargeService;

    @RequestMapping(value = "/companies", method = RequestMethod.GET)
    public @ResponseBody List<TelecomProvider> listCompanies(@Valid ListCompaniesDto listCompaniesDto) {
        return rechargeService.listCompanies(listCompaniesDto);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, headers = "Content-type=application/json")
    public @ResponseBody Recharge recharge(@RequestBody CreateRechargeDto createRechargeDto) throws Exception {
        return rechargeService.recharge(createRechargeDto);
    }

}
