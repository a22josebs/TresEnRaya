
import motor3R.TresEnRaya;

import java.util.Scanner;
public class InterfaceConsola {
    Scanner sc = new Scanner(System.in);
    int fila;
    int columna;

    char MenuDificultad(){
        System.out.println("Escoge un nivel de dificultad\n\tfacil(f)\n\tintermedio(i)\n\tdificil(d)");
        char nivel = sc.next().charAt(0);
        return nivel;
    }

    void muestraTablero(char[][] tablero){
        for(int i=0;i<3;i++){
            System.out.print("| ");
            for(int j=0;j<3;j++){
                System.out.print(tablero[i][j]+" ");
            }
            System.out.println("|");
        }
    }

    void turnoHumano(TresEnRaya tres){
        
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

    void turnoMaquina(TresEnRaya tres){
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

    boolean hayGanador(TresEnRaya tres){
        boolean b = false;
        if(tres.hayTresEnRaya()==tres.getHumano()){
            System.out.println("\nEnhorabuena Has Ganado, has tenido suerte\n\n");
            b = true;
        }else if(tres.hayTresEnRaya()== tres.getMaquina()){
            System.out.println("\nJAJAJAJA te he vencido....SOY LA MAQUINAAAA\n\n");
        }else{
            System.out.println("\nHay EMPATE no ha ganado nadie\n\n");
            b = true;
        }
        return b;
    }


    public static void main(String[] args) {

        InterfaceConsola ic = new InterfaceConsola();                
        TresEnRaya tres = new TresEnRaya('X', 'O');

        System.out.println("\nIniciamos el juego\n");
        ic.muestraTablero(tres.getTablero());

        while(tres.quedanHuecos() || !ic.hayGanador(tres)){
            
            ic.turnoHumano(tres);
            ic.muestraTablero(tres.getTablero());

            if(tres.hayTresEnRaya()==tres.getHumano()){
                break;
            }
            ic.turnoMaquina(tres);
            ic.muestraTablero(tres.getTablero());
            if(tres.hayTresEnRaya()==tres.getMaquina()){
                break;
            }
        }
        ic.hayGanador(tres);
        




    }

}
