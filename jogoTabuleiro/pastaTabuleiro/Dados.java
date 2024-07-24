package jogoTabuleiro.pastaTabuleiro;

import java.util.Random;
public class Dados {
    private Random contador;
    
    public  Dados(){
        setContador(new Random());
    }
    public int rolarDados(){
        int somaDados;
        int dado1 =  contador.nextInt(6)+1;
        int dado2 = contador.nextInt(6)+1;
        somaDados = dado1 + dado2;
        return somaDados;
    }
    public Random getContador() {
        return contador;
    }
    public void setContador(Random contador) {
        this.contador = contador;
    }

    

    }
    
