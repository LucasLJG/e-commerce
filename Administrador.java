public class Administrador extends Usuario{
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
	
	public void inicializar_sistema(Administrador adm_sistema) { // definindo o dono da plataforma (sistema)
		adm_sistema.getCadastroUsuarios().setDono(adm_sistema);
		adm_sistema.criarCadastro(adm_sistema);
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
				if (this.getCadastroUsuarios().getDono().equals(usuario_remover)) {
					System.out.println("Você não tem permissão para remover o dono da plataforma. \n");
				}
				else {
					this.getCadastroUsuarios().getUsuariosCadastrados().remove(usuario_remover);
					quantidadeUsuarios--;
					usuario_remover.setStatus(false);
				}
			}
		}
	}
	
	public void desabilitar_usuario(Usuario usuario_desabilitar) { // o usuario permanece no cadastro do sistema, porem agora esta desabilitado.
		if (this.getCadastroUsuarios().getDono().equals(usuario_desabilitar)) {
			System.out.println("Você não pode desabilitar o dono do sistema. \n");
		}
		else {
			if (this.getCadastroUsuarios().getUsuariosCadastrados().isEmpty()) {
				System.out.println("Não há nenhum usuário cadastrado na plataforma. \n");
			}
			if (this.getCadastroUsuarios().getUsuariosCadastrados().contains(usuario_desabilitar)) {
				usuario_desabilitar.setStatus(false);
			}
			else {
				System.out.println("O usuário não está no cadastro da plataforma. \n");
			}
		}
	}
	
}

