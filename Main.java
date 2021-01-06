import java.util.Scanner;
import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.io.*;
import javax.swing.*;

public class Main {


	public static void main(String[] args) {
		
	
		
		ArrayList<Item> lista_itens;
		lista_itens = new ArrayList<Item>();
		
		int identificador_usuario = 1589;
		int identificador_pedido = 1547;
		
		Item celular = new Item(" Celular", 64368, 1, 1800.00f, 25, true, lista_itens);
		Item notebook = new Item(" Notebook", 58794, 1, 3200.00f, 15, true, lista_itens);
		Item camera_fotografica = new Item(" Camera Fotografica", 74185, 1, 1500.00f, 10, true, lista_itens);
		Item oculos = new Item(" Oculos", 17463, 2, 300.50f, 50, true, lista_itens);
		Item impressora = new Item(" Impressora", 87465, 1, 700.00f, 8, true, lista_itens);
		Item lapis = new Item(" Lapis", 78549, 5, 1.15f, 1000, true, lista_itens);
		Item caderno = new Item(" Caderno", 41208, 2, 8.50f, 250, true, lista_itens);
		Item caneta = new Item (" Caneta", 58971, 3, 1.75f, 850, true, lista_itens);
		Item agenda = new Item(" Agenda", 37148, 1, 11.75f, 150, true, lista_itens);

		
		Perfil perfil_admin1 = new Perfil(Sexo.HOMEM, new GregorianCalendar(1987, 12, 21), Estado.MINAS_GERAIS.getCapital(), Estado.MINAS_GERAIS, "15 88888-8888", "123XXXXXXXXX/89");
		Administrador admin1 = new Administrador(identificador_usuario, "Rafael Santos", "rafael_santos@gmail.com", "react2021", perfil_admin1, true);
		
		Perfil perfil_admin2 = new Perfil(Sexo.MULHER, new GregorianCalendar(1980, 12, 15), Estado.SAO_PAULO.getCapital(), Estado.SAO_PAULO, "11 98547-7584", "456XXXXXXXXX/74");
		Administrador admin2 = new Administrador(identificador_usuario, "Clarice Lopes", "clarice_lopes@gmail.com", "cyberpunk2077", perfil_admin2, true);
		
		// AUTENTICANDO UM ADMIN NO SISTEMA.
		admin1.criarCadastro(admin1);
		admin1.getCadastroUsuarios().setDono(admin1);
		admin1.criarCadastro(admin2);
		
		String nome;
		String senhaAutenticacao;
		
		// FAZER A AUTENTICACAO DO ADMINISTRADOR NO SISTEMA (PEDIR A SENHA).
		
		/*
		senhaAutenticacao = JOptionPane.showInputDialog("É preciso autenticação do Administrador para entrar no sistema. Por favor digite a senha: ");
		if (admin1.autenticarAcesso(senhaAutenticacao) == true) {
			JOptionPane.showMessageDialog(null, "Acesso autorizado ao sistema.");
		}
		else {
			 JOptionPane.showMessageDialog(null, JOptionPane.ERROR_MESSAGE, "Senha inválida. Acesso ao sistema negado!");
		}
		*/
		
		Scanner leitor = new Scanner(System.in);
		String compras = null;
		String cadastro = null;
		int opcaoUsuario;
		
		// INTERFACE GRAFICA 
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception erro) {
			System.out.println("Erro: " + erro.getMessage());
		}
		opcaoUsuario = JOptionPane.showConfirmDialog(null,"Bem vindo ao Prime Store! Gostaria de cadastrar um usuário ? ");
		if (opcaoUsuario == JOptionPane.YES_OPTION) {
			cadastro = "S";
		}
		if (opcaoUsuario == JOptionPane.NO_OPTION || opcaoUsuario == JOptionPane.CANCEL_OPTION) {
			cadastro = "N";
		}
		
		// E PRECISO TRATAR CASO QUANDO O USUARIO CLICA NO BOTAO CANCELAR OU CLICA NO X PRA FECHAR A CAIXA DE DIALOGO.
		
