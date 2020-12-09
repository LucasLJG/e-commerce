import java.util.ArrayList;
import java.util.Scanner;
public class Usuario {
	private int identificador;
	private String nome;
	private String email;
	private String senha;
	private ArrayList<Pedido> pedidos;
	private Perfil perfil;
	
	public Usuario(int identificador, String nome, String email, String senha, Perfil perfil) {
		this.identificador = identificador;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.perfil = perfil;
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
	
	public void recuperar_senha(String email) {
		if (this.email == email) {
			System.out.println("Digite o número do seu cpf para confirmação de autenticidade: \n");
			Scanner dados = new Scanner(System.in);
			String entrada = dados.nextLine();
			dados.close();
			if (this.perfil.getCpf().equals(entrada) == true) {
				System.out.println("Senha: ");
				System.out.println(this.getSenha());
			}
			else {
				System.out.println("Número de CPF inválido.\n");
			}
		}
		System.out.println("Endereço de e-mail inválido.\n");
	}
	
	public void alterar_senha(String email, String senha) {
		if (this.getEmail().equals(email)== true && this.getSenha().equals(senha) == true) {
			System.out.println("Digite a nova senha: \n");
			Scanner senha_nova = new Scanner(System.in);
			String senha_atual = senha_nova.nextLine();
			senha_nova.close();
			this.setSenha(senha_atual);
			System.out.println("Senha alterada com sucesso.\n");
		}
		else {
			System.out.println("Dados inválidos.\n");
		}
	}
	
	@Override
	public String toString() {
		String out = "";
		out = out + "Identificação do usuário: " + getIdentificador() + "\n";
		out = out + "Nome: " + getNome() + "\n";
		if (this.pedidos.isEmpty()) {
			out = out + "O usuário não tem pedidos realizados.\n";
		}
		else {
			out = out + "Pedido do Usuário: \n";
			int j = 1;
			for (Pedido pedido_atual: getPedidos()) {
				for (int i = 0; i < pedido_atual.getItem().size(); i++) {
					String nome = pedido_atual.getItem().get(i).getNome();
					out = out + "Item" + j + "\n";
					out = out + "Nome: " + nome + "\n";
					j++;
				}
			}
		}
		return out;
	}
	
	
}
