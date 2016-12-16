package com.mkdika.booris.ui.web.config;

import com.mkdika.booris.entity.TbUser;
import com.mkdika.booris.entity.dto.UserDetail;
import com.mkdika.booris.service.ServiceDao;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 *
 * @author maikel
 */
@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private ServiceDao serviceDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();

        HttpServletRequest request = attr.getRequest();

        UserDetails user = null;
        try {
            TbUser tbuser = serviceDao.getTbUserActiveByUid(username);
            List<SimpleGrantedAuthority> authList = new ArrayList<>();

            if (tbuser != null) {                
                authList.add(new SimpleGrantedAuthority("ROLE_DEFAULT"));
                
                if (tbuser.getAccessMenu01()) {
                    authList.add(new SimpleGrantedAuthority("ROLE_MENU01"));
                }
                
                if (tbuser.getAccessMenu02()) {
                    authList.add(new SimpleGrantedAuthority("ROLE_MENU02"));
                }
                
                if (tbuser.getAccessMenu03()) {
                    authList.add(new SimpleGrantedAuthority("ROLE_MENU03"));
                }
                
                if (tbuser.getAccessMenu04()) {
                    authList.add(new SimpleGrantedAuthority("ROLE_MENU04"));
                }
                
                if (tbuser.getAccessMenu05()) {
                    authList.add(new SimpleGrantedAuthority("ROLE_MENU05"));
                }                
            }
                      
            String remoteAddress = (request.getHeader("X-Real-IP") != null) ? request.getHeader("X-Real-IP") : request.getRemoteAddr();
            user = new UserDetail(remoteAddress, tbuser.getUid(), "", true, true, true, true, authList);
        } catch (UsernameNotFoundException e) {
            throw new UsernameNotFoundException("Invalid Credentials");
        }
        return user;
    }
}
