package jogoTabuleiro.pastaTabuleiro;

import jogoTabuleiro.pastaJogador.Jogador;
import jogoTabuleiro.pastaJogador.JogadorAz;
import jogoTabuleiro.pastaJogador.JogadorN;
import jogoTabuleiro.pastaJogador.JogadorS;

public class Principal {
    public static void main(String[] args) {
        Jogar jogo = new Jogar();
        Jogador az1 = new JogadorAz("AZUL");
        Jogador n1 = new JogadorN("VERMELHO");
        Jogador s1 = new JogadorS("LILÁS");
        Jogador n2= new JogadorN("AMARELO");

        jogo.addJogador(s1);
        jogo.addJogador(az1);
        jogo.addJogador(n1);
        jogo.addJogador(n2);
        jogo.iniciarJogo();
    }
}

