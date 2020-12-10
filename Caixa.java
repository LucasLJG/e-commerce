import java.util.ArrayList;
import java.util.Scanner;

public class Caixa {
	// Atributos das Classes
	private int codigo;
	private ArrayList<Usuario> usuarios;
	private boolean status;
	
	// Contrutor da classe.
	public Caixa(int codigo, boolean status) {
		usuarios = new ArrayList<Usuario>();
		this.codigo = codigo;
		this.status = status;
	}
	
	// Metetodos para acessar e modificar o atributo codigo.
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	// Metodos para acessar e modificar o atributo Usuario.
	public ArrayList<Usuario> getUsuario() {
		return usuarios;
	}
	public void setUsuario(ArrayList<Usuario> usuario) {
		this.usuarios = usuario;
	}
	
	//Metodos para acessar e modificar o atributo Status.
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	/* 
	 * O metodo pagamentoVista retorna um valor a ser cobrado do usuario na sua compra com um desconto de 5%.
	 * Em geral, esse metodo percorre o array de pedidos pertecente ao usuario, percorre o array de Itens, detro de 
	 * cada posicao da array de pedidos, e soma o [precoUnitario * Quantidade] de cada posicao do array de Itens para 
	 * calcular o preco total da atual pedido. Depois armazena esse valor em um novo array (precos) na mesma posicao do
	 * pedido atual. A funcao retorna a variavel armagenadora.
	 */
	public ArrayList<Double> pagamentoVista (Usuario cliente) {
		ArrayList<Pedido> pedidos  = cliente.getPedidos(); 
		ArrayList<Double> precos = new ArrayList<Double>();
		double preco = 0;
		// Percorrendo o array pedidos e itens.
		for (Pedido pedido: pedidos) {
			for (Item item: pedido.getItem()) {
				// Somando [precoUnitario * Quantidade].
				preco += item.getPrecoUnitario() * item.getQuantidade();
			}
			// Aplicando o desconto e armazenando.
			preco = preco * 0.95;
			precos.add(preco);
		}
		return precos;
	}
	
	/* 
	 * O metodo pagamentoParcelado retorna o valor da parcela a ser cobrado do usuario na sua compra.
	 * Em geral, esse metodo pergunta para o Usuario quantas parcelas ele quer. Depois percorre o 
	 * array de pedidos pertecente ao usuario, depois percorre o array de Itens, detro de cada 
	 * posicao da array de pedidos, e soma o [precoUnitario * Quantidade] de cada posicao do array 
	 * de Itens para calcular o preco total da atual pedido e depois divide pelo numero de parcelas.
	 * Por fim, armazena esse valor em um novo array (precos) na mesma posicao dopedido atual. 
	 * A funcao retorna a variavel armagenadora sendo a ultima posicao o numero de parcelas.
	 */
	public ArrayList<Double> pagamentoParcelado (Usuario cliente) {
		double parcelas;
		double preco = 0;		
		ArrayList<Pedido> pedidos  = cliente.getPedidos();
		ArrayList<Double> precos = new ArrayList<Double>();
		// Perguntando o numero de parcelas.
		Scanner ler = new Scanner(System.in);
		System.out.println("Escolha o numero de parcelas entre as opcoes abaixo digitando o numero entre []:");
		System.out.println("[1]: 3 parcelas\n[2]: 6 parcelas\n[3]: 9 parcelas\n[4]: 12 parcelas");
		int tipo = ler.nextInt();
		if (tipo == 1) parcelas = 3;
		else if (tipo == 2) parcelas = 6;
		else if (tipo == 3) parcelas = 9;
		else if (tipo == 4) parcelas = 12;
		else parcelas = 1;
		// Percorrendo o array pedidos e itens.
		for (Pedido pedido: pedidos) {
			for (Item item: pedido.getItem()) {
				// Somando [precoUnitario * Quantidade].
				preco += item.getPrecoUnitario() * item.getQuantidade();
			}
			// Calculando o valor de parcelas e armazenando.
			preco = preco / parcelas;
			precos.add(preco);
		}
		precos.add(parcelas);
		return precos;
	}
	
	// Metodo ToString().
	public String ToString() {
		String geral = "Informacoes do Caixa.";
		geral += "Codigo:" + this.getCodigo() + "\n";
		geral += "Usuarios:";
		for (Usuario usuario: this.usuarios)
		{
			geral += usuario.getNome();
		}
		geral += "\n";
		geral += "Status:" + this.getStatus() + "\n";
		return geral;
	}
}
