package com.webflux.service.impl;

import com.webflux.entity.Account;
import com.webflux.repository.AccountRepository;
import com.webflux.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public Mono<Account> findAccountById(String accountId) {
        return accountRepository.findById(accountId);
    }

    @Override
    public Flux<Account> findAllAccounts() {
        return accountRepository.findAll();
    }
}
