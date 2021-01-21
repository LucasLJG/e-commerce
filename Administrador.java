import javax.swing.JOptionPane;

public class Administrador extends Usuario implements Autenticacao{
	private static final long serialVersionUID = 304L;
	private UsuariosCadastrados cadastroUsuarios;
	private static int quantidadeUsuarios = 0;
	
	public Administrador(int identificador, String nome, String email, String senha, Perfil perfil, boolean status) {
		super(identificador, nome, email, senha, perfil, status);
		cadastroUsuarios = new UsuariosCadastrados();
	}

	public UsuariosCadastrados getCadastroUsuarios() {
		return cadastroUsuarios;
	}

	public void setCadastroUsuarios(UsuariosCadastrados cadastroUsuarios) {
		this.cadastroUsuarios = cadastroUsuarios;
	}
	
	public static int getQuantidadeUsuarios() {
		return quantidadeUsuarios;
	}

	public void criarCadastro(Usuario usuario_adicionar) {
		if (this.getCadastroUsuarios().getUsuariosCadastrados().contains(usuario_adicionar) == false) {
			this.getCadastroUsuarios().getUsuariosCadastrados().add(usuario_adicionar);
			quantidadeUsuarios++;
		}
		else {
			System.out.println("O usuario ja se encontra cadastrado na plataforma. \n");
		}
	}
	
	public void removerCadastro(Usuario usuario_remover) {
		if (this.getCadastroUsuarios().getUsuariosCadastrados().isEmpty()) {
			System.out.println("A plataforma nao possui nenhum usuario cadastrado \n");
		}
		else {
			if (this.getCadastroUsuarios().getUsuariosCadastrados().contains(usuario_remover)) {
				this.getCadastroUsuarios().getUsuariosCadastrados().remove(usuario_remover);
				quantidadeUsuarios--;
				usuario_remover.setStatus(false);
			}
		}
	}
	
	public void desabilitar_usuario(Usuario usuario_desabilitar) { // desabilita o usuario, porem sem remove-lo do cadastro do sistema
		if (this.getCadastroUsuarios().getDono().equals(this)) {
			System.out.println("Voce precisa transferir a posse do sistema para outro Administrador antes disso. \n");
		}
		else {
			if (this.getCadastroUsuarios().getUsuariosCadastrados().isEmpty()) {
				System.out.println("O sistema nao possui usuarios cadastrados. \n");
			}
			else {
				if (this.getCadastroUsuarios().getDono().equals(usuario_desabilitar)) {
					System.out.println("Voce nao pode desabilitar o dono do sistema. \n");
				}
				else {
					if (this.getCadastroUsuarios().getUsuariosCadastrados().contains(usuario_desabilitar)) {
						usuario_desabilitar.setStatus(false);
					}
					else {
						System.out.println("O usuario nao esta cadastrado no sistema. \n");
					}
				}
			}
		}
	}
	
	public void autenticarAcesso(String senhaUsuario) {
		if (this.getSenha().equals(senhaUsuario)) {
			JOptionPane.showMessageDialog(null, "Acesso autorizado!", null, JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(null, "Senha invalida. Acesso ao sistema negado!", "Senha invalida!", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
	}
	
	@Override
	public String toString() {
		return super.toString();
		// IMPRIMIR QUANTIDADES DE USUARIOS CADASTRADOS.
		
	}
	
}

