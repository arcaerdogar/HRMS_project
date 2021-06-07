package hrms.hrms.core.utilities.results;

public class Result {
	public Result(boolean success) {
		this.success = success;
	}
	public Result(boolean success,String message) {
		this.success=success;
		this.message=message;
	}
	private boolean success;
	private String message;
	
	public boolean isSuccess() {
		return success;
	}
	public String getMessage() {
		return message;
	}
}
