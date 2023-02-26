package quanlynhadat.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import quanlynhadat.Models.Transaction;
import quanlynhadat.File.HomeTransactionFile;
import quanlynhadat.File.LandTransactionFile;

public class TransactionController {

    // Lấy toàn bộ danh sách giao dịch
    public static List<Transaction> getAllTransaction() {
        List<Transaction> list = new ArrayList<Transaction>();
        List<Transaction> list1 = new ArrayList<Transaction>();
        HomeTransactionFile hf = new HomeTransactionFile();
        LandTransactionFile lf = new LandTransactionFile();
        try {
            list = lf.readLandTransaction();
        } catch (IOException ex) {
            Logger.getLogger(TransactionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            list1 = hf.readHomeTransaction();
        } catch (IOException ex) {
            Logger.getLogger(TransactionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        list.addAll(list1);
        
        return list;
        
    }
    

    // Lấy toàn bộ danh sách giao dịch theo idUser
    public static List<Transaction> getAllTransactionByUser(String idUser) {
        List<Transaction> list = new ArrayList<Transaction>();
        List<Transaction> list1 = new ArrayList<Transaction>();
        List<Transaction> list2 = new ArrayList<Transaction>();
        HomeTransactionFile hf = new HomeTransactionFile();
        LandTransactionFile lf = new LandTransactionFile();
        try {
            list = lf.readLandTransaction();
        } catch (IOException ex) {
            Logger.getLogger(TransactionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            list1 = hf.readHomeTransaction();
        } catch (IOException ex) {
            Logger.getLogger(TransactionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        list.addAll(list1);
        for(Transaction i :list){
            if(i.getId() == Integer.parseInt(idUser)){
                list2.add(i);
            }
        }
        
        
        return list2;
    }

    // Lấy toàn bộ danh sách giao dịch theo năm
    public static List<Transaction> getAllTransactionByYear(String year) {
        List<Transaction> list = new ArrayList<Transaction>();
        List<Transaction> list1 = new ArrayList<Transaction>();
        List<Transaction> list2 = new ArrayList<Transaction>();
        HomeTransactionFile hf = new HomeTransactionFile();
        LandTransactionFile lf = new LandTransactionFile();
        try {
            list = lf.readLandTransaction();
        } catch (IOException ex) {
            Logger.getLogger(TransactionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            list1 = hf.readHomeTransaction();
        } catch (IOException ex) {
            Logger.getLogger(TransactionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        list.addAll(list1);
        SimpleDateFormat sd = new SimpleDateFormat("yyyy");
        for(Transaction i:list){
            if(sd.format(i.getT_date()).equalsIgnoreCase(year)){
                list2.add(i);
            }
        }
        return list2;
    }

    // Lấy toàn bộ danh sách giao dịch theo idUser và năm
    public static List<Transaction> getAllTransactionByUserAndYear(String idUser, String year) {
        List<Transaction> list = new ArrayList<Transaction>();
        List<Transaction> list1 = new ArrayList<Transaction>();
        List<Transaction> list2 = new ArrayList<Transaction>();
        HomeTransactionFile hf = new HomeTransactionFile();
        LandTransactionFile lf = new LandTransactionFile();
        try {
            list = lf.readLandTransaction();
        } catch (IOException ex) {
            Logger.getLogger(TransactionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            list1 = hf.readHomeTransaction();
        } catch (IOException ex) {
            Logger.getLogger(TransactionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        list.addAll(list1);
        SimpleDateFormat sd = new SimpleDateFormat("yyyy");
        for(Transaction i:list){
            if(sd.format(i.getT_date()).equalsIgnoreCase(year) && i.getId() == Integer.parseInt(idUser)){
                list2.add(i);
            }
        }
        return list2;
    }

    // Lấy toàn bộ danh sách giao dịch theo tháng năm
    public static List<Transaction> getAllTransactionByMonthYear(String year, String month) {
        List<Transaction> list = new ArrayList<Transaction>();
        List<Transaction> list1 = new ArrayList<Transaction>();
        List<Transaction> list2 = new ArrayList<Transaction>();
        HomeTransactionFile hf = new HomeTransactionFile();
        LandTransactionFile lf = new LandTransactionFile();
        try {
            list = lf.readLandTransaction();
        } catch (IOException ex) {
            Logger.getLogger(TransactionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            list1 = hf.readHomeTransaction();
        } catch (IOException ex) {
            Logger.getLogger(TransactionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        list.addAll(list1);
        String[] arrchar = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        for(String i:arrchar){
            if(i.equalsIgnoreCase(month)){
                month = "0" + month;
                break;
            }
        }
        SimpleDateFormat sdy = new SimpleDateFormat("yyyy");
        SimpleDateFormat sdm = new SimpleDateFormat("MM");
        for(Transaction i:list){
            if(sdy.format(i.getT_date()).equalsIgnoreCase(year) && sdm.format(i.getT_date()).equalsIgnoreCase(month)){
                list2.add(i);
            }
        }
        return list2;
    }


    // Lấy toàn bộ danh sách giao dịch theo idUser và tháng năm
    public static List<Transaction> getAllTransactionByUserAndMonthYear(String idUser, String year, String month) {
        List<Transaction> list = new ArrayList<Transaction>();
        List<Transaction> list1 = new ArrayList<Transaction>();
        List<Transaction> list2 = new ArrayList<Transaction>();
        HomeTransactionFile hf = new HomeTransactionFile();
        LandTransactionFile lf = new LandTransactionFile();
        try {
            list = lf.readLandTransaction();
        } catch (IOException ex) {
            Logger.getLogger(TransactionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            list1 = hf.readHomeTransaction();
        } catch (IOException ex) {
            Logger.getLogger(TransactionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        list.addAll(list1);
        String[] arrchar = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        for(String i:arrchar){
            if(i.equalsIgnoreCase(month)){
                month = "0" + month;
                break;
            }
        }
        SimpleDateFormat sdy = new SimpleDateFormat("yyyy");
        SimpleDateFormat sdm = new SimpleDateFormat("MM");
        for(Transaction i:list){
            if(sdy.format(i.getT_date()).equalsIgnoreCase(year) && sdm.format(i.getT_date()).equalsIgnoreCase(month) && i.getId() == Integer.parseInt(idUser)){
                list2.add(i);
            }
        }
        
        return list2;
    }

}
