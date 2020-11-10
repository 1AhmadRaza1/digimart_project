package com.digimart.entity;

import java.sql.Date;

public class Product {
	private int product_id;
	private String product_name;
	private String category_name;
	private String sub_categoryname;
	private long product_price;
	private String product_scription;
	private String product_photo;
	private Date product_expiry_date;
	private Date product_manufacture_date;
	private String manufacture_company; 
	private String discount_type;
	private int product_discount;
	/**
	 * @return the product_id
	 */
	public int getProduct_id() {
		return product_id;
	}
	/**
	 * @param product_id the product_id to set
	 */
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	/**
	 * @return the product_name
	 */
	public String getProduct_name() {
		return product_name;
	}
	/**
	 * @param product_name the product_name to set
	 */
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	/**
	 * @return the category_name
	 */
	public String getCategory_name() {
		return category_name;
	}
	/**
	 * @param category_name the category_name to set
	 */
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	/**
	 * @return the sub_categoryname
	 */
	public String getSub_categoryname() {
		return sub_categoryname;
	}
	/**
	 * @param sub_categoryname the sub_categoryname to set
	 */
	public void setSub_categoryname(String sub_categoryname) {
		this.sub_categoryname = sub_categoryname;
	}
	/**
	 * @return the product_price
	 */
	public long getProduct_price() {
		return product_price;
	}
	/**
	 * @param product_price the product_price to set
	 */
	public void setProduct_price(long product_price) {
		this.product_price = product_price;
	}
	/**
	 * @return the product_scription
	 */
	public String getProduct_scription() {
		return product_scription;
	}
	/**
	 * @param product_scription the product_scription to set
	 */
	public void setProduct_scription(String product_scription) {
		this.product_scription = product_scription;
	}
	/**
	 * @return the product_photo
	 */
	public String getProduct_photo() {
		return product_photo;
	}
	/**
	 * @param product_photo the product_photo to set
	 */
	public void setProduct_photo(String product_photo) {
		this.product_photo = product_photo;
	}
	/**
	 * @return the product_expiry_date
	 */
	public Date getProduct_expiry_date() {
		return product_expiry_date;
	}
	/**
	 * @param product_expiry_date the product_expiry_date to set
	 */
	public void setProduct_expiry_date(Date product_expiry_date) {
		this.product_expiry_date = product_expiry_date;
	}
	/**
	 * @return the product_manufacture_date
	 */
	public Date getProduct_manufacture_date() {
		return product_manufacture_date;
	}
	/**
	 * @param product_manufacture_date the product_manufacture_date to set
	 */
	public void setProduct_manufacture_date(Date product_manufacture_date) {
		this.product_manufacture_date = product_manufacture_date;
	}
	/**
	 * @return the manufacture_company
	 */
	public String getManufacture_company() {
		return manufacture_company;
	}
	/**
	 * @param manufacture_company the manufacture_company to set
	 */
	public void setManufacture_company(String manufacture_company) {
		this.manufacture_company = manufacture_company;
	}
	/**
	 * @return the discount_type
	 */
	public String getDiscount_type() {
		return discount_type;
	}
	/**
	 * @param discount_type the discount_type to set
	 */
	public void setDiscount_type(String discount_type) {
		this.discount_type = discount_type;
	}
	/**
	 * @return the product_discount
	 */
	public int getProduct_discount() {
		return product_discount;
	}
	/**
	 * @param product_discount the product_discount to set
	 */
	public void setProduct_discount(int product_discount) {
		this.product_discount = product_discount;
	}
	
}
