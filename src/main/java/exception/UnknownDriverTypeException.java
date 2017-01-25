package exception;

public class UnknownDriverTypeException extends RuntimeException {

	private static final long serialVersionUID = 5329668084611431031L;

	public UnknownDriverTypeException(String msg) {
		super(msg);
	}
}
