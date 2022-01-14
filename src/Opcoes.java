import java.util.Scanner;

public class Opcoes {
	
	Usuario usuario = new Usuario();
	Scanner entrada = new Scanner(System.in);
	
	public void menuDeOpcoes() {
		System.out.println("..........................");
		System.out.println("Selecione o que deseja fazer:\n" + "1 - Cadastro de Usuários \n"
				+ "2 - Reserva de Passagens \n" + "3 - Cancelamento de Reservas \n" + "4 - Sair");
		System.out.println("..........................");
		
		int opcao = entrada.nextInt();
		
		selecionar(opcao);
	}
	
	public void selecionar(int opcao) {
		switch (opcao) {
		case 1:
			System.out.println("Por favor insira seu nome:");
			String nome = entrada.next();
			System.out.println("Agora, insira seu CPF:");
			String cpf = entrada.next();
			usuario.cadastrar(nome, cpf);
			menuDeOpcoes();
			break;
		case 2:
			System.out.println("Porfavor, selecione a rota para que possamos liberar a sua passagem\n");
			usuario.visualizarRotas();
			System.out.println("Selecione uma das rotas disponiveis.");
			char rota = entrada.next().charAt(0);
			usuario.reservarRota(rota);
			menuDeOpcoes();
			break;
		case 3:
			usuario.cancelarReserva();
			menuDeOpcoes();
			break;
			
		case 4:
			System.out.println("Saindo...");
			break;
			
		default:
			System.out.println("Opção Inválida");
			break;
		}
		entrada.close();
	}
}