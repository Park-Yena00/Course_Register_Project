package Control;

import java.util.Vector;

import Model.MIndex;
import Valueobject.VIndex;
//coderabbit review
public class CIndex {
	private MIndex mIndex;
	
	public CIndex() {
		this.mIndex = new MIndex();
	}
	
	public Vector<VIndex> getIndexVector(String parentFileName) {
		Vector<VIndex> vIndexVector = mIndex.FindIndexFileName(parentFileName);
		return vIndexVector;
	}
}
