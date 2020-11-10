package com.digimart.DAO;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.digimart.entity.AdminEntity;
import com.digimart.entity.Category;
import com.digimart.entity.Offer;
import com.digimart.entity.PracticeImage;
import com.digimart.entity.Product;
import com.digimart.entity.Purchase;
import com.digimart.entity.SubCategory;

public class ProductCategoryDAOImplimentation implements ProductCategoryDao{

	private JdbcTemplate template;
	private String sql="";
	public ProductCategoryDAOImplimentation(DataSource dataSource) {
		template=new JdbcTemplate(dataSource);
	}
	
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}    
	
	
	@Override
	public int addCategory(Category category) {
		sql="insert into category(category_name, category_prority, category_description, category_photo)values('"+category.getCategory_name()+"','"+category.getCategory_prority()+"','"+category.getCategory_description()+"','"+category.getCategory_photo()+"')";    
		return template.update(sql);
	}
	
	@Override
	public int addSubCategory(SubCategory subCategory) {
		sql="insert into sub_category(sub_category_name,sub_category_photo)values('"+subCategory.getSub_category_name()+"','"+subCategory.getSub_category_photo()+"')";
		return template.update(sql);
	}

	@Override
	public int addProduct(Product product) {
		sql="insert into product(product_name,category_name,sub_categoryname,product_price,product_scription,product_photo,product_expiry_date,product_manufacture_date,manufacture_company,discount_type,product_discount)values('"+product.getProduct_name()+"','"+product.getCategory_name()+"','"+product.getSub_categoryname()+"',"+product.getProduct_price()+",'"+product.getProduct_scription()+"','"+product.getProduct_photo()+"','"+product.getProduct_expiry_date()+"','"+product.getProduct_manufacture_date()+"','"+product.getManufacture_company()+"','"+product.getDiscount_type()+"',"+product.getProduct_discount()+")";
		return template.update(sql);
	}


	@Override
	public List<Object> listCategory() {
			sql="select * from category";
			return template.query(sql,new RowMapper<Object>() {
				List<Map<Object, String>> list=new ArrayList<Map<Object,String>>();
				public Object mapRow(ResultSet rs,int row) throws SQLException{
					ResultSetMetaData resultSetMetaData=rs.getMetaData();
					int countColumn=resultSetMetaData.getColumnCount();	
					if(rs!=null){
							Map<Object, String> resultHashMap1=new HashMap<Object, String>();
							for(int i=1;i<=countColumn;i++) {
								resultHashMap1.put(resultSetMetaData.getColumnName(i),rs.getString(i));
							}
							list.add(resultHashMap1);
						}
					return list;
				}
		});
	}

	@Override
	public List<SubCategory> listSubCategory() {
		sql="select * from sub_category";
		return template.query(sql, new RowMapper<SubCategory>(){
			@Override
			public SubCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
				SubCategory subCategory=new SubCategory();
				subCategory.setSub_category_id(rs.getInt("sub_category_id"));
				subCategory.setSub_category_name(rs.getString("sub_category_name"));
				subCategory.setSub_category_photo(rs.getString("sub_category_photo"));
				return subCategory;
			}
		});
	}
	
	@Override
	public List<Product> listProduct() {
		sql="select * from product";
		return template.query(sql, new RowMapper<Product>(){
			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product products=new Product();
				products.setProduct_id(rs.getInt("product_id"));
				products.setProduct_name(rs.getString("product_name"));
				products.setCategory_name(rs.getString("category_name"));
				products.setSub_categoryname(rs.getString("sub_categoryname"));
				products.setProduct_price(rs.getInt("product_price"));
				products.setProduct_scription(rs.getString("product_scription"));
				products.setProduct_photo(rs.getString("product_photo"));
				products.setProduct_expiry_date(rs.getDate("product_expiry_date"));
				products.setProduct_manufacture_date(rs.getDate("product_manufacture_date"));
				products.setManufacture_company(rs.getString("manufacture_company"));
				products.setDiscount_type(rs.getString("discount_type"));
				products.setProduct_discount(rs.getInt("product_discount"));
				return products;
			}
			
		});
	}

	
	
	@Override
	public Category categoryById(int category_id) {
		sql="select * from category where category_id=?";
		return template.queryForObject(sql, new Object[]{category_id},new BeanPropertyRowMapper<Category>(Category.class));
	}
	
	@Override
	public SubCategory subCategoryById(int subCategory_id) {
		sql="select * from sub_category where sub_category_id=?";
		return template.queryForObject(sql, new Object[]{subCategory_id},new BeanPropertyRowMapper<SubCategory>(SubCategory.class));
	}
	
	@Override
	public Product productByID(int product_id) {
		sql="select * from product where product_id=?";
		return template.queryForObject(sql, new Object[]{product_id},new BeanPropertyRowMapper<Product>(Product.class));
	}

	@Override
	public int editCategory(Category category) {
		sql="update category set category_name='"+category.getCategory_name()+"', category_prority='"+category.getCategory_prority()+"', category_description='"+category.getCategory_description()+"', category_photo='"+category.getCategory_photo()+"' where category_id="+category.getCategory_id();
		return template.update(sql);
	}
	
	@Override
	public int editSubCategory(SubCategory subCategory) {
		sql="update sub_category set sub_category_name='"+subCategory.getSub_category_name()+"',sub_category_photo='"+subCategory.getSub_category_photo()+"' where sub_category_id="+subCategory.getSub_category_id();
		return template.update(sql);
	}
	
	@Override
	public int editProduct(Product product) {
		sql="update product set product_name='"+product.getProduct_name()+"',category_name='"+product.getCategory_name()+"',sub_categoryname='"+product.getSub_categoryname()+"',product_price='"+product.getProduct_price()+"',product_scription='"+product.getProduct_scription()+"',product_photo='"+product.getProduct_photo()+"',product_expiry_date='"+product.getProduct_expiry_date()+"',product_manufacture_date='"+product.getProduct_manufacture_date()+"',manufacture_company='"+product.getManufacture_company()+"',discount_type='"+product.getDiscount_type()+"',product_discount='"+product.getProduct_discount()+"' where product_id="+product.getProduct_id();
		return template.update(sql);
	}

	@Override
	public void deleteCategory(int category_id) {
		sql="delete from category where category_id=?";
		template.update(sql,category_id);
	}
	
	@Override
	public void deleteSubCategory(int subCategory_id) {
		sql="delete from sub_category where sub_category_id=?";
		template.update(sql, subCategory_id);
	}
	
	@Override
	public void deleteProduct(int product_id) {
		sql="delete from product where product_id=?";
		template.update(sql, product_id);
	}

	@Override
	public int addPurchaseDetai(Purchase purchase) {
		String sql="insert into purchase(product_name, company_name, amount, date_time,number_product)values('"+purchase.getProduct_name()+"','"+purchase.getCompany_name()+"','"+purchase.getAmount()+"','"+purchase.getDate_time()+"','"+purchase.getNumber_product()+"')";
		return template.update(sql);
	}

	@Override
	public List<Object> listAllStock() {
		sql="select purchase_id,product_name,sum(number_product) AS totalBycompany,company_name,amount,date_time from purchase group by company_name order by company_name asc";
		return template.query(sql,new RowMapper<Object>() {
			List<Map<Object, String>> list=new ArrayList<Map<Object,String>>();
			public Object mapRow(ResultSet rs,int row) throws SQLException{
				ResultSetMetaData resultSetMetaData=rs.getMetaData();
				int countColumn=resultSetMetaData.getColumnCount();	
				if(rs!=null){
						Map<Object, String> resultHashMap1=new HashMap<Object, String>();
						for(int i=1;i<=countColumn;i++) {
							resultHashMap1.put(resultSetMetaData.getColumnName(i),rs.getString(i));
						}
						list.add(resultHashMap1);
					}
				return list;
			}
		});

	}

	@Override
	public Purchase getPurchaseById(int purchase_id) {
		sql="select * from purchase where purchase_id=?";
		return template.queryForObject(sql, new Object[] {purchase_id},new BeanPropertyRowMapper<Purchase>(Purchase.class));
	}

	@Override
	public int editPurchase(Purchase purchase) {
		sql="update purchase set product_name='"+purchase.getProduct_name()+"', company_name='"+purchase.getCompany_name()+"', amount='"+purchase.getAmount()+"', date_time='"+purchase.getDate_time()+"',number_product='"+purchase.getNumber_product()+"' where purchase_id="+purchase.getPurchase_id();
		return template.update(sql);
	}

	@Override
	public int addOffer(Offer offer) {
		sql="insert into offer(offer_name, offer_start_date, offer_end_date, offer_description, offer_code)values('"+offer.getOffer_name()+"','"+offer.getOffer_start_date()+"','"+offer.getOffer_end_date()+"','"+offer.getOffer_description()+"','"+offer.getOffer_code()+"')";
		return template.update(sql);
	}

	@Override
	public Offer getOfferById(int offer_id) {
		sql="select * from offer where offer_id=?";
		return template.queryForObject(sql,new Object[] {offer_id}, new BeanPropertyRowMapper<Offer>(Offer.class));
	}

	@Override
	public int editOffer(Offer offer) {
		sql="update offer set offer_name='"+offer.getOffer_name()+"', offer_start_date='"+offer.getOffer_start_date()+"', offer_end_date='"+offer.getOffer_end_date()+"', offer_description='"+offer.getOffer_description()+"', offer_code='"+offer.getOffer_code()+"' where offer_id="+offer.getOffer_id();
		return template.update(sql);
	}

	@Override
	public List<Offer> getOfferList() {
		sql="select * from offer";
		return template.query(sql,new RowMapper<Offer>() {
			@Override
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Offer offerList=new Offer();
				offerList.setOffer_id(rs.getInt("offer_id"));
				offerList.setOffer_name(rs.getString("offer_name"));
				offerList.setOffer_start_date(rs.getDate("offer_start_date"));
				offerList.setOffer_end_date(rs.getDate("offer_end_date"));
				offerList.setOffer_description(rs.getString("offer_description"));
				offerList.setOffer_code(rs.getString("offer_code"));
				return offerList;
			}
		});
	}

	@Override
	public void deleteOfferById(int offer_id) {
		sql="delete from offer where offer_id=?";
		template.update(sql,new Object[] {offer_id});
	}
}
