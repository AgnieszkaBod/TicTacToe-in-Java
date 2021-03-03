
package kolkoikrzyzyk;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Agnieszka
 */
public class KolkoiKrzyzyk extends JFrame{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       KolkoiKrzyzyk  okno = new KolkoiKrzyzyk ();
       okno.setMinimumSize(new Dimension(400, 400));
       okno.setDefaultCloseOperation(EXIT_ON_CLOSE);
       okno.setResizable(false);
       okno.setTitle("Tic-Tac-Toe");
       
       JPanel plansza = new JPanel();
       plansza.setLayout(new GridLayout(3,3));
       Element a[][]= new Element[3][3];
       int wyniki[][]= new int[3][3];
       
       for(int i=0;i<3;i++)
       {
           for(int j=0;j<3;j++)
           {
               a[i][j]= new Element();
               wyniki[i][j]=0;
           }
       }
       for(int i=0;i<3;i++)
       {
           for(int j=0;j<3;j++)
           {
               a[i][j].addActionListener(new ElementsListener(a, wyniki, plansza));
               plansza.add(a[i][j]);
           }
       }
       
       okno.add(plansza);//dodadanie komponetu planasza do okna
       okno.setVisible(true);
    }
    
}
