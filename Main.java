public class Main {

	public static void main(String[] args) {
		
		
		
		Data dataNascimento;
		System.out.println("Informe sua data de nascimento (dd/mm/aaaa");
		String data_nasc [] = leitor.nextLine().split("/"); 
		int dia = Integer.parseInt(data_nasc[0]);
		int mes = Integer.parseInt(data_nasc[1]);
		int ano = Integer.parseInt(data_nasc[2]);
		
		dataNascimento(dia, mes, ano);

	}

}
