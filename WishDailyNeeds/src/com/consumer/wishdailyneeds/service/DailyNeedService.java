/**
* The DailyNeedService interface contains 
* bussiness logic to fetch brands and category of products.
* @author  Abhinav Kumar
* @version 1.0
* @since   2016-01-19 
*/
package com.consumer.wishdailyneeds.service;

import java.util.List;

import com.consumer.wishdailyneeds.model.BrandDTO;
import com.consumer.wishdailyneeds.model.ProductDTO;
import com.consumer.wishdailyneeds.model.ProductDetailDTO;

public interface DailyNeedService {
	public List<ProductDTO> getAllProductList();

	public List<BrandDTO> getAllBrandList();
	
	public List<ProductDetailDTO> getAllProductDetailList();

}
