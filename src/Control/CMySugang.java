package Control;

import Model.MMySugang;
import Valueobject.VLecture;

public class CMySugang {
    private MMySugang mMySugang;
    private VLecture vSugangVector;
    //coderabbit review
    public CMySugang() {
        this.mMySugang = new MMySugang();
    }
    
    public void add(VLecture vLecture) {
        mMySugang.add(vLecture);
    }

    public void Show() {
    	mMySugang.SugangRead(vSugangVector);
    }
		   
    public void remove() {
        mMySugang.Sugangremove(vSugangVector);
    }
}






