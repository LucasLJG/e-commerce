import java.util.Scanner;

public class UsuarioComum extends Usuario implements Autenticacao {
	private static final long serialVersionUID = 305L;
	public UsuarioComum(int identificador, String nome, String email, String senha, Perfil perfil, boolean status) {
		super(identificador, nome, email, senha, perfil, status);
	}
	
	public void criarCadastro(Usuario usuario_adicionar) {
		if (this instanceof UsuarioComum) {
			System.out.println("Você não tem autorização para adicionar um outro usuário no sistema. \n");
		}
	}
	
	public void removerCadastro(Usuario usuario_remover) {
		if (this instanceof UsuarioComum) {
			System.out.println("Você não tem autorização para remover um outro usuário no sistema. \n");
		}
	}
	
	public void desabilitar_usuario(Usuario usuario_desabilitar) {
		if (this instanceof UsuarioComum) {
			System.out.println("Você não tem autorização para desabilitar um outro usuário no sistema. \n");
		}
	}
	
	public boolean autenticarAcesso(String senhaUsuario) {
		if (this.getSenha() == senhaUsuario) {
			System.out.println("Acesso concedido com sucesso! \n");
			System.out.println("Gostaria de atualizar suas informações de cadastro ? Digite [1] para alterar sua senha ou [2] para recuperar sua senha: ");
			Scanner entrada_usuario = new Scanner(System.in);
			String opcao_usuario = entrada_usuario.nextLine();
			while (opcao_usuario.equals("1") == false && opcao_usuario.equals("2") == false) {
				System.out.println("Entrada inválida. Digite [1] ou [2] (valor númerico dentro de []) para acessar sua opção.");
				System.out.println("Gostaria de atualizar suas informações de cadastro ? Digite [1] para alterar sua senha ou [2] para recuperar sua senha: ");
				opcao_usuario = entrada_usuario.nextLine();
			}
			if (opcao_usuario.contentEquals("1")) {
				this.alterar_senha(this.getEmail(), this.getSenha());
			}
			else {
				this.recuperar_senha(this.getEmail());
			}
			entrada_usuario.close();
			return true;
		}
		else {
			System.out.println("Senha inválida! Acesso não autorizado ao sistema. \n");
			return false;
		}
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
}
