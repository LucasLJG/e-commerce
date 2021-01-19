public enum Sexo {
	HOMEM("M","Masculino"),
	MULHER("F","Feminino");
	
	private final String sigla;
	private final String descricao;
	
	Sexo(String sigla, String descricao) {
		this.sigla = sigla;
		this.descricao = descricao;
	}

	public String getSigla() {
		return sigla;
	}
	public String getDescricao() {
		return descricao;
	}
	
	@Override
	public String toString() {
		String out = "";
		out = out + "Sigla: " + getSigla() + "\n";
		out = out + "Descricao: " + getDescricao() + "\n";
		return out;
	}
}
