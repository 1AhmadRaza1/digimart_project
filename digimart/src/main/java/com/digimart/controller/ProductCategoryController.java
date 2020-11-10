package com.digimart.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.hibernate.id.BulkInsertionCapableIdentifierGenerator;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.digimart.DAO.ProductCategoryDao;
import com.digimart.entity.Category;
import com.digimart.entity.Offer;
import com.digimart.entity.PracticeImage;
import com.digimart.entity.Product;
import com.digimart.entity.Purchase;
import com.digimart.entity.SubCategory;

@Controller
public class ProductCategoryController {

	@Autowired
	private ProductCategoryDao productCategoryDAO;
	
	int intValue=0;
	ModelAndView andView=null;
	String responseString=null;
	
	@RequestMapping(value="/add-category",method = RequestMethod.GET)
	public ModelAndView addCategory(){
		andView=new ModelAndView("add_category");
		andView.addObject("addCategory", new Category());
		return andView;
	}
	
	@RequestMapping(value="/add-new-category",method = RequestMethod.POST)
	public String save(@ModelAttribute("addCategory") Category category,@RequestParam("file") MultipartFile file) throws IOException{
		category.setCategory_name(file.getOriginalFilename());
		category.setCategory_photo(Base64.getEncoder().encodeToString(file.getBytes()));
		productCategoryDAO.addCategory(category);
		return "redirect:/view-datatable";
	}
	  
	@RequestMapping(value = "/view-datatable",method = RequestMethod.GET)
	public ModelAndView listDatatable(){
		andView=new ModelAndView("showimage");
		return andView;
	}
	
	  @RequestMapping(value = "/list-dataTable",method = RequestMethod.GET)
	  @ResponseBody
	  public String listCategory() {
		  List<Object> l2=productCategoryDAO.listCategory();
		  Map<String, Object> m1=new HashMap<String, Object>();
		  for(Object l1:l2) {
			  m1.put("data", l1);
		  }
		  String s=JSONValue.toJSONString(m1);
		 return s;
	  }
	  
	  @RequestMapping(value="/add-sub-category",method = RequestMethod.GET)
	  public ModelAndView addSubCategory(){
		  andView=new ModelAndView("sub_category");
		  andView.addObject("addsubcategory", new SubCategory());
		  return andView;
		} 
	  
	  @RequestMapping(value = "add-new-sub-category",method = RequestMethod.POST)
	  public String addNewSubCategory(@ModelAttribute("addsubcategory") SubCategory subCategory,@RequestParam("file") MultipartFile file) throws IOException, SerialException, SQLException{
		  andView=new ModelAndView("sub_category");
		  subCategory.setSub_category_name(file.getOriginalFilename());
		  subCategory.setSub_category_photo(Base64.getEncoder().encodeToString(file.getBytes()));
		  productCategoryDAO.addSubCategory(subCategory);
		  return "redirect:/list-sub-categories";
	  }
	  
	  @RequestMapping(value="/add-product",method = RequestMethod.GET)
	  public ModelAndView addProduct(){
			andView=new ModelAndView("add_product");
			andView.addObject("addproduct", new Product());
			return andView;
	  } 
	  
	  @RequestMapping(value = "/add-new-product",method = RequestMethod.POST)
	  public String addProduct(@ModelAttribute("addproduct") Product product,BindingResult result,@RequestParam("product_photo") MultipartFile file) throws IOException{
		  product.setProduct_photo(Base64.getEncoder().encodeToString(file.getBytes()));
		  product.setProduct_name(file.getOriginalFilename());
		  productCategoryDAO.addProduct(product);
		  return "redirect:/list-prouct";
	  }

	  @RequestMapping(value = "/list-prouct")
	  public ModelAndView productList(Product product) {
		  List<Product> productList=productCategoryDAO.listProduct();
		  andView=new ModelAndView("list_product");
		  andView.addObject("listproduct", productList);
		  return andView;
	  }
	  
