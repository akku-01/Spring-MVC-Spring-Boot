package com.cntmgr.contactmanager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.cntmgr.contactmanager.dao.UserRepo;
import com.cntmgr.contactmanager.entities.User;

public class UserDetailServiceImplementation implements UserDetailsService{
    @Autowired
    private UserRepo userRepo ;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Fetching user from database;
        User user = userRepo.getUserByUserName(username);
        if(user==null){
            throw new UsernameNotFoundException("There is no user with this user name ...");
        }

        CustomUserDetails customUserDetails = new CustomUserDetails(user);
        return customUserDetails;
        
    }
    
}
