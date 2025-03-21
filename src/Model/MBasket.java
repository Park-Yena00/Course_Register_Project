package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import Valueobject.VLecture;

public class MBasket {
	private Vector<VLecture> vBasketVector;
	
	public MBasket() {
		this.vBasketVector = new Vector<VLecture>();
	}
	
	public void add(VLecture vLecture) {
		this.vBasketVector.add(vLecture);
		BasketWrite();
	}
	
	private void BasketWrite() {
		  try (BufferedWriter writer = new BufferedWriter(new FileWriter("data/basket.txt"))) {
	            for (VLecture vlecture : vBasketVector) {
	                String bLecture = vlecture.getCode() + " " + vlecture.getTitle() + " " +
	                        vlecture.getLecturer() + " " + vlecture.getCredit() + " " +
	                        vlecture.getTime();
			                writer.write(bLecture);
			                writer.newLine();
					        }
					        writer.flush();
					        } catch (IOException e) {
					          System.out.println("파일을 읽을 수 없습니다." + e.getMessage());
					        }
					    }
	
	public void BasketRead(VLecture vLecture) {
			 try (BufferedReader reader = new BufferedReader(new FileReader("data/basket.txt"))) {
				 String line;
		         while ((line = reader.readLine()) != null) {
		             System.out.println(line);
			         }
				     } catch (IOException e) {
				       System.out.println("파일을 읽을 수 없습니다." + e.getMessage());
				     }
	}
		
	public void Basketremove(VLecture vLecture) {
			Scanner keyboard = new Scanner(System.in);
			int remover = keyboard.nextInt();
			
			boolean remove = false;
		    for (VLecture VLecture : vBasketVector) {
		        if (VLecture.getCode() == remover) {
		            vBasketVector.remove(VLecture);
		            remove = true;
		            System.out.println(VLecture.getCode()+" "+ VLecture.getTitle()+"가 성공적으로 삭제되었습니다.");
		            break;
		        }
		    }  if (!remove){
		    	System.out.println("입력이 잘못됐습니다. 삭제할 강좌의 코드를 다시 입력해주세요.");
		    }
		}
	
	public VLecture[] getvLectureVector() {
		return vBasketVector.toArray(new VLecture[0]);
	}
}
