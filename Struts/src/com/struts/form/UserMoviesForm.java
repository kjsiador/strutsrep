package com.struts.form;

import org.apache.struts.action.ActionForm;

public class UserMoviesForm extends ActionForm{
	private int userMoviedId;
	private int userid;
	private int movieid;
	private int status;
	public int getUserMoviedId() {
		return userMoviedId;
	}
	public void setUserMoviedId(int userMoviedId) {
		this.userMoviedId = userMoviedId;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getMovieid() {
		return movieid;
	}
	public void setMovieid(int movieid) {
		this.movieid = movieid;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
