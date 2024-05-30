package com.upc.demosec.controller;

import com.upc.demosec.model.Item;
import com.upc.demosec.model.User;
import com.upc.demosec.service.ItemService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@EnableMethodSecurity(prePostEnabled = true)
public class ItemController {
    @Autowired
    ItemService itemService;

    @GetMapping("/items")
    ResponseEntity<List<Item>> findAll() {
        return new ResponseEntity<List<Item>>(itemService.findAll(), HttpStatus.OK);
    }
    @PostMapping("/items")
    ResponseEntity<Item> save(HttpSession session, @RequestBody Item item) throws  Exception {
        User userSession = (User) session.getAttribute("warehouseSession");

        if (userSession == null)
            return new ResponseEntity<Item> (HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);

        if (!item.getWarehouse().equals(userSession.getWarehouse()))
            return new ResponseEntity<Item> (HttpStatus.BAD_REQUEST);

        if (!userSession.getAuthorities().get(0).getName().toString().equals("ADMIN"))
            return new ResponseEntity<Item> (HttpStatus.BAD_REQUEST);

        return new ResponseEntity<Item>(itemService.save(item), HttpStatus.CREATED);
    }
    @Transactional
    @PutMapping("/items/{id}")
    @Secured("ADMIN")
    public ResponseEntity<Item> update(HttpSession session, @RequestBody Item item, @PathVariable Long id) throws  Exception{
        User userSession = (User) session.getAttribute("warehouseSession");

        if (userSession == null)
            return new ResponseEntity<Item> (HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);

         if (!item.getWarehouse().equals(userSession.getWarehouse()))
            return new ResponseEntity<Item> (HttpStatus.BAD_REQUEST);

        if (!userSession.getAuthorities().get(0).getName().toString().equals("ADMIN"))
            return new ResponseEntity<Item> (HttpStatus.BAD_REQUEST);

        return new ResponseEntity<Item>(itemService.update(item, id), HttpStatus.OK);
    }
    @GetMapping("/items/warehouse")
    ResponseEntity<List<Item>> findByWarehouse(HttpSession session) {
        User userSession = (User) session.getAttribute("warehouseSession");

        if (userSession == null)
            return new ResponseEntity<List<Item>> (HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);

        return new ResponseEntity<List<Item>>(
                itemService.findByWarehouseOrderByDescriptionDesc(userSession.getWarehouse()), HttpStatus.OK);
    }


}
