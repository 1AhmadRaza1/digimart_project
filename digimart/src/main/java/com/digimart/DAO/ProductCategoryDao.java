package com.digimart.DAO;

import java.util.List;
import com.digimart.entity.Category;
import com.digimart.entity.Offer;
import com.digimart.entity.PracticeImage;
import com.digimart.entity.Product;
import com.digimart.entity.Purchase;
import com.digimart.entity.SubCategory;

public interface ProductCategoryDao {

	public int addCategory(Category category);
	public int addSubCategory(SubCategory subCategory);
	public int addProduct(Product product);
	public List<Object> listCategory();
	public List<SubCategory> listSubCategory();
	public List<Product> listProduct();
	public int editSubCategory(SubCategory subCategory);
	public int editCategory(Category category);
	public int editProduct(Product product);
	public Category categoryById(int category_id);
	public SubCategory subCategoryById(int subCategory_id);
	public Product productByID(int product_id);
	public void deleteCategory(int category_id);
	public void deleteSubCategory(int subCategory_id);
	public void deleteProduct(int product_id);
	public int addPurchaseDetai(Purchase purchase);
	public List<Object> listAllStock();
	public Purchase getPurchaseById(int purchase_id);
	public int editPurchase(Purchase purchase);
	public int addOffer(Offer offer);
	public Offer getOfferById(int offer_id);
	public int editOffer(Offer offer);
	public List<Offer> getOfferList();
	public void deleteOfferById(int offer_id);
}
