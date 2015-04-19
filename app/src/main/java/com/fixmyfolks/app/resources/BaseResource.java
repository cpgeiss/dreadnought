package com.fixmyfolks.app.resources;

import com.fixmyfolks.data.FixFolkData;

public class BaseResource {

	private FixFolkData data;
	
	public BaseResource(FixFolkData data) {
		this.data = data;
	}
	
	public FixFolkData getData() {
		return data;
	}
	
}