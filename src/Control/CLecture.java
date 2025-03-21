package Control;

import java.util.Vector;

import Model.MLecture;
import Valueobject.VLecture;
//coderabbit review
public class CLecture { 
	private MLecture mLecture;
	
	public CLecture() {
		this.mLecture = new MLecture();
	}
	
	public Vector<VLecture> getLectureVector(String fileName) {
		 Vector<VLecture> vLectureVector = mLecture.getLectureVector(fileName);
		return vLectureVector;
	}
}
