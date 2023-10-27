package br.com.api.trabalho.controllers;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.trabalho.config.JWTUtil;
import br.com.api.trabalho.dto.LoginDTO;
import br.com.api.trabalho.dto.UserDTO;
import br.com.api.trabalho.entities.Endereco;
import br.com.api.trabalho.entities.Pessoa;
import br.com.api.trabalho.entities.Role;
import br.com.api.trabalho.entities.User;
import br.com.api.trabalho.enums.TipoRoleEnum;
import br.com.api.trabalho.repositories.EnderecoRepository;
import br.com.api.trabalho.repositories.RoleRepository;
import br.com.api.trabalho.services.EmailService;
import br.com.api.trabalho.services.EnderecoService;
import br.com.api.trabalho.services.PessoaService;
import br.com.api.trabalho.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	private EmailService emailService;

	@Autowired
	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}

	@Autowired
	UserService userService;

	@Autowired
	EnderecoRepository enderecoRepository;

	@Autowired
	PessoaService pessoaService;

	@Autowired
	EnderecoService enderecoService;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	private JWTUtil jwtUtil;

	@Autowired
	private AuthenticationManager authManager;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping("/registro")
	public ResponseEntity<String> cadastro(@RequestParam String email, @Valid @RequestBody UserDTO user) {

		Set<String> strRoles = user.getRole();
		Set<Role> role = new HashSet<>();

		Endereco viaCep = enderecoService.pesquisarEndereco(user.getCep());
		Endereco enderecoNovo = new Endereco();
		enderecoNovo.setBairro(viaCep.getBairro());
		enderecoNovo.setCep(user.getCep());
		enderecoNovo.setComplemento(user.getComplementoAdicional());
		enderecoNovo.setLocalidade(viaCep.getLocalidade());
		enderecoNovo.setLogradouro(viaCep.getLogradouro());
		enderecoNovo.setNumero(user.getNumero());
		enderecoNovo.setUf(viaCep.getUf());
		enderecoRepository.save(enderecoNovo);

		if (strRoles == null) {
			Role userRole = roleRepository.findByName(TipoRoleEnum.ROLE_PESSOA)
					.orElseThrow(() -> new RuntimeException("Erro: Role não encontrada."));
			role.add(userRole);
		} else {

			User usuarioResumido = new User();
			String encodedPass = passwordEncoder.encode(user.getSenha());
			usuarioResumido.setEmail(user.getEmail());
			usuarioResumido.setRole(role);
			usuarioResumido.setSenha(encodedPass);
			userService.save(usuarioResumido);

			Pessoa pessoa = new Pessoa();
			pessoa.setCpf(user.getCpf());
			pessoa.setEmail(user.getEmail());
			pessoa.setNome(user.getNome());
			pessoa.setDataNascimento(user.getDataNascimento());
			pessoa.setNumeroCnh(user.getNumeroCnh());
			pessoa.setCategoriaHab(user.getCategoriaHab());
			pessoa.setTelefoneFixo(user.getTelefoneFixo());
			pessoa.setCelular(user.getCelular());
			pessoa.setEndereco(enderecoNovo);
			pessoa.setSenha(encodedPass);
			pessoa.setUser(usuarioResumido);
			pessoaService.salvar(pessoa);

			emailService.envioEmailCadastro(user);

		}
		return ResponseEntity.status(HttpStatus.CREATED).body("Cadastro efetuado com sucesso!");
	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@Valid @RequestBody LoginDTO body) {
		try {
			UsernamePasswordAuthenticationToken authInputToken = new UsernamePasswordAuthenticationToken(
					body.getEmail(), body.getSenha());

			authManager.authenticate(authInputToken);

			User user = userService.findByEmail(body.getEmail());
			User usuarioResumido = new User();
			usuarioResumido.setEmail(user.getEmail());
			usuarioResumido.setIdUser(user.getIdUser());
			usuarioResumido.setRole(user.getRole());
			String token = jwtUtil.generateTokenWithUserData(usuarioResumido);

			return ResponseEntity.status(HttpStatus.OK).body("Login efetuado com sucesso!\n\nToken:\n\n" + token);
		} catch (AuthenticationException authExc) {
			throw new RuntimeException("Credenciais Invalidas");
		}
	}
}
