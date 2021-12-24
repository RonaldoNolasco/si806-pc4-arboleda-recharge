package com.arboleda.arboledarecharge.service;

import com.arboleda.arboledarecharge.dto.CreateRechargeDto;
import com.arboleda.arboledarecharge.dto.ListCompaniesDto;
import com.arboleda.arboledarecharge.model.TelecomProvider;
import com.arboleda.arboledarecharge.model.Recharge;
import com.arboleda.arboledarecharge.repository.AccountRepository;
import com.arboleda.arboledarecharge.repository.TelecomProviderRepository;
import com.arboleda.arboledarecharge.repository.PhoneRepository;
import com.arboleda.arboledarecharge.repository.RechargeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class RechargeServiceImpl implements RechargeService {
    @Autowired
    private RechargeRepository rechargeRepository;
    @Autowired
    private TelecomProviderRepository telecomProviderRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private PhoneRepository phoneRepository;

    public List<TelecomProvider> listCompanies(ListCompaniesDto listCompanies) {
        if (listCompanies.getPartialCompanyName() == null) {
            return telecomProviderRepository.findAll();
        }
        return telecomProviderRepository.findByNameContaining(listCompanies.getPartialCompanyName());
    }

    public Recharge recharge(CreateRechargeDto createRechargeDto) throws Exception {
        var company = telecomProviderRepository
                .findById(createRechargeDto.getCompanyId())
                .orElseThrow();
        var account = accountRepository
                .findById(createRechargeDto.getAccountId())
                .orElseThrow();
        var phone = phoneRepository
                .findById(createRechargeDto.getPhoneNumber())
                .orElseThrow();
        if (!Objects.equals(account.user.secretKey, createRechargeDto.getSecretKey())) {
            throw new Exception("Secret key mismatch");
        }
        if (!Objects.equals(phone.telecomProvider.getId(), company.getId())) {
            throw new Exception("An error occurred");
        }
        if (!Objects.equals(account.currency, createRechargeDto.getCurrency())) {
            throw new Exception("Currency mismatch");
        }
        if (account.balance < createRechargeDto.getAmount()) {
            throw new Exception("Insufficient funds");
        }
        var recharge = new Recharge();
        recharge.setRechargeDate(new Date());
        recharge.setAccount(account);
        recharge.setCompany(company);
        recharge.setPhone(phone);
        recharge.setAmount(createRechargeDto.getAmount());
        recharge.setCurrency(createRechargeDto.getCurrency());
        rechargeRepository.save(recharge);
        account.balance -= createRechargeDto.getAmount();
        accountRepository.save(account);
        return recharge;
    }

}
