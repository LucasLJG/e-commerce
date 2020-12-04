import java.util.ArrayList;

public class Item {
	private int codigo;
	private int quantidade;
	private float precoUnitario;
	private int estoqueDisponivel;
	private int capacidade;
	private boolean status;
	private ArrayList<Fornecedor> fornecedores;
	
	public Item(int codigo, int quantidade, int precoUnitario, int estoqueDisponivel, int capacidade, boolean status) {
		this.codigo = codigo;
		this.quantidade = quantidade;
		this.precoUnitario = precoUnitario;
		this.estoqueDisponivel = estoqueDisponivel;
		this.capacidade = capacidade;
		this.status = status;
		fornecedores = new ArrayList<Fornecedor>();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public float getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(float precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public int getEstoqueDisponivel() {
		return estoqueDisponivel;
	}

	public void setEstoqueDisponivel(int estoqueDisponivel) {
		this.estoqueDisponivel = estoqueDisponivel;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public ArrayList<Fornecedor> getFornecedores() {
		return fornecedores;
	}
	
	
	
	
}
