import java.util.ArrayList;

public class Item {
	private String nome;
	private int codigo;
	private int quantidade;
	private float precoUnitario;
	private int estoqueDisponivel;
	private boolean status;
	private ArrayList<Fornecedor> fornecedores;
	
	//todo item instanciado eh adicionado a lista de itens
	public Item(String nome, int codigo, int quantidade, float precoUnitario, int estoqueDisponivel, boolean status, Fornecedor fornecedor, ArrayList<Item> lista_itens) {
		this.nome = nome;
		this.codigo = codigo;
		this.quantidade = quantidade;
		this.precoUnitario = precoUnitario;
		this.estoqueDisponivel = estoqueDisponivel;
		this.status = status;
		fornecedores = new ArrayList<Fornecedor>();
		fornecedores.add(fornecedor);
		lista_itens.add(this);
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
	
	public static void listar_catalogo(ArrayList<Item> lista_itens) {
		System.out.println("\nLista de produtos: ");	
		for(int i = 0; i < lista_itens.size(); i++) {
			System.out.println(i + "-" + lista_itens.get(i).getNome() + " - " + "preco: R$: " + lista_itens.get(i).getPrecoUnitario() + 
					" - " + "quantidade: " + lista_itens.get(i).getEstoqueDisponivel());	
		}
	}
	
	public void reposicao_estoque() { // rep�em o estoque quando restar 50 unidades
		if(this.getEstoqueDisponivel() < 50) {
			this.setEstoqueDisponivel(fornecedores.get(0).getQuantidadeDisponivel());
		}
	}

	
	@Override
	public String toString() {
		String out = "";
		out = out + "Nome do Item: " + getNome() + "\n";
		out = out + "Codigo: " + getCodigo() + "\n";
		out = out + "Quantidade: " + getQuantidade() + "\n";
		out = out + "Preco Unitário: " + getPrecoUnitario() + "\n";
		out = out + "Estoque Disponivel: " + getEstoqueDisponivel() + "\n";
		out = out + "Status: " + getStatus() + "\n";
		if (this.getFornecedores().isEmpty()) {
			out = out + "Os fornecedores estao temporariamente indisponiveis para esse item";
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
