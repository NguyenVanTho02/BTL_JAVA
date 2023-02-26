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
public class LandTransactionFile {
    private static final String FILE_NAME ="LandTransaction.txt";
    
    public static void writeLandTransaction(List<Transaction> landList) throws IOException{
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            fos = new FileOutputStream(new File(FILE_NAME));
            oos = new ObjectOutputStream(fos);

            System.out.println(landList.size());
            for (Transaction a : landList) {
                if(a.getT_type().compareToIgnoreCase("A") == 0 || a.getT_type().compareToIgnoreCase("B") == 0 || a.getT_type().compareToIgnoreCase("C") == 0){
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
                Logger.getLogger(LandTransactionFile.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    public List<Transaction> readLandTransaction() throws  IOException{
        List<Transaction> landList = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(new File(FILE_NAME));
            ois = new ObjectInputStream(fis);

            while(fis.available() > 0){
                Transaction a = (Transaction) ois.readObject();
                landList.add(a);
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
                Logger.getLogger(LandTransactionFile.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
        return landList;
    }
//    public static void main(String[] args) throws IOException{
//        Date n = new Date();
//        Transaction t1 = new Transaction (1,n,1000,"A",1000,3);
//        Transaction t2 = new Transaction (2,n,1000,"B",1000,3);
//        Transaction t3 = new Transaction (3,n,1000,"C",1000,3);
//        Transaction t4 = new Transaction (4,n,1000,"A",1000,2);
//        List<Transaction> lts = new ArrayList<Transaction>();
//        lts.add(t1);
//        lts.add(t2);
//        lts.add(t3);
//        lts.add(t4);
//        writeLandTransaction(lts);
//        
//    }
}
