import java.util.Scanner;
import java.util.GregorianCalendar;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
	
		
		ArrayList<Item> lista_itens;
		lista_itens = new ArrayList<Item>();
		
		int identificador_usuario = 1589;
		int identificador_pedido = 1547;

		
		Fornecedor fabricante_notebook = new Fornecedor(48258, "Notebook SA", 50, true);
		Fornecedor fabricante_celular = new Fornecedor(87156, "Celular Inc.", 50, true);
		Fornecedor fabricante_camera = new Fornecedor(91754, "Cameras SA", 50, true);
		Fornecedor fabricante_oculos = new Fornecedor(37180, "Oculos Inc", 200, true);
		Fornecedor fabricante_impressora = new Fornecedor(21352, "Impressora SA", 50, true);
		Fornecedor fabricante_lapis = new Fornecedor(11378, "Lapis Inc", 5000, true);
		Fornecedor fabricante_caderno = new Fornecedor(51127, "Caderno SA", 1000, true);
		Fornecedor fabricante_caneta = new Fornecedor(91025, "Caneta Inc", 4000, true);
		Fornecedor fabricante_agenda = new Fornecedor(18798, "Agenda SA", 500, true);

		/* 
		* Instanciando itens
		*/
		
		Item celular = new Item(" Celular", 64368, 1, 1800.00f, 25, true, fabricante_celular, lista_itens);
		Item notebook = new Item(" Notebook", 58794, 1, 3200.00f, 15, true, fabricante_notebook, lista_itens);
		Item camera_fotografica = new Item(" Camera Fotografica", 74185, 1, 1500.00f, 10, true, fabricante_camera, lista_itens);
		Item oculos = new Item(" Oculos", 17463, 2, 300.50f, 50, true, fabricante_oculos, lista_itens);
		Item impressora = new Item(" Impressora", 87465, 1, 700.00f, 8, true, fabricante_impressora, lista_itens);
		Item lapis = new Item(" Lapis", 78549, 5, 1.15f, 1000, true, fabricante_lapis, lista_itens);
		Item caderno = new Item(" Caderno", 41208, 2, 8.50f, 250, true, fabricante_caderno, lista_itens);
		Item caneta = new Item (" Caneta", 58971, 3, 1.75f, 850, true, fabricante_caneta, lista_itens);
		Item agenda = new Item(" Agenda", 37148, 1, 11.75f, 150, true, fabricante_agenda, lista_itens);
		

		
		Scanner leitor = new Scanner(System.in);
		

		
		Perfil perfil_admin1 = new Perfil(Sexo.HOMEM, new GregorianCalendar(1987, 12, 21), Estado.MINAS_GERAIS.getCapital(), Estado.MINAS_GERAIS, "15 88888-8888", "123XXXXXXXXX/89");
		Administrador admin1 = new Administrador(identificador_usuario, "Rafael Santos", "rafael_santos@gmail.com", "12345678", perfil_admin1, true);
		
		Perfil perfil_admin2 = new Perfil(Sexo.MULHER, new GregorianCalendar(1980, 12, 15), Estado.SAO_PAULO.getCapital(), Estado.SAO_PAULO, "11 98547-7584", "456XXXXXXXXX/74");
		Administrador admin2 = new Administrador(identificador_usuario, "Clarice Lopes", "clarice_lopes@gmail.com", "cyberpunk2077", perfil_admin2, true);
		admin1.criarCadastro(admin1);
		admin1.getCadastroUsuarios().setDono(admin1);
		admin1.criarCadastro(admin2);
		
		
		System.out.println("Bem vindo ao American Prime. Gostaria de se cadastrar? (S/N)");
		String opcao_usuario = leitor.nextLine();
		while (opcao_usuario.equals("S") == false  && opcao_usuario.equals("N") == false) {
			System.out.println("Entrada invalida, Digite S ou N para acessar sua opcao.");
			System.out.println("Bem vindo ao American Prime. Gostaria de se cadastrar? (S/N)");
			opcao_usuario = leitor.nextLine();
		}
		
		String cadastro = opcao_usuario;
		while(cadastro.equals("S")) {
			identificador_usuario++;
			identificador_pedido++;
			System.out.println("Digite seu nome completo");
			String nome = leitor.nextLine();
			while (nome.isEmpty()) {
				System.out.println("Entrada invalida. Digite seu nome completo");
				nome = leitor.nextLine();
			}
			
			System.out.println("Digite seu email");
			String email = leitor.nextLine();
			while (email.isEmpty()) {
				System.out.println("Entrada invalida. Digite seu email");
				email = leitor.nextLine();
			}
			
			System.out.println("Digite sua senha");
			String senha = leitor.nextLine();
			while (senha.isEmpty()) {
				System.out.println("Entrada invalida. Digite sua senha");
				senha = leitor.nextLine();
			}
			
			System.out.println("Digite seu sexo: (H/M)");
			String opcao_sexo = leitor.nextLine();
			while (opcao_sexo.equals("H") == false && opcao_sexo.equals("M") == false) {
				System.out.println("Opcao invalida. Digite seu sexo: (H/M)");
				opcao_sexo = leitor.nextLine();
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
				Usuario user1 = new Usuario(identificador_usuario, nome, email, senha, perfil_user1, true);
				Pedido pedido1_user1 = new Pedido(identificador_pedido, "Loja X", new GregorianCalendar(2020, 12, 5), true);
				user1.getPedidos().add(pedido1_user1);
				admin1.criarCadastro(user1);
				Item.listar_catalogo(lista_itens);
				
				System.out.println("\nGostaria de adquirir um produto (S/N)");
				String compras = leitor.nextLine();
				
				while (compras.equals("S") == false  && compras.equals("N") == false) {
					System.out.println("Entrada invalida.");
					System.out.println("Gostaria de adquirir um produto (S/N)");
					compras = leitor.nextLine();
				}
				ArrayList<Item> lista_auxiliar;
				lista_auxiliar = new ArrayList<Item>();
				
				while(compras.equals("S")) {
					
					System.out.println("Selecione o produto");
					String opcao_mercadoria;
					opcao_mercadoria = leitor.nextLine();
					boolean condicao = true;
					while (condicao) {
						switch(opcao_mercadoria) {
						case "0":
							condicao = false;
							break;
						case "1":
							condicao = false;
							break;
						case "2":
							condicao = false;
							break;
						case "3":
							condicao = false;
							break;
						case "4":
							condicao = false;
							break;
						case "5":
							condicao = false;
							break;
						case "6":
							condicao = false;
							break;
						case "7":
							condicao = false;
							break;
						case "8":
							condicao = false;
							break;
						default:
							System.out.println("Opcao invalida. Digite um numero no intervalo [0,8] para escolher seu produto: ");
							opcao_mercadoria = leitor.nextLine();
						}
					}
					
					int mercadoria = Integer.parseInt(opcao_mercadoria);
					
					
					System.out.println("Selecione a quantidade");
					int quantidade;
					String quantidade_mercadoria = leitor.nextLine();
					while(Pedido.ehInteiro(quantidade_mercadoria) == false || quantidade_mercadoria.isEmpty() == true) {
						System.out.println("Entrada invalida. Selecione a quantidade");
						quantidade_mercadoria = leitor.nextLine();
					}
					System.out.println(quantidade_mercadoria);
					quantidade = Integer.parseInt(quantidade_mercadoria);
					
					
					//instanciacao de um novo item baseado no produto escolhido
					Item auxiliar = new Item(lista_itens.get(mercadoria).getNome(), lista_itens.get(mercadoria).getCodigo(), 
							lista_itens.get(mercadoria).getQuantidade(), lista_itens.get(mercadoria).getPrecoUnitario(), 
							lista_itens.get(mercadoria).getEstoqueDisponivel(), true, fabricante_celular, lista_auxiliar);
					
					//adicionar item ao pedido do usuario
					user1.adicionaItem(auxiliar, pedido1_user1, quantidade);
					
					//alterar estoque dos itens da lista de itens
					lista_itens.get(mercadoria).setEstoqueDisponivel(auxiliar.getEstoqueDisponivel());
					
					
					System.out.println("\nGostaria de adquirir mais produtos (S/N)");
					compras = leitor.nextLine();
					while (compras.equals("S") == false  && compras.equals("N") == false) {
						System.out.println("Entrada invalida. Gostaria de adquirir mais produtos (S/N)");
						compras = leitor.nextLine();
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
					System.out.println("Qual a forma de pagamento ? \n1 - Pagamento a vista \n2 - Pagamento parcelado");
					String opcaoPagamento = leitor.nextLine();
					while (opcaoPagamento.equals("1") == false && opcaoPagamento.equals("2") == false) {
						System.out.println("Entrada invalida, Digite 1 ou 2 para acessar sua opcao. \n");
						System.out.println("Qual a forma de pagamento ? \n1 - Pagamento a vista \n2 - Pagamento parcelado");
						opcaoPagamento = leitor.nextLine();
					}
					if (opcaoPagamento.equals("1")) {
						total.pagamentoVista(user1);
					}
					else {
						total.pagamentoParcelado(user1);
					}
					System.out.println("\n****************************************************************************\n");
				}
			}

			System.out.println("Gostaria de cadastrar mais alguem ? (S/N)");
			cadastro = leitor.nextLine();
			while (cadastro.equals("S") == false  && cadastro.equals("N") == false) {
				System.out.println("Entrada invalida");
				System.out.println("Gostaria de cadastrar mais alguem ? (S/N)");
				cadastro = leitor.nextLine();
			}
			if (cadastro.equals("N")) {
				System.out.println("Cadastro de clientes encerrado. ");
			}
		}
		
		System.out.println("****************************************************************************");
			
		//lista de usuarios cadastrados
		System.out.println(admin1.getCadastroUsuarios());
		System.out.println("Usuários cadastrados: " + Administrador.getQuantidadeUsuarios());
		
		System.out.println("****************************************************************************\n");
		System.out.println("Operacao finalizada. \n");
		
		leitor.close();
		
		
	}
}

