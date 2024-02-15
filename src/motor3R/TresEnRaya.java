package motor3R;

public class TresEnRaya {

    private char[][] tablero = new char[3][3];
    private final char VACIA = '-';
    private final char HUMANO;
    private final char MAQUINA;


    public TresEnRaya(char humano, char maquina){
        this.HUMANO = humano;
        this.MAQUINA = maquina;

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                tablero[i][j] = VACIA;
            }
        }
    }

    public char getHumano(){
        return HUMANO;
    }

    public char getMaquina(){
        return MAQUINA;
    }

    public char[][] getTablero(){
        return this.tablero;
    }

    public void setTablero(int f, int c,char hm){
        tablero[f][c] = hm;
    }

    public boolean estaVacia(int fila, int columna){
        if(tablero[fila][columna]!='-'){
            return false;
        }
        return true;
    }

    public boolean quedanHuecos(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(tablero[i][j]==VACIA){
                    return true;
                }
            }
        }
        return false;
    }

    public char hayTresEnRaya(){
        char c = VACIA;
        if(hayTresEnRayaFila()!=VACIA){
            c = hayTresEnRayaFila();
        }else if(hayTresEnRayaColumna()!=VACIA){
            c = hayTresEnRayaColumna();
        }else if(hayTresEnRayaDiagonal()!=VACIA){
            c = hayTresEnRayaDiagonal();
        }
        return c;
    }

    private char  hayTresEnRayaFila(){
        char c;
        for(int i=0;i<3;i++){
            c = tablero[i][0];
            if(c!=VACIA){
                if(c==tablero[i][1] && c==tablero[i][2]){
                    return c;
                }
            }
        }
        return VACIA;
    }

    private char hayTresEnRayaColumna(){
        char c;
        for(int i=0;i<3;i++){
            c = tablero[0][i];
            if(c!=VACIA){
                if(c==tablero[1][i] && c==tablero[2][i]){
                    return c;
                }
            }
        }
        return VACIA;
    }

    private char hayTresEnRayaDiagonal(){
        char c=tablero[0][0];
        if(c==tablero[1][1] && c==tablero[2][2]){
            return c;
        }
        c=tablero[0][2];
        if(c==tablero[1][1] && c==tablero[2][0]){
            return c;
        }
        return VACIA;
    }

    void juegaHumano(int fila, int columna){
        if(estaVacia(fila, columna)){
            tablero[fila][columna] = HUMANO;
        }
    }
    
}
