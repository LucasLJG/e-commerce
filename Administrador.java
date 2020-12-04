import java.util.ArrayList;

public class Administrador extends Usuario{
	private ArrayList<UsuariosCadastrados> usuariosCadastrados;
	
	public Administrador(int identificador, String nome, String email, String senha, Perfil perfil) {
		super(identificador, nome, email, senha, perfil);
		usuariosCadastrados = new ArrayList<UsuariosCadastrados>();
	}

	public ArrayList<UsuariosCadastrados> getUsuariosCadastrados() {
		return usuariosCadastrados;
	}
	
}
