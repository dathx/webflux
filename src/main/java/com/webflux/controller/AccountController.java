package com.webflux.controller;

import com.webflux.dto.AccountResponse;
import com.webflux.entity.Account;
import com.webflux.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;
    private final ModelMapper mapper;

    @GetMapping(value = "/account/{accountId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<AccountResponse> getAccount(@PathVariable("accountId") String accountId) {
        return accountService.findAccountById(accountId)
                .map(this::getAccountResponse).onErrorResume(ex -> Mono.empty());
    }

    @GetMapping(value = "/account/all")
    public Flux<AccountResponse> fetchAllAccount() {
        return accountService.findAllAccounts()
                .map(this::getAccountResponse).onErrorResume(ex -> {
                    return Flux.empty();
                });
    }

    private AccountResponse getAccountResponse(Account account) {
        AccountResponse response = mapper.map(account, AccountResponse.class);
        response.setStatus(account.getAge() > 25 ? "Adult" : "Minor");
        return response;
    }
}
