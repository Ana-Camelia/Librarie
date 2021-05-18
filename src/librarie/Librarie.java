/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarie;

import java.sql.*;

/**
 *
 * @author camel
 */
public class Librarie {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{  
Class.forName("com.mysql.cj.jdbc.Driver");  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/librarie","root","");  
//here sonoo is database name, root is username and password  
Statement stmt=con.createStatement();  
ResultSet rs=stmt.executeQuery("select * from bon_fiscal");  
/*update vandut V,tip_produs P
SET pret_final=(P.pret_init - P.pret_init * P.reducere /100) + (P.pret_init - P.pret_init * P.reducere /100) * P.tva / 100 + P.taxa_eco
where V.idp=P.idp;
update bon_fiscal
set pret_total=(select S
                from (select bon_fiscal.idb, sum(vandut.pret_final) as S
                from vandut, bon_fiscal
                where vandut.idb=bon_fiscal.idb
                group by vandut.idb)
                WHERE bon_fiscal.idb=vandut.idb);*/
while(rs.next())  
System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
con.close();  
}catch(Exception e){ System.out.println(e);}  
    }
    
}
