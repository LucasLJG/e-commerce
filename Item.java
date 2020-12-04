
public class Item {
	private int codigo;
	private int quantidade;
	private float precoUnitario;
	
	public Item(int codigo, int quantidade, int precoUnitario) {
		this.codigo = codigo;
		this.quantidade = quantidade;
		this.precoUnitario = precoUnitario;
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
	
}
