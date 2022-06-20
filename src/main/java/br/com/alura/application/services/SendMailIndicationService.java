package br.com.alura.application.services;

import br.com.alura.domain.entities.student.StudentEntity;

public interface SendMailIndicationService {

	void sendTo(StudentEntity student);

}
