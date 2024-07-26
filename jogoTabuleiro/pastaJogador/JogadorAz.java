package jogoTabuleiro.pastaJogador;
  
import jogoTabuleiro.pastaTabuleiro.Dados;

public class JogadorAz extends Jogador {
    private Dados jgDados;


    public JogadorAz(String corJogador){
        super(corJogador);
        this.setJgDados(new Dados()); //instância da classe dados.
    }
    
    @Override
    public void AdcJogada() {
        super.AdcJogada();
    }
    @Override
    public int jogarDados() {
       
        if(getEstaNoTab()){
        
            int somaDados;
            somaDados = this.getJgDados().rolarDados();
            if(somaDados<=6){
                System.out.println(somaDados);
                return somaDados;
            }
            else{
                System.out.println(6);
                return 6;
            }       
        }
        else{
            System.out.println("Imposível rolar os dados! Jogador azarado cor " + 
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

