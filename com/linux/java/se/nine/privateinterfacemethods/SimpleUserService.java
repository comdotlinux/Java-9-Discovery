package com.linux.java.se.nine.privateinterfacemethods;

interface UserService{

	default String getUser() {
		return getUserFromEnv();
	}
	
	static String getSystemUser(){
		return getUserFromEnv();
	}
	
	private static String getUserFromEnv() {
		return System.getenv("USER");
	}

}

public class SimpleUserService implements UserService{

	@Override
	public String getUser() {
		return "john";
	}

	public static void main(String[] args) {
		UserService s = new SimpleUserService();
		System.out.println("Current User :: " + s.getUser());
		System.out.println("Current System User :: " + UserService.getSystemUser());
	}

}