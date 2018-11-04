package com.struts.form;

import org.apache.struts.action.ActionForm;

public class MoviesForm extends ActionForm{
	private int movieid;
	private String moviename;
	private String genre;
	public int getMovieid() {
		return movieid;
	}
	public void setMovieid(int movieid) {
		this.movieid = movieid;
	}
	public String getMoviename() {
		return moviename;
	}
	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
}
