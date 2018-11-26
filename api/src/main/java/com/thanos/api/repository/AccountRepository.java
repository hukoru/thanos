package com.thanos.api.repository;

import com.thanos.api.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Frank, Lim on 2018. 11. 11.
 * 계정 레파지토리
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {


}
