package com.upc.alumnoapi.security;

import com.upc.alumnoapi.model.entity.Authority;
import com.upc.alumnoapi.util.AuthorityName;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
public class SecurityAuthority implements GrantedAuthority {

    private final Authority authority;
    @Override
    public String getAuthority() {
        return authority.getName().toString();
    }
}
