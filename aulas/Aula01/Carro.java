package Aula01;

public class Carro{
       
    String modelo;
    String marca;       
    int ano;
    String cor;    
    int tanque = 100;
    double potencia;

    

    Carro(String _modelo, 
        String _marca, 
        String _cor,
        int _ano, 
        double _potencia )
        
        {
        
        modelo = _modelo;
        marca = _marca;
        ano = _ano;
        cor = _cor;
        potencia = _potencia;
    }
              
        public void mostrarInfo(String modelo){
           System.out.println("Modelo = " + modelo);
           System.out.println("Marca = " + marca);
           System.out.println("Ano = " + ano);
           System.out.println("Cor = " + cor);
           System.out.println("Potencia = " + potencia);

        }

        public void mostraTanque(){
            System.out.println("Tanque = " + tanque + "%");
        }
        
        public double anda(int tanque){

            if (tanque > 9){
                tanque -= 10;
                System.out.println("O " + modelo + "está em movimento"); 
            }

            else {
                System.out.println("Combustivel insuficiente");
            }
                        return tanque;


        }

    }

