import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public class Pedido implements Serializable {
	private static final long serialVersionUID = 300L;
	private int codigo;
	private String nomeVendedor;
	private Calendar dataPedido;
	private ArrayList<Item> item;
	private boolean status;
	
	public Pedido(int codigo, String nomeVendedor, Calendar dataPedido, boolean status) {
		this.codigo = codigo;
		this.nomeVendedor = nomeVendedor;
		this.dataPedido = dataPedido;
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

	public Calendar getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Calendar dataPedido) {
		this.dataPedido = dataPedido;
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
	
	public static boolean ehInteiro(String quantidade) {
		char[] array_char = quantidade.toCharArray();
		boolean ehInteiro = true;
		
		for(int i = 0; i < array_char.length; i++) {
			if(!Character.isDigit(array_char[i])) {
				ehInteiro = false;
				break;
			}
		}
		return ehInteiro;
	}
	
	@Override
	public String toString() {
		if (this.getItem().isEmpty()) {
			String out = "Nao ha itens em pedidos do usuario \n";
			return out;
		}
		else {
			if (this.getStatus() == false) {
				String out = "Pedido desativado \n"; 
				return out;
			}
			else {
				String out = "";
				out = out + "Codigo do Pedido: " + getCodigo() + "\n";
				out = out + "Nome do Vendedor: " + getNomeVendedor() + "\n";
				int k = 1;
				out = out + "Itens do Pedido: ";
				for (Item item_atual: this.getItem()) {
					out = out + "Item: " + k + item_atual.getNome() + "\n";
					k++;
				}
				return out;
			}
		}
	}
	
	
}
