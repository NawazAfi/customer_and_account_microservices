package com.userServices;

//
//import lombok.AllArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//@Service
//public class UserServiceImpl implements UserService {
//
//    private UserRepository userRepository;
//    private RestTemplate restTemplate;
//    
//
//    public UserServiceImpl(UserRepository userRepository, RestTemplate restTemplate) {
//		super();
//		this.userRepository = userRepository;
//		this.restTemplate = restTemplate;
//	}
//
//	@Override
//    public User saveUser(User user) {
//        return userRepository.save(user);
//    }
//
//    @Override
//    public ResponseDto getUser(Long userId) {
//
//        ResponseDto responseDto = new ResponseDto();
//        User user = userRepository.findById(userId).get();
//        UserDto userDto = mapToUser(user);
//
//        ResponseEntity<AccountDto> responseEntity = restTemplate
//                .getForEntity("http://localhost:8081/api/accounts/" + user.getAcountId(),
//                		AccountDto.class);
//
//        AccountDto accountDto = responseEntity.getBody();
//
//        System.out.println(responseEntity.getStatusCode());
//
//        responseDto.setUser(userDto);
//        responseDto.setAccount(accountDto);
//
//        return responseDto;
//    }
//
//    private UserDto mapToUser(User user){
//        UserDto userDto = new UserDto();
//        userDto.setId(user.getId());
//        userDto.setFirstName(user.getFirstName());
//        userDto.setLastName(user.getLastName());
//        userDto.setEmail(user.getEmail());
//        return userDto;
//    }
//}




//New method to get all accounts
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.List;
//
//@Service
//public class UserServiceImpl implements UserService {
//
//    private UserRepository userRepository;
//    private RestTemplate restTemplate;
//
//    public UserServiceImpl(UserRepository userRepository, RestTemplate restTemplate) {
//        this.userRepository = userRepository;
//        this.restTemplate = restTemplate;
//    }
//
//    @Override
//    public User saveUser(User user) {
//        return userRepository.save(user);
//    }
//
//    @Override
//    public ResponseDto getUser(Long userId) {
//        ResponseDto responseDto = new ResponseDto();
//        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
//        UserDto userDto = mapToUser(user);
//
//        ResponseEntity<AccountDto> responseEntity = restTemplate
//                .getForEntity("http://localhost:8081/api/accounts/" + user.getAcountId(), AccountDto.class);
//
//        AccountDto accountDto = responseEntity.getBody();
//
//        responseDto.setUser(userDto);
//        responseDto.setAccount(accountDto);
//
//        return responseDto;
//    }
//
//    @Override
//    public List<User> getAllUsers() {
//        return userRepository.findAll();
//    }
//
//    @Override
//    public User updateUserById(Long userId, User user) {
//        User existingUser = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
//        existingUser.setFirstName(user.getFirstName());
//        existingUser.setLastName(user.getLastName());
//        existingUser.setEmail(user.getEmail());
//        existingUser.setAcountId(user.getAcountId()); // Assuming this field can be updated
//        return userRepository.save(existingUser);
//    }
//
//    @Override
//    public void deleteCustomerById(Long userId) {
//        userRepository.deleteById(userId);
//    }
//
//    private UserDto mapToUser(User user) {
//        UserDto userDto = new UserDto();
//        userDto.setId(user.getId());
//        userDto.setFirstName(user.getFirstName());
//        userDto.setLastName(user.getLastName());
//        userDto.setEmail(user.getEmail());
//        return userDto;
//    }
//}







//// New method to get all accounts


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RestTemplate restTemplate;

    public UserServiceImpl(UserRepository userRepository, RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public ResponseDto getUser(Long userId) {
        ResponseDto responseDto = new ResponseDto();
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        UserDto userDto = mapToUser(user);

        ResponseEntity<AccountDto> responseEntity = restTemplate
                .getForEntity("http://localhost:8081/api/accounts/" + user.getAcountId(), AccountDto.class);

        AccountDto accountDto = responseEntity.getBody();

        responseDto.setUser(userDto);
        responseDto.setAccount(accountDto);

        return responseDto;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUserById(Long userId, User user) {
        User existingUser = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        existingUser.setAcountId(user.getAcountId()); // Assuming this field can be updated
        return userRepository.save(existingUser);
    }

    @Override
    public void deleteCustomerById(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        // You may need to implement logic to retrieve all accounts from the account service
        // For simplicity, let's assume there's an API to get all accounts
        ResponseEntity<List> responseEntity = restTemplate
                .getForEntity("http://localhost:8081/api/accounts", List.class);

        return responseEntity.getBody();
    }

    private UserDto mapToUser(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        return userDto;
    }
}





////New method to get all users with accounts
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.List;
//
//@Service
//public class UserServiceImpl implements UserService {
//
//    private UserRepository userRepository;
//    private RestTemplate restTemplate;
//
//    public UserServiceImpl(UserRepository userRepository, RestTemplate restTemplate) {
//        this.userRepository = userRepository;
//        this.restTemplate = restTemplate;
//    }
//
//    @Override
//    public User saveUser(User user) {
//        return userRepository.save(user);
//    }
//
//    @Override
//    public ResponseDto getUser(Long userId) {
//        ResponseDto responseDto = new ResponseDto();
//        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
//        UserDto userDto = mapToUser(user);
//
//        ResponseEntity<AccountDto> responseEntity = restTemplate
//                .getForEntity("http://localhost:8081/api/accounts/" + user.getAcountId(), AccountDto.class);
//
//        AccountDto accountDto = responseEntity.getBody();
//
//        responseDto.setUser(userDto);
//        responseDto.setAccount(accountDto);
//
//        return responseDto;
//    }
//
//    @Override
//    public List<User> getAllUsers() {
//        return userRepository.findAll();
//    }
//
//    @Override
//    public User updateUserById(Long userId, User user) {
//        User existingUser = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
//        existingUser.setFirstName(user.getFirstName());
//        existingUser.setLastName(user.getLastName());
//        existingUser.setEmail(user.getEmail());
//        existingUser.setAcountId(user.getAcountId()); // Assuming this field can be updated
//        return userRepository.save(existingUser);
//    }
//
//    @Override
//    public void deleteCustomerById(Long userId) {
//        userRepository.deleteById(userId);
//    }
//
//    @Override
//    public List<AccountDto> getAllAccounts() {
//        // You may need to implement logic to retrieve all accounts from the account service
//        // For simplicity, let's assume there's an API to get all accounts
//        ResponseEntity<List> responseEntity = restTemplate
//                .getForEntity("http://localhost:8081/api/accounts", List.class);
//
//        return responseEntity.getBody();
//    }
//
//    @Override
//    public List<User> getAllUsersWithAccounts() {
//        List<User> allUsers = userRepository.findAll();
//        for (User user : allUsers) {
//            ResponseEntity<AccountDto> responseEntity = restTemplate
//                    .getForEntity("http://localhost:8081/api/accounts/" + user.getAcountId(), AccountDto.class);
//
//            AccountDto accountDto = responseEntity.getBody();
//            user.setAccount(accountDto);
//        }
//        return allUsers;
//    }
//
//    private UserDto mapToUser(User user) {
//        UserDto userDto = new UserDto();
//        userDto.setId(user.getId());
//        userDto.setFirstName(user.getFirstName());
//        userDto.setLastName(user.getLastName());
//        userDto.setEmail(user.getEmail());
//        return userDto;
//    }
//}


