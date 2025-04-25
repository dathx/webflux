package com.webflux.service;

import com.webflux.entity.Account;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AccountService {
    Mono<Account> findAccountById(String accountId);
    Flux<Account> findAllAccounts();
}
