
import motor3R.TresEnRaya;

import java.util.Scanner;
public class InterfaceConsola {
    Scanner sc = new Scanner(System.in);
    int fila;
    int columna;

    char MenuDificultad(){
        System.out.println("Escoge un nivel de dificultad\n\tfacil(f)\n\tintermedio(i)");//\n\tdificil(d)");
        char nivel = sc.next().toLowerCase().charAt(0);
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
        System.out.println("\t..juegas tu..");
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
            System.out.println("esa celda está ocupada");
            System.out.println("\tTeclea la fila:  ");
            fila = sc.nextInt();
            System.out.println("\tTeclea la columna:  ");
            columna = sc.nextInt();
        }
    }

    boolean hayGanador(TresEnRaya tres){
        boolean b = false;
        if(tres.hayTresEnRaya()==tres.getHumano()){
            System.out.println("\nEnhorabuena Has Ganado, has tenido suerte\n\n");
            b = true;
        }else if(tres.hayTresEnRaya()== tres.getMaquina()){
            System.out.println("\nJAJAJAJA te he vencido....SOY LA MAQUINAAAA\n\n");
            b = true;
        }else{
            System.out.println("\nHay EMPATE no ha ganado nadie\n\n");   
        }
        return b;
    }


    public static void main(String[] args) {

        
        InterfaceConsola ic = new InterfaceConsola();                
        TresEnRaya tres = new TresEnRaya('X', 'O');

        char level = ic.MenuDificultad();
        System.out.println("\n\tIniciamos el juego\n");
        ic.muestraTablero(tres.getTablero());

        while(tres.quedanHuecos() || !ic.hayGanador(tres)){
            

            ic.turnoHumano(tres);
            ic.muestraTablero(tres.getTablero());

            if(tres.hayTresEnRaya()==tres.getHumano()){
                break;
            }else if(!tres.quedanHuecos()){
                break;
            }
            System.out.println("\t..juega la máquina..");
            if(level=='f'){
                tres.juegaMaquinaF();
            }else if(level=='i'){
                tres.juegaMaquinaI();
            }
            
            ic.muestraTablero(tres.getTablero());
            if(tres.hayTresEnRaya()==tres.getMaquina()){
                break;
            }
        }
        ic.hayGanador(tres);

    }

}
