import java.util.Scanner;

import javax.swing.JOptionPane;

public class UsuarioComum extends Usuario implements Autenticacao {
	private static final long serialVersionUID = 305L;
	public UsuarioComum(int identificador, String nome, String email, String senha, Perfil perfil, boolean status) {
		super(identificador, nome, email, senha, perfil, status);
	}
	
	public void criarCadastro(Usuario usuario_adicionar) {
		if (this instanceof UsuarioComum) {
			System.out.println("Voce nao tem autorizacao para adicionar um outro usuario no sistema. \n");
		}
	}
	
	public void removerCadastro(Usuario usuario_remover) {
		if (this instanceof UsuarioComum) {
			System.out.println("Voce nao tem autorizaco para remover um outro usuario no sistema. \n");
		}
	}
	
	public void desabilitar_usuario(Usuario usuario_desabilitar) {
		if (this instanceof UsuarioComum) {
			System.out.println("Voce nao tem autorizacao para desabilitar um outro usuario no sistema. \n");
		}
	}
	
	public void autenticarAcesso(String senhaUsuario) {
		if (this.getSenha().equals(senhaUsuario)) {
			int opcaoUsuario;
			opcaoUsuario = JOptionPane.showConfirmDialog(null,"Gostaria de alterar a senha atual de " + this.getNome() + " ?");
			if (opcaoUsuario == JOptionPane.YES_OPTION) {
				String novaSenha;
				novaSenha = JOptionPane.showInputDialog("Digite sua nova senha: ");
				if (novaSenha.isEmpty()) { // senha invalida.
					JOptionPane.showMessageDialog(null, "A senha nao pode ser um campo vazio!", "Campo vazio", JOptionPane.INFORMATION_MESSAGE);
					System.exit(0);
				}
				else {
					this.alterar_senha(this.getEmail(), senhaUsuario, novaSenha);
					JOptionPane.showMessageDialog(null, "Senha alterada!", "Alteracao de senha", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			else if(opcaoUsuario == JOptionPane.CANCEL_OPTION || opcaoUsuario == JOptionPane.CLOSED_OPTION) {
				System.exit(0);
			}
			else {
				System.exit(0);
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Senha invalida!", null, JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
}
