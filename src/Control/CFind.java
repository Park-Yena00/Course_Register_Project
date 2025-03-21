package Control;

import Model.MFind;
import Valueobject.VFindUserInfo;
import Valueobject.VLogin;
//coderabbit review
public class CFind {
    public VFindUserInfo FindUserInfo(VLogin vlogin) {
        MFind mFind = new MFind();
        VFindUserInfo vFindUserInfo = mFind.InfoInput(vlogin);
        return vFindUserInfo;
    }
}
