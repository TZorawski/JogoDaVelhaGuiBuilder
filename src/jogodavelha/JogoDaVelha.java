package jogodavelha;
IMPLEMENTE ELE NÃO PODER MAIS JOGAR DEPOIS DO JOGO ACABAR
ARRUMAR VARIAVEIS GLOBAIS
public class JogoDaVelha {
    private int[][] posicoes = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
    private int estado; // 0 -> não iniciado; 1 -> iniciado; 2 -> finalizado
    private int ganhador; // 0 -> sem ganhadores; 1 -> X; 8 -> O
    private int x = 1;
    private int o = 8;
    private String simboloX = "X";
    private String simboloO = "O";

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getO() {
        return o;
    }

    public void setO(int o) {
        this.o = o;
    }
    
    public String getStringX() {
        return this.simboloX;
    }
    
    public String getStringO() {
        return this.simboloO;
    }

    public int getGanhador() {
        return ganhador;
    }

    
    // Construtor
    public JogoDaVelha() {
        this.iniciarJogo();
    }
    
    // Inicia jogo em branco
    public void iniciarJogo () {
        for (int i = 0; i<3; i++){
            for (int j = 0; j<3; j++){
                System.out.println("limpando");
                this.posicoes[i][j] = 0;
            }
        }
        
        this.estado = 0;
        this.ganhador = 0;
    }
    
    // Realiza jogada
    // Retorna true -> jogada realizada
    // Retorna false -> jogada não realizada: posição já ocupada ou jogador inválido
    public boolean jogar (int lin, int col, int jogador) {
        // Jogador inválido
        if (jogador != this.x && jogador != this.o) {
            return false;
        }
        
        // Jogada realizada
        if (this.posicoes[lin][col] == 0) {
            this.posicoes[lin][col] = jogador;
            return true;
        }
        
        // Posição já ocupada
        return false;
    }
    
    // Verifica o estado do jogo e o ganhador
    // Retorna true -> jogo terminado
    // retorna false -> jogo ainda não terminou
    public boolean verificaJogo () {
        int soma;
        System.out.println(this.posicoes);
        // Vencedor nas diagonais
        if (( ((this.posicoes[0][0] == this.posicoes[1][1]) && (this.posicoes[1][1] == this.posicoes[2][2])) 
                || ((this.posicoes[0][2] == this.posicoes[1][1]) && (this.posicoes[1][1] == this.posicoes[2][0])) )
                && this.posicoes[1][1] != 0 ) {
            this.estado = 2;
            this.ganhador = this.posicoes[1][1];
            return true;
        }
        
        // Vencedor nas linhas
        for (int i = 0; i<3; i++){
            soma = 0;
            for (int j = 0; j<3; j++){
                soma += this.posicoes[i][j];
            }
            System.out.println(soma);
            if (soma == (this.x * 3) || soma == (this.o * 3) ) {
                System.out.println("entrou1");
                this.estado = 2;
                this.ganhador = this.posicoes[i][0];
                return true;
            }
        }
        
        // Vencedor nas colunas
        for (int i = 0; i<3; i++){
            soma = 0;
            for (int j = 0; j<3; j++){
                soma += this.posicoes[j][i];
            }
            System.out.println(soma);
            if (soma == (this.x * 3) || soma == (this.o * 3) ) {
                System.out.println("entrrou2");
                this.estado = 2;
                this.ganhador = this.posicoes[0][i];
                return true;
            }
        }
        
        // Empate
        boolean casaVazia = false;
        for (int i = 0; i<3; i++){
            for (int j = 0; j<3; j++){
                if (this.posicoes[i][j] == 0)
                casaVazia = true;
            }
        }
        if (casaVazia == false) {
            this.estado = 2;
            this.ganhador = 0;
            return true;
        }
        
        return false;
    }
}