	  @RequestMapping(value = "/edit-product/{product_id}",method = RequestMethod.GET)
	  public ModelAndView editProduct(@PathVariable int product_id) {
		  andView=new ModelAndView("edit_product");
		  Product productByid=productCategoryDAO.productByID(product_id);
		  andView.addObject("getProductById", productByid);
		  return andView;
	  }
	  
	  @RequestMapping(value = "/edit-new-product",method = RequestMethod.POST)
	  public String editProduct(@ModelAttribute() Product product,BindingResult result,@RequestParam("product_photo") MultipartFile file) throws IOException {
		  product.setProduct_name(file.getOriginalFilename());
		  product.setProduct_photo(Base64.getEncoder().encodeToString(file.getBytes()));
		  productCategoryDAO.editProduct(product);
		  return "redirect:/list-prouct";
	  }
	  
	  @RequestMapping(value = "/edit-category/{category_id}",method = RequestMethod.GET)
	  public ModelAndView edit(@PathVariable int category_id) {
		  andView=new ModelAndView("edit_category");
		  Category categoryByid=productCategoryDAO.categoryById(category_id);
		  andView.addObject("categoryById", categoryByid);
		  return andView;
	  }
	  
	  @RequestMapping(value = "/edit-new-category",method = RequestMethod.POST)
	  public String editCategory(@ModelAttribute("categoryById") Category category,@RequestParam("file") MultipartFile file) throws IOException {
		  category.setCategory_name(file.getOriginalFilename());
		  category.setCategory_photo(Base64.getEncoder().encodeToString(file.getBytes()));
		  productCategoryDAO.editCategory(category);
		  return "redirect:/view-datatable";
	  }
	    	
	  @RequestMapping(value="/list-sub-categories")
	  public ModelAndView showList(){
		  andView=new ModelAndView("list_subcategory");
		  List<SubCategory> subCategory=productCategoryDAO.listSubCategory();
		  andView.addObject("subCategory", subCategory);
		  return andView;
		}
	  
	  @RequestMapping(value = "/edit-subcategory/{subcategory_id}",method = RequestMethod.GET)
	  public ModelAndView editSubCategory(@PathVariable int subcategory_id) {
		  andView=new ModelAndView("edit_subcategory");
		  SubCategory subCategoryByid=productCategoryDAO.subCategoryById(subcategory_id);
		  andView.addObject("getSubCategoryById", subCategoryByid);
		  return andView;
	  }
	  
	  @RequestMapping(value = "/edit-new-sub-category",method = RequestMethod.POST)
	  public String editSubCategory(@ModelAttribute() SubCategory subCategory,@RequestParam("file") MultipartFile file) throws IOException {
		  subCategory.setSub_category_name(file.getOriginalFilename());
		  subCategory.setSub_category_photo(Base64.getEncoder().encodeToString(file.getBytes()));
		  productCategoryDAO.editSubCategory(subCategory);
		  return "redirect:/list-sub-categories";
	  }
	  
	  @RequestMapping(value = "/delete-category-by/{category_id}",method = RequestMethod.GET)
	  public String deleteCategory(@PathVariable int category_id) {
		  productCategoryDAO.deleteCategory(category_id);
		  return "redirect:/view-datatable";
	  }
	  
	  @RequestMapping(value = "/delete-subcategory-by/{subCategory_id}",method = RequestMethod.GET)
	  public String deleteSubCategory(@PathVariable int subCategory_id) {
		  productCategoryDAO.deleteSubCategory(subCategory_id);
		  return "redirect:/list-sub-categories";
	  }
	  
	  @RequestMapping(value = "/delete-prduct-by/{product_id}",method = RequestMethod.GET)
	  public String deleteProduct(@PathVariable int product_id) {
		  productCategoryDAO.deleteProduct(product_id);
		  return "redirect:/list-prouct";
	  }

	  @RequestMapping(value="/add-purchase",method = RequestMethod.GET)
	  public ModelAndView addPurchase(){
			andView=new ModelAndView("add_purchase");
			andView.addObject("addpurchase", new Purchase());
			return andView;
	  } 
	  
