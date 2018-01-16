package com.neilist.mrs.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neilist.mrs.domain.User;
import com.neilist.mrs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

//    private static final String HEADER_TOKEN = "X-Auth-Token";
//    @Value("${service.user.url}")
//    private String userServiceUrl;
//    @Value("${service.user.token}")
//    private String userServiceToken;
//    @Autowired
//    private RestTemplate restTemplate;
//    @Autowired
//    private ObjectMapper objectMapper;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(userName);
        //TODO
        List<GrantedAuthority> authorities = getUserAuthority();
        return buildUserForAuthentication(user, authorities);
    }

    public User save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(true);
        userRepository.save(user);
        return user;
    }

//    private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles) {
    private List<GrantedAuthority> getUserAuthority() {
        Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
//        for (Role role : userRoles) {
//            roles.add(new SimpleGrantedAuthority(role.getRole()));
//        }
        roles.add(new SimpleGrantedAuthority("USER"));
        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>(roles);
        return grantedAuthorities;
    }

    private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), user.isActive(), true, true, true, authorities);
    }

//    public Optional<UserCommand> saveToUserService(UserCommand user) {
//        try {
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.APPLICATION_JSON);
//            headers.set(HEADER_TOKEN, userServiceToken);
//            HttpEntity<String> entity = new HttpEntity<String>(objectMapper.writeValueAsString(user), headers);
//            ResponseEntity<UserCommand> response = restTemplate.postForEntity(userServiceUrl + "/user", entity, UserCommand.class);
//            if (response.getStatusCode().equals(HttpStatus.CREATED)) {
//                return Optional.of(response.getBody());
//            } else {
//                System.out.println("Failed to save user " + user.getUsername() + " to user service, response: " + response.getStatusCode().toString());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return Optional.empty();
//    }

}
