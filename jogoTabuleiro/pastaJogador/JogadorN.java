package jogoTabuleiro.pastaJogador;

import jogoTabuleiro.pastaTabuleiro.Dados;
public class JogadorN extends Jogador {
    
    private Dados jgDados;

    public JogadorN(String corJogador){
        super(corJogador);
        setJgDados(new Dados()); //instância da classe dados.
    }
    

    @Override
    public void AdcJogada() {
       super.AdcJogada();
    }

    @Override
    public int jogarDados() {
       
        if(getEstaNoTab()){
            int somaDados;
            somaDados = getJgDados().rolarDados();
            System.out.println(somaDados);
            return somaDados;
        }
        else{
            System.out.println("Imposível rolar os dados! Jogador normal cor " + 
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
