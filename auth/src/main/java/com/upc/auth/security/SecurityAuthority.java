package com.upc.auth.security;

import com.upc.auth.model.Authority;
import org.springframework.security.core.GrantedAuthority;

public class SecurityAuthority implements GrantedAuthority {

    final Authority authority;

    public SecurityAuthority(Authority authority) {
        this.authority = authority;
    }


    @Override
    public String getAuthority() {
        return authority.getName().toString();
    }
}
