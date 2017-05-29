/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customerbrowser_1;

import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * TENTO PROJEKT STRÁNKUJE VÝPIS DATAZE UŽ V SQL SELECTU !!
 */
public class CustomerBrowser {

    /**
     * projekt byl upraven pro tabulku Zamestnanci databáze rhrtest
     */
    public static void main(String[] args) {
        Customers customers = new Customers();
        Scanner sc = new Scanner(System.in, "Windows-1250");
        System.out.printf("Zadejte heslo do databáze (uživatel rhronza):"); 
        String hsl = sc.nextLine();
        long i;
        for (i=0;i< 25000; i++) {
            try {   
                    int radekOd = 0; 
                    while (radekOd>-1) 
                      { customers.vypisCustomers(hsl, radekOd, 15);
                        //System.out.printf("Pro další zobrazení zadejte první řádek:");
                        //String radekOdString = sc.nextLine();
                        //radekOd = Integer.parseInt(radekOdString); 
                      }   
                }
            catch(SQLException ex){
                System.out.println("Chyba komunikace s databaze:"+ex.getLocalizedMessage());
            }
        System.out.printf(" %5d \n", i);
        }
        
        
        
        
    }
    
}
