import java.util.Scanner;
import java.util.GregorianCalendar;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		/* 
		* Instanciando itens
		*/
		
		ArrayList<Item> lista_itens;
		lista_itens = new ArrayList<Item>();
		

		
		Fornecedor fabricante_notebook = new Fornecedor(48258, "Notebook SA", 50, true);
		Fornecedor fabricante_celular = new Fornecedor(87156, "Celular Inc.", 50, true);
		Fornecedor fabricante_camera = new Fornecedor(91754, "Cameras SA", 50, true);
		Fornecedor fabricante_oculos = new Fornecedor(37180, "Oculos Inc", 200, true);
		Fornecedor fabricante_impressora = new Fornecedor(21352, "Impressora SA", 50, true);
		Fornecedor fabricante_lapis = new Fornecedor(11378, "Lapis Inc", 5000, true);
		Fornecedor fabricante_caderno = new Fornecedor(51127, "Caderno SA", 1000, true);
		Fornecedor fabricante_caneta = new Fornecedor(91025, "Caneta Inc", 4000, true);
		Fornecedor fabricante_agenda = new Fornecedor(18798, "Agenda SA", 500, true);

		Item celular = new Item("Celular", 64368, 1, 1800.00f, 25, true, fabricante_notebook, lista_itens);
		Item notebook = new Item("Notebook", 58794, 1, 3200.00f, 15, true, fabricante_celular, lista_itens);
		Item camera_fotografica = new Item("Camera Fotografica", 74185, 1, 1500.00f, 10, true, fabricante_camera, lista_itens);
		Item oculos = new Item("Oculos", 17463, 2, 300.50f, 50, true, fabricante_oculos, lista_itens);
		Item impressora = new Item("Impressora", 87465, 1, 700.00f, 8, true, fabricante_impressora, lista_itens);
		Item lapis = new Item("Lapis", 78549, 5, 1.15f, 1000, true, fabricante_lapis, lista_itens);
		Item caderno = new Item("Caderno", 41208, 2, 8.50f, 250, true, fabricante_caderno, lista_itens);
		Item caneta = new Item ("Caneta", 58971, 3, 1.75f, 850, true, fabricante_caneta, lista_itens);
		Item agenda = new Item("Agenda", 37148, 1, 11.75f, 150, true, fabricante_agenda, lista_itens);
		

		
		Scanner leitor = new Scanner(System.in);

		
		Perfil perfil_admin1 = new Perfil(Sexo.HOMEM, new GregorianCalendar(2020, 12, 8), Estado.MINAS_GERAIS.getCapital(), Estado.MINAS_GERAIS, "15 88888-8888", "123XXXXXXXXX/89");
		Administrador admin1 = new Administrador(2, "Rafael Santos", "rafael_santos@gmail.com", "12345678", perfil_admin1, true);
		admin1.criarCadastro(admin1);
		
		
		System.out.println("Bem vindo. Gostaria de se cadastrar? (S/N)");
		String cadastro = leitor.nextLine();
		while(cadastro.equals("S")) {
			
			System.out.println("\nDigite seu nome completo");
			String nome = leitor.nextLine();
			
			System.out.println("\nDigite seu email");
			String email = leitor.nextLine();
			
			System.out.println("\nDigite sua senha");
			String senha = leitor.nextLine();

			
			
			Perfil perfil_user1 = new Perfil(Sexo.HOMEM, new GregorianCalendar(1998, 05, 22), Estado.SAO_PAULO.getCapital(), Estado.SAO_PAULO, "19 99999-9999", "257XXXXXXXXX/55");		
			Usuario user1 = new Usuario(1, nome, email, senha, perfil_user1, true);
			
			Pedido pedido1_user1 = new Pedido(1, "Loja X", new GregorianCalendar(2020, 12, 5), true);
			user1.getPedidos().add(pedido1_user1);
			
			//cadastro de user1
			admin1.criarCadastro(user1);
			
			
			Item.listar_catalogo(lista_itens);
			
			System.out.println("\nGostaria de adquirir um produto (S/N)");
			
			String compras = leitor.nextLine();
			while(compras.equals("S")) {
				System.out.println("\nSelecione o produto e quantidade (produto - quantidade)");
				String carrinho[] = leitor.nextLine().split(" - ");
				int pedido = Integer.parseInt(carrinho[0]);
				int quantidade = Integer.parseInt(carrinho[1]);
				pedido1_user1.getItem().add(lista_itens.get(pedido));
				lista_itens.get(pedido).setQuantidade(quantidade);
				
			
				
				System.out.println("\nGostaria de adquirir mais produtos (S/N)");
				compras = leitor.nextLine();
				}
			
			Caixa total = new Caixa(1, true);
			
			System.out.printf("\n\nDados de %s\n", user1.getNome());
			System.out.println(user1);
			System.out.println(perfil_user1);
			//System.out.println("Preco a vista: " + total.pagamentoVista(user1) + "\n");
			//System.out.println("\nPreco parcelado: " + total.pagamentoParcelado(user1));
			
			System.out.println("\n****************************************************************************");
			
			System.out.println("\n\nBem vindo. Gostaria de se cadastrar? (S/N)");
			cadastro = leitor.nextLine();
		}
			
			System.out.println("\n****************************************************************************");
			
			Perfil perfil_user2 = new Perfil(Sexo.MULHER, new GregorianCalendar(1995, 11, 10), Estado.ALAGOAS.getCapital(), Estado.ALAGOAS, "82 88888-8888", "742XXXXXXXXX/35");		
			Usuario user2 = new Usuario(1, "Giovanna Nogueira", "giovanna.nogueira@email.com", "giovanna1234", perfil_user2, true);
			admin1.criarCadastro(user2);
			
			Pedido pedido1_user2 = new Pedido(2, "Loja W", new GregorianCalendar(2020, 12, 7), true);
			user2.getPedidos().add(pedido1_user2);
			
			
			pedido1_user2.getItem().add(impressora);
			pedido1_user2.getItem().add(lapis);
			pedido1_user2.getItem().add(camera_fotografica);
			
			
			
			//novo pedido de user2
			Pedido pedido2_user2 = new Pedido(4, "Loja Z", new GregorianCalendar(2020, 12, 8), true);
			user2.getPedidos().add(pedido2_user2);
			pedido2_user2.getItem().add(notebook);
			
			Caixa total_user2 = new Caixa(1, true);
			
			System.out.printf("Dados de Usuario: \n");
			System.out.println(user2);
			System.out.println("Dados de perfil do Usuario: ");
			System.out.println(perfil_user2);
						
			System.out.println("****************************************************************************");
			System.out.println("Qual a forma de pagamento ? \n1 - Pagamento a vista \n2 - Pagamento parcelado");
			Scanner formaPagamento = new Scanner(System.in);
			int opcaoPagamento = formaPagamento.nextInt();
			while (opcaoPagamento != 1  && opcaoPagamento != 2) {
				System.out.println("Entrada invalida, Digite 1 ou 2 para acessar sua opcao. \n");
				System.out.println("Qual a forma de pagamento ? \n1 - Pagamento a vista \n2 - Pagamento parcelado");
				opcaoPagamento = formaPagamento.nextInt();
			}
			if (opcaoPagamento == 1) {
				System.out.println("Pagamento a vista: ");
				total_user2.pagamentoVista(user2);
			}
			else {
				System.out.println("Pagamento parcelado: ");
				total_user2.pagamentoParcelado(user2);
			}
			formaPagamento.close();
			
			System.out.println("\n****************************************************************************\n");
			
			//remover usuario
			System.out.println("O " + admin1.getNome() + " removeu o usuario: " + user2.getNome());
			admin1.removerCadastro(user2);
			
			//lista de usuarios cadastrados
			System.out.println(admin1.getCadastroUsuarios() + "\n");

			leitor.close();

	}
}
