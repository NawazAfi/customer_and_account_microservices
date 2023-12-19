package com.userServices;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class ResponseDto {
    private AccountDto account;
    private UserDto user;
    
	public AccountDto getAccount() {
		return account;
	}

	public void setAccount(AccountDto account) {
		this.account = account;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	public ResponseDto(AccountDto account, UserDto user) {
		super();
		this.account = account;
		this.user = user;
	}

	public ResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
