import java.util.ArrayList;

public class UsuariosCadastrados {
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
			String out = "Nao ha usuarios cadastrados na plataforma \n";
			return out; 
		}
		else {
			String out = "";
			int i = 1;
			out = out + "Usuarios Cadastrados: \n";
			for (Usuario usuario_atual: this.getUsuariosCadastrados()) {
				out = out + "Usuario " + i + ": " + usuario_atual.getNome() + " \n";
				i++;
			}
			return out;
		}
	}
	
}
