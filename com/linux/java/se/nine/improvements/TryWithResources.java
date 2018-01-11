package com.linux.java.se.nine.improvements;

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
		return "from doWork : Work Done -- " + context;
	}

	@Override
	public void close() {
		System.out.printf("from close : Resource %s closed%n", name);
	}
}

/**
 * TryWithResources
 */
public class TryWithResources {
	public static void main(String[] args) {
		System.out.printf("%n-- Before :: %n%n");
		try(SimpleResource res = new SimpleResource("Inside Try With Resources")){
			String workResponse = res.doWork("old style");
			System.out.println(workResponse);
		}


		System.out.printf("%n-- After :: %n%n");
		SimpleResource resource = new SimpleResource("Outside Try With Resources");
		try(resource) {
			String workResponse = resource.doWork("Java 9 Style");
			System.out.println(workResponse);
		}

	}
}