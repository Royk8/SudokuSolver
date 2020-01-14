import java.util.ArrayList;

public class Matriz {
    private ArrayList<Integer> M[][];
    private ArrayList<Integer> VI[];
    private ArrayList<Integer> VJ[];
    private ArrayList<Integer> VBox[];
    private int changes = 0;

    public Matriz(){
        M = new ArrayList[9][9];
        VI = new ArrayList[9];
        VJ = new ArrayList[9];
        VBox = new ArrayList[9];
        for(int i=0; i<=8; i++){
            for(int j=0; j<=8; j++) {
                M[i][j] = new ArrayList<>();
                for (int k = 1; k <= 9; k++)
                    M[i][j].add(k);
            }
        }
        for(int i=0; i < 9; i++){
            VI[i] = new ArrayList<>();
            VJ[i] = new ArrayList<>();
            VBox[i] = new ArrayList<>();
            for(int k = 1; k <= 9; k++){
                VI[i].add(k);
                VJ[i].add(k);
                VBox[i].add(k);
            }
        }
    }

    public void printMatriz(){
        for(int i=0; i<9; i++){
            for(int j =0; j<9; j++){
                System.out.print(M[i][j].toString());
            }
            System.out.println("");
        }
    }

    public String retornarSquare(int i, int j){
        if(M[i][j].size() == 1) return Integer.toString(M[i][j].get(0));
        return "0";
    }

    public void printSudoku(){
        for(int i=0; i<9; i++){
            if(i%3==0) System.out.println("__________________________________________________________________________");
            for(int j =0; j<9; j++){
                if(j%3==0) System.out.print("|");
                if(M[i][j].size()==1){
                    System.out.print("\t"+M[i][j].get(0)+"\t");
                }else{
                    System.out.print("\t0\t");
                }
            }
            System.out.println("|");
        }
        System.out.println("__________________________________________________________________________");
    }

    public void addDate(int d, int i, int j){
        for(int k = 0; k < M[i][j].size(); k++){
            if(M[i][j].get(k) != d){
                M[i][j].remove(k);
                k--;
            }
        }
        cleanVector();
    }

    public void solveFirst(){
        int iterador = 0, contador = 0;
        do {
            iterador = 0;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    for (int k = 0; k < M[i][j].size(); k++) {
                        int d = M[i][j].get(k);
                        if (compareBox(d, i, j) || compareColumn(d, i, j) || compareLine(d, i, j)) {
                            M[i][j].remove(k);
                            k--;
                            iterador++;
                        }
                    }
                }
            }
            contador++;
        }while(iterador != 0);
        System.out.println("Se itero "+ contador +" veces.");
        //cleanVector();
    }

    public void solveSecond(){
        System.out.println("Comenzando SolveSecond");
        do {
            changes = 0;
            for (int i = 0; i < 9; i++)
                solveSecondLines(i);
            solveFirst();
            for (int i = 0; i < 9; i++)
                solveSecondColumns(i);
            solveFirst();
            for (int i = 0; i < 9; i++)
                solveSecondBoxes(i);
            solveFirst();
            printMatriz();
        }while(changes != 0);
    }

    private void solveSecondLines(int i){
        for(int k = 0; k < VI[i].size(); k++){
            int options = 0, onlyOption = 0;
            int comparing = VI[i].get(k);
            for(int j = 0; j < 9; j++) {
                if (M[i][j].size() > 1 && M[i][j].contains(comparing)) {
                    options++;
                    onlyOption = j;
                }
            }
            if(options == 1) {
                addDate(comparing, i, onlyOption);
                changes++;
            }
        }
    }

    private void solveSecondColumns(int j){
        for(int k = 0; k < VJ[j].size(); k++){
            int options = 0, onlyOption = 0;
            int comparing = VJ[j].get(k);
            for(int i = 0; i < 9; i++){
                if(M[i][j].size() > 1 && M[i][j].contains(comparing)){
                    options++;
                    onlyOption = i;
                }
            }
            if(options == 1) {
                addDate(comparing, onlyOption, j);
                changes++;
            }
        }
    }

    private void solveSecondBoxes(int box){
        int cI=0, cJ=0;
        if(box>=0 && box<3) cI = 0;
        else if(box>=3 && box<6) cI = 3;
        else cI = 6;
        if(box%3 == 0) cJ = 0;
        else if(box%3 == 1) cJ = 3;
        else cJ = 6;
        for(int k = 0; k < VBox[box].size(); k++){
            int comparing = VBox[box].get(k);
            int options = 0, onlyOptionI = 0, onlyOptionJ = 0;
            int boxCounterI=0, boxCounterJ =0;
            while(boxCounterI <3){
                boxCounterJ = 0;
                while (boxCounterJ <3){
                    int iIndex = cI + boxCounterI;
                    int jIndex = cJ + boxCounterJ;
                    if(M[iIndex][jIndex].size() > 1 && M[iIndex][jIndex].contains(comparing)){
                        onlyOptionI = iIndex;
                        onlyOptionJ = jIndex;
                        options++;
                    }
                    boxCounterJ++;
                }
                boxCounterI++;
            }
            if(options == 1) {
                addDate(comparing, onlyOptionI, onlyOptionJ);
                changes++;
            }
        }

    }

    private void cleanVector(){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(M[i][j].size() == 1) {
                    int del = M[i][j].get(0);
                    int box = whatBox(i,j);
                    if (VI[i].contains(del)) VI[i].remove(VI[i].indexOf(del));
                    if (VJ[j].contains(del)) VJ[j].remove(VJ[j].indexOf(del));
                    if (VBox[box].contains(del)) VBox[box].remove(VBox[box].indexOf(del));
                }
            }
        }
    }

    private int whatBox(int i, int j){
        switch (i/3){
            case 0:
                if(j/3 == 0) return 0;
                else if(j/3 == 1) return 1;
                else return 2;
            case 1:
                if(j/3 == 0) return 3;
                else if(j/3 == 1) return 4;
                else return 5;
            case 2:
                if(j/3 == 0) return 6;
                else if(j/3 == 1) return 7;
                else return 8;
        }
        return -1;
    }

    public boolean compareLine(int d, int i, int j){
        for(int cJ = 0; cJ<9; cJ++){
            if(cJ == j) continue;
            if(M[i][cJ].size() == 1 && M[i][cJ].get(0)==d) return true;
        }
        return false;
    }

    public boolean compareColumn(int d, int i, int j){
        for(int cI = 0; cI<9; cI++){
            if(cI == i) continue;
            if(M[cI][j].size() == 1 && M[cI][j].get(0)==d) return true;
        }
        return false;
    }

    public boolean compareBox(int d, int i, int j){
        int cI=0, cJ=0, boxCounterI=0, boxCounterJ =0;
        if(i>=0 && i<3) cI = 0;
        else if(i>=3 && i<6) cI = 3;
        else if(i>=6 && i<9) cI = 6;
        if(j>=0 && j<3) cJ = 0;
        else if(j>=3 && j<6) cJ = 3;
        else if(j>=6 && j<9) cJ = 6;
        while(boxCounterI <3){
            while (boxCounterJ <3){
                if(cI+boxCounterI == i && cJ+boxCounterJ == j) {
                    boxCounterJ++;
                    continue;
                }
                if(M[cI+boxCounterI][cJ+boxCounterJ].size() == 1 && M[cI+boxCounterI][cJ+boxCounterJ].get(0) == d) return true;
                boxCounterJ++;
            }
            boxCounterI++;
        }
        return false;
    }
    /*public void llenarEspacio(int i, int j) {
        for(int k=1; k<=9; k++)
            M[i][j].add(k);
    }*/
}
