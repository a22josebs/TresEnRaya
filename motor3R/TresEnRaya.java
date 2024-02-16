package motor3R;

public class TresEnRaya {

    private char[][] tablero = new char[3][3];
    private final char VACIA = '-';
    private final char HUMANO;
    private final char MAQUINA;

    /**
     * crea un nuevo tablero con los caracteres que usará el jugador y la máquina
     * @param humano caracter de la posición escogida por el jugador
     * @param maquina caracter de la posición escogida por la máquina
     */
    public TresEnRaya(char humano, char maquina){
        this.HUMANO = humano;
        this.MAQUINA = maquina;

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                tablero[i][j] = VACIA;
            }
        }
    }

    /*
     * Devuelve el caracter de posición/posiciones sin ocupar
     */
    public char getVacia(){
        return VACIA;
    }

    /**
     * Devuelve el caracter de posición/posiciones ocupada por el jugador
     *@return caracter de jugador
     */
    public char getHumano(){
        return HUMANO;
    }

    /**
     * Devuelve el caracter de posición/posiciones ocupada por la máquina
     * @return caracter de máquina
     */
    public char getMaquina(){
        return MAQUINA;
    }

    /**
     * crea un nuevo tablero
     * @return nuevo tablerode 3x3
     */
    public char[][] getTablero(){
        return this.tablero;
    }

    /**
     * ocupa una posición del tablero con el caracter del jugador o de la máquina según corresponda
     * @param f indica fila
     * @param c indica columna
     * @param hm indica caracter jugador o maquina
     */
    public void setTablero(int f, int c,char hm){
        tablero[f][c] = hm;
    }

    /**
     * comprueba si la celda que se quiere ocupar está vacia
     * @param fila indice de la fila
     * @param columna indice de la columna
     * @return devuelve un true/false 
     */
    public boolean estaVacia(int fila, int columna){
        if(tablero[fila][columna]!='-'){
            return false;
        }
        return true;
    }

    /**
     * comprueba si quedan celdas sin ocupar para seguir jugando
     * @return devuelve un true/false
     */
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

    /**
     * comprueba si se ha hecho tres en raya en cualquier posición
     * @return devuelve el caracter de quien hizo el tres en raya para identificarlo posteriormente
     */
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

    /**
     * comprueba si se ha hecho tres en raya en cualquier fila
     * @return devuelve el caracter de quien hizo el tres en raya para identificarlo posteriormente
     */
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

    /**
     * comprueba si se ha hecho tres en raya en cualquier columna
     * @return devuelve el caracter de quien hizo el tres en raya para identificarlo posteriormente
     */
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

    /**
     * comprueba si se ha hecho tres en raya en cualquier de las dos diagonales
     * @return devuelve el caracter de quien hizo el tres en raya para identificarlo posteriormente
     */
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

    /**
     * marca la jugada del jugador
     * @param fila fila en la que se quiere marcar
     * @param columna columna en la que se quiere apuntar
     */
    void juegaHumano(int fila, int columna){
        if(estaVacia(fila, columna)){
            tablero[fila][columna] = HUMANO;
        }
    }
    
    /**
     * marca la jugada de la máquina
     */
    public void juegaMaquinaF(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(getTablero()[i][j]=='-'){
                    setTablero(i, j, getMaquina());
                    return;
                }
            }
        }

    }
}
