package jogoTabuleiro;

/*Existem 3 tipos de jogador: jogador com sorte, cuja soma dos valores dos dados é
sempre maior ou igual à 7; jogador azarado, cuja soma dos valores dos dados é sempre
menor ou igual a 6; jogador normal, que pode obter tanto valores altos como baixos
para a soma dos dados. */
import java.util.Random;
public class JogadorS extends Jogador {

    private Random contador;
    
    public JogadorS(String corJogador){
        super(corJogador); // necessario para que receba a cor do jogador
        setContador(new Random());
    }

     @Override
     public int jogarDados(){

        int dado1 = contador.nextInt(6) + 1; //dessa forma não vai ficar de 0 a 5
        System.out.println("Dado 1: " + dado1);
        int dado2 = contador.nextInt(6) + 1;
        System.out.println("Dado 1: " + dado1);
        int somaDados = 0;
        somaDados = dado1 + dado2;
        System.out.println("A soma dos dados deu: "+somaDados+". Portanto, o jogador"
                            +this.getCorJogador()+ "anda "+somaDados +"casas");
        return somaDados;
     }

     //POLIMORFISMO 
     @Override
     public void mudarPosicao(int somaDados){
        this.setPosicao(this.getPosicao()+ somaDados);
        
        System.out.println("A posição atual do Jogador"+this.getCorJogador()+ "é"+ this.getPosicao());
        
     }
     public Random getContador() {
         return contador;
     }
     public void setContador(Random cont) {
         this.contador = cont;
     }
}
