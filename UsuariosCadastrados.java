import java.util.ArrayList;
import java.io.Serializable;

public class UsuariosCadastrados implements Serializable {
	private static final long serialVersionUID = 303L;
	private Administrador dono;
	private ArrayList<Usuario> usuariosCadastrados;
	
	public UsuariosCadastrados() {
		usuariosCadastrados = new ArrayList<Usuario>();
	}

	public ArrayList<Usuario> getUsuariosCadastrados() {
		return usuariosCadastrados;
	}
	
	public Administrador getDono() {
		return dono;
	}

	public void setDono(Administrador dono) {
		this.dono = dono;
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
