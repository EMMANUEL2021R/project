package com.efunzo.services.epellation.security.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.efunzo.services.epellation.domaine.EpellationUser;
import com.efunzo.services.epellation.repository.EpellationUserRepository;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private EpellationUserRepository epellationUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	
    	Optional<EpellationUser> epellationUserOptional = epellationUserRepository.findEpellationUserByUserName(username);
    	
        if (epellationUserOptional.isPresent()) {
        	
        	EpellationUser epellationUser = epellationUserOptional.get();
        	
            return new User(epellationUser.getUserName(), epellationUser.getPassword(), new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
