package vn.mista.guitarshop.viewutils;

import java.util.ArrayList;

import org.apache.tomcat.util.codec.binary.Base64;

import vn.mista.guitarshop.bo.Item;
import vn.mista.guitarshop.bo.Product;
import vn.mista.guitarshop.viewbo.ItemView;
import vn.mista.guitarshop.viewbo.ProductView;

public class ProductUtils {

	public static ArrayList<ProductView> convertToProductViewList(ArrayList<Product> productList){
		ArrayList<ProductView> productViewsList = new ArrayList<ProductView>();
		for(Product product : productList) {
			productViewsList.add(convertToProductView(product));
		}
		return productViewsList;
		
	}
	
	
	public static ProductView convertToProductView(Product product) {
		ProductView productView = new ProductView();
		productView.setProductID(product.getProductID());
		
		String photoEncode=Base64.encodeBase64String(product.getProductImg());
		productView.setProductImg(photoEncode);
		
		productView.setProductName(product.getProductName());
		productView.setProductType(product.getProductType());
		productView.setAmount(product.getAmount());
		productView.setPrice(product.getPrice());
		
		return productView;
	}
}
