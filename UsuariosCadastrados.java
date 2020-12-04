import java.util.ArrayList;

public class UsuariosCadastrados {
	private ArrayList<Usuario> usuariosCadastrados;
	private ArrayList<Usuario> usuariosAtivos;
	private ArrayList<Usuario> usuariosInativos;
	private static int quantidadeUsuarios = 0;
	
	public UsuariosCadastrados() {
		usuariosCadastrados = new ArrayList<Usuario>();
		usuariosAtivos = new ArrayList<Usuario>();
		usuariosInativos = new ArrayList<Usuario>();
	}

	public ArrayList<Usuario> getUsuariosCadastrados() {
		return usuariosCadastrados;
	}

	public ArrayList<Usuario> getUsuariosAtivos() {
		return usuariosAtivos;
	}

	public ArrayList<Usuario> getUsuariosInativos() {
		return usuariosInativos;
	}

	public static int getQuantidadeUsuarios() {
		return quantidadeUsuarios;
	}
	
	
	
}
