package Present;

import java.util.Vector;

import Control.CBasket;
import Valueobject.VLecture;

public class PBasket {
	private CBasket cBasket;
	private Vector<VLecture> vBasketVector;
	
	public PBasket() {
		cBasket = new CBasket();
		vBasketVector = new Vector<>();
	}
	
	public void add(VLecture vLecture) {
		 vBasketVector.add(vLecture);
		 cBasket.add(vLecture);
	}
	
	public void show() {
		System.out.println("미리담기 내역입니다.");
		for(VLecture vLecture: vBasketVector) {
		cBasket.Show();
		}
	}
	
	public void remove() {
		System.out.println("삭제할 강좌 코드를 입력하세요.");
		cBasket.Remove();
	}
}
