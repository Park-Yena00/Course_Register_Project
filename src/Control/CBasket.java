package Control;

import Model.MBasket;
import Valueobject.VLecture;

public class CBasket {
		
		private MBasket mBasket;
		private VLecture vBasketVector;
		
		public CBasket() {
			this.mBasket = new MBasket();
		}
		
		public void add(VLecture vLecture) {
	        mBasket.add(vLecture);
		}

		public void Show() {
			   mBasket.BasketRead(vBasketVector);
			   }

		public void Remove() {
			   mBasket.Basketremove(vBasketVector);
		}
}
