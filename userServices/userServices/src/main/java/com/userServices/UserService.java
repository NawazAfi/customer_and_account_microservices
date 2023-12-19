package com.userServices;


//public interface UserService {
//	
//	
//    User saveUser(User user);
//
//    ResponseDto getUser(Long userId);
//}
// 

//
//import java.util.List;
//
//public interface UserService {
//    
//    User saveUser(User user);
//
//    ResponseDto getUser(Long userId);
//
//    List<User> getAllUsers();
//
//    User updateUserById(Long userId, User user);
//
//    void deleteCustomerById(Long userId);
//}




 

//New method to get all accounts
import java.util.List;

public interface UserService {

    User saveUser(User user);

    ResponseDto getUser(Long userId);

    List<User> getAllUsers();

    User updateUserById(Long userId, User user);

    void deleteCustomerById(Long userId);

    List<AccountDto> getAllAccounts();  // New method to get all accounts
}


//
////New method to get all users with accounts
//
//import java.util.List;
//
//public interface UserService {
//
//    User saveUser(User user);
//
//    ResponseDto getUser(Long userId);
//
//    List<User> getAllUsers();
//
//    User updateUserById(Long userId, User user);
//
//    void deleteCustomerById(Long userId);
//
//    List<AccountDto> getAllAccounts();
//
//    List<User> getAllUsersWithAccounts();  
//}

