package hrms.hrms.services.mernis;

import org.springframework.stereotype.Component;

@Component
public class FakeMernisService {
	public static boolean validate(String tckn) {
		return tckn.length()==11 ?true:false;
	}
}
