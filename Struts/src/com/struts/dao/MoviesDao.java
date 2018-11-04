package com.struts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

import com.struts.form.MoviesForm;

public class MoviesDao {
	public List<MoviesForm> viewMovies() throws Exception{
		Connection conn = DBConnection.dbCon();
		System.out.println("Connection: " + conn);
		MoviesForm movies = new MoviesForm();
		List<MoviesForm> list = new ArrayList<MoviesForm>();
		ResultSet rs = null;
		try {
			Statement statement = conn.createStatement();
			String query = "SELECT * FROM MOVIES ORDER BY GENRE";
			rs = statement.executeQuery(query);
			while(rs.next()) {
				movies.setMovieid(rs.getInt("MOVIE_ID"));
				movies.setMoviename(rs.getString("MOVIE_NAME"));
				movies.setGenre(rs.getString("GENRE"));
				list.add(movies);
				movies = new MoviesForm();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public int saveMovie(MoviesForm movies) {
		int r = 0;
		Connection conn = DBConnection.dbCon();
		System.out.println("Connection: " + conn);
		try {
			PreparedStatement ps = null;
			ps = conn.prepareStatement("INSERT INTO MOVIES(MOVIE_NAME, GENRE) VALUES (?,?)");
			ps.setString(1, movies.getMoviename());
			ps.setString(2, movies.getGenre());
			r = ps.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return r;
		
	}
}
