import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class Interface extends JFrame {
    public Interface(Matriz sudo){
        this.setSize(500, 500); //tamaño
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //parar programa al darle X
        this.setTitle("Mi Primera Ventana"); //Titulo
        //this.setLocation(600,200); //Posicion
        //this.setBounds(710, 200, 500, 500); //Tamaño + Posicion
        this.setLocationRelativeTo(null); //Posicion centrada
        //this.getContentPane().setBackground(Color.blue);
        this.iniciarComponentes(sudo);
    }

    public void iniciarComponentes(Matriz sudo){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        //panel.setBackground(Color.green);
        this.getContentPane().add(panel);

        JLabel etiqueta = new JLabel("Mi primera etiquieta de texto", SwingConstants.CENTER);
        panel.add(etiqueta);
        etiqueta.setOpaque(true);
        etiqueta.setText("Mi primera modificación a la etiqueta de texto");
        etiqueta.setBounds(50, 50, 400, 20);
        etiqueta.setForeground(Color.red);
        etiqueta.setBackground(Color.blue);
        squareLabels(panel,sudo);

    }

    public void squareLabels (JPanel panel, Matriz sudo){
        JLabel labels[][] = new JLabel[9][9];
        for (int i = 0; i<9; i++){
            for (int j = 0; j<9; j++){
                int x = 80 + 20*i, y = 80 + 20*j;
                labels[i][j] = new JLabel();
                panel.add(labels[i][j]);
                labels[i][j].setOpaque(true);
                labels[i][j].setText(sudo.retornarSquare(i,j));
                labels[i][j].setBounds(x,y,10,10);
            }
        }
    }

    public void paint(Graphics gp) {
        super.paint(gp);
        Graphics2D graphics = (Graphics2D) gp;
        Line2D line = new Line2D.Float(80, 120, 260, 120);
        graphics.draw(line);
    }
}
