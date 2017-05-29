/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customerbrowser_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author roman
 */
public class Customers {
    
    ArrayList <Customer> customers = new ArrayList<>();
    Customer customer =  new Customer();
/*
    public Customers(String heslo, int radekOd, int pocet) throws SQLException {
        
        
    }  KONEC KONSTRUKTORU */
    
    private void posliSelectnaplnArrayList (String heslo, int odRadku, int pocetRadku ) throws SQLException
        {
        try 
            (
                Connection spojeni = DriverManager.getConnection("jdbc:mysql:"
                                                             + "//www.hronza.cz/rhrtest", 
                                                               "rhronza", heslo);
                PreparedStatement dotazSQL = spojeni.prepareStatement("SELECT "
                                                                 + "Jmeno,"
                                                                 + "ID,"
                                                                + "Prijmeni"
                                                                + " FROM Zamestnanci "
                        + "LIMIT ?,?");


            ) /* KONEC TRY-RESOURCE*/       
            {
                dotazSQL.setInt(1, odRadku);
                dotazSQL.setInt(2, pocetRadku);
                ResultSet vysledekSQL  = dotazSQL.executeQuery();
                naplneniArrayListu (vysledekSQL);

            } /* KONEC TRY */
        } /* konec posliSelect */
    
    private void naplneniArrayListu (ResultSet vysledekSQL) throws SQLException{
        Customer radek;
        customers.clear();
        while (vysledekSQL.next()){
            radek = new Customer();
            radek.setId(vysledekSQL.getInt("Id"));
            radek.setJmeno(vysledekSQL.getString("Jmeno"));
            radek.setPrijmeni(vysledekSQL.getString("Prijmeni"));
            // radek.setNarozeni(vysledekSQL.getString("Narozeni"));
            pridatRadek(radek);
        } /* KONEC WHILE */
    }
    
    private void pridatRadek (Customer radekSeznamu){
        customers.add(radekSeznamu);
    }
    
    
    public void vypisCustomers (String heslo, int odRadku, int pocetRadku ) throws SQLException {
        posliSelectnaplnArrayList(heslo, odRadku, pocetRadku); 
        System.out.printf("\n\n");
        for (Customer cu: customers)
              System.out.printf(" %5d  %20s %20s \n",
                     cu.getId(),
                     cu.getJmeno(),
                     cu.getPrijmeni()
                     //cu.getNarozeni()
             );
        System.out.printf("\n");
    };
    
    
    
    
    
    
    
    
    
}
