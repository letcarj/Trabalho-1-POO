package jogoTabuleiro.pastaJogador;

/*Existem 3 tipos de jogador: jogador com sorte, cuja soma dos valores dos dados é
sempre maior ou igual à 7; jogador azarado, cuja soma dos valores dos dados é sempre
menor ou igual a 6; jogador normal, que pode obter tanto valores altos como baixos
para a soma dos dados. */
import jogoTabuleiro.pastaTabuleiro.Dados;
public class JogadorS extends Jogador {

    private Dados jgDados;
    
    public JogadorS(String corJogador){
        super(corJogador); // necessario para que receba a cor do jogador
        setJgDados(new Dados()); //instância da classe dados.
    }

     @Override
     public int jogarDados(){
        if(getEstaNoTab()){
           
            int somaDados;
            somaDados= getJgDados().rolarDados();
            
            if(somaDados>=7){
            System.out.println(somaDados);
                return somaDados;
            }
            else{
            System.out.println(7);
                return 7;
            }
        }
         else{
            System.out.println("Imposível rolar os dados! Jogador de sorte cor " + 
            this.getCorJogador()+" não está no tabuleiro.");
            return 0;
         }  
    }

    public Dados getJgDados() {
        return jgDados;
    }

    public void setJgDados(Dados jgDados) {
        this.jgDados = jgDados;
    }

    
 
}
