package az.developia.spring_mvc_project;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class ComputerRepository {

	@Autowired
	private DataSource ds;
	
	public List<Computer> findAll(){
		List<Computer> computers =new ArrayList<>();
		
		try {
			
			Connection conn=ds.getConnection();
			Statement st=conn.createStatement();
			ResultSet result=st.executeQuery("select * from computers");
			while(result.next()) {
				Computer computer=new Computer();
				computer.setBrand(result.getNString("brand"));
				computer.setPrice(result.getLong("price"));
				
				computers.add(computer);
				
				
			}
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return computers;
		
	}


}
