import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import javax.swing.JOptionPane;

import java.io.*;

public abstract class Usuario implements Serializable{
	private static final long serialVersionUID = 302L;
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
	
	
	// METODOS QUE PRECISAM SER IMPLEMENTADOS EM CLASSES FILHAS SE ELAS QUISEREM SER CONCRETAS.
	public abstract void criarCadastro(Usuario usuario_adicionar);
	public abstract void removerCadastro(Usuario usuario_remover);
	public abstract void desabilitar_usuario(Usuario usuario_desabilitar);
	
	public void recuperar_senha(String email) {
		
		if(this.getStatus() == true) {
		
			if (this.getEmail() == email) {
				JOptionPane.showMessageDialog(null, "A senha de " + this.getNome() + " eh: " + this.getSenha() , "Recuperacao de senha", JOptionPane.INFORMATION_MESSAGE);
			}
			else{
				JOptionPane.showMessageDialog(null, "Os dados informados sao invalidos.", "Dados invalidos.", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "O usuario encontra-se desativado no sistema.", "Usuario desativado.", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public void alterar_senha(String email, String senha, String novaSenha) {
		
		if(status == true) {
			
			if (this.getEmail().equals(email) == true && this.getSenha().equals(senha) == true) {
				this.setSenha(novaSenha);
			}
			else {
				JOptionPane.showMessageDialog(null, "Os dados informados sao invalidos.", "Dados invalidos.", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "O usuario encontra-se desativado no sistema.", "Usuario desativado.", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	/* Essa funcao adiciona um item na lista de item de cada pedido. Para isso, ela acessa o pedido e
	 * adiciona o item e, em seguida, atualiza os dados do item.
	 */
	public void adicionaItem (Item item, Pedido pedido, int quantidade) {
		while(item.getEstoqueDisponivel() < quantidade) {
			String auxiliar = JOptionPane.showInputDialog(null,"Nao possuimos estoque suficiente desse item. Selecione outra quatidade.");
			while(Pedido.ehInteiro(auxiliar) == false || auxiliar.isEmpty() == true) {
				auxiliar = JOptionPane.showInputDialog(null,"Entrada invalida. Selecione uma quatidade.");
			}
			quantidade = Integer.parseInt(auxiliar);
		}
		item.setQuantidade(quantidade);
		item.setEstoqueDisponivel(item.getEstoqueDisponivel() - quantidade);
		pedido.getItem().add(item);
	}
	
	// GRAVANDO OS OBJETOS EM FORMATO BINARIO NO ARQUIVO.
	public static void gravarArquivosEmBinario(ArrayList<Usuario> usuarios, String nomeDoArquivo) {
		try {
			ObjectOutputStream out = new ObjectOutputStream (new FileOutputStream (nomeDoArquivo));
			for (Usuario usuario: usuarios)
			{
				out.writeObject(usuario);
				out.flush();
			}
			out.close();
		}
		catch(IOException erro) {
			System.out.println("A operacao resultou em erro: " + erro.getMessage());
		}
	}
	
	// RECUPERANDO OS OBJETOS GRAVADOS EM FORMATO BINARIO NO ARQUIVO.
	public static void lerArquivosEmBInario(String nomeDoArquivo){
		int i = 0;
		try {
			ObjectInputStream in = new ObjectInputStream (new FileInputStream (nomeDoArquivo));
			while (true) {
				Usuario usuarioSerializado = (Usuario) in.readObject();
				System.out.println("*** Lendo Resistro do usuario " + (++ i));
				System.out.println(usuarioSerializado);
			}
		}
		catch(EOFException endOfFileException) {
			return;
		}
		catch(IOException erro1) {
			System.out.println("A operacao resultou em erro. Descricao do erro: " + erro1.getMessage());
		}
		catch (ClassNotFoundException erro2) {
			System.out.println("A operacao resultou em erro. Descricao do erro: " + erro2.getMessage());
		}
	}
	
	@Override
	public String toString() {
		String out = "";
		out = out + "Identificacao do usuario: " + getIdentificador() + "\n";
		out = out + "Nome: " + getNome() + "\n";
		if (this.getPedidos().isEmpty())
		{
			out = out + "Pedido do Usuario: ";
			out = out + "O usuario nao tem pedidos realizados.\n";
		}
		else if (this.getPedidos().get(0).getItem().isEmpty()) {
			out = out + "Pedido do Usuario: ";
			out = out + "O usuario nao tem pedidos realizados.\n";
		}
		else {
			out = out + "Pedido de " + this.getNome() + ":\n";
			int j = 1;
			for (Pedido pedido_atual: getPedidos()) {
				for (int i = 0; i < pedido_atual.getItem().size(); i++) {
					String nome = pedido_atual.getItem().get(i).getNome();
					int quantidade = pedido_atual.getItem().get(i).getQuantidade();
					out = out + "Item " + j + ":\n";
					out = out + "Nome:" + nome + " \n" ;
					out = out + "Quantidade: " + quantidade + "\n"; 
					j++;
				}
			}
		}
		return out;
	}
}
