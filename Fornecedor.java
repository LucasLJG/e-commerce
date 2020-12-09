
public class Fornecedor {
	private int codigo;
	private String nome;
	private int quantidadeDisponivel;
	private boolean status;
	
	public Fornecedor(int codigo, String nome, int quantidadeDisponivel, boolean status) {
		this.codigo = codigo;
		this.nome = nome;
		this.quantidadeDisponivel = quantidadeDisponivel;
		this.status = status;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantidadeDisponivel() {
		return quantidadeDisponivel;
	}

	public void setQuantidadeDisponivel(int quantidadeDisponivel) {
		this.quantidadeDisponivel = quantidadeDisponivel;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public String toString() {
		String out = "";
		out = out + "Nome do Fornecedor: " + getNome() + "\n";
		out = out + "Código: " + getCodigo() + "\n";
		out = out + "Quantidade Disponível: " + getQuantidadeDisponivel() + "\n";
		out = out + "Status:" + getStatus() + "\n";
		return out;
	}
	
	
}
