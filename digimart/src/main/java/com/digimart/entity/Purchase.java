package com.digimart.entity;

import java.sql.Date;

public class Purchase {

	private int purchase_id;
	private String product_name;
	private String company_name;
	private int amount;
	private Date date_time;
	private int number_product;
	/**
	 * @return the purchase_id
	 */
	public int getPurchase_id() {
		return purchase_id;
	}
	/**
	 * @param purchase_id the purchase_id to set
	 */
	public void setPurchase_id(int purchase_id) {
		this.purchase_id = purchase_id;
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
	 * @return the company_name
	 */
	public String getCompany_name() {
		return company_name;
	}
	/**
	 * @param company_name the company_name to set
	 */
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}
	/**
	 * @return the date_time
	 */
	public Date getDate_time() {
		return date_time;
	}
	/**
	 * @param date_time the date_time to set
	 */
	public void setDate_time(Date date_time) {
		this.date_time = date_time;
	}
	/**
	 * @return the number_product
	 */
	public int getNumber_product() {
		return number_product;
	}
	/**
	 * @param number_product the number_product to set
	 */
	public void setNumber_product(int number_product) {
		this.number_product = number_product;
	}
	
}
