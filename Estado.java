
public enum Estado {
	ACRE ("AC","Capital Rio Branco"), 
	ALAGOAS("AL", "Capital Maceió"),
	AMAPÁ("AP","Capital Macapá"),
	AMAZONAS("AM","Capital Manaus"),
	BAHIA("BA","Capital Salvador"),
	CEARÁ("CE","Capital Fortaleza"),
	DISTRITO_FEDERAL("DF","Capital Brasília"),
	ESPÍRITO_SANTO("ES","Capital Vitória"),
	GOIÁS("GO","Capital Goiânia"),
	MARANHÃO("MA","Capital São Luís"), 
	MATO_GROSSO("MT","Capital Cuiabá"),
	MATO_GROSSO_DO_SUL("MS","Capital Campo Grande"),
	MINAS_GERAIS("MG","Capital Belo Horizonte"),
	PARÁ("PA","Capital Belém"),
	PARAÍBA("PB","Capital João Pessoa"),
	PARANÁ("PR","Capital Curitiba"), 
	PERNAMBUCO("PE","Capital Recife"),
	PIAUÍ("PI","Capital Teresina"), 
	RIO_DE_JANEIRO("RJ","Capital Rio de Janeiro"),
	RIO_GRANDE_DO_NORTE("RN","Capital Natal"),
	RIO_GRANDE_DO_SUL("RS","Capital Porto Alegre"), 
	RONDÔNIA("RO","Capital Porto Velho"), 
	RORAIMA("RR","Capital Boa Vista"), 
	SANTA_CATARINA("SC","Capital Florianópolis"),
	SÃO_PAULO("SP","Capital São Paulo"), 
	SERGIPE("SE","Capital Aracaju"),
	TOCANTINS("TO","Capital Palmas");
	
	private String sigla;
	private String descricao;
	
	Estado(String sigla, String descricao){
		this.sigla = sigla;
		this.descricao = descricao;
	}
	
	public String getSigla() {
		return sigla;
	}
	
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
