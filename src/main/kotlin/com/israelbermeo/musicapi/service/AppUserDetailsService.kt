package com.israelbermeo.musicapi.service

import org.springframework.stereotype.Service
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import java.util.ArrayList

@Service
class AppUserDetailsService : UserDetailsService{
    override fun loadUserByUsername(username: String?): UserDetails {
        return User("user","{noop}admin", ArrayList())
    }
}