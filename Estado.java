
public enum Estado {
	ACRE("AC","Acre","Rio Branco"),
	ALAGOAS("AL","Alagoas","Maceio"),
	AMAPA("AP","Amapa","Macapa"),
	AMAZONAS("AM","Amazonas","Manaus"),
	BAHIA("BA","Bahia","Salvador"),
	CEARA("CE","Ceara","Fortaleza"),
	DISTRITO_FEDERAL("DF","Distrito Federal","Brasilia"),
	ESPIRITO_SANTO("ES","Espirito Santo","Vitoria"),
	GOIAS("GO","Goias","Goiania"),
	MARANHAO("MA","Maranhao","Sao Luis"),
	MATO_GROSSO("MT","Mato Grosso","Cuiaba"),
	MATO_GROSSO_DO_SUL("MS","Mato Grosso do Sul","Campo Grande"),
	MINAS_GERAIS("MG","Minas Gerais","Belo Horizonte"),
	PARA("PA","Para","Belem"),
	PARAIBA("PB","Paraiba","Joao Pessoa"),
	PARANA("PR","Parana","Curitiba"),
	PERNAMBUCO("PE","Pernambuco","Recife"),
	PIAUI("PI","Piaui­","Teresina"),
	RIO_DE_JANEIRO("RJ","Rio de Janeiro","Rio de Janeiro"),
	RIO_GRANDE_DO_NORTE("RN","Rio Grande do Norte","Capital Natal"),
	RIO_GRANDE_DO_SUL("RS","Rio Grande do Sul","Porto Alegre"),
	RONDONIA("RO","Rondonia","Porto Velho"),
	RORAIMA("RR","Roraima","Boa Vista"),
	SANTA_CATARINA("SC","Santa Catarina","Florianopolis"),
	SAO_PAULO("SP","Sao Paulo","Sao Paulo"),
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
