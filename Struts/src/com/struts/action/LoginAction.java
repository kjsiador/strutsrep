package com.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.struts.dao.LoginDao;
import com.struts.form.LoginForm;

public class LoginAction extends Action{
	LoginDao dao = new LoginDao();
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		LoginForm loginForm = (LoginForm) form;
		ActionErrors error = new ActionErrors();
		
		boolean flag = dao.verifyLogin(loginForm);
		if(flag == true) {
			if(loginForm.getUsername().equalsIgnoreCase("admin")) {
				return mapping.findForward("success_admin");
			}
			else {
				return mapping.findForward("success_user");
			}
		}
		else {
			error.add("login", new ActionMessage("error.login.incorrect"));
			saveErrors(request, error);
			return mapping.findForward("failure");
		}		
	}
}
