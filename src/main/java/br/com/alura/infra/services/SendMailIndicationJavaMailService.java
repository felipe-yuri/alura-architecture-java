package br.com.alura.infra.services;

import br.com.alura.application.services.SendMailIndicationService;
import br.com.alura.domain.entities.student.StudentEntity;

public class SendMailIndicationJavaMailService implements SendMailIndicationService {

	@Override
	public void sendTo(StudentEntity student) {
		//Implementar envio de email com javamail.
		System.out.println("Sended mail to " + student);
	}

}
