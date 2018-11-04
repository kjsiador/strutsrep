package com.struts.action;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.struts.dao.UsersDao;
import com.struts.form.UserForm;

public class UsersAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		UsersDao dao = new UsersDao();
		HttpSession session = request.getSession(true);
		String forward = "";

		if (mapping.getPath().equals("/View_User")) {
			List<UserForm> userList = new ArrayList<UserForm>();
			try {
				userList = dao.viewUsers();
				session.setAttribute("userList", userList);

			} catch (Exception e) {
				e.printStackTrace();
			}
			forward = "success";
		} else {
			UserForm regForm = (UserForm) form;
			try {
				int res = dao.saveUser(regForm);
				if (res > 0) {
					ActionMessages messages = new ActionMessages();
					messages.add("message", new ActionMessage("actionMessage.save.success"));
					saveMessages(request, messages);
					forward = "success";
				} else {
					forward = "failure";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return mapping.findForward(forward);
	}

}
