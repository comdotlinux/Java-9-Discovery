package com.linux.java.se.nine.trywithresources;

import java.util.concurrent.TimeUnit;

class SimpleResource implements AutoCloseable{
	private final String name;

	SimpleResource(String name) {
		this.name = name;
	}

	public String doWork(String context) {
		try{
			TimeUnit.SECONDS.sleep(2);
		} catch(InterruptedException ie) {
			throw new RuntimeException(ie);
		}
		return "Work Done for " + context;
	}

	@Override
	public void close() {
		System.out.println("Resource " + name + " closed");
	}
}

/**
 * TryWithResources
 */
public class TryWithResources {
	public static void main(String[] args) {
		System.out.println("-- Before :: ");
		try(SimpleResource res = new SimpleResource("insideTryWithResource")){
			String workResponse = res.doWork("old style try with resources");
			System.out.println(workResponse);
		}


		System.out.println("-- After :: ");
		SimpleResource resource = new SimpleResource("OutsideTryWithResource");
		try(resource) {
			String workResponse = resource.doWork("yay! java 9");
			System.out.println(workResponse);
		}

	}
}