package com.linux.java.se.nine.additions;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import static java.lang.System.currentTimeMillis;


/**
 * CompletableFutureAdditions
 */
public class CompletableFutureAdditions {
	public static void main(String[] args) {
		CompletableFutureAdditions additions = new CompletableFutureAdditions();
		
		System.out.println("Before First CompletableFuture " + currentTimeMillis());
		CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> additions.sleep(2));
		System.out.printf("Original Completable Future is done ? %b%n%n", cf.isDone());
		
		System.out.println("Before a copy of Completable Future " + currentTimeMillis());
		CompletableFuture<String> newCopy = cf.copy();
		System.out.printf("Copy of Completable Future is done ? %b%n%n", cf.isDone());
		newCopy.completeExceptionally(new InterruptedException("newCopy :: Some message"));

		System.out.println("Before Copying and completing on timeout " + currentTimeMillis());
		CompletableFuture<String> completeOnTimeOut = cf.copy().completeOnTimeout("completeOnTimeOut :: Failed to complete", 1, TimeUnit.SECONDS);
		System.out.printf("Completable Future Complete on Timeout is done ? %b%n%n", cf.isDone());

		cf.thenAccept(s -> System.out.printf("Result after Original Future Completion : %s%n%n", s));

		newCopy.thenAccept(s -> System.out.printf("Result after Copied Future Completion : %s%n%n", s));

		completeOnTimeOut.thenAccept(s -> System.out.printf("Result after Copied and Timed out Future Completion : %s%n%n", s));

		System.out.println("Before Final Sleep " + currentTimeMillis());
		additions.sleep(5);

	}


	private String sleep(int sleepTimeSeconds) {
		try {
			Thread.sleep(TimeUnit.SECONDS.toMillis(sleepTimeSeconds));
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		return "Done : " + currentTimeMillis() + " By " + Thread.currentThread().getName();
	}
	
}