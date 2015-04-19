package com.fixmyfolks.app.resources;

import javax.servlet.http.HttpSession;

import com.fixmyfolks.app.AuthException;
import com.fixmyfolks.data.FixFolkData;
import com.fixmyfolks.data.model.Account;

public class BaseResource {

	private FixFolkData data;
	
	public BaseResource(FixFolkData data) {
		this.data = data;
	}
	
	protected FixFolkData getData() {
		return data;
	}
	
	protected Account getSessionAccount(HttpSession session) {
		Account account = null;
		Object id = session.getAttribute("id");
		if (id != null) {
			account = getData().getAccountById(id.toString());
		}
		if (account == null) {
			throw new AuthException();
		}
		return account;
	}
	
}