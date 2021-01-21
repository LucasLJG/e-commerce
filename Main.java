import java.util.GregorianCalendar;
import java.util.ArrayList;
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
		identificador_usuario++;
		
		Perfil perfil_admin2 = new Perfil(Sexo.MULHER, new GregorianCalendar(1980, 12, 15), Estado.SAO_PAULO.getCapital(), Estado.SAO_PAULO, "11 98547-7584", "456XXXXXXXXX/74");
		Administrador admin2 = new Administrador(identificador_usuario, "Clarice Lopes", "clarice_lopes@gmail.com", "cyberpunk2077", perfil_admin2, true);
		
		identificador_usuario++;
		Perfil perfil_usuarioComum = new Perfil(Sexo.MULHER, new GregorianCalendar(1976,10,12), Estado.SAO_PAULO.getCapital(), Estado.SAO_PAULO, "11 98756-9687", "486XXXXXXXXX/75");
		UsuarioComum usuarioComum1 = new UsuarioComum(identificador_usuario, "Nicole Dantas", "nicoledantas@outlook.com", "nick789", perfil_usuarioComum, true);
		
		admin1.criarCadastro(admin1);
		admin1.getCadastroUsuarios().setDono(admin1);
		admin1.criarCadastro(admin2);
		admin1.criarCadastro(usuarioComum1);
		
		
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception erro) {
			System.out.println("Erro: " + erro.getMessage());
		}
		
		// AUTENTICACAO DO ADMINISTRADOR DO SISTEMA.
		
		admin1.autenticarAcesso(admin1.getSenha());
		
		String nome = null;
		String compras = null;
		String cadastro = null;
		int opcaoUsuario;
		
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception erro) {
			System.out.println("Erro: " + erro.getMessage());
		}
		opcaoUsuario = JOptionPane.showConfirmDialog(null,"Bem vindo ao Prime Store! Gostaria de cadastrar um usuario ? ");
		if (opcaoUsuario == JOptionPane.YES_OPTION) {
			cadastro = "S";
		}
		else if (opcaoUsuario == JOptionPane.NO_OPTION || opcaoUsuario == JOptionPane.CANCEL_OPTION) {
			cadastro = "N";
		}
		else {
			System.exit(0);
		}
		
		while(cadastro.equals("S")) {
			identificador_usuario++;
			identificador_pedido++;
			
			nome = JOptionPane.showInputDialog("Digite seu nome: ");
			
			if(nome == null || nome.isEmpty()) {
				JOptionPane.showMessageDialog(null,"O nome nao pode ser um campo vazio!", "Campo vazio", JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			}
			
			String email = null;
			email = JOptionPane.showInputDialog("Digite seu email: ");
			if(email == null || email.isEmpty()) {
				JOptionPane.showMessageDialog(null, "O email nao pode ser um campo vazio!", "Campo vazio", JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			}
			
			String senha = null;
			senha = JOptionPane.showInputDialog("Digite sua senha: ");
			if(senha == null || senha.isEmpty()) {
				JOptionPane.showMessageDialog(null, "A senha nao pode ser um campo vazio!", "Campo vazio", JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			}
			
			int opcaoSexo;
			Object[] opcao = {"Masculino","Feminino"};
			opcaoSexo = JOptionPane.showOptionDialog(null,"Selecione seu sexo: ", "Escolha do sexo do usuario", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null ,opcao, opcao);
			String opcao_sexo = null;
			if (opcaoSexo == 0) {
				opcao_sexo = "H";
			}
			else if (opcaoSexo == 1) {
				opcao_sexo = "M";
			}
			else { 
				System.exit(0);
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
				else if (opcaoUsuario == JOptionPane.NO_OPTION){
					compras = "N";
				}
				else {
					System.exit(0);
				}

				while(compras.equals("S")) {
					
					Object[] itens = {"Celular", "Notebook", "Camera Fotografica","Oculos", "Impressora", "Lapis", "Caderno", "Caneta", "Agenda"};
					Object itemSelecionado = JOptionPane.showInputDialog(null, "Selecione o produto desejado: ","Selecao de Produtos", JOptionPane.INFORMATION_MESSAGE, null, itens, itens);
					Item.listar_catalogo(lista_itens);
					int mercadoria = 0;
					for(int i = 0; i < itens.length; i ++)
					{
						if (itemSelecionado == itens[i])
						{
							mercadoria = i;
						}
					}
					
					ArrayList<Item> lista_auxiliar;
					lista_auxiliar = new ArrayList<Item>();
									
					String quantidade_mercadoria;
					int quantidade=0;
					
					quantidade_mercadoria = JOptionPane.showInputDialog(null," Quantos deseja comparar?");
					try {
						quantidade=Integer.parseInt(quantidade_mercadoria);
					} catch (Exception erro) {
						System.exit(0); 
					}
					
					//INSTANCIACAO DE UM NOVO ITEM BASEADO NO PRODUTO ESCOLHIDO PELO USUARIO.
					Item auxiliar = new Item(lista_itens.get(mercadoria).getNome(), lista_itens.get(mercadoria).getCodigo(), 
							lista_itens.get(mercadoria).getQuantidade(), lista_itens.get(mercadoria).getPrecoUnitario(), 
							lista_itens.get(mercadoria).getEstoqueDisponivel(), true, lista_auxiliar);
					
					//ADICIONAR ITEM AO PEDIDO DO USUARIO.
					user1.adicionaItem(auxiliar, pedido1_user1, quantidade);
					
					//ATUALIZAR CAPACIDADE DO ESTOQUE.
					lista_itens.get(mercadoria).setEstoqueDisponivel(auxiliar.getEstoqueDisponivel());
					
					opcaoUsuario = JOptionPane.showConfirmDialog(null," Gostaria de comprar mais produtos ?");
					if (opcaoUsuario == JOptionPane.YES_OPTION) {
						compras = "S";
					}
					else if (opcaoUsuario == JOptionPane.NO_OPTION){
						compras = "N";
					}
					else {
						System.exit(0);
					}
					
				}
				Caixa total = new Caixa(1, true);
				System.out.printf("\n\nDados de Usuario: \n");
				System.out.println(user1);
				System.out.println("Dados de perfil do Usuario: ");
				System.out.println(perfil_user1);
				System.out.println("****************************************************************************");
				
				//CASO O ITEM NAO FOR VAZIO, SOLICITAR FORMA DE PAGAMENTO.
				if (user1.getPedidos().get(0).getItem().isEmpty() == false) {
					Object[] formaDePagamento = {"Pagamento a vista","Pagamento Parcelado"};
					int opcaoPagamento;
					opcaoPagamento = JOptionPane.showOptionDialog(null,"Selecione o tipo de pagamento: ", "Forma de Pagamento", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null , formaDePagamento, formaDePagamento);
					if (opcaoPagamento == 0) { // PAGAMENTO A VISTA.
						total.pagamentoVista(user1);
					}
					else if (opcaoPagamento == 1) { // PAGAMENTO PARCELADO.
						total.pagamentoParcelado(user1);
					}
					else {
						System.exit(0);
					}
					System.out.println("\n****************************************************************************\n");
				}
			}
			
			opcaoUsuario = JOptionPane.showConfirmDialog(null,"Gostaria de cadastrar mais usuarios no sistema ?");
			if (opcaoUsuario == JOptionPane.YES_OPTION) {
				cadastro = "S";
			}
			if (opcaoUsuario == JOptionPane.NO_OPTION || opcaoUsuario == JOptionPane.CANCEL_OPTION) {
				cadastro = "N";
			}
			
			if (cadastro.equals("N")) {
				System.out.println("Cadastro de usuarios encerrado. ");
			}
		}
		
		// USUARIO UTILIZANDO A INTERFACE IMPLEMENTADA NA CLASSE USUARIOCOMUM.
		usuarioComum1.autenticarAcesso(usuarioComum1.getSenha());
		
		// RECUPERANDO A SENHA DE UM USUARIO COMUM USANDO O ADMINISTRADOR DO SISTEMA.
		opcaoUsuario = JOptionPane.showConfirmDialog(null,"Gostaria de recuperar a senha de " + usuarioComum1.getNome() + " ?");
		if (opcaoUsuario == JOptionPane.YES_OPTION) {
			usuarioComum1.recuperar_senha(usuarioComum1.getEmail());
		}
		else if (opcaoUsuario == JOptionPane.NO_OPTION || opcaoUsuario == JOptionPane.CANCEL_OPTION) {
			// NAO FAZ NADA.
		}
		
		System.out.println("****************************************************************************");
			
		//LISTA DE USUARIOS CADASTRADOS.
		System.out.println(admin1.getCadastroUsuarios());
		System.out.println("Usuarios cadastrados: " + Administrador.getQuantidadeUsuarios());
		
		System.out.println("****************************************************************************\n");
		
		
		// GRAVACAO E LEITURA DE ARQUIVOS.

		// SALVANDO OS DADOS DE USUARIOS EM ARQUIVO.
		String nomeDoArquivo = "cadastroUsuarios.dat";
		Usuario.gravarArquivosEmBinario(admin1.getCadastroUsuarios().getUsuariosCadastrados(), nomeDoArquivo);
		
		// LENDO OS DADOS DE USUARIOS GRAVADOS EM ARQUIVO.
		System.out.println("Lendo os dados de usuarios cadastrados no sistema: ");
		Usuario.lerArquivosEmBInario(nomeDoArquivo);
		
		
	}
}
