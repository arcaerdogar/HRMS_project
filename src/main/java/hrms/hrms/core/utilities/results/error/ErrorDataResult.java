package hrms.hrms.core.utilities.results.error;

import hrms.hrms.core.utilities.results.DataResult;

public class ErrorDataResult<T> extends DataResult<T> {

	public ErrorDataResult(T data, String message) {
		super(data, false, message);
	}
	public ErrorDataResult(T data) {
		super(data,false);
	}
}
