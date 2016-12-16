package com.mkdika.booris.ui.web.config;

import com.mkdika.booris.entity.TbUser;
import com.mkdika.booris.helper.Crypto;
import com.mkdika.booris.service.ServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 *
 * @author maikel
 */
@Component
public class CustomAuthProvider implements AuthenticationProvider {

    @Autowired
    private ServiceDao serviceDao;

    @Autowired
    private UserDetailService userDetailService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String uid = authentication.getName();
        String password = authentication.getCredentials().toString();

        TbUser t = serviceDao.getTbUserActiveByUid(uid);
               
        if (t == null) {
            throw new BadCredentialsException("Username not found/not actived.");
        } else {
            if (t.getPassword().equals(Crypto.Md5(password, uid))) {
                UserDetails user = userDetailService.loadUserByUsername(uid);                
                return new UsernamePasswordAuthenticationToken(user, password, user.getAuthorities());
            } else {                
                throw new BadCredentialsException("Invalid password.");
            }
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
