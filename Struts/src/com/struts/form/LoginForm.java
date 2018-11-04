package com.struts.form;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;

public class LoginForm extends ActionForm{
	private String username;
	private String password;
	
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors error = new ActionErrors();
		if(username.equals("") && password.equals("")) {
			error.add("login", new ActionMessage ("error.login.required"));
		}
		else if(username.equals("") && !password.equals("")) {
			error.add("login", new ActionMessage ("error.username.required"));
		}
		else if(!username.equals("") && password.equals("")) {
			error.add("login", new ActionMessage ("error.password.required"));
		}
		return error;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
