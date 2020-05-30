package viewutils;

import java.util.ArrayList;
import org.apache.tomcat.util.codec.binary.Base64;
import model.Sanpham;
import viewbo.SanphamView;

public class Sanphamutils {
	public static ArrayList<SanphamView> convertToProductViewList(ArrayList<Sanpham> productList){
		ArrayList<SanphamView> productViewsList = new ArrayList<SanphamView>();
		for(Sanpham product : productList) {
			productViewsList.add(convertToProductView(product));
		}
		return productViewsList;
		
	}

	private static SanphamView convertToProductView(Sanpham product) {
		SanphamView productView = new SanphamView();
		productView.setId(product.getId()); 
		
		String photoEncode = Base64.encodeBase64String(product.getAvatar());
		productView.setAvatar(photoEncode);
		
		productView.setName(product.getName());
		productView.setSpecies(product.getSpecies());
		productView.setQuantity(product.getQuantity());
		return productView;
	}
}
