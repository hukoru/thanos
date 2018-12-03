package com.thanos.api.service;

import com.thanos.api.common.constant.ErrorInfoEnum;
import com.thanos.api.domain.Account;
import com.thanos.api.result.AccountResponse;
import com.thanos.api.exceptions.GlobalErrorInfoException;
import com.thanos.api.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.ZoneId;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class AccountService {

    private static final Logger LOG = LoggerFactory.getLogger(AccountService.class);

    private static final ZoneId zoneId = ZoneId.systemDefault();

    @Autowired
    private AccountRepository accountRepository;

    public Account saveBy(Account account) {
        return accountRepository.save(account);
    }

    private Optional<Account> findBy(long id) {
        return accountRepository.findById(id);
    }

    public AccountResponse.Response accountResponse(Long memberId) throws GlobalErrorInfoException {
        return new AccountResponse.Response(this.findBy(memberId).orElseThrow(() ->
            new GlobalErrorInfoException(ErrorInfoEnum.ERR0001)));
    }

}
