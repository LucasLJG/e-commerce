import java.util.ArrayList;

public class Caixa {
	private int codigo;
	private ArrayList<Usuario> usuario;
	private boolean status;
	
	public Caixa(int codigo, boolean status) {
		usuario = new ArrayList<Usuario>();
		this.codigo = codigo;
		this.status = status;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public ArrayList<Usuario> getUsuario() {
		return usuario;
	}
	
	
}
