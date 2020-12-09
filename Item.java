import java.util.ArrayList;

public class Item {
	private String nome;
	private int codigo;
	private int quantidade;
	private float precoUnitario;
	private int estoqueDisponivel;
	private boolean status;
	private ArrayList<Fornecedor> fornecedores;
	
	public Item(String nome, int codigo, int quantidade, int precoUnitario, int estoqueDisponivel, boolean status) {
		this.nome = nome;
		this.codigo = codigo;
		this.quantidade = quantidade;
		this.precoUnitario = precoUnitario;
		this.estoqueDisponivel = estoqueDisponivel;
		this.status = status;
		fornecedores = new ArrayList<Fornecedor>();
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public ArrayList<Fornecedor> getFornecedores() {
		return fornecedores;
	}
	
	public void reposicao_estoque(ArrayList<Fornecedor> fornecedores) { // repoe o estoque para 50 itens
		int i = 0;
		while (fornecedores.isEmpty() != true) {
			if (fornecedores.get(i).getQuantidadeDisponivel() != 0) {
				this.setEstoqueDisponivel(this.getEstoqueDisponivel() + fornecedores.get(i).getQuantidadeDisponivel());
				fornecedores.get(i).setQuantidadeDisponivel(0);
				if (this.getEstoqueDisponivel() > 50) {
					break;
				}
			}
			i++;
		}
	}
	
	@Override
	public String toString() {
		String out = "";
		out = out + "Nome do Item: " + getNome() + "\n";
		out = out + "Código: " + getCodigo() + "\n";
		out = out + "Quantidade: " + getQuantidade() + "\n";
		out = out + "Preço Unitário: " + getPrecoUnitario() + "\n";
		out = out + "Estoque Disponível: " + getEstoqueDisponivel() + "\n";
		out = out + "Status: " + getStatus() + "\n";
		if (this.getFornecedores().isEmpty()) {
			out = out + "Os fornecedores estão temporariamente indisponíveis para esse item";
		}
		else {
			int j = 1;
			for (Fornecedor fornecedor_item: this.getFornecedores()) {
				out = out + "Fornecedor" + j;
				out = out + "Nome: " + fornecedor_item.getNome() + "\n";
				j++;
			}
		}
		return out;
	}
	
}
