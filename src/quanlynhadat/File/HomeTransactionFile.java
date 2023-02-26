/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlynhadat.File;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
//import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
//import quanlynhadat.Models.Account;
import quanlynhadat.Models.Transaction;

/**
 *
 * @author Vương Linh
 */
public class HomeTransactionFile {
    private static final String FILE_NAME ="HomeTransaction.txt";
    
    public static void writeHomeTransaction(List<Transaction> homeList) throws IOException{
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            fos = new FileOutputStream(new File(FILE_NAME));
            oos = new ObjectOutputStream(fos);

            System.out.println(homeList.size());
            for (Transaction a : homeList) {
                if(a.getT_type().compareToIgnoreCase("cao cấp") == 0 || a.getT_type().compareToIgnoreCase("thuong") == 0){
                    oos.writeObject(a);
                }
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } finally {
            try {
                if( oos != null && fos != null){
                    oos.close();
                    fos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(HomeTransactionFile.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    public List<Transaction> readHomeTransaction() throws  IOException{
        List<Transaction> homeList = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(new File(FILE_NAME));
            ois = new ObjectInputStream(fis);

            while(fis.available() > 0){
                Transaction a = (Transaction) ois.readObject();
                homeList.add(a);
            }
        } catch (FileNotFoundException e) {
        } catch (IOException | ClassNotFoundException e) {
        } finally {
            try {
                if(fis != null && ois != null){
                    ois.close();
                    fis.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(HomeTransactionFile.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
        return homeList;
    }
    
    
   
 
}
