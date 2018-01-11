package com.linux.java.se.nine.additions;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import static java.lang.System.currentTimeMillis;


/**
 * CompletableFutureAdditions
 */
public class CompletableFutureAdditions {
	public static void main(String[] args) {
		CompletableFutureAdditions cfAdditions = new CompletableFutureAdditions();
		
		System.out.println("Before First CompletableFuture " + currentTimeMillis());
		CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> cfAdditions.sleep(2));
		System.out.printf("Original Completable Future is done ? %b%n%n", cf.isDone());
		
		System.out.println("Before creating a copy of Completable Future " + currentTimeMillis());
		CompletableFuture<String> newCopy = cf.copy();
		System.out.printf("Copy of Completable Future is done ? %b%n%n", newCopy.isDone());


		System.out.println("Before a copy of Completable Future for completing exceptionally " + currentTimeMillis());
		CompletableFuture<String> newCopyForCompleteExceptionally = cf.copy();
		System.out.printf("Copy of Completable Future for completing exceptionally is done ? %b%n%n", newCopyForCompleteExceptionally.isDone());
		newCopyForCompleteExceptionally.completeExceptionally(new InterruptedException("newCopyForCompleteExceptionally :: Some message"));

		System.out.println("Before Copying and completing on timeout " + currentTimeMillis());
		CompletableFuture<String> completeOnTimeOut = cf.copy().completeOnTimeout("completeOnTimeOut :: Failed to complete", 1, TimeUnit.SECONDS);
		System.out.printf("Completable future complete on timeout is done ? %b%n%n", completeOnTimeOut.isDone());

		cf.thenAccept(s -> System.out.printf("%nResult after Original future completion : %s%n%n", s));
		
		newCopy.thenAccept(s -> System.out.printf("%nResult after Original future completion : %s%n%n", s));

		newCopyForCompleteExceptionally.thenAccept(s -> System.out.printf("%nResult after Copied future Completion : %s%n%n", s));

		completeOnTimeOut.thenAccept(s -> System.out.printf("%nResult after Copied and timed out future Completion : %s%n%n", s));

		System.out.println("Before Final Sleep -- this is needed otherwise  we will see no output. " + currentTimeMillis());
		cfAdditions.sleep(5);

	}


	private String sleep(int sleepTimeSeconds) {
		System.out.println(Thread.currentThread().getId() + " is sleeping ... for " + sleepTimeSeconds);
		try {
			Thread.sleep(TimeUnit.SECONDS.toMillis(sleepTimeSeconds));
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		System.out.println("Waking up! ... after " + sleepTimeSeconds);
		return "Done : " + currentTimeMillis() + " By " + Thread.currentThread().getName();
	}
	
}