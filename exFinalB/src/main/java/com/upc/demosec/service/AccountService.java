package com.upc.demosec.service;

import com.upc.demosec.model.Account;
import com.upc.demosec.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    public List<Account> listAll() {return accountRepository.findAll(); }

    public List<Account> listAllByType (String type) {return accountRepository.search(type);}

    public Account update(Account account, Long id) {
        Account accountActual = accountRepository.findById(id)
                .orElse(null);

        if (accountActual == null) { return accountActual; }

        if (accountActual.equals(account)) { return accountActual; }

        accountActual.setId(id);
        accountActual.setDescription(account.getDescription());
        accountActual.setType(account.getType());
        accountActual.setAmount(account.getAmount());

        return accountRepository.save(accountActual);
    }

    public Account insert(Account account) {return accountRepository.save(account); }
}
