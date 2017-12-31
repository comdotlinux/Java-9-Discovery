import java.util.concurrent.TimeUnit;

/**
 * TryWithResources
 */
class SimpleResouce implements AutoCloseable{
	private final String name;

	public SimpleResouce(String name) {
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

public class TryWithResources {
	public static void main(String[] args) {
		// Before
		try(SimpleResouce res = new SimpleResouce("insideTryWithResource")){
			String workResponse = res.doWork("old style try with resources");
			System.out.println(workResponse);
		}
		
		
		// Java 9
		SimpleResouce resource = new SimpleResouce("OutsideTryWithResource");
		try(resource) {
			String workResponse = resource.doWork("yay! java 9");
			System.out.println(workResponse);
		}

	}
}