package com.struts.action;

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

import com.struts.dao.MoviesDao;
import com.struts.form.MoviesForm;
import com.struts.form.UserForm;

public class MoviesAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		MoviesDao dao = new MoviesDao();
		HttpSession session = request.getSession(true);
		String forward = "";

		if (mapping.getPath().equals("/View_Movies")) {
			List<MoviesForm> list = new ArrayList<MoviesForm>();
			try {
				list = dao.viewMovies();
				session.setAttribute("movieList", list);
			} catch (Exception e) {
				e.printStackTrace();
			}
			forward = "success";
		} else {
			MoviesForm movieForm = (MoviesForm) form;
			try {
				int res = dao.saveMovie(movieForm);
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
