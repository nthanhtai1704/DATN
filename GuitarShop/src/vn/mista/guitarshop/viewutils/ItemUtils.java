package vn.mista.guitarshop.viewutils;

import java.util.ArrayList;

import org.apache.tomcat.util.codec.binary.Base64;

import vn.mista.guitarshop.bo.Item;
import vn.mista.guitarshop.viewbo.ItemView;

public class ItemUtils {

	public static ArrayList<ItemView> convertToProductViewList(ArrayList<Item> itemList){
		ArrayList<ItemView> itemViewsList = new ArrayList<ItemView>();
		for(Item item : itemList) {
			itemViewsList.add(convertToItemView(item));
		}
		return itemViewsList;
		
	}
	
	public static ItemView convertToItemView(Item item) {
		ItemView itemView = new ItemView();
		itemView.setProductID(item.getProduct().getProductID());
		
		String photoEncode=Base64.encodeBase64String(item.getProduct().getProductImg());
		itemView.setProductImg(photoEncode);
		
		itemView.setProductName(item.getProduct().getProductName());
		itemView.setProductType(item.getProduct().getProductType());
		itemView.setAmount(item.getProduct().getAmount());
		itemView.setPrice(item.getProduct().getPrice());
		itemView.setQuantity(item.getQuantity());
		
		return itemView;
		
	}

}
