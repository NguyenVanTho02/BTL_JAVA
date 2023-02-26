/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlynhadat.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//import java.util.AbstractList;
import java.util.logging.Level;
import java.util.logging.Logger;
import quanlynhadat.Models.Account;
import quanlynhadat.File.AccountFile;
public class AccountController {

    public AccountController() {
    }

    public static List<Account> getAllAccount() {
        List<Account> accounts = new ArrayList<>();
        AccountFile af = new AccountFile();
        try {
            accounts = af.docfile();
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return accounts;
    }
    
    public static List<Account> getAccountsLikeUsername(String name) {
        List<Account> accounts = new ArrayList<>();
        AccountFile af = new AccountFile();
        List<Account> acc = new ArrayList<>();
        try {
            accounts = af.docfile();
            for(Account i: accounts){
                if(i.getUsername().compareToIgnoreCase(name) == 0){
                    acc.add(i);
                }
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return acc;
    }

    public static Account getAccountByID(int id) {
        Account acc = null;
        List<Account> a = new ArrayList<>();
        AccountFile ac = new AccountFile();
        try {
            a = ac.docfile();
        } catch (IOException ex) {
            Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(Account item:a){
            if(item.getId() == id){
                acc = item;
            }
        }
        return acc;
    }

    public static Account checkLogin (String username, String password) throws IOException{
        List<Account> a = new ArrayList<>();
        AccountFile ac = new AccountFile();
        a = ac.docfile();
        Account acc = null;
        for(Account item:a){
            if(item.getPassword().compareToIgnoreCase(password) == 0 && item.getUsername().compareToIgnoreCase(username) == 0 ){
                acc = item;
            }
        }
        return acc;
    }

    public static boolean checkUsername(String username) {
        List<Account> a = new ArrayList<>();
        AccountFile ac = new AccountFile();
        try {
            a = ac.docfile();
        } catch (IOException ex) {
            Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(Account item:a){
            if(item.getUsername().compareToIgnoreCase(username) == 0){
                return true;
            }
        }
        return false;

    }

    public static boolean CreateNewAccount(Account account) {
    List<Account> listaccounts = new ArrayList<Account>();
    AccountFile af = new AccountFile();
        try {
            listaccounts = af.docfile();
        } catch (IOException ex) {
            Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
        }
    try{
        Account ac = new Account();
        ac.setId(101);
        ac.setFullname(account.getFullname());
        ac.setUsername(account.getUsername());
        ac.setPassword(account.getPassword());
        ac.setRole_id(account.getRole_id());
        ac.setStatus(true);
        System.out.println("Create new account success!");
        listaccounts.add(ac);
        af.ghifile(listaccounts);
         return true;
    }catch(Exception e){
        System.out.println(e.getMessage());
        return false;
    }
    }

    public static boolean updateAccount(Account account) {
        List<Account> listaccounts = new ArrayList<Account>();
        AccountFile af = new AccountFile();
        try {
            listaccounts = af.docfile();
        } catch (IOException ex) {
            Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
        }
    int newLocated = -1 ;
    try{
        Account ac = new Account();
        for(int i = 0 ; i < listaccounts.size() ; i++){
            if(listaccounts.get(i).getId() == account.getId()){
                ac = listaccounts.get(i);
                listaccounts.remove(i);
                newLocated = i;
                break;
            }
        }
        ac.setFullname(account.getFullname());
        ac.setUsername(account.getUsername());
        ac.setPassword(account.getPassword());
        if(account.getStatus().compareToIgnoreCase("Đang hoạt động") == 0 ){
            ac.setStatus(true);
        }else{
            ac.setStatus(false);
        }
        System.out.println(ac);
        listaccounts.add(newLocated, ac);
        System.out.println("Update account success!");
        af.ghifile(listaccounts);
         return true;
    }catch(Exception e){
        System.out.println(e.getMessage());
        return false;
    }
    }
    
    public static boolean deleteAccount(Integer accountId, boolean status) {
          List<Account> listaccounts = new ArrayList<Account>();
        AccountFile af = new AccountFile();
        try {
            listaccounts = af.docfile();
        } catch (IOException ex) {
            Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
        }
    try{
    
        Account ac = new Account();
        for(int i = 0 ; i < listaccounts.size() ; i++){
            if(listaccounts.get(i).getId() == accountId && !status){
                ac = listaccounts.get(i);
            }
        }
        listaccounts.remove(ac);
        System.out.println("Delete account success!");
        af.ghifile(listaccounts);
         return true;
    }catch(Exception e){
        System.out.println(e.getMessage());
        return false;
    }
    }

}
