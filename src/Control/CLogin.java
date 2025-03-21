package Control;

import Model.MAccount;
import Valueobject.VLogin;
import Valueobject.VUserInfo;
//coderabbit review
public class CLogin {
	public VUserInfo login(VLogin vlogin) {
		MAccount mAccount = new MAccount();
		VUserInfo vUserInfo = mAccount.login(vlogin);
		return vUserInfo;	
	}
}

	
