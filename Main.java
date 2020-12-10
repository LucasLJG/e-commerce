import java.util.Scanner;
import java.util.GregorianCalendar;


public class Main {

	public static void main(String[] args) {
		
		/* 
		* Instanciando itens
		*/
		Item celular = new Item("Celular", 64368, 1, 1800.00f, 25, true);
		Item notebook = new Item("Notebook", 58794, 1, 3200.00f, 15, true);
		Item camera_fotografica = new Item("Camera Fotografica", 74185, 1, 1500.00f, 10, true);
		Item oculos = new Item("Óculos", 17463, 2, 300.50f, 50, true);
		Item impressora = new Item("Impressora", 87465, 1, 700.00f, 8, true);
		Item lapis = new Item("Lápis", 78549, 5, 1.15f, 1000, true);
		Item caderno = new Item("Caderno", 41208, 2, 8.50f, 250, true);
		Item caneta = new Item ("Caneta", 58971, 3, 1.75f, 850, true);
		Item agenda = new Item("Agenda", 37148, 1, 11.75f, 150, true);
		
		
		Scanner leitor = new Scanner(System.in);
		
		Perfil perfil_admin1 = new Perfil(Sexo.HOMEM, new GregorianCalendar(2020, 12, 8), Estado.MINAS_GERAIS.getCapital(), Estado.MINAS_GERAIS, "15 88888-8888", "123XXXXXXXXX/89");
		Administrador admin1 = new Administrador(2, "Rafael Santos", "rafael_santos@mail.com", "12345678", perfil_admin1, true);
		
		System.out.println("Bem vindo. Gostaria de se cadastrar? (S/N)");
		String cadastro = leitor.nextLine();
		if(cadastro.equals("S")) {
			
			System.out.println("Digite seu nome completo");
			String nome = leitor.nextLine();
			
			System.out.println("Digite seu email");
			String email = leitor.nextLine();
			
			System.out.println("Digite sua senha");
			String senha = leitor.nextLine();
			
			System.out.println("Selecione seu gênero (M/F)");
			String genero = leitor.nextLine();
			Sexo sexo = null;
			if(genero.equals(Sexo.HOMEM.getSigla())) {
				sexo = Sexo.HOMEM;
			}
			if (genero.equals(Sexo.MULHER.getSigla())) {
				sexo = Sexo.MULHER;
			}
			
			System.out.println("Informe sua data de nascimento (dd/mm/aaaa)");
			String dataNascimento [] = leitor.nextLine().split("/"); 
			int dia = Integer.parseInt(dataNascimento[0]);
			int mes = Integer.parseInt(dataNascimento[1]);
			int ano = Integer.parseInt(dataNascimento[2]);
			
			Perfil perfil_user1 = new Perfil(sexo, new GregorianCalendar(ano, mes, dia), Estado.SÃO_PAULO.getCapital(), Estado.SÃO_PAULO, "19 99999-9999", "257XXXXXXXXX/55");		
			Usuario user1 = new Usuario(1, nome, email, senha, perfil_user1, true);
			
			
			//criar cadastro de user1
			admin1.criarCadastro(user1);
			
			Pedido pedido1_user1 = new Pedido(1, "Carlos", new GregorianCalendar(2020, 12, 5), true);
			user1.getPedidos().add(pedido1_user1);
			
			pedido1_user1.getItem().add(celular);
			pedido1_user1.getItem().add(oculos);
			pedido1_user1.getItem().add(agenda);
			
			//novo pedido de user1
			Pedido pedido2_user1 = new Pedido(3, "Antonio", new GregorianCalendar(2020, 12, 8), true);
			user1.getPedidos().add(pedido2_user1);
			pedido2_user1.getItem().add(caneta);
			pedido2_user1.getItem().add(caderno);
			
			System.out.printf("\n\nDados de %s\n", user1.getNome());
			System.out.println(user1);
			System.out.println(perfil_user1);
		}
		else {
			System.out.println("Usuario nao deseja se cadastrar\n");
		}
			

			Perfil perfil_user2 = new Perfil(Sexo.MULHER, new GregorianCalendar(1995, 11, 10), Estado.ALAGOAS.getCapital(), Estado.ALAGOAS, "82 88888-8888", "742XXXXXXXXX/35");		
			Usuario user2 = new Usuario(1, "Giovanna Nogueira", "giovanna.nogueira@email.com", "giovanna1234", perfil_user2, true);
			admin1.criarCadastro(user2);
			
			Pedido pedido1_user2 = new Pedido(2, "Antonio", new GregorianCalendar(2020, 12, 7), true);
			user2.getPedidos().add(pedido1_user2);
			
			pedido1_user2.getItem().add(impressora);
			pedido1_user2.getItem().add(lapis);
			pedido1_user2.getItem().add(camera_fotografica);
			
			
			
			//Criando novos pedidos para user2
			
			
			Pedido pedido2_user2 = new Pedido(4, "Carlos", new GregorianCalendar(2020, 12, 8), true);
			user2.getPedidos().add(pedido2_user2);
			pedido2_user2.getItem().add(notebook);
			
			System.out.printf("Dados de %s\n", user2.getNome());
			System.out.println(user2);
			System.out.println(perfil_user2);
			
			
			//remover usuario
			admin1.removerCadastro(user2);
			System.out.println(admin1.getCadastroUsuarios());
			
			
			
			//alterar senha
			user2.alterar_senha("giovanna.nogueira@email.com", "giovanna1234");

			leitor.close();

	}
}

