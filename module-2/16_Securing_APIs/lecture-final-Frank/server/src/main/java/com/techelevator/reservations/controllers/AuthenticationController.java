package com.techelevator.reservations.controllers;

import com.techelevator.reservations.model.LoginDto;
import com.techelevator.reservations.security.jwt.JWTFilter;
import com.techelevator.reservations.security.jwt.TokenProvider;
import com.techelevator.reservations.model.TokenDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Controller to authenticate users.
 */
@RestController
public class AuthenticationController {

    private final TokenProvider tokenProvider;

    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    public AuthenticationController(TokenProvider tokenProvider, AuthenticationManagerBuilder authenticationManagerBuilder) {
        this.tokenProvider = tokenProvider;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
    }

    // Handle a POST for the /login path with JSON for the LoginDto POJO
    // LoginDto POJO has 3 instance variables: username, password, rememberme
    //          JSON with the request must have attributes with the same name
    //
    // returns a ResponseEntity<TokenDto>
    //
    // a ResponseEntity is a generic HTTP response
    // its used when you don't want to just return a POJO or you have no POJO to return

    @PostMapping("/login")  // Same as @RequestMapping(path="/login", method=RequestMethod.POST)
    public ResponseEntity<TokenDto> authorize(@Valid @RequestBody LoginDto loginDto) {

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword());

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        boolean rememberMe = (loginDto.isRememberMe() == null) ? false : loginDto.isRememberMe();
        String jwt = tokenProvider.createToken(authentication, rememberMe);

        HttpHeaders httpHeaders = new HttpHeaders();
        // AUTHORIZATION_HEADER, "Bearer " indicate the place response where JWT token goes
        //   The AUTHORIZATION_HEADER "bears" the JWT for the request/response
        httpHeaders.add(JWTFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);
        return new ResponseEntity<>(new TokenDto(jwt), httpHeaders, HttpStatus.OK);
    }

}

