import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Usuario {

	private String nome;
	private String cpf;
	private boolean cadastrado = false;
	private char rota;
	private boolean rotaReservada = false;

	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	String data = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(timestamp.getTime());
	BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

	public void cadastrar(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
		System.out.println(data + " O usuario " + this.nome + " foi cadastrado");
		this.cadastrado = true;
	}

	public void visualizarRotas() {

		System.out.println(
				"A - 3 conexões, tempo total de voo 3 horas\n" + "B - Voo direto, tempo total de voo 6 horas\n");
	}

	public void reservarRota(char rota) throws Exception {

		System.out.println("Digite seu CPF para confirmar:");
		String cpf = entrada.readLine();

		if (this.cpf.equals(cpf)) {
			this.rota = Character.toUpperCase(rota);
			reservarPassagem(this.rota);
			this.rotaReservada = true;
		} else {
			System.out.println("CPF incorreto.");
		}
	}

	public void reservarPassagem(char rota) {

		if (rota == 'A' || rota == 'B') {
			System.out.println(data + " Passagem reservada por " + this.nome + " Rota " + this.rota + " escolhida");
			this.rota = rota;
		} else {
			System.out.println("Entrada Inválida");
		}
	}

	public void cancelarReserva() {
		if (rotaReservada && this.rota != ' ') {
			System.out.println(data + " O usuario " + this.nome + " cancelou a passagem reservada: Rota " + this.rota
					+ " cancelada");
			this.rota = ' ';
		} else {
			System.out.println("Nenhuma reserva foi efetuada!");
		}

	}

	public void menuDeOpcoes() throws Exception {
		System.out.println("...................................");
		System.out.println("Selecione o que deseja fazer:\n" + "1 - Cadastro de Usuários \n"
				+ "2 - Reserva de Passagens \n" + "3 - Cancelamento de Reservas \n" + "4 - Sair");
		System.out.println("...................................");

		int opcao = Integer.parseInt(entrada.readLine());

		selecionar(opcao);
	}

	public void selecionar(int opcao) throws Exception {
		switch (opcao) {
		case 1:
			System.out.println("Por favor insira seu nome:");
			String nome = entrada.readLine();
			System.out.println("Agora, insira seu CPF:");
			String cpf = entrada.readLine();
			cadastrar(nome, cpf);
			menuDeOpcoes();
			break;
		case 2:
			if (cadastrado) {
				System.out.println("Por favor, selecione a rota para que possamos liberar a sua passagem.\n");
				visualizarRotas();
				System.out.println("Selecione uma das rotas disponiveis.");
				char rota = entrada.readLine().charAt(0);
				reservarRota(rota);
				menuDeOpcoes();
			} else {
				System.out.println("Precisa estar cadastrado!");
				menuDeOpcoes();
			}
			break;
		case 3:
			if (cadastrado) {
				cancelarReserva();
			} else {
				System.out.println("Precisa estar cadastrado!");
			}
			menuDeOpcoes();
			break;
		case 4:
			if (this.nome != null) {
				System.out.println("O Usuario " + this.nome + " saiu...");
			} else {
				System.out.println("Usuario não identificado saiu...");
			}
			break;
		default:
			System.out.println("Opção Inválida");
			menuDeOpcoes();
			break;
		}
	}
}