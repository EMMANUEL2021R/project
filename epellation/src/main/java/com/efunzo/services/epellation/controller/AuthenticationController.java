package com.efunzo.services.epellation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.efunzo.services.epellation.model.request.LoginRequest;
import com.efunzo.services.epellation.model.response.LoginResponse;
import com.efunzo.services.epellation.security.jwt.JwtTokenUtil;
import com.efunzo.services.epellation.security.jwt.JwtUserDetailsService;
import com.efunzo.services.epellation.service.EpellationUserService;

@Controller
public class AuthenticationController {
	
	@Autowired
	private EpellationUserService epellationUserService;
	
	  @Autowired
	  private AuthenticationManager authenticationManager;

	  @Autowired
	  private JwtTokenUtil jwtTokenUtil;

	  @Autowired
	  private JwtUserDetailsService userDetailsService;
	
	
	@PostMapping("/api/epellation/secure/login")
	public ResponseEntity<LoginResponse> authenticateUser(@RequestBody LoginRequest loginRequest) throws Exception {
		
		authenticate(loginRequest.getUserName(), loginRequest.getPassword());

	    final UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getUserName());

	    final String token = jwtTokenUtil.generateToken(userDetails);

		LoginResponse user = epellationUserService.findByUserName(loginRequest);
		
		user.setJwtToken(token);
		
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	
	
	 private void authenticate(String username, String password) throws Exception {
		    try {
		      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		    } catch (DisabledException e) {
		      throw new Exception("USER_DISABLED", e);
		    } catch (BadCredentialsException e) {
		      throw new Exception("INVALID_CREDENTIALS", e);
		    }
		  }

}
