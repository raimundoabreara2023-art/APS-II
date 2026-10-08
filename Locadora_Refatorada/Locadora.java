public class Locadora {

    public static void main(String[] args) {

        Cliente cliente = new Cliente("Raul");

        Fita fita1 = new Fita("Matrix", Fita.NORMAL);
        Fita fita2 = new Fita("Toy Story", Fita.INFANTIL);
        Fita fita3 = new Fita("Oppenheimer", Fita.LANCAMENTO);

        cliente.adicionaAluguel(new Aluguel(fita1, 3));
        cliente.adicionaAluguel(new Aluguel(fita2, 4));
        cliente.adicionaAluguel(new Aluguel(fita3, 2));

        /*
         * TESTE DA VERSÃO REFATORADA
         *
         * A forma de utilização da classe Cliente permanece praticamente
         * igual à versão original. A diferença está na organização interna
         * das responsabilidades.
         */
        System.out.println(cliente.extrato());
    }
}
