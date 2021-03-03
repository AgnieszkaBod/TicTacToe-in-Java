package kolkoikrzyzyk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class ElementsListener implements ActionListener{
   
    private Element[][] elements;
    private int[][] ints;
    JPanel plansza;
   
    public ElementsListener(Element[][] el, int[][] w, JPanel p) {
        elements=el;
        ints=w;
        plansza=p;
    }//konstruktor

 public void restart(boolean koniec){
     if(koniec) //czysci plansze
        {
        
            for(int i=0;i<3;i++)
            {
               for(int j=0;j<3;j++)
               {
                   elements[i][j].stan=0;
                   ints[i][j]=0;
                    elements[i][j].setEnabled(true);
               }
            }
                plansza.repaint();
                koniec=false; //dalej mozna grac
         }
   
}
  
 void zapisz(int znak) throws FileNotFoundException{
 
     Date now = new Date();
    
 File plik= new File("wyniki.txt");
  
  try (PrintWriter zapis = new PrintWriter(plik)) {
    
     
     if(znak==1){
         zapis.println("Wygrales! "+now); 
      }
     
    else if(znak==2){
         zapis.println("Wygral komputer! "+now);
         }
   else if (znak==0){
         zapis.println("Remis! "+now);
      }
     zapis.close();    
  }
            
         
}
 
    private boolean sprawdz(int a, boolean t) //a-- sprawdza czy wstawione jest kolko czy krzyzk 
          {
              if(a==1){
        //===== poziom 
        if(ints[0][0]==1 && ints[0][1]==1 && ints[0][2]==1) {
                  if(t) JOptionPane.showMessageDialog(null, "Wygrales!!");//Klasa JOptionPane z biblioteki Swing, metoda do wyswietlanai komunikatu
                  return true;
              }
        
        if(ints[1][0]==1 && ints[1][1]==1 && ints[1][2]==1) {
                  if(t) JOptionPane.showMessageDialog(null, "Wygrales!!");
                  return true;
              }
        
        if(ints[2][0]==1 && ints[2][1]==1 && ints[2][2]==1) {
                  if(t) JOptionPane.showMessageDialog(null, "Wygrales!!");
                  return true;
              }
          }
     
        //==== pion dla usera
        if(ints[0][0]==1 && ints[1][0]==1 && ints[2][0]==1) {
                  if(t) JOptionPane.showMessageDialog(null, "Wygrales!!");
                  return true;
              }
        
        if(ints[0][1]==1 && ints[1][1]==1 && ints[2][1]==1) {
                  if(t) JOptionPane.showMessageDialog(null, "Wygrales!!");
                  return true;
              }
        
        if(ints[0][2]==1 && ints[1][2]==1 && ints[2][2]==1) {
                  if(t) JOptionPane.showMessageDialog(null, "Wygrales!!");
                  return true;
              }
        
        if(ints[0][0]==1 && ints[1][1]==1 && ints[2][2]==1) {
                  if(t) JOptionPane.showMessageDialog(null, "Wygrales!!");
                  return true;
              }
        
        if(ints[0][2]==1 && ints[1][1]==1 && ints[2][0]==1) {
                  if(t) JOptionPane.showMessageDialog(null, "Wygrales!!");
                  return true;
              }
        
     if(a==2){
        if(ints[0][2]==2 && ints[1][1]==2 && ints[2][0]==2) {
                  if(t) JOptionPane.showMessageDialog(null, "Wygral komputer!!");
                  return true;
              }
            
        if(ints[0][0]==2 && ints[0][1]==2 && ints[0][2]==2) {
                  if(t) JOptionPane.showMessageDialog(null, "Wygral komputer!!");
                   return true;
              }
        
        if(ints[1][0]==2 && ints[1][1]==2 && ints[1][2]==2) {
                  if(t) JOptionPane.showMessageDialog(null, "Wygral komputer!!");
                  return true;
              }
        
        if(ints[2][0]==2 && ints[2][1]==2 && ints[2][2]==2) {
                  if(t) JOptionPane.showMessageDialog(null, "Wygral komputer!!");
                  return true;
              }
        //========== w dol to pion 
        if(ints[0][0]==2 && ints[1][0]==2 && ints[2][0]==2) {
                  if(t) JOptionPane.showMessageDialog(null, "Wygral komputer!!");
                  return true;
              }
        
        if(ints[0][1]==2 && ints[1][1]==2 && ints[2][1]==2) {
                  if(t) JOptionPane.showMessageDialog(null, "Wygral komputer!!");
                  return true;
              }
        
        if(ints[0][2]==2 && ints[1][2]==2 && ints[2][2]==2) {
                  if(t) JOptionPane.showMessageDialog(null, "Wygral komputer!!");
                  return true;
              }
        
        if(ints[0][0]==2 && ints[1][1]==2 && ints[2][2]==2) {
                  if(t) JOptionPane.showMessageDialog(null, "Wygral komputer!!");
                  return true;
              }
        }
        return false;
        }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            Element source = (Element) e.getSource();
            int x = 0, y = 0;
            boolean koniec = false;
            for(int i=0; i<3; i++)
            {
                for(int j=0; j<3; j++)
                {
                    if(elements[i][j]== source) //sprawdzanie który element został klikniety
                    {
                        x=i;
                        y=j;
                        break;
                    }
                }
            }  
            
            elements[x][y].stan=1; //wstawienie krzyzyka
            ints[x][y]=1;
            elements[x][y].setEnabled(false);//zablowkawanie przycisku
           
            koniec = sprawdz(1, true); //sprawdzanie ewentualnej wygranej
            if(koniec==true) {zapisz(1);}
           
            restart(koniec);
            Random rn = new Random();
            int rn1=0,rn2=0;
            int counter=0;
           
            if(koniec == false) {
                
                while(true) //losowanie ruchu komputera
                {
                    counter++;
                    rn1=rn.nextInt(3);// losowanie pozyji x od 0 do 2
                    rn2=rn.nextInt(3); //losowanie pozyji y od 0 do 2
                    
                    if(counter>70) // 70 razy przechodzi maksymalnie tablice w sprawdzaniu czy jest gdzies puste pole
                    {
                        koniec=true;
                        break;
                    }
                    
                    if(elements[rn1][rn2].stan == 0) //sprawdzanie czy pole jest puste
                    {
                        
                        elements[rn1][rn2].stan=2; //wstaw kolko
                        ints[rn1][rn2]=2;
                        elements[rn1][rn2].setEnabled(false);
                        break;
                    }
                    
                }
            }
           
            plansza.repaint(); //odswiezenie widoku komponentów
            
            koniec=sprawdz(2, true); // sprawdz czy komputer wygral
           
            if(koniec==true) {zapisz(2);}
           
            boolean end=true;
        
         for(int i=0; i<3; i++)//sprawdza czy jakies pole jest puste
            {
               for(int j=0;j<3;j++)
                 {
                    if(ints[i][j]==0) end = false;
                 }
            }
          
            if(sprawdz(1, false)==false && sprawdz(2, false)==false && end == true) {
                JOptionPane.showMessageDialog(null, "Remis!"); if(end==true) zapisz(0); koniec=true;
                // jezeli nie ma wygranej ani komputera ani gracza to wstawiam remis i jak wszystkie pola są puste
            }
            restart(koniec); //czyszczenie planszy
       
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ElementsListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        
           
    }
}