package jogoTabuleiro.pastaTabuleiro;

import jogoTabuleiro.pastaJogador.Jogador;
import jogoTabuleiro.pastaJogador.JogadorAz;
import jogoTabuleiro.pastaJogador.JogadorN;
import jogoTabuleiro.pastaJogador.JogadorS;

public class Principal {
    public static void main(String[] args) {
        Jogar jogo = new Jogar();

        jogo.addJogador(new JogadorAz("VERMELHO"));
        jogo.addJogador(new JogadorN ("AZUL"));
        jogo.addJogador(new JogadorS("ROSA"));
        jogo.iniciarJogo();
        
    }
}

