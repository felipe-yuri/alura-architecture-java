package br.com.alura.infra.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.domain.entities.student.CPF;
import br.com.alura.domain.entities.student.Email;
import br.com.alura.domain.entities.student.Phone;
import br.com.alura.domain.entities.student.StudentEntity;
import br.com.alura.domain.repositories.StudentRepository;

public class StudentRepositoryJDBC implements StudentRepository {

	private final Connection connection;

	public StudentRepositoryJDBC(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void enroll(StudentEntity student) {
		try {
			String query = "INSERT INTO STUDENT VALUES(?, ?, ?);";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, student.getCpf());
			ps.setString(2, student.getName());
			ps.setString(3, student.getEmail());
			ps.execute();

			query = "INSERT INTO PHONE VALUES(?,?);";

			for (Phone phone : student.getPhones()) {
				ps.setString(1, phone.getDdd());
				ps.setString(2, phone.getNumber());
				ps.execute();
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public StudentEntity searchByCpf(CPF cpf) {
		try {
			String query = "SELECT id, name, email FROM STUDENT WHERE cpf = ? ";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, cpf.getCPF());
			ResultSet rs = ps.executeQuery();
			if (!rs.next()) {
				throw new RuntimeException("Student not found!");
			}
			String name = rs.getString("name");
			Email email = new Email(rs.getString("email"));
			StudentEntity student = new StudentEntity(cpf, name, email);
			Long id = rs.getLong("id");

			query = "SELECT ddd, number FROM PHONE WHERE student_id = ? ";
			ps = connection.prepareStatement(query);
			ps.setLong(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				String number = rs.getString("number");
				String ddd = rs.getString("ddd");
				student.addPhones(ddd, number);
			}
			return student;

		} catch (Exception e) {
			throw new RuntimeException("Error to find by this cpf!", e);
		}
	}

	@Override
	public List<StudentEntity> searchAll() {
		try {
			String query = "SELECT * FROM STUDENT ";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			List<StudentEntity> students = new ArrayList<>();
			while (rs.next()) {
				CPF cpf = new CPF(rs.getString("cpf"));
				String name = rs.getString("name");
				Email email = new Email(rs.getString("name"));
				StudentEntity student = new StudentEntity(cpf, name, email);
				Long id = rs.getLong("id");

				query = "SELECT ddd, number FROM PHONE WHERE student_id = ? ";
				PreparedStatement psPhone = connection.prepareStatement(query);
				psPhone.setLong(1, id);
				ResultSet rsPhone = ps.executeQuery();
				while (rsPhone.next()) {
					String ddd = rsPhone.getString("ddd");
					String number = rsPhone.getString("number");
					student.addPhones(ddd, number);
				}
				students.add(student);
			}
			return students;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
