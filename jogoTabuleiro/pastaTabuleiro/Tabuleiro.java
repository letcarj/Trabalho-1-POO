package jogoTabuleiro.pastaTabuleiro;
import java.util.ArrayList;
import jogoTabuleiro.pastaJogador.Jogador;

public class Tabuleiro {
    private int[] casasTab;
   
    public Tabuleiro(){
        this.setCasasTab(new int[40]);
    }

    public void moverJogador(Jogador player, int posiAtual, ArrayList<Jogador>playersTab){
        if(player.getSkipNextRound()) {
            System.out.println(player.getCorJogador() + " Não pode jogar esta rodada");
            player.setSkipNextRound(false); // depois que pular a rodada, passa a ser false
        }
         else {
            Regras aplicar = new Regras();
            player.posicaoAtual(posiAtual);
            aplicar.MoverCasas(player,playersTab);
        }
    }

    public void tabela(ArrayList<Jogador>players){
        System.out.println("\n-------------------- ATUALIZAÇÕES --------------------");
        for(int i= 0; i<players.size();i++){
            Jogador jogadores = players.get(i);
            System.out.println( " (" + jogadores.getCorJogador() + ") está na casa " + jogadores.getPosicao());
        }
        System.out.println("---------------------------------------------------");
    }

    public int[] getCasasTab() {
        return casasTab;
    }

    public void setCasasTab(int[] casasTab) {
        this.casasTab = casasTab;
    }
}



