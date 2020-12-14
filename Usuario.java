import java.util.ArrayList;
import java.util.Scanner;
public class Usuario {
	private int identificador;
	private String nome;
	private String email;
	private String senha;
	private ArrayList<Pedido> pedidos;
	private Perfil perfil;
	private boolean status;
	
	public Usuario(int identificador, String nome, String email, String senha, Perfil perfil, boolean status) {
		this.identificador = identificador;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.perfil = perfil;
		this.status = status;
		pedidos = new ArrayList<Pedido>();
	}

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	
	public boolean getStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public void recuperar_senha(String email) {
		
		if(this.getStatus() == true) {
		
			if (this.getEmail() == email) {
				System.out.println("Digite o numero do seu cpf para confirmacao de autenticidade: \n");
				Scanner dados = new Scanner(System.in);
				String entrada = dados.nextLine();
				dados.close();
				if (this.getPerfil().getCpf().equals(entrada) == true) {
					System.out.println("Senha: ");
					System.out.println(this.getSenha());
				}
				else {
					System.out.println("Numero de CPF invalido. \n");
				}
			}
			else{
				System.out.println("Endereco de e-mail invalido. \n");
			}
		}
		else {
			System.out.println("Usuario desativado. \n");
		}
	}
	
	public void alterar_senha(String email, String senha) {
		
		if(status == true) {
			
			if (this.getEmail().equals(email)== true && this.getSenha().equals(senha) == true) {
				System.out.println("Como medida adicional de seguranca, por favor digite o numero de seu CPF no formato (YYYXXX/ZA): ");
				Scanner cpf_usuario = new Scanner(System.in);
				String cpf_paraValidar = cpf_usuario.nextLine();
				cpf_usuario.close();
				if (this.getPerfil().getCpf().equals(cpf_paraValidar)) {
					System.out.println("CPF validado com sucesso. \n");
					System.out.printf("Digite a nova senha de %s: \n", this.getNome());
					Scanner senha_nova = new Scanner(System.in);
					String senha_atual = senha_nova.nextLine();
					this.setSenha(senha_atual);
					System.out.println("Senha alterada com sucesso. \n");
					senha_nova.close();
				}
				else {
					System.out.println("CPF invalido. \n");
				}
			}
			else {
				System.out.println("Dados invalidos. \n");
			}
		}
		else {
			System.out.println("Usuario desativado. \n");
		}
	}
	/* Essa funcao adiciona um item na lista de item de cada pedido. Para isso, ela acessa o pedido e
	 * adiciona o item e, em seguida, atualiza os dados do item.
	 */
	public void adicionaItem (Item item, Pedido pedido, int quantidade) {
		while(item.getEstoqueDisponivel() < quantidade) {
			System.out.println("Nao possuimos estoque suficiente desse item.\nSelecione a quantidade");
			Scanner ler = new Scanner(System.in);
			String auxiliar;
			auxiliar = ler.nextLine();
			while(Pedido.ehInteiro(auxiliar) == false || auxiliar.isEmpty() == true) {
				System.out.println("Entrada invalida. Selecione a quantidade");
				auxiliar = ler.nextLine();
			}
			quantidade = Integer.parseInt(auxiliar);
		}
		
		item.setQuantidade(quantidade);
		item.setEstoqueDisponivel(item.getEstoqueDisponivel() - quantidade);
		pedido.getItem().add(item);
	}
	
	@Override
	public String toString() {
		String out = "";
		out = out + "Identificacao do usuario: " + getIdentificador() + "\n";
		out = out + "Nome: " + getNome() + "\n";
		if (this.getPedidos().get(0).getItem().isEmpty()) {
			out = out + "Pedido do Usuario: ";
			out = out + "O usuario nao tem pedidos realizados.\n";
		}
		else {
			out = out + "Pedido do Usuario: \n";
			int j = 1;
			for (Pedido pedido_atual: getPedidos()) {
				for (int i = 0; i < pedido_atual.getItem().size(); i++) {
					String nome = pedido_atual.getItem().get(i).getNome();
					int quantidade = pedido_atual.getItem().get(i).getQuantidade();
					out = out + "Item" + j + "\n";
					out = out + "Nome:" + nome + "; " ;
					out = out + "Quantidade: " + quantidade + "\n"; 
					j++;
				}
			}
		}
		return out;
	}
}
