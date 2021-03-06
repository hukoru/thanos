package com.thanos.api.repository;

import com.thanos.api.domain.Account;
import com.thanos.api.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Frank, Lim on 2018. 11. 11.
 * 공통 아이템 레파지토리
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {



}
