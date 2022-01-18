import java.util.ArrayList;

public class TestaSistema {

	public static void main(String[] args) throws Exception {

		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

		Usuario usuario1 = new Usuario();
		usuarios.add(usuario1);
		usuario1.menuDeOpcoes();

		Usuario usuario2 = new Usuario();
		usuarios.add(usuario2);
		usuario2.menuDeOpcoes();
	}
}