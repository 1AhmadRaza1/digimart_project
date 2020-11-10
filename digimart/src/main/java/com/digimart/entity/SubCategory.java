package com.digimart.entity;

public class SubCategory {
	
	private int sub_category_id;
	private String sub_category_name;
	private String sub_category_photo;
	/**
	 * @return the sub_category_id
	 */
	public int getSub_category_id() {
		return sub_category_id;
	}
	/**
	 * @param sub_category_id the sub_category_id to set
	 */
	public void setSub_category_id(int sub_category_id) {
		this.sub_category_id = sub_category_id;
	}
	/**
	 * @return the sub_category_name
	 */
	public String getSub_category_name() {
		return sub_category_name;
	}
	/**
	 * @param sub_category_name the sub_category_name to set
	 */
	public void setSub_category_name(String sub_category_name) {
		this.sub_category_name = sub_category_name;
	}
	/**
	 * @return the sub_category_photo
	 */
	public String getSub_category_photo() {
		return sub_category_photo;
	}
	/**
	 * @param sub_category_photo the sub_category_photo to set
	 */
	public void setSub_category_photo(String sub_category_photo) {
		this.sub_category_photo = sub_category_photo;
	}
	@Override
	public String toString() {
		return "SubCategory [sub_category_id=" + sub_category_id + ", sub_category_name=" + sub_category_name + "]";
	}
	
}
