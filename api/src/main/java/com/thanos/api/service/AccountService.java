package com.thanos.api.service;

import com.thanos.api.domain.Account;
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

    public Optional<Account> findBy(long id) {
        Optional<Account> account = accountRepository.findById(id);
        if (account == null)
            System.out.println("계정이 없습니다.");

        return account;
    }
}
