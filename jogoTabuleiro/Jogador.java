package jogoTabuleiro;

public abstract class Jogador{ //nao pode ser instanciada
    private String corJogador;
    private int posicao;
    private int numJogadas;

    public Jogador(String corJogador){
        this.setCorJogador(corJogador);
        this.setPosicao(0);
        this.setNumJogadas(0);
    }

    public abstract int jogarDados();
    public abstract void mudarPosicao(int somaDados);

    public void AdcJogada(){
        this.setNumJogadas(getNumJogadas()+1);
    }

    public String getCorJogador() {
        return corJogador;
    }
    public void setCorJogador(String corplayer) {
        this.corJogador = corplayer;
    }

    public int getPosicao() {
        return posicao;
    }
    public void setPosicao(int posi) {
        this.posicao = posi;
    }

    public int getNumJogadas() {
        return numJogadas;
    }
    public void setNumJogadas(int numJgs) {
        this.numJogadas = numJgs;
    }

    
}