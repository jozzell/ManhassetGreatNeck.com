/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mgn.obj.cust;

import java.io.Serializable;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import mgn.obj._beans.customerBean;
import mgn.obj._beans.customerLinkBean;
import obj.db.v1.dbMgrInterface;
import org.apache.log4j.Logger;
//import org.apache.log4j.Logger;
//import org.apache.log4j.Logger;
import sun.jdbc.rowset.CachedRowSet;

/**
 *
 * @author lmeans
 */
public class custObj  implements Serializable{
    private final String NonEMail="NonEMail";
    public  final Logger logger = (Logger) Logger.getLogger(custObj.class);
     custSql custSql;
    public custObj(){
        custSql = new custSql();
    }
    public void insertIntoLink(customerBean b,customerLinkBean bean, dbMgrInterface db){
        insertIntoLink(b.getCustId(),b.getCustId(),bean,db);
    }
    public void insertIntoLink(int id,int rollup,customerLinkBean bean, dbMgrInterface db){
        try {
            db.updateDatabase(custSql.sqlDeleteLink,  new Object[]{id,rollup});
            db.updateDatabase(custSql.sqlInsertCustLink, new Object[]{id,rollup,bean.getDob(),bean.getType()});
            //sqlInsertCustLink
        } catch (Exception ex) {
            logger.error(ex.toString());
        }
    }
    public  int createUser(customerBean b, dbMgrInterface db) {
        b.setEMail(this.genEMail(b.getEMail()));
        //b.setEMail(b.getEMail().toLowerCase());
        try {
            if (b.getCustId() == 0) {
                db.updateDatabase(custSql.sqlInsertCust, getObject(b, false));
                return getCustID(b.getEMail(),db);
            } else {
                db.updateDatabase(custSql.sqlUpdateCust, getObject(b, true));
            }
        } catch (Exception ex) {
            logger.error(ex.toString());
        }
        return b.getCustId();
    }
    public  int getCustID(String email,dbMgrInterface db){
        int i = -1;
        CachedRowSet r;
        try {
            r = db.getCachedRowSet(custSql.sqlSelectCustChk, new Object[]{email});
            while(r.next()){
                i = r.getInt(1);
            }
        } catch (Exception ex) {
            logger.error(ex.toString());
        }
        return i;
    }
     public  List<customerBean> getcustomerList_link(int id,dbMgrInterface db){
        List<customerBean> b = new ArrayList<customerBean>();
        CachedRowSet r;
         try {
            r = db.getCachedRowSet(custSql.sqlCustLink, new Object[]{id});
            while(r.next()){
                customerBean x = getcustomerBean(r);
                x.setSlot01(r.getString(21));
                b.add(x);
            }
        } catch (Exception ex) {
            logger.error(ex.toString());
        }
        return b;
    }
    public  customerBean getcustomerBean(int id,dbMgrInterface db){
        customerBean b = null;
        CachedRowSet r;
         try {
            r = db.getCachedRowSet(custSql.sqlSelectByCustID, new Object[]{id});
            while(r.next()){
                b = getcustomerBean(r);
            }
        } catch (Exception ex) {
            logger.error(ex.toString());
        }
        return b;
    }
    public  customerBean getcustomerBeanEMail(String email,int id,dbMgrInterface db){
        if (email == null) return null;
        customerBean b = null;
        CachedRowSet r;
         try {
            r = db.getCachedRowSet(custSql.sqlCust_Email, new Object[]{email.toLowerCase(),id});
            while(r.next()){
                b = getcustomerBean(r);
            }
        } catch (Exception ex) {
            logger.error(ex.toString());
        }
        return b;
    }
    private  customerBean getcustomerBean(CachedRowSet r){
        customerBean b = new customerBean();
        try {
            b.setCustId(r.getInt(1)); 
            b.setEmail_key(r.getString(2)); //email_key ,
            b.setKeyStr(r.getString(3));//keyStr ,
            b.setFirstName(r.getString(4)); //FIRST_NAME , 
            b.setLastName(r.getString(5)); //LAST_NAME, 
            b.setAddr1(r.getString(6));// ADDR1 , "
            b.setAddr2(r.getString(7)); //   + " ADDR2 , "
            b.setCity(r.getString(8));//            + "CITY, "
            b.setState(r.getString(9));    //        + "STATE,"
            b.setHmPhone(r.getString(10));    //        + "HM_PHONE , "
            b.setWkPhone(r.getString(11));          //  + "WK_PHONE , "
            b.setWkExt(r.getString(12));       //     + "WK_EXT ,"
            b.setZip(r.getString(13));  //          + "ZIP , "
            b.setEMail(r.getString(14));   // + " EMAIL ,"
            b.setDbId(r.getInt(15));       //     + "dbId ,	"
            b.setUserName(r.getString(16));  //          + "user_name ,"
            b.setUserPass(r.getString(17));//u            + "user_pass ,	"
            b.setVendorId(r.getInt(18));  //          + "vendor_id ,"
            b.setAccessLevel(r.getInt(19));    //        + "access_lvl  ,   "
            b.setSponsorLinkId(r.getInt(20)); //           + "SPONSOR_LINK_ID
            if (b.getEMail() != null && b.getEMail().contains(NonEMail.toLowerCase())){
                b.setEMail(null);
            }
        } catch (SQLException ex) {
           logger.error(ex.toString());
        }
         return b;
    }
    public  Object[] getObject(customerBean b,boolean update){
        return new Object[]{
           
            b.getFirstName() , 
            b.getLastName(), 
            b.getAddr1() == null ? "":b.getAddr1() , 
            b.getAddr2() == null ? "":b.getAddr2() , 
            b.getCity() == null ? "":b.getCity(), 
            b.getState() == null ? "":b.getState(),
            b.getHmPhone() == null ? "":b.getHmPhone() , 
            b.getWkPhone() == null ? "":b.getWkPhone() , 
            b.getWkExt() == null ? "":b.getWkExt() ,
            b.getZip() == null ? "":b.getZip() ,
            genEMail(b.getEMail()),
            b.getUserPass() == null ? genPassword():b.getUserPass() ,	
            b.getAccessLevel() ,   
            b.getSponsorLinkId(),
            update ? b.getCustId() : null
        };
    }
    private String genEMail(String email){
        if (email != null && email.trim().length() > 0){
            return email.toLowerCase().trim();
        } else {
            return NonEMail+"@"+new SimpleDateFormat("MMddyyHHSSS").format(Calendar.getInstance().getTime());
        }
    }
    private String genPassword(){
        
        return "welcome"+new SimpleDateFormat("MMddyyHHSSS").format(Calendar.getInstance().getTime());
    }
}
