package az.developia.spring_mvc_project.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
				book.setPrice(result.getLong("price"));
				book.setPageCount(result.getLong("pageCount"));
				books.add(book);
				
			}
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return books;
		
	}

	public Integer add(Book bookInfo) {
		Integer id=0;
		

		try {
			
			Connection conn=ds.getConnection();
			PreparedStatement pr=conn.prepareStatement("insert into books(name,price,pageCount) values(?,?,?)",
					Statement.RETURN_GENERATED_KEYS );
			pr.setString(1, bookInfo.getName());
			pr.setLong(2, bookInfo.getPrice());
			pr.setLong(3, bookInfo.getPageCount());
			pr.executeUpdate();
			ResultSet rs=pr.getGeneratedKeys();
			rs.next();
			id=rs.getInt(1);
			
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return id;
	}

	

}
