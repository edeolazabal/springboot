package com.upc.demosec.controller;

import com.upc.demosec.model.Account;
import com.upc.demosec.model.User;
import com.upc.demosec.service.AccountService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/accounts")
    ResponseEntity<List<Account>> list() {
        return new ResponseEntity<List<Account>>(accountService.listAll(), HttpStatus.OK);
    }

    @GetMapping("/accounts/type")
    ResponseEntity<List<Account>> listByType(HttpSession session) {
        User userSession = (User) session.getAttribute("typeSession");

        if (userSession == null)
            return new ResponseEntity<List<Account>>(HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);

        return new ResponseEntity<List<Account>>(accountService.listAllByType(userSession.getType()), HttpStatus.OK);
    }

    @PostMapping("/accounts")
    ResponseEntity<Account> insert(HttpSession session, @RequestBody Account account) {
        User userSession = (User) session.getAttribute("typeSession");

        if (userSession == null)
            return new ResponseEntity<Account>(HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);

        if (!account.getType().equals(userSession.getType()))
            return new ResponseEntity<Account>(HttpStatus.BAD_REQUEST);

        if (!userSession.getAuthorities().get(0).getName().toString().equals( "ADMIN"))
            return new ResponseEntity<Account>(HttpStatus.BAD_REQUEST);

        return new ResponseEntity<Account>(accountService.insert(account), HttpStatus.CREATED);
    }

    @PutMapping("/accounts/{id}")
    ResponseEntity<Account> update(HttpSession session, @RequestBody Account account, @PathVariable Long id) {
        User userSession = (User) session.getAttribute("typeSession");

        if (userSession == null)
            return new ResponseEntity<Account>(HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);

        if (!account.getType().equals(userSession.getType()))
            return new ResponseEntity<Account>(HttpStatus.BAD_REQUEST);

        if (!userSession.getAuthorities().get(0).getName().toString().equals( "ADMIN"))
            return new ResponseEntity<Account>(HttpStatus.BAD_REQUEST);

            return new ResponseEntity<Account>(accountService.update(account, id), HttpStatus.OK);
        }

    }
