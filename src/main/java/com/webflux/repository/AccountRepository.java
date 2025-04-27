package com.webflux.repository;

import com.webflux.entity.Account;
import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface AccountRepository extends ReactiveCrudRepository<Account, String> {
    Mono<Account> findAccountByAccountId(String accountId);
    Mono<Void> deleteByAccountId(String accountId);
}