	  @RequestMapping(value = "/add-new-purchase",method = RequestMethod.POST)
	  public String addNewPurchase(@ModelAttribute("addpurchase") Purchase purchase,@RequestParam("purchase_date_time") Date date) throws IOException{
		  purchase.setDate_time(date);
		  productCategoryDAO.addPurchaseDetai(purchase);
		  return "redirect:/view-stock-datatable";
	  }

	  @RequestMapping(value = "/view-stock-datatable",method = RequestMethod.GET)
	  public ModelAndView listStockDatatable(){
		  andView=new ModelAndView("stock_datatable");
		  return andView;
	  }
		
	  @RequestMapping(value = "/list-stock-dataTable",method = RequestMethod.GET)
	  @ResponseBody
	  public String listStock() {
		  List<Object> l2=productCategoryDAO.listAllStock();
		  Map<String, Object> m1=new HashMap<String, Object>();
		  for(Object l1:l2) {
			  m1.put("data", l1);
		  }
		  String s=JSONValue.toJSONString(m1);
		  return s;
	  }
	  
	  @RequestMapping(value="/edit-purchase/{purchase_id}",method = RequestMethod.GET)
	  public ModelAndView editPurchase(@PathVariable int purchase_id){
			andView=new ModelAndView("edit_purchase");
			Purchase purchaseList=productCategoryDAO.getPurchaseById(purchase_id);
			andView.addObject("editpurchase", purchaseList);
			return andView;
	  } 
	  
	  @RequestMapping(value = "/edit-new-purchase",method = RequestMethod.POST)
	  public String editNewPurchase(@ModelAttribute("editpurchase") Purchase purchase,@RequestParam("purchase_date_time") Date date) throws IOException{
		  purchase.setDate_time(date);
		  productCategoryDAO.editPurchase(purchase);
		  return "redirect:/view-stock-datatable";
	  }
	  
	  @RequestMapping(value = "/add-offer",method = RequestMethod.GET)
	  public ModelAndView addOffer() {
		  andView=new ModelAndView("add_offer");
		  andView.addObject("addoffer", new Offer());
		  return andView;
	  }
	  
	  @RequestMapping(value = "/add-new-offer",method = RequestMethod.POST)
	  public String addNewOffer(@ModelAttribute("addoffer") Offer offer,@RequestParam("offer_start_date") Date startDate,@RequestParam("offer_end_date") Date endDate){
		  offer.setOffer_start_date(startDate);
		  offer.setOffer_end_date(endDate);
		  productCategoryDAO.addOffer(offer);
		  return "redirect:/listOffer";
	  }
	  
	  @RequestMapping(value = "/listOffer")
	  public ModelAndView listOffer() {
		  andView=new ModelAndView("offer_list");
		  List<Offer> offerList=productCategoryDAO.getOfferList();
		  andView.addObject("offerList", offerList);
		  return andView;
	  }
	  
	  @RequestMapping(value = "/edit-offer/{offer_id}",method = RequestMethod.GET)
	  public ModelAndView editOffer(@PathVariable("offer_id") int offer_id) {
		  andView=new ModelAndView("edit_offer");
		  Offer offerById=productCategoryDAO.getOfferById(offer_id);
		  andView.addObject("editoffer", offerById);
		  return andView;
	  }
	  
	  @RequestMapping(value = "/edit-new-offer",method = RequestMethod.POST)
	  public String editNewOffer(@ModelAttribute("editoffer") Offer offer,@RequestParam("offer_start_date") Date startDate,@RequestParam("offer_end_date") Date endDate){
		  offer.setOffer_start_date(startDate);
		  offer.setOffer_end_date(endDate);
		  productCategoryDAO.editOffer(offer);
		  return "redirect:/listOffer";
	  }
	  
	  @RequestMapping(value = "/delete-offer/{offer_id}",method = RequestMethod.GET)
	  public String deleteOffer(@PathVariable int offer_id) {
		  productCategoryDAO.deleteOfferById(offer_id);
		  return "redirect:/listOffer";
	  }
	  
}
