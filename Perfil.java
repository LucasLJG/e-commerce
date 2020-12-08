import java.util.Calendar;

public class Perfil {
	private Sexo sexo;
	private Calendar dataNascimento;
	private String cidade;
	private Estado estado;
	private String telefone;
	private String cpf;
	
	public Perfil(Sexo sexo, Calendar dataNascimento, String cidade, Estado estado, String telefone, String cpf) {
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.cidade = cidade;
		this.estado = estado;
		this.telefone = telefone;
		this.cpf = cpf;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String toString() {
		String out = "Sexo: " + getSexo() + "\n";
		out = out + "Data de nascimento: " + dataNascimento.get(Calendar.DAY_OF_MONTH) + "/" + dataNascimento.get(Calendar.MONTH)+"/" + dataNascimento.get(Calendar.YEAR) + "\n";
		out = out + "CPF: " + "getCpf() + "\n";
		out = out + "Telefone: " + getTelefone() + "\n";
		out = out + "Cidade: " + getCidade() + "\n";
		out = out + "Estado: " + getEstado() + "\n";
		return out;
		
	
		
}
