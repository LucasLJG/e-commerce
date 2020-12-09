public class Administrador extends Usuario{
	private UsuariosCadastrados cadastroUsuarios;
	private static int quantidadeUsuarios = 0;
	
	public Administrador(int identificador, String nome, String email, String senha, Perfil perfil) {
		super(identificador, nome, email, senha, perfil);
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
			System.out.println("O usuário já se encontra cadastrado na plataforma. \n");
		}
	}
	
	public void removerCadastro(Usuario usuario_remover) {
		if (this.getCadastroUsuarios().getUsuariosCadastrados().isEmpty()) {
			System.out.println("A plataforma não possui nenhum usuário cadastrado \n");
		}
		else {
			if (this.getCadastroUsuarios().getUsuariosCadastrados().contains(usuario_remover)) {
				this.getCadastroUsuarios().getUsuariosCadastrados().remove(usuario_remover);
				quantidadeUsuarios--;
			}
		}
	}
	
}
