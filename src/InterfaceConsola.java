
import motor3R.TresEnRaya;

import java.util.Scanner;
public class InterfaceConsola {
    static Scanner sc = new Scanner(System.in);
    static int fila;
    static int columna;

    char MenuDificultad(){
        System.out.println("Escoge un nivel de dificultad\n\tfacil(f)\n\tintermedio(i)\n\tdificil(d)");
        char nivel = sc.next().charAt(0);
        return nivel;
    }

    static void muestraTablero(char[][] tablero){
        for(int i=0;i<3;i++){
            System.out.print("| ");
            for(int j=0;j<3;j++){
                System.out.print(tablero[i][j]+" ");
            }
            System.out.println("|");
        }
    }

    static void turnoHumano(TresEnRaya tres){
        
        System.out.println("\tTeclea la fila:  ");
        fila = sc.nextInt();
        System.out.println("\tTeclea la columna:  ");
        columna = sc.nextInt();
        boolean ocupada = true;
        while(ocupada){
            if(tres.estaVacia(fila, columna)){
                tres.setTablero(fila,columna,tres.getHumano());
                ocupada = false;
                break;
            }
        System.out.println("\tTeclea la fila:  ");
        fila = sc.nextInt();
        System.out.println("\tTeclea la columna:  ");
        columna = sc.nextInt();
        }
    }

    static void turnoMaquina(TresEnRaya tres){
        int fila;
        int columna;
        System.out.println("\tTurno de la MAQUINA");
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(tres.getTablero()[i][j]=='-'){
                    tres.setTablero(i, j, tres.getMaquina());
                    return;
                }
            }
        }
    }
/* REVISAR BIEN ANTES ESTABA COMO BOLEAN
    static char elGanadorEs(TresEnRaya tres, char c){
        char c = false;
        if(tres.hayTresEnRaya()==tres.getHumano()){
            System.out.println("Enhorabuena Has Ganado");
            b= true;
        }else if(tres.hayTresEnRaya()== tres.getMaquina()){
            System.out.println("JAJA te he vencido");
            b = true;
        }
        return b;
    }

*/
    public static void main(String[] args) {

        boolean ganahumano = false;
        boolean ganamaquina = false;

        
        TresEnRaya tres = new TresEnRaya('X', 'O');
        while(tres.quedanHuecos()){
            
            muestraTablero(tres.getTablero());
            turnoHumano(tres);
            muestraTablero(tres.getTablero());

            if(tres.hayTresEnRaya()==tres.getHumano()){
                ganahumano = true;
                break;
            }
            turnoMaquina(tres);
            muestraTablero(tres.getTablero());
            if(tres.hayTresEnRaya()==tres.getMaquina()){
                ganamaquina = true;
                break;
            }
        }





    }

}
