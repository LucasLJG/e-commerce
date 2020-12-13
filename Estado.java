
public enum Estado {
	ACRE("AC","Acre","Rio Branco"),
	ALAGOAS("AL","Alagoas","Maceió"),
	AMAPA("AP","Amapá","Macapá"),
	AMAZONAS("AM","Amazonas","Manaus"),
	BAHIA("BA","Bahia","Salvador"),
	CEARA("CE","Ceará","Fortaleza"),
	DISTRITO_FEDERAL("DF","Distrito Federal","Brasília"),
	ESPIRITO_SANTO("ES","Espírito Santo","Vitória"),
	GOIAS("GO","Goiás","Goiânia"),
	MARANHAO("MA","Maranhão","São Luís"),
	MATO_GROSSO("MT","Mato Grosso","Cuiabá"),
	MATO_GROSSO_DO_SUL("MS","Mato Grosso do Sul","Campo Grande"),
	MINAS_GERAIS("MG","Minas Gerais","Belo Horizonte"),
	PARA("PA","Pará","Belém"),
	PARAIBA("PB","Paraíba","João Pessoa"),
	PARANA("PR","Paraná","Curitiba"),
	PERNAMBUCO("PE","Pernambuco","Recife"),
	PIAUI("PI","Piauí","Teresina"),
	RIO_DE_JANEIRO("RJ","Rio de Janeiro","Rio de Janeiro"),
	RIO_GRANDE_DO_NORTE("RN","Rio Grande do Norte","Capital Natal"),
	RIO_GRANDE_DO_SUL("RS","Rio Grande do Sul","Porto Alegre"),
	RONDONIA("RO","Rondônia","Porto Velho"),
	RORAIMA("RR","Roraima","Boa Vista"),
	SANTA_CATARINA("SC","Santa Catarina","Florianópolis"),
	SAO_PAULO("SP","São Paulo","São Paulo"),
	SERGIPE("SE","Sergipe","Aracaju"),
	TOCANTINS("TO","Tocantins","Palmas");
	
	private final String sigla;
	private final String nome;
	private final String capital;
	
	Estado(String sigla,String nome,String capital){
		this.sigla=sigla;
		this.nome=nome;
		this.capital=capital;
	}

	public String getSigla() {
		return sigla;
	}

	public String getNome() {
		return nome;
	}

	public String getCapital() {
		return capital;
	}
}
