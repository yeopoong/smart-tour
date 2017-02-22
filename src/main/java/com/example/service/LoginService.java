package com.example.service;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.dao.AuthorityDao;
import com.example.dao.LoginDao;
import com.example.vo.LoginUserVo;

@Service
public class LoginService implements UserDetailsService {

    @Resource
    private AuthorityDao authorityDao;

    @Resource
    private LoginDao loginDao;
    
    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        
        LoginUserVo loginUser = loginDao.getUser(userId); 

        if (loginUser != null) {
            Set<GrantedAuthority> authority = authorityDao.getAuthority(userId);
            return new User(loginUser.getUserId(), loginUser.getPassword(), authority);
        }

        throw new UsernameNotFoundException("User '" + userId + "' not found.");
    }
}
