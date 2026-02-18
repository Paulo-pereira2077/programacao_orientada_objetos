public class TesteAula01 {
    
    public static void main(String[] args) {
        Carro c1 = new Carro("Fusca", "Wolks Wagen", "Azul", 1973, 1.0);
        Carro c2 = new Carro("Corsa", "Chevrolet", "vermelho", 2001, 1.0);
        Carro c3 = new Carro("Civic", "Honda", "Cinza", 2001, 1.8);
        
        c1.mostrarInfo(null);
        c2.mostrarInfo(null);
        c3.mostrarInfo(null);

        c1.anda(0);
    }

}
