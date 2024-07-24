
package jogoTabuleiro.pastaJogador;

public abstract class Jogador{ //nao pode ser instanciada
  
    private String corJogador;
    private int posicao;
    private int numJogadas;
    private boolean estaNoTab;
    private boolean skipNextRound;

    public Jogador(String corJogador){
        this.setCorJogador(corJogador); // decide a cor
        this.setPosicao(0); //começa na posição 0
        this.setNumJogadas(0); //inicia com 0 jogadas
        this.setEstaNoTab(false); // não inicia no tabuleiro
        this.setSkipNextRound(false); // não inicia pulando rodada
    
        // this.corJogador = corJogador;
        //this.posicao= 0;
        //this.posicao = 0;
    }

    public abstract int jogarDados();
    
    public void posicaoAtual(int atual){
        setPosicao(getPosicao()+atual);
    }

    public void AdcJogada(){ //adicionar sempre  jogada que for feita
        if(getEstaNoTab()){
           this.setNumJogadas(getNumJogadas()+1);
            System.out.println("numero de jogadas: " + this.getNumJogadas());
            
        }
        else{
            System.out.println("Jogador " + this.getCorJogador() + " não está na partida");
    
        }
    }

    public void removerJogadas(){
        this.setNumJogadas(0);
    }

    

    public boolean equals(Object plyer){
        if(this == plyer){
            return true;
        }
        else if(plyer==null || getClass()!= plyer.getClass()){
            return false;
        }
        else{
            Jogador player = (Jogador) plyer;
            //player passa a ser o objeto plyer so que convertido para Jogador
            return corJogador.equalsIgnoreCase(player.corJogador);
        }
    }

        //valor do hashcode é baseado no endereço de memoria
    public int hashCode(){   
        // vai retornar o codigo  hash de corJogador, assim garantindo que 
        //jogadores com mesma cor tenham o mesmo valor de hash.

        return corJogador.toUpperCase().hashCode(); // é preciso usar o toUpperCase para evitar q dependa
        // de letras maiúsculas e minúsculas. assim, as cores IGUAIS vão gerar o mesmo codigo,
        //independente de ser maiuscula ou minuscula.
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

    public boolean getEstaNoTab() {
        return estaNoTab;
    }
    public void setEstaNoTab(boolean estaNoTab) {
        this.estaNoTab = estaNoTab;
    }

    public boolean getSkipNextRound() {
        return skipNextRound;
    }

    public void setSkipNextRound(boolean skipNextRound) {
        this.skipNextRound = skipNextRound;
    }
    
    
}