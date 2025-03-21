package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import Valueobject.VLecture;
//coderabbit review
public class MLecture {
	
	public Vector<VLecture> getLectureVector(String fileName) {
		Vector<VLecture> vLectureVector = null;
		try {
			//lecture file
			vLectureVector = new Vector<VLecture>();
			File file = new File("data/"+ fileName +".txt");
			Scanner parentFile = new Scanner(file);
			while(parentFile.hasNext()) {
				VLecture vLecture = new VLecture();
				vLecture.load(parentFile);
				vLectureVector.add(vLecture);
			}
			parentFile.close();
	
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
		return vLectureVector;
	}
}
