import java.util.ArrayList;

public class Pedido {
	private int codigo;
	private String nomeVendedor;
	private Data dia;
	private ArrayList<Item> item;
	private boolean status;
	
	public Pedido(int codigo, String nomeVendedor, Data dia, boolean status) {
		this.codigo = codigo;
		this.nomeVendedor = nomeVendedor;
		this.dia = dia;
		this.status = status;
		item = new ArrayList<Item>();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNomeVendedor() {
		return nomeVendedor;
	}

	public void setNomeVendedor(String nomeVendedor) {
		this.nomeVendedor = nomeVendedor;
	}

	public Data getDia() {
		return dia;
	}

	public void setDia(Data dia) {
		this.dia = dia;
	}

	public ArrayList<Item> getItem() {
		return item;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		if (this.getItem().isEmpty()) {
			String out = "Não há itens em pedidos do usuário \n";
			return out;
		}
		else {
			if (this.getStatus() == false) {
				String out = "Pedido desativado \n"; 
				return out;
			}
			else {
				String out = "";
				out = out + "Código do Pedido: " + getCodigo() + "\n";
				out = out + "Nome do Vendedor: " + getNomeVendedor() + "\n";
				int k = 1;
				out = out + "Itens do Pedido: ";
				for (Item item_atual: this.getItem()) {
					out = out + "Item " + k + "\n";
					out = out + "Nome: " + item_atual.getNome() + "\n";
					k++;
				}
				return out;
			}
		}
	}
	
	
}
