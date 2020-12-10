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
		
		if(status == true) {
		
			if (this.email == email) {
				System.out.println("Digite o numero do seu cpf para confirmacao de autenticidade: \n");
				Scanner dados = new Scanner(System.in);
				String entrada = dados.nextLine();
				dados.close();
				if (this.perfil.getCpf().equals(entrada) == true) {
					System.out.println("Senha: ");
					System.out.println(this.getSenha());
				}
				else {
					System.out.println("Numero de CPF invÃ¡lido.\n");
				}
			}
			System.out.println("Endereco de e-mail invalido.\n");
		}
		else {
			System.out.println("Usuário não cadastrado.\n");
		}
	}
	
	public void alterar_senha(String email, String senha) {
		
		if(status == true) {
			
			if (this.getEmail().equals(email)== true && this.getSenha().equals(senha) == true) {
				System.out.printf("Digite a nova senha de %s: \n", this.getNome());
				Scanner senha_nova = new Scanner(System.in);
				String senha_atual = senha_nova.nextLine();
				senha_nova.close();
				this.setSenha(senha_atual);
				System.out.println("Senha alterada com sucesso.\n");
			}
			else {
				System.out.println("Dados invalidos.\n");
			}
		}
		else {
			System.out.println("Usuário não cadastrado");
		}
	}
	
	@Override
	public String toString() {
		String out = "";
		out = out + "Identificacao do usuario: " + getIdentificador() + "\n";
		out = out + "Nome: " + getNome() + "\n";
		if (this.pedidos.isEmpty()) {
			out = out + "O usuario nao tem pedidos realizados.\n";
		}
		else {
			out = out + "Pedido do Usuario: \n";
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
