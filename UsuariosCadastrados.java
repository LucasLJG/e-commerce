import java.util.ArrayList;

public class UsuariosCadastrados {
	private ArrayList<Usuario> usuariosCadastrados;
	
	public UsuariosCadastrados() {
		usuariosCadastrados = new ArrayList<Usuario>();
	}

	public ArrayList<Usuario> getUsuariosCadastrados() {
		return usuariosCadastrados;
	}
	
	@Override
	public String toString() {
		if (this.getUsuariosCadastrados().isEmpty()) {
			String out = "Não há usuários cadastrados na plataforma \n";
			return out; 
		}
		else {
			String out = "";
			int i = 1;
			out = out + "Usuários Cadastrados: \n";
			for (Usuario usuario_atual: this.getUsuariosCadastrados()) {
				out = out + "Usuário " + i + ": " + usuario_atual.getNome() + " \n";
				i++;
			}
			return out;
		}
	}
	
}
