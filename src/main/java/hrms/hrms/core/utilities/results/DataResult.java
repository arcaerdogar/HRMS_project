package hrms.hrms.core.utilities.results;

public class DataResult<T> extends Result{

	public DataResult(T data,boolean success, String message) {
		super(success, message);
		this.data=data;
	}
	public DataResult(T data,boolean success) {
		super(success);
		this.data=data;
	}
	private T data;
	
	public T getData() {
		return this.data;
	}
}
