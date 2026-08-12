package main.java.app;
import main.java.controller.ListaController;

public class Principal {
// funcao da main será apenas a de criar e executar o controller
    public static void main(String[] args) {

        ListaController controller = new ListaController();

        controller.executar();
    }
}