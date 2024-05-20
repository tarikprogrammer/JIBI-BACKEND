package com.team.backendjibi.CMI.mapper;

import com.team.backendjibi.CMI.dto.AccountDto;
import com.team.backendjibi.CMI.entity.Account;
import org.springframework.beans.BeanUtils;

public class AccountMapper {

    public static AccountDto mapAccountToAccountDto(Account account){
        AccountDto accountDto = new AccountDto();
        BeanUtils.copyProperties(account,accountDto);
        return accountDto;
    }
}
