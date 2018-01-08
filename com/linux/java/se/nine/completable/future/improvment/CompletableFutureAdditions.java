package com.linux.java.se.nine.completable.future.improvment;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * CompletableFutureAdditions
 */
public class CompletableFutureAdditions {
	public static void main(String[] args) {
		CompletableFutureAdditions additions = new CompletableFutureAdditions();
		CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> additions.sleep(2));
		System.out.println(" Original Completable Future is done ?" + cf.isDone());

		CompletableFuture<String> newCopy = cf.copy();
		System.out.println(" Copy of Completable Future is done ?" + cf.isDone());
		newCopy.completeExceptionally(new InterruptedException("Some message"));

		CompletableFuture<String> completeOnTimeOut = cf.copy().completeOnTimeout("Failed to complete", 1, TimeUnit.SECONDS);
		System.out.println("Completable Future Complete on Timeout is done ?" + cf.isDone());

		cf.thenAccept(System.out::println);
		newCopy.thenAccept(System.out::println);
		completeOnTimeOut.thenAccept(System.out::println);


		additions.sleep(5);

	}


	private String sleep(int sleepTimeSeconds) {
		try {
			Thread.sleep(TimeUnit.SECONDS.toMillis(sleepTimeSeconds));
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		return "Done : " + System.currentTimeMillis() + " By " + Thread.currentThread().getName();
	}
	
}