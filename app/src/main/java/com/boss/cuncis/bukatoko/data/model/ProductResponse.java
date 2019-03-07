package com.boss.cuncis.bukatoko.data.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ProductResponse{

	@SerializedName("data")
	private List<Product> data;

	public List<Product> getData(){
		return data;
	}
}