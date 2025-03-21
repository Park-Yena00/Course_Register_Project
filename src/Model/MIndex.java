package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import Valueobject.VIndex;
//coderabbit review
public class MIndex {

	public Vector<VIndex> FindIndexFileName(String parentFileName) {
		Vector<VIndex> vIndexVector = null;
		try {
			//index file
			vIndexVector = new Vector<VIndex>();
			File file = new File("data/"+ parentFileName +".txt");
			Scanner parentFile = new Scanner(file);
			while(parentFile.hasNext()) {
				VIndex vIndex = new VIndex();
				vIndex.load(parentFile);
				vIndexVector.add(vIndex);
			}
			parentFile.close();
	
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
		return vIndexVector;
	} 

}
