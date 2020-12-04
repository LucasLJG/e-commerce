import java.util.ArrayList;

public class Usuario {
	private int identificador;
	private String nome;
	private String email;
	private String senha;
	private ArrayList<Pedido> pedidos;
	
	public Usuario(int identificador, String nome, String email, String senha) {
		this.identificador = identificador;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		pedidos = new ArrayList<Pedido>();
	}

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}
	
	
}
