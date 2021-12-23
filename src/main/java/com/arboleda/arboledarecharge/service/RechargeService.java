package com.arboleda.arboledarecharge.service;

import com.arboleda.arboledarecharge.dto.CreateRechargeDto;
import com.arboleda.arboledarecharge.dto.ListCompaniesDto;
import com.arboleda.arboledarecharge.model.TelecomProvider;
import com.arboleda.arboledarecharge.model.Recharge;

import java.util.List;

public interface RechargeService {
    public List<TelecomProvider> listCompanies(ListCompaniesDto listCompanies);
    public Recharge recharge(CreateRechargeDto createRechargeDto) throws Exception;
}
