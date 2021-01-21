import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Caixa {
	// Atributos das Classes
	private int codigo;
	private boolean status;
	
	// Contrutor da classe.
	public Caixa(int codigo, boolean status) {
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
	public void pagamentoVista (Usuario cliente) {
		
		ArrayList<Pedido> pedidos  = cliente.getPedidos(); 
		ArrayList<BigDecimal> precos = new ArrayList<BigDecimal>();
		double preco = 0;
		// Percorrendo o array pedidos e itens.
		for (Pedido pedido: pedidos) {
			for (Item item: pedido.getItem()) {
				// Somando [precoUnitario * Quantidade].
				preco += item.getPrecoUnitario() * item.getQuantidade();
				 
				System.out.println("Preco sem desconto, R$: " + item.getPrecoUnitario() * item.getQuantidade());
			}
			// Aplicando o desconto e armazenando.
			preco = preco * 0.95;
			BigDecimal preco_corrigido = new BigDecimal(preco).setScale(2, RoundingMode.HALF_EVEN);
			precos.add(preco_corrigido);
		}
		System.out.println("Pagamento a vista: desconto de 5% no valor total do pedido. ");
		for (int i = 0; i < precos.size(); i++) {
			System.out.println("Valor do pedido com desconto: " + "R$ " + precos.get(i));
		}
	}
	
	/* 
	 * O metodo pagamentoParcelado retorna o valor da parcela a ser cobrado do usuario na sua compra.
	 * Em geral, esse metodo pergunta para o Usuario quantas parcelas ele quer. Depois percorre o 
	 * array de pedidos pertecente ao usuario, depois percorre o array de Itens, detro de cada 
	 * posicao da array de pedidos, e soma o [precoUnitario * Quantidade] de cada posicao do array 
	 * de Itens para calcular o preco total da atual pedido e depois divide pelo numero de parcelas.
	 * Por fim, armazena esse valor em um novo array (precos) na mesma posicao dopedido atual. 
	 * A funcao retorna a variavel armazenadora sendo a ultima posicao o numero de parcelas.
	 */
	public ArrayList<BigDecimal> pagamentoParcelado (Usuario cliente) {
		double parcela;
		double preco = 0;		
		ArrayList<Pedido> pedidos  = cliente.getPedidos();
		ArrayList<BigDecimal> precos = new ArrayList<BigDecimal>();
		// Perguntando o numero de parcelas.
		Object[] aux = {"3", "6", "9", "12"};
		Object tipo = JOptionPane.showInputDialog(null, "Selecione a quantidade de parcelas desejado: ","Selecao da quantidade de parcelas", JOptionPane.INFORMATION_MESSAGE, null, aux, aux);
		if (tipo.equals("3")) parcela = 3;
		else if (tipo.equals("6")) parcela = 6;
		else if (tipo.equals("9")) parcela = 9;
		else parcela = 12;
		// Percorrendo o array pedidos e itens.
		for (Pedido pedido: pedidos) {
			for (Item item: pedido.getItem()) {
				// Somando [precoUnitario * Quantidade].
				preco += item.getPrecoUnitario() * item.getQuantidade();
			}
			// Calculando o valor de parcelas e armazenando.
			preco = preco / parcela;
			BigDecimal preco_corrigido = new BigDecimal(preco).setScale(2, RoundingMode.HALF_EVEN);

			precos.add(preco_corrigido);
			
		}
		
		BigDecimal parcelas_corrigidas = new BigDecimal(parcela).setScale(0, RoundingMode.HALF_EVEN);
		precos.add(parcelas_corrigidas);
		System.out.println("Pagamento parcelado, sem cobranca de juros. Os valores das parcelas do pedido conforme a sua escolha. ");
		for (int j = 0; j < precos.size() - 1; j++) {
			System.out.println("Pedido parcelado em " + parcelas_corrigidas + " vezes. Valor de cada parcela: R$ " + precos.get(j));
		}
		return precos;
	}
	
	// Metodo ToString().
	public String ToString() {
		String geral = "Informacoes do Caixa.";
		geral += "Codigo:" + this.getCodigo() + "\n";
		geral += "Status:" + this.getStatus() + "\n";
		return geral;
	}
}