package az.developia.spring_mvc_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

	public List<Computer> findAll() {
		List<Computer> computers = new ArrayList<>();

		try {

			Connection conn = ds.getConnection();
			Statement st = conn.createStatement();
			ResultSet result = st.executeQuery("select * from computers");
			while (result.next()) {
				Computer computer = new Computer();
				computer.setId(result.getInt("id"));
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

	public Integer add(Computer c) {
		Integer id = 0;

		try {

			Connection conn = ds.getConnection();
			PreparedStatement pr = conn.prepareStatement("insert into computers(brand,price) values(?,?)",
					Statement.RETURN_GENERATED_KEYS);
			pr.setString(1, c.getBrand());
			pr.setLong(2, c.getPrice());

			pr.executeUpdate();
			ResultSet rs = pr.getGeneratedKeys();
			rs.next();
			id = rs.getInt(1);

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return id;
	}

	public void deleteById(Integer id) {
		try {

			Connection conn = ds.getConnection();
			PreparedStatement pr = conn.prepareStatement("delete from computers where id=?");
			pr.setInt(1, id);
			pr.executeUpdate();

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
