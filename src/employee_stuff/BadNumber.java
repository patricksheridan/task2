package employee_stuff;

public class BadNumber extends Exception {

	public BadNumber() {
	}

	public BadNumber(String message) {
		super(message);
	}

	public BadNumber(Throwable cause) {
		super(cause);
	}

	public BadNumber(String message, Throwable cause) {
		super(message, cause);
	}

	public BadNumber(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
