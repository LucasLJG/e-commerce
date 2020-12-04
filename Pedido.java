import java.util.ArrayList;

public class Pedido {
	private int numero;
	private String nomeVendedor;
	private Data dia;
	private ArrayList<Item> item;
	private boolean status;
	
	public Pedido(int numero, String nomeVendedor, Data dia, boolean status) {
		this.numero = numero;
		this.nomeVendedor = nomeVendedor;
		this.dia = dia;
		this.status = status;
		item = new ArrayList<Item>();
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}
