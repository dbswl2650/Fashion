import java.util.List;

import com.fashion.dao.CartDAO;
import com.fashion.vo.CartItem;

public class cart {
	public static void main(String[] args) {
		CartDAO cdao = new CartDAO();
		List<CartItem> clist = cdao.selectCart("1");
	System.out.println(clist);
	}
}
