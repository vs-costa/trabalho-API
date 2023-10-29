package br.com.api.trabalho.services;

import java.time.LocalDate;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import br.com.api.trabalho.dto.UserDTO;

@Configuration
@Service
public class EmailService {

	@Autowired
	UserService userService;

	private JavaMailSender emailSender;

	// no email o @Autowired é feito no construtor por causa da dependência
	@Autowired
	public void setJavaMailSender(JavaMailSender emailSender) {
		this.emailSender = emailSender;
	}

	@Value("${spring.mail.host}")
	private String host;

	@Value("${spring.mail.port}")
	private Integer port;

	@Value("${spring.mail.username}")
	private String username;

	@Value("${spring.mail.password}")
	private String password;

	@Bean
	public JavaMailSender javaMailSender() {
		JavaMailSenderImpl emailSender = new JavaMailSenderImpl();
		Properties prop = new Properties();
		emailSender.setHost(host);
		emailSender.setPort(port);
		emailSender.setUsername(username);
		emailSender.setPassword(password);
		prop.put("mail.transport.protocol", "smtp");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		emailSender.setJavaMailProperties(prop);
		return emailSender;
	}

	public void envioEmailCadastro(UserDTO user) {
		MimeMessage mensagemCadastro = emailSender.createMimeMessage();

		try {
			MimeMessageHelper helper = new MimeMessageHelper(mensagemCadastro, true);
			helper.setFrom("victorsoares.c@gmail.com");
			helper.setTo(user.getEmail());
			helper.setSubject("Cadastro concluido!");

			LocalDate localDate = LocalDate.now();

			StringBuilder builder = new StringBuilder();
			builder.append("<html>\r\n");
			builder.append("	<body>\r\n");
			builder.append("		<div align=\"center\">\r\n");
			builder.append("			<h1>Confirmação de Cadastro</h1>\r\n");
			builder.append("		</div>\r\n");
			builder.append("		<br/>\r\n");
			builder.append("		<div align=\"left\">\r\n");
			builder.append("			Olá,\r\n");
			builder.append("		</div>\r\n");
			builder.append("		<div align=\"left\">\r\n");
			builder.append("			<br/>\r\n");
			builder.append("			Bem vindo ao sistema de cadastro de veículos de nossa empresa\r\n");
			builder.append("		</div>\r\n");
			builder.append("		<div align=\"left\">\r\n");
			builder.append("			<br/>\r\n");
			builder.append("			Aqui estão os detalhes do seu cadastro:\r\n");
			builder.append("		</div>\r\n");
			builder.append("		<div align=\"left\">\r\n");
			builder.append("			<br/>\r\n");
			builder.append("			Nome: \r\n");
			builder.append(user.getNome());
			builder.append("		</div>\r\n");
			builder.append("		<div align=\"left\">\r\n");
			builder.append("			Endereço de E-mail: \r\n");
			builder.append(user.getEmail());
			builder.append("		</div>\r\n");
			builder.append("		<div align=\"left\">\r\n");
			builder.append("			Data de Cadastro: \r\n");
			builder.append(localDate);
			builder.append("		</div>\r\n");
			builder.append("		<div align=\"left\">\r\n");
			builder.append("			<br/>\r\n");
			builder.append(
					"			Agora você pode cadastrar seus veículos para ter acesso livre ao nosso estabelecimento.\r\n");
			builder.append("		</div>\r\n");
			builder.append("		<div align=\"left\">\r\n");
			builder.append("			<br/>\r\n");
			builder.append("		</div>\r\n");
			builder.append("		<div align=\"left\">\r\n");
			builder.append("			<br/>\r\n");
			builder.append("		</div>\r\n");
			builder.append("		<div align=\"left\">\r\n");
			builder.append("		</div>\r\n");
			builder.append("	</body>\r\n");
			builder.append("</html>\r\n");

			helper.setText(builder.toString(), true);
			emailSender.send(mensagemCadastro);

		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

	//PROFESSORA: tentei fazer mais métodos de e-mail e Não consegui. Deixei para você ver a tentativa.
//	public void envioEmailEncerramentoConta(PessoaDTO pessoa) {
//		MimeMessage mensagemCadastro = emailSender.createMimeMessage();
//
//		try {
//			MimeMessageHelper helper = new MimeMessageHelper(mensagemCadastro, true);
//			helper.setFrom("victorsoares.c@gmail.com");
//			helper.setTo(pessoa.getEmail());
//			helper.setSubject("Encerramento de Conta!");
//
//			StringBuilder builder = new StringBuilder();
//			builder.append("<html>\r\n");
//			builder.append("	<body>\r\n");
//			builder.append("		<div align=\"center\">\r\n");
//			builder.append("			<h1>Confirmação de Encerramento de Conta</h1>\r\n");
//			builder.append("		</div>\r\n");
//			builder.append("		<br/>\r\n");
//			builder.append("		<div align=\"left\">\r\n");
//			builder.append("			Olá ");
//			builder.append(pessoa.getNome());
//			builder.append(",\r\n");
//			builder.append("		</div>\r\n");
//			builder.append("		<div align=\"left\">\r\n");
//			builder.append("			<br/>\r\n");
//			builder.append("			Informamos que sua conta foi encerrada.\r\n");
//			builder.append("		</div>\r\n");
//			builder.append("		<div align=\"left\">\r\n");
//			builder.append("			<br/>\r\n");
//			builder.append(
//					"			Reforçamos que devido ao encerramento da conta, seu Carro cadastrado não terá mais acesso ao nosso estabelecimento.\r\n");
//			builder.append("		</div>\r\n");
//			builder.append("		<div align=\"left\">\r\n");
//			builder.append("			<br/>\r\n");
//			builder.append("			");
//			builder.append(
//					"			Se quiser, você pode reativar sua conta a qualquer momento em nosso sistema.\r\n");
//			builder.append("		</div>\r\n");
//			builder.append("	</body>\r\n");
//			builder.append("</html>\r\n");
//
//			helper.setText(builder.toString(), true);
//			emailSender.send(mensagemCadastro);
//
//		} catch (MessagingException e) {
//			e.printStackTrace();
//		}
//
//	}
//
//	public void envioEmailAtivacaoConta(PessoaDTO pessoaDTO) {
//		MimeMessage mensagemCadastro = emailSender.createMimeMessage();
//
//		try {
//			MimeMessageHelper helper = new MimeMessageHelper(mensagemCadastro, true);
//			helper.setFrom("victorsoares.c@gmail.com");
//			helper.setTo(pessoaDTO.getEmail());
//			helper.setSubject("Ativacao de Conta de Cliente!");
//
//			StringBuilder builder = new StringBuilder();
//
//			builder.append("<html>\r\n");
//			builder.append("	<body>\r\n");
//			builder.append("		<div align=\"center\">\r\n");
//			builder.append("		<img src=\"cid:logo6\">\r\n");
//			builder.append("			<h1>Ativação de Conta</h1>\r\n");
//			builder.append("		</div>\r\n");
//			builder.append("		<br/>\r\n");
//			builder.append("		<div align=\"left\">\r\n");
//			builder.append("			Olá \r\n");
//			builder.append(pessoaDTO.getNome());
//			builder.append("		</div>\r\n");
//			builder.append("		<div align=\"left\">\r\n");
//			builder.append("			<br/>\r\n");
//			builder.append("			Sua conta foi ativada com sucesso.\r\n");
//			builder.append("		</div>\r\n");
//			builder.append("		<div align=\"left\">\r\n");
//			builder.append("			<br/>\r\n");
//			builder.append(
//					"			Caso tenha alguma dúvida ou precise de assistência, nossa equipe de suporte está à disposição para ajudá-lo.\r\n");
//			builder.append("		</div>\r\n");
//			builder.append("	</body>\r\n");
//			builder.append("</html>\r\n");
//
//			helper.setText(builder.toString(), true);
//			emailSender.send(mensagemCadastro);
//
//		} catch (MessagingException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public void envioEmailCadastroCarro(CarroDTO carro) {
//		MimeMessage mensagemCadastro = emailSender.createMimeMessage();
//
//		try {
//			MimeMessageHelper helper = new MimeMessageHelper(mensagemCadastro, true);
//			helper.setFrom("victorsoares.c@gmail.com");
//			helper.setTo(carro.getuser.getEmail());
//			helper.setSubject("Cadastro concluido!");
//
//			LocalDate localDate = LocalDate.now();
//
//			StringBuilder builder = new StringBuilder();
//			builder.append("<html>\r\n");
//			builder.append("	<body>\r\n");
//			builder.append("		<div align=\"center\">\r\n");
//			builder.append("			<h1>Confirmação de Cadastro</h1>\r\n");
//			builder.append("		</div>\r\n");
//			builder.append("		<br/>\r\n");
//			builder.append("		<div align=\"left\">\r\n");
//			builder.append("			Olá,\r\n");
//			builder.append("		</div>\r\n");
//			builder.append("		<div align=\"left\">\r\n");
//			builder.append("			<br/>\r\n");
//			builder.append("			Bem vindo ao sistema de cadastro de veículos de nossa empresa\r\n");
//			builder.append("		</div>\r\n");
//			builder.append("		<div align=\"left\">\r\n");
//			builder.append("			<br/>\r\n");
//			builder.append("			Aqui estão os detalhes do  cadastro de seu veículo:\r\n");
//			builder.append("		</div>\r\n");
//			builder.append("		<div align=\"left\">\r\n");
//			builder.append("			<br/>\r\n");
//			builder.append("			Marca: \r\n");
//			builder.append(carro.getMarca());
//			builder.append("		</div>\r\n");
//			builder.append("		<div align=\"left\">\r\n");
//			builder.append("			Modelo: \r\n");
//			builder.append(carro.getModelo());
//			builder.append("		</div>\r\n");
//			builder.append("		<div align=\"left\">\r\n");
//			builder.append("			Ano: \r\n");
//			builder.append(carro.getAnoModelo());
//			builder.append("		</div>\r\n");
//			builder.append("		<div align=\"left\">\r\n");
//			builder.append("			Data de Cadastro: \r\n");
//			builder.append(localDate);
//			builder.append("		</div>\r\n");
//			builder.append("		<div align=\"left\">\r\n");
//			builder.append("			<br/>\r\n");
//			builder.append(
//					"			Agora seu veículo está liberado para ter acesso livre ao nosso estabelecimento.\r\n");
//			builder.append("		</div>\r\n");
//			builder.append("		<div align=\"left\">\r\n");
//			builder.append("			<br/>\r\n");
//			builder.append("		</div>\r\n");
//			builder.append("		<div align=\"left\">\r\n");
//			builder.append("			<br/>\r\n");
//			builder.append("		</div>\r\n");
//			builder.append("		<div align=\"left\">\r\n");
//			builder.append("		</div>\r\n");
//			builder.append("	</body>\r\n");
//			builder.append("</html>\r\n");
//
//			helper.setText(builder.toString(), true);
//			emailSender.send(mensagemCadastro);
//
//		} catch (MessagingException e) {
//			e.printStackTrace();
//		}
//
//	}
//
//	public void envioEmailEncerramentoCarro(PessoaDTO pessoa) {
//		MimeMessage mensagemCadastro = emailSender.createMimeMessage();
//
//		try {
//			MimeMessageHelper helper = new MimeMessageHelper(mensagemCadastro, true);
//			helper.setFrom("victorsoares.c@gmail.com");
//			helper.setTo(pessoa.getEmail());
//			helper.setSubject("Encerramento de Conta!");
//
//			StringBuilder builder = new StringBuilder();
//			builder.append("<html>\r\n");
//			builder.append("	<body>\r\n");
//			builder.append("		<div align=\"center\">\r\n");
//			builder.append("			<h1>Confirmação de Exclusão de veículo</h1>\r\n");
//			builder.append("		</div>\r\n");
//			builder.append("		<br/>\r\n");
//			builder.append("		<div align=\"left\">\r\n");
//			builder.append("			Olá ");
//			builder.append(pessoa.getNome());
//			builder.append(",\r\n");
//			builder.append("		</div>\r\n");
//			builder.append("		<div align=\"left\">\r\n");
//			builder.append("			<br/>\r\n");
//			builder.append("			Informamos que seu carro foi descadastrado.\r\n");
//			builder.append("		</div>\r\n");
//			builder.append("		<div align=\"left\">\r\n");
//			builder.append("			<br/>\r\n");
//			builder.append(
//					"			Reforçamos que seu Carro cadastrado não terá mais acesso ao nosso estabelecimento.\r\n");
//			builder.append("		</div>\r\n");
//			builder.append("		<div align=\"left\">\r\n");
//			builder.append("			<br/>\r\n");
//			builder.append("			");
//			builder.append(
//					"			Se quiser, você pode reativar ou recadastrar um novo veículo a qualquer momento em nosso sistema.\r\n");
//			builder.append("		</div>\r\n");
//			builder.append("	</body>\r\n");
//			builder.append("</html>\r\n");
//
//			helper.setText(builder.toString(), true);
//			emailSender.send(mensagemCadastro);
//
//		} catch (MessagingException e) {
//			e.printStackTrace();
//		}
//
//	}
//
//	public void envioEmailAtivacaoCarro(PessoaDTO pessoaDTO, CarroDTO carro) {
//		MimeMessage mensagemCadastro = emailSender.createMimeMessage();
//
//		try {
//			MimeMessageHelper helper = new MimeMessageHelper(mensagemCadastro, true);
//			helper.setFrom("victorsoares.c@gmail.com");
//			helper.setTo(pessoaDTO.getEmail());
//			helper.setSubject("Ativacao de Conta de Cliente!");
//
//			StringBuilder builder = new StringBuilder();
//
//			builder.append("<html>\r\n");
//			builder.append("	<body>\r\n");
//			builder.append("		<div align=\"center\">\r\n");
//			builder.append("		<img src=\"cid:logo6\">\r\n");
//			builder.append("			<h1>Ativação de Conta</h1>\r\n");
//			builder.append("		</div>\r\n");
//			builder.append("		<br/>\r\n");
//			builder.append("		<div align=\"left\">\r\n");
//			builder.append("			Olá \r\n");
//			builder.append(pessoaDTO.getNome());
//			builder.append("		</div>\r\n");
//			builder.append("		<div align=\"left\">\r\n");
//			builder.append("			<br/>\r\n");
//			builder.append("			Reativamos o cadadtro de seu veículo, confira as informações:\r\n");
//			builder.append("		</div>\r\n");
//			builder.append("		<div align=\"left\">\r\n");
//			builder.append("			<br/>\r\n");
//			builder.append("			Marca: \r\n");
//			builder.append(carro.getMarca());
//			builder.append("		</div>\r\n");
//			builder.append("		<div align=\"left\">\r\n");
//			builder.append("			Modelo: \r\n");
//			builder.append(carro.getModelo());
//			builder.append("		</div>\r\n");
//			builder.append("		<div align=\"left\">\r\n");
//			builder.append("			Ano: \r\n");
//			builder.append(carro.getAnoModelo());
//			builder.append("		</div>\r\n");
//			builder.append(
//					"			Caso tenha alguma dúvida ou precise de assistência, nossa equipe de suporte está à disposição para ajudá-lo.\r\n");
//			builder.append("		</div>\r\n");
//			builder.append("	</body>\r\n");
//			builder.append("</html>\r\n");
//
//			helper.setText(builder.toString(), true);
//			emailSender.send(mensagemCadastro);
//
//		} catch (MessagingException e) {
//			e.printStackTrace();
//		}
//
//	}
//
}