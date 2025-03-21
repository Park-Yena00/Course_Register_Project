package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import Valueobject.VLecture;

public class MMySugang {
	private Vector<VLecture> vSugangVector;
	
	public MMySugang() {
		this.vSugangVector = new Vector<VLecture>();
	}

	public void add(VLecture vLecture) {
		this.vSugangVector.add(vLecture);
		SugangWrite();
	}

	private void SugangWrite() {
		  try (BufferedWriter writer = new BufferedWriter(new FileWriter("data/sincheong.txt"))) {
	            for (VLecture vlecture : vSugangVector) {
	                String mLecture = vlecture.getCode() + " " + vlecture.getTitle() + " " +
	                        vlecture.getLecturer() + " " + vlecture.getCredit() + " " +
	                        vlecture.getTime();
			                writer.write(mLecture);
			                writer.newLine();
					        }
					        writer.flush();
					        } catch (IOException e) {
					          System.out.println("파일을 읽을 수 없습니다." + e.getMessage());
					        }
					    }
	
	public void SugangRead(VLecture vLecture) {
		 try (BufferedReader reader = new BufferedReader(new FileReader("data/sincheong.txt"))) {
			 String line;
	         while ((line = reader.readLine()) != null) {
	             System.out.println(line);
		         }
			     } catch (IOException e) {
			       System.out.println("파일을 읽을 수 없습니다." + e.getMessage());
			     }
	}
	
	

		public void Sugangremove(VLecture vlecture) {
			Scanner keyboard = new Scanner(System.in);
			int remover = keyboard.nextInt();
			
			boolean remove = false;
		    for (VLecture VLecture : vSugangVector) {
		        if (VLecture.getCode() == remover) {
		            vSugangVector.remove(VLecture);
		            remove = true;
		            System.out.println(VLecture.getCode()+" "+ VLecture.getTitle()+"가 성공적으로 삭제되었습니다.");
		            break;
		        }
		    } if (!remove){
		    	System.out.println("잘못된 입력입니다. 다시 입력하세요.");
		    }
		}
		
	public VLecture[] getvLectureVector() {
		return vSugangVector.toArray(new VLecture[0]);
	}
		
	}
