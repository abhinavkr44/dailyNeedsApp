package com.consumer.wishdailyneeds.model;

public class ProductDetailDTO {
	private String objectId;
	private String brandDescription;
	private int quantity;
	private float rate;
	private String unit;
	private BrandDTO brandId;
	
	public String getObjectId() {
		return objectId;
	}
	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}
	public String getBrandDescription() {
		return brandDescription;
	}
	public void setBrandDescription(String brandDescription) {
		this.brandDescription = brandDescription;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public BrandDTO getBrandId() {
		return brandId;
	}
	public void setBrandId(BrandDTO brandId) {
		this.brandId = brandId;
	}
}
