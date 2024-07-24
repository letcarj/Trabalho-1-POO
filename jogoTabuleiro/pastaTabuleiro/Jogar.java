package jogoTabuleiro.pastaTabuleiro;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import jogoTabuleiro.pastaJogador.*;

public class Jogar {
    private boolean iniciarGame;
    private Tabuleiro tab;
    private int ordemPlayers;
    private ArrayList<Jogador> jogadores; // esse ArrayList vai me permitir adc os jogadores na partida
    private Set<String> MonitorarCorJog;  
     

    public Jogar(){
    setTab(new Tabuleiro());  //nova instancia da classe tabuleiro
    setIniciarGame(false);
    setJogadores(new ArrayList<Jogador>());
    setMonitorarCorJog(new HashSet<String>());
    setOrdemPlayers(0);
    }

    public void addJogador(Jogador players){ 
        //recebe esses parametro para uma instancia do tipo Jogador
        if(this.getJogadores().size()>=6) {
            System.out.println("Limite de jogadores atingido"); 
        }
        if(this.getMonitorarCorJog().contains(players.getCorJogador().toUpperCase())){ //garantindo que as cores sejam
            //comparadas em maiúsculo
            System.out.println("Cor "+ players.getCorJogador().toUpperCase()+" Indisponivel! Há um jogador usando essa cor");
        }
        else{
           this.getJogadores().add(players); 
           this.getMonitorarCorJog().add(players.getCorJogador().toUpperCase()); //cor do jogador fica maiuscula antes de
           // ser armazenada
           players.setEstaNoTab(true);
           System.out.println("Jogador "+ players.getCorJogador().toUpperCase()+ " adicionado");
        }
    }
    public void removerJogador(Jogador players){
        if(this.getJogadores().size() <=0){
            System.out.println("Impossível remover! Não há jogadores no tabuleiro.");
        }
        else if(this.getJogadores().remove(players)){
            this.getMonitorarCorJog().remove(players.getCorJogador().toUpperCase());
            players.removerJogadas();
        }
        else{
            System.out.println("Impossível remover! Esse jogador não está no tabuleiro.");
        }
    }
    
    

    public void estatistica(){

    }

    public void iniciarJogo(){
        if(this.getJogadores().size() < 2){
            System.out.println("Impossível jogar! Adicione mais jogadores");
            return; 
        }
        Scanner rolar= new Scanner(System.in);
      
        setIniciarGame(true);
    
            while(getIniciarGame()){

           for(int i=0; i < this.getJogadores().size(); i ++){
            Jogador vezdePlayer = this.getJogadores().get(i);// armazena em vezdePlayer
            System.out.println("Turno do jogador de cor "+ vezdePlayer.getCorJogador());
            System.out.println("Pressione ENTER para rolar os dados");
            
            
            rolar.nextLine(); 
            
           
            System.out.print("Valor dos dados: ");
            int rolarDados = vezdePlayer.jogarDados();
            System.out.println("");
            vezdePlayer.AdcJogada();
            this.getTab().moverJogador(vezdePlayer, rolarDados, this.getJogadores());
            this.getTab().tabela(this.getJogadores());

            
            if(vezdePlayer.getPosicao()>=40){
                System.out.println(vezdePlayer.getCorJogador()+" venceu o jogo!");
                setIniciarGame(false);
                break;
                }

            }
        }
        rolar.close();
    }
   

    public Tabuleiro getTab() {
        return tab;
    }
    public void setTab(Tabuleiro tab) {
        this.tab = tab;
    }

    public int getOrdemPlayers() {
        return ordemPlayers;
    }

    public void setOrdemPlayers(int ordemPlayers) {
        this.ordemPlayers = ordemPlayers;
    }
    

    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(ArrayList<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    public Set<String> getMonitorarCorJog() {
        return MonitorarCorJog;
    }

    public void setMonitorarCorJog(Set<String> monitorarCorJog) {
        MonitorarCorJog = monitorarCorJog;
    }

    public boolean getIniciarGame() {
        return iniciarGame;
    }

    public void setIniciarGame(boolean iniciarGame) {
        this.iniciarGame = iniciarGame;
    }

    

    } 

