package jogoTabuleiro.pastaTabuleiro;
import jogoTabuleiro.pastaJogador.Jogador;
import jogoTabuleiro.pastaJogador.JogadorAz;
import jogoTabuleiro.pastaJogador.JogadorN;
import jogoTabuleiro.pastaJogador.JogadorS;
import java.util.Random;
//import java.util.Scanner;
import java.util.ArrayList;


public class Regras {
    private Random mudarTipo;
    //private Tabuleiro tabu;
    public Regras(){
        this.setMudarTipo(new Random());
        //this.setTabu(tabu);
    }

    public void MoverCasas(Jogador player,ArrayList<Jogador>players){
       
        int posicao = player.getPosicao();
        //optei pelo switch case pois um if else ao meu ver ficaria com bastante informação
        switch (posicao) {
            case 10:
            case 25:
            case 38:
                System.out.println(player.getCorJogador()+ " não joga a próxima rodada!");
                player.setSkipNextRound(true);
                break;
        
            case 13:
                 System.out.println("Carta surpresa! "); //adiciona random pra colocar
                 trocarTipoPlayer(player,players);
                break;
            case 5:
            case 15:
            case 30: //instanceof para verificar se player é da classe JogadorAz.
                if(!(player instanceof JogadorAz)){
                     System.out.println("Oportunidade de seguir em frente: Avance 3 casas!");
                     avancarCasas(player,players);
                }
                else{
                    System.out.println("Jogador azarado da cor " + player.getCorJogador() +" aguarde a próxima rodada");
                }
                break;
            
            case 17:
            case 27:
                System.out.println("Escolha um jogador para retornar ao início");
                retornarInicio(player, players);
                break;

            case 20:
            case 35:
                System.out.println("Parece que você se deu mal! Troque de lugar com o jogador que está em último.");
                trocarLugar(player, players);
                break;

            default:
                System.out.println("Aguarde a próxima rodada");
        }
    }
    
    
   public void retornarInicio(  Jogador playerAtual,ArrayList<Jogador> players){
        
        
        System.out.println("Jogadores disponíveis: ");
    
        for(int i = 0; i < players.size(); i++){
            Jogador jogadores = players.get(i); 
            //acessar um objeto jogador do arraylist
            if( jogadores!= playerAtual){
               System.out.println( i +" - " + jogadores.getCorJogador()); 
            }
        }
        int numplayers = players.size(); // vai armazenar em numplayers o numero de jogadores
        if(numplayers > 1){ //se for maior que 1 entra nessa condição
        int aleat = mudarTipo.nextInt(numplayers); //aleat vai gerar um random de acordo com numplayers
        Jogador peaoEscolhido = players.get(aleat);
        System.out.println(peaoEscolhido);
         if(peaoEscolhido!=playerAtual){ //não vai contar com o playerAtual, se random cair neste, a casa perde a ação
            //na rodada e nenhum vai retornar ao inicio. ver isso dps
            System.out.println("O jogador " +peaoEscolhido.getCorJogador()+ " retornou para o início.");
            peaoEscolhido.setPosicao(0);
            }
        }                
      }   
    
     /*public void retornarInicio(  Jogador playerAtual,ArrayList<Jogador> players){
        Scanner escolher = new Scanner(System.in);
         
        //para que possa ser digitado o numero do jogador escolhido.
        System.out.println("Jogadores disponíveis: ");
    
        for(int i = 0; i < players.size(); i++){
            Jogador jogadores = players.get(i); //acessar um objeto jogador do arraylist
            if( jogadores!= playerAtual){
               System.out.println( i +" - " + jogadores.getCorJogador());  
            }
        }
        int escolhido = escolher.nextInt();
        escolher.nextLine();
        if(escolhido < 0 || escolhido >= players.size()){
            System.out.println("Escolha inválida");
            escolher.next();

        } 
            
        Jogador peaoEscolhido = players.get(escolhido); //peaoescolhido recebe o indice que foi selecionado

            //agora, o peaoEscolhido vai retornar para o inicio.
        System.out.println("O jogador " +peaoEscolhido.getCorJogador()+ " retornou para o início.");
        peaoEscolhido.setPosicao(0);
        
        
        escolher.close(); 
    }*/

    public void avancarCasas(Jogador playerAtual,ArrayList<Jogador>players){
        playerAtual.posicaoAtual(3);
    }


    public void trocarLugar(Jogador playerTroca,ArrayList<Jogador>playersTrocar){
      //fazer metodo para trocar com o ultimo jogaodor.
      //possivelmente vamos tentar realizar a troca pelo indice, de modo que tb inclua o tab
    
    
      
            
    }
    

   
    public void trocarTipoPlayer(Jogador player, ArrayList<Jogador> players ){
    // player para modificar o tipo e o arraylist para encontra esse player e atualizar.
  
        String corJogador = player.getCorJogador();
        Jogador jogadorAlterado = null;
        int mTipo= mudarTipo.nextInt(3); //inicia no 1.
        
        //apos cair nos numeros de 1 a 3, mTipo entra no switch case
        // assim, modificando o tipo do jogador de acordo com o numero.
        switch (mTipo) {
            case 0:
                jogadorAlterado = new JogadorAz(corJogador);
                System.out.println("Seu tipo de jogador agora é o azarado");
                break;

            case 1:
                jogadorAlterado = new JogadorN(corJogador);
                System.out.println("Seu tipo de jogador agora é o normal");
                break;
                
            case 2:
                jogadorAlterado = new JogadorS(corJogador);
                System.out.println("Seu tipo de jogador agora é o de sorte");
                break;
        }
        for(int i = 0; i <players.size(); i++){
            if(players.get(i).getCorJogador().equals(corJogador)){
                players.set(i, jogadorAlterado);
            }
        }
    }

    public Random getMudarTipo() {
        return mudarTipo;
    }

    public void setMudarTipo(Random mudarTipo) {
        this.mudarTipo = mudarTipo;
    }

    /*public Tabuleiro getTabu() {
        return tabu;
    }

    public void setTabu(Tabuleiro tabu) {
        this.tabu = tabu;
    }*/

    
}  
