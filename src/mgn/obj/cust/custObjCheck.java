/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mgn.obj.cust;

import mgn.obj._beans.customerBean;

/**
 *
 * @author Lloyd
 */
public class custObjCheck {
     public  String chkNewUserAddr(customerBean b){
         String msg = null;
         int cntr = 0;
         if (b.getHmPhone() == null || b.getHmPhone().trim().length() == 0){
            cntr++;
         }
         if (b.getWkPhone() == null || b.getWkPhone().trim().length() == 0){
             cntr++;
         }
         if (b.getAddr1() == null || b.getAddr1().trim().length() == 0){
             msg = "Mssing Address";
         } else if (b.getCity() == null || b.getCity().trim().length() == 0){
             msg = "Missing City";                     
         } else if (b.getState() == null || b.getState().trim().length() == 0){
             msg = "Missing State";
         } else if (b.getZip() == null || b.getZip().trim().length() == 0){
             msg = "Missing Zip";
         } else if (cntr == 2){
             msg = "Missing Home/Cell/Work Number";
         }
         return msg;
     }
     public  String chkNewUserName(customerBean customerBean){
         String msg = null;
        if (customerBean.getFirstName() ==  null || customerBean.getFirstName().trim().length() == 0){
            msg = "Missing First Name";
        } else if (customerBean.getLastName() == null || customerBean.getLastName().trim().length() == 0){
            msg = "Missing Last Name";
        } 
        return msg;
     }
    public  String chkNewUser(customerBean customerBean){
        String msg = null;
        if (customerBean.getFirstName() ==  null || customerBean.getFirstName().trim().length() == 0){
            msg = "Missing First Name";
        } else if (customerBean.getLastName() == null || customerBean.getLastName().trim().length() == 0){
            msg = "Missing Last Name";
        } else if (customerBean.getEMail() == null || customerBean.getEMail().trim().length() == 0){
            msg = "Missing E-Mail";
        } else if (customerBean.getUserPass() == null || customerBean.getUserPass().trim().length() == 0){
            msg = "Missing Password0";
        } else if (customerBean.getUserPassChk() == null || customerBean.getUserPassChk().trim().length() == 0 ||
                !customerBean.getUserPass().endsWith(customerBean.getUserPassChk())){
            msg = "Conformation don't match";
        } 
        return msg;
    }
}