		while(cadastro.equals("S")) {
			identificador_usuario++;
			identificador_pedido++;
			
			nome = JOptionPane.showInputDialog("Digite seu nome: ");
			
			String email;
			email = JOptionPane.showInputDialog("Digite seu email: ");
			
			String senha;
			senha = JOptionPane.showInputDialog("Digite sua senha: ");
			
			int opcaoSexo;
			Object[] opcao = {"Masculino","Feminino"};
			opcaoSexo = JOptionPane.showOptionDialog(null,"Selecione seu sexo: ", "Escolha do sexo do usuário", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null ,opcao, opcao);
			String opcao_sexo = null;
			if (opcaoSexo == 0) {
				opcao_sexo = "H";
			}
			if (opcaoSexo == 1) {
				opcao_sexo = "M";
			}
			else { 
				// E PRECISO TRATAR CASO QUANDO O USUARIO CLICA NO BOTAO CANCELAR OU CLICA NO X PRA FECHAR A CAIXA DE DIALOGO.
			}
			
			if (opcao_sexo.equals("H") || opcao_sexo.equals("M")) {
				Sexo sexo;
				if(opcao_sexo.equals("M")) {
					sexo = Sexo.MULHER;
				}
				else {
					sexo = Sexo.HOMEM;
				}
				Perfil perfil_user1 = new Perfil(sexo, new GregorianCalendar(1998, 05, 22), Estado.SAO_PAULO.getCapital(), Estado.SAO_PAULO, "19 99999-9999", "257XXXXXXXXX/55");
				Usuario user1 = new UsuarioComum(identificador_usuario, nome, email, senha, perfil_user1, true);
				Pedido pedido1_user1 = new Pedido(identificador_pedido, "Loja X", new GregorianCalendar(2020, 12, 5), true);
				user1.getPedidos().add(pedido1_user1);
				admin1.criarCadastro(user1);
				
				opcaoUsuario = JOptionPane.showConfirmDialog(null,"Gostaria de comprar um produto ? ");
				if (opcaoUsuario == JOptionPane.YES_OPTION) {
					compras = "S";
				}
				if (opcaoUsuario == JOptionPane.NO_OPTION){
					compras = "N";
				}
				else {
					// E PRECISO TRATAR CASO QUANDO O USUARIO CLICA NO BOTAO CANCELAR OU CLICA NO X PRA FECHAR A CAIXA DE DIALOGO.
				}
				
				Object[] itens = {"Celular", "Notebook", "Câmera Fotográfica","Óculos", "Impressora", "Lápis", "Caderno", "Caneta", "Agenda"};
				Object itemSelecionado = JOptionPane.showInputDialog(null, "Selecione o produto desejado: ","Seleção de Produtos", JOptionPane.INFORMATION_MESSAGE, null, itens, itens);
				//Item.listar_catalogo(lista_itens);
				
				ArrayList<Item> lista_auxiliar;
				lista_auxiliar = new ArrayList<Item>();
				
				while(compras.equals("S")) {
					
					String opcao_mercadoria;
					opcao_mercadoria = leitor.nextLine();
					
					
					
					int mercadoria = Integer.parseInt(opcao_mercadoria);
					
					// FAZER A INTERFACE GRAFICA DE SELECIONAR QUANTIDADE DE CADA PRODUTO. IDEIA: USAR JSLIDER.
					
					System.out.println("Selecione a quantidade: ");
					String quantidade_mercadoria = leitor.nextLine();
					int quantidade;
					while(Pedido.ehInteiro(quantidade_mercadoria) == false || quantidade_mercadoria.isEmpty() == true) {
						System.out.println("Entrada inválida. Selecione a quantidade: ");
						quantidade_mercadoria = leitor.nextLine();
					}
					quantidade = Integer.parseInt(quantidade_mercadoria);
					
					
					//instanciacao de um novo item baseado no produto escolhido
					Item auxiliar = new Item(lista_itens.get(mercadoria).getNome(), lista_itens.get(mercadoria).getCodigo(), 
							lista_itens.get(mercadoria).getQuantidade(), lista_itens.get(mercadoria).getPrecoUnitario(), 
							lista_itens.get(mercadoria).getEstoqueDisponivel(), true, lista_auxiliar);
					
					//adicionar item ao pedido do usuario
					user1.adicionaItem(auxiliar, pedido1_user1, quantidade);
					
					//alterar estoque dos itens da lista de itens
					lista_itens.get(mercadoria).setEstoqueDisponivel(auxiliar.getEstoqueDisponivel());
					
					opcaoUsuario = JOptionPane.showConfirmDialog(null,"Gostaria de comprar mais produtos ?");
					if (opcaoUsuario == JOptionPane.YES_OPTION) {
						compras = "S";
					}
					if (opcaoUsuario == JOptionPane.NO_OPTION){
						compras = "N";
					}
					else {
						// E PRECISO TRATAR CASO QUANDO O USUARIO CLICA NO BOTAO CANCELAR OU CLICA NO X PRA FECHAR A CAIXA DE DIALOGO.
					}
					
				}
				Caixa total = new Caixa(1, true);
				System.out.printf("Dados de Usuario: \n");
				System.out.println(user1);
				System.out.println("Dados de perfil do Usuario: ");
				System.out.println(perfil_user1);
				System.out.println("****************************************************************************");
				
				//caso o item nao for vazio, solicitar forma de pagamento
				if (user1.getPedidos().get(0).getItem().isEmpty() == false) {
					Object[] formaDePagamento = {"Pagamento à vista","Pagamento Parcelado"};
					int opcaoPagamento;
					opcaoPagamento = JOptionPane.showOptionDialog(null,"Selecione seu sexo: ", "Forma de Pagamento", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null , formaDePagamento, formaDePagamento);
					if (opcaoPagamento == 0) { // PAGAMENTO A VISTA
						total.pagamentoVista(user1);
					}
					if (opcaoPagamento == 1) { // PAGAMENTO PARCELADO
						total.pagamentoParcelado(user1);
					}
					else {
						// E PRECISO TRATAR CASO QUANDO O USUARIO CLICA NO BOTAO CANCELAR OU CLICA NO X PRA FECHAR A CAIXA DE DIALOGO.
					}
					System.out.println("\n****************************************************************************\n");
				}
			}
			
			opcaoUsuario = JOptionPane.showConfirmDialog(null,"Gostaria de cadastrar mais usuários no sistema ?");
			if (opcaoUsuario == JOptionPane.YES_OPTION) {
				cadastro = "S";
			}
			if (opcaoUsuario == JOptionPane.NO_OPTION || opcaoUsuario == JOptionPane.CANCEL_OPTION) {
				cadastro = "N";
			}
			
			if (cadastro.equals("N")) {
				System.out.println("Cadastro de usuários encerrado. ");
			}
		}
		
		System.out.println("****************************************************************************");
			
		//lista de usuarios cadastrados
		System.out.println(admin1.getCadastroUsuarios());
		System.out.println("Usuários cadastrados: " + Administrador.getQuantidadeUsuarios());
		
		System.out.println("****************************************************************************\n");
		
		
		// E PRECISO CONSERTAR A FUNCAO DE ARQUIVOS. GRAVAR OU LER NAO ESTA FUNCIONANDO DIREITO.
		/*
		// SALVANDO OS DADOS DE USUARIOS EM ARQUIVO.
		String nomeDoArquivo = "cadastroUsuarios.dat";
		Usuario.gravarArquivosEmBinario(admin1.getCadastroUsuarios().getUsuariosCadastrados(), nomeDoArquivo);
		
		// LENDO OS DADOS DE USUARIOS GRAVADOS EM ARQUIVO.
		System.out.println("Lendo os dados de usuários cadastrados no sistema: ");
		Usuario.lerArquivosEmBInario(nomeDoArquivo);
		
		
		System.out.println("Operação finalizada. \n");
		*/
	}
}
