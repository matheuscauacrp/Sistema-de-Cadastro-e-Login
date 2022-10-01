package com.projeto.moto.service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.projeto.moto.model.Usuario;
import com.projeto.moto.repository.UsuarioRepository;

@Service
public class UsuarioService {

	private UsuarioRepository usuarioRepository;

	private PasswordEncoder passwordEncoder;

	/* Ao invés de Autowired podemos usar um construtor */
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
		this.passwordEncoder = new BCryptPasswordEncoder();
	}

	public List<Usuario> listaUsuario() {
		List<Usuario> lista = usuarioRepository.findAll();
		return lista;
	}

	public Usuario criaUsuario(Usuario usuario) {
		String encoder = this.passwordEncoder.encode(usuario.getSenha()); /* Criptografa a senha */
		usuario.setSenha(encoder);/* Seta a senha criptografada */
		Usuario novoUsuario = usuarioRepository.save(usuario);
		return novoUsuario;
	}

	public Usuario atualizaUsuario(Usuario usuario) {
		String encoder = this.passwordEncoder.encode(usuario.getSenha()); /* Criptografa a senha */
		usuario.setSenha(encoder);/* Seta a senha criptografada */
		Usuario novoUsuario = usuarioRepository.save(usuario);
		return novoUsuario;
	}

	public boolean excluiUsuario(Integer id) {
		usuarioRepository.deleteById(id);
		return true;
	}

	public boolean validarSenha(Usuario usuario) { /* Valida a senha para login */
		String senha = usuarioRepository.getById(usuario.getId()).getSenha();
		boolean valid = passwordEncoder.matches(usuario.getSenha(), senha);
		return valid;
	}
}
