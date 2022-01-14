public class Usuario {
	
	private String nome;
	private String cpf;
	private boolean cadastrado = false;
	private char rota;
	private boolean rotaReservada = false;
		
	public void cadastrar(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
		System.out.println("Usuario " + this.nome + " cadastrado");
		this.cadastrado = true;
	}
	
	public void visualizarRotas() {
		
		System.out.println("A - 3 conexÃµes, tempo total de voo 3 horas\n"
				+ "B - Voo direto, tempo total de voo 6 horas\n");
	}
	
	public void reservarRota(char rota) {
		
		if(cadastrado) {
			this.rota = Character.toUpperCase(rota);
			reservarPassagem(this.rota);
			this.rotaReservada = true;
		}else {
			System.out.println("Precisa estar cadastrado");
		}
	}
	
	public void reservarPassagem(char rota) {
		
		if(rota == 'A' || rota == 'B') {
			System.out.println("Passagem reservada: Rota "+ this.rota + " escolhida");
			//this.rota = rota;
		}else {
			System.out.println("Precisa estar cadastrado");
		}
	}
	public void cancelarReserva() {
		if (rotaReservada) {
			System.out.println("Cancelando passagem reservada: Rota "+ this.rota + " cancelada");
			this.rota = ' ';
		}else {
			System.out.println("Nenhuma reserva foi efetuada!");
		}
		
	}
	
}