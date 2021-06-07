package hrms.hrms.core.utilities.results.success;

import hrms.hrms.core.utilities.results.Result;

public class SuccessResult extends Result{

	public SuccessResult() {
		super(true);
	}
	public SuccessResult(String message) {
		super(true,message);
	}

}
