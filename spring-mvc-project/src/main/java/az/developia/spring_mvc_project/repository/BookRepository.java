package az.developia.spring_mvc_project.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import az.developia.spring_mvc_project.model.Book;

@Repository
public class BookRepository {

	@Autowired
	private DataSource ds;
	
	public List<Book> findAll(){
		List<Book> books =new ArrayList<>();
		
		try {
			
			Connection conn=ds.getConnection();
			Statement st=conn.createStatement();
			ResultSet result=st.executeQuery("select * from books");
			while(result.next()) {
				Book book=new Book();
				book.setName(result.getString("name"));
				books.add(book);
				
			}
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return books;
		
	}
	
	

}
