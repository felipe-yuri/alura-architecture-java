package br.com.alura.infra.entities.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.domain.entities.student.CPF;
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
		return null;
	}

	@Override
	public List<StudentEntity> searchAll() {
		return null;
	}

}
