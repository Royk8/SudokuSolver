public class main {
    public static void main(String[] args) {
        Matriz sudo = new Matriz();
        sudo.printMatriz();
        /*sudo.addDate(3,0,5);
        sudo.addDate(6,0,6);
        sudo.addDate(2,1,4);
        sudo.addDate(3,2,1);
        sudo.addDate(9,2,2);
        sudo.addDate(8,2,3);
        sudo.addDate(1,2,8);
        sudo.addDate(9,3,0);
        sudo.addDate(4,3,4);
        sudo.addDate(3,3,8);
        sudo.addDate(3,4,0);
        sudo.addDate(4,4,1);
        sudo.addDate(6,4,3);
        sudo.addDate(2,4,5);
        sudo.addDate(8,4,7);
        sudo.addDate(6,5,1);
        sudo.addDate(1,5,4);
        sudo.addDate(9,5,6);
        sudo.addDate(8,6,1);
        sudo.addDate(2,6,6);
        sudo.addDate(5,7,1);
        sudo.addDate(6,7,2);
        sudo.addDate(1,7,3);
        sudo.addDate(3,7,4);
        sudo.addDate(4,7,6);
        sudo.addDate(4,8,0);
        sudo.addDate(8,8,4);
        sudo.addDate(7,8,5);*/

        sudo.addDate(2,0,1);
        sudo.addDate(4,0,5);
        sudo.addDate(3,0,6);
        sudo.addDate(9,1,0);
        sudo.addDate(2,1,4);
        sudo.addDate(8,1,8);
        sudo.addDate(6,2,3);
        sudo.addDate(9,2,5);
        sudo.addDate(5,2,7);
        sudo.addDate(1,3,8);
        sudo.addDate(7,4,1);
        sudo.addDate(2,4,2);
        sudo.addDate(5,4,3);
        sudo.addDate(3,4,5);
        sudo.addDate(6,4,6);
        sudo.addDate(8,4,7);
        sudo.addDate(6,5,0);
        sudo.addDate(8,6,1);
        sudo.addDate(2,6,3);
        sudo.addDate(5,6,5);
        sudo.addDate(1,7,0);
        sudo.addDate(9,7,4);
        sudo.addDate(3,7,8);
        sudo.addDate(9,8,2);
        sudo.addDate(8,8,3);
        sudo.addDate(6,8,7);

        /*sudo.addDate(8,0,0);
        sudo.addDate(3,1,2);
        sudo.addDate(6,1,3);
        sudo.addDate(7,2,1);
        sudo.addDate(9,2,4);
        sudo.addDate(2,2,6);
        sudo.addDate(5,3,1);
        sudo.addDate(7,3,5);
        sudo.addDate(4,4,4);
        sudo.addDate(5,4,5);
        sudo.addDate(7,4,6);
        sudo.addDate(1,5,3);
        sudo.addDate(3,5,7);
        sudo.addDate(1,6,2);
        sudo.addDate(6,6,7);
        sudo.addDate(8,6,8);
        sudo.addDate(8,7,2);
        sudo.addDate(5,7,3);
        sudo.addDate(1,7,7);
        sudo.addDate(9,8,1);
        sudo.addDate(4,8,6);*/

        sudo.printSudoku();
        sudo.printMatriz();
        sudo.solveFirst();
        sudo.printSudoku();
        sudo.printMatriz();
        sudo.solveSecond();
        sudo.printSudoku();
        sudo.printMatriz();

        Interface v1 = new Interface(sudo);
        v1.setVisible(true);

    }
}
