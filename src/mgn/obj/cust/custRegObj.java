/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mgn.obj.cust;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import mgn.obj._beans.customerBean;
import mgn.obj._beans.customerLinkBean;
import mgn.obj._beans.customerRegBean;
import obj.db.v1.dbMgrInterface;
import org.apache.log4j.Logger;
import sun.jdbc.rowset.CachedRowSet;

/**
 *
 * @author Lloyd
 */
public class custRegObj   implements Serializable{
    public  final Logger logger = (Logger) Logger.getLogger(custRegObj.class);
    
    public List<customerRegBean> getCustomerRegBeanList_byRollup(int id,dbMgrInterface db){
        List<customerRegBean> list = new ArrayList<customerRegBean>();
        CachedRowSet r = null;
         try {
            r = db.getCachedRowSet(custRegSql.sqlCustRegList_rollup, new Object[]{id});
            while(r.next()){
                customerRegBean x = getcustomerRegBean(r);
                list.add(x);
            }
        } catch (Exception ex) {
            logger.error(ex.toString());
        } finally {
             db.closeCachedRowSet(r);
         }
        
        
        return list;
    }
     public void insertIntoLink(customerBean b,customerLinkBean bean, dbMgrInterface db){
        insertIntoLink(b.getCustId(),b.getCustId(),bean,db);
    }
    public void insertIntoLink(int id,int rollup,customerLinkBean bean, dbMgrInterface db){
        try {
            db.updateDatabase(custRegSql.sqlDeleteLink,  new Object[]{id,rollup});
            db.updateDatabase(custRegSql.sqlInsertCustLink, new Object[]{id,rollup,bean.getDob(),bean.getType()});
            //sqlInsertCustLink
        } catch (Exception ex) {
            logger.error(ex.toString());
        }
    }
    public void customerRegUpdate(customerRegBean bean, dbMgrInterface db){
        try {
            if (bean.getRegId() == 0){
                Object[] obj = getCustRegObj(bean);
                db.updateDatabase(custRegSql.sqlInsertCustReg,  getCustRegObj(bean));
            } else {
                
            }
            
            
            //sqlInsertCustLink
        } catch (Exception ex) {
            logger.error(ex.toString());
        }
    }
    public customerLinkBean getCustomerLinkBean(int id,dbMgrInterface db){
        customerLinkBean b= null;
        CachedRowSet r = null;
         try {
            r = db.getCachedRowSet(custRegSql.sqlCustReg, new Object[]{id});
            while(r.next()){
                b = getCustomerLinkBean(r);
            }
        } catch (Exception ex) {
            logger.error(ex.toString());
        } finally {
             db.closeCachedRowSet(r);
         }
         return b;
    }
    private customerLinkBean getCustomerLinkBean(CachedRowSet r){
        customerLinkBean b = new customerLinkBean();
        try {
            b.setCust_id(r.getInt(1));
            b.setCust_rollup_id(r.getInt(2));
            b.setDob(r.getDate(3));
            b.setType(r.getInt(4));
            if (b.getDob() == null) b.setDob(Calendar.getInstance().getTime());
        } catch (SQLException ex) {
            logger.error(ex.toString());
        }
        return b;
    }
    private Object[] getCustRegObj(customerRegBean b){
        return new Object[]{
         b.getCust_id(),
         b.getRegLookupId(),
         b.getRegPaidId(),
         
         b.getRegNote() == null ? "":b.getRegNote(),
         b.getPdf() == null ? "": b.getPdf(),
         b.getRegCompleted(),
         b.getShirtSize(),
         b.getWarmupSuiteSize(),
         b.getShortSide()
            };
    }
    private customerRegBean getcustomerRegBean(CachedRowSet r){
        customerRegBean b = new customerRegBean();
        try {
            b.setRegId(r.getInt(1));
            b.setRegCustId(r.getInt(2));
            b.setRegLookupId(r.getInt(3));
            b.setRegPaidId(r.getInt(4));
            b.setRegNote((String)r.getObject(5));
            b.setPdf(r.getString(6));
            b.setRegCompleted(r.getInt(7));
            b.setDob(r.getDate(8));
            b.setType(r.getInt(9));
            b.setLookupDesc(r.getString(10));
            b.setShirtSize(r.getInt(11));
            b.setWarmupSuiteSize(r.getInt(12));
            b.setShortSide(r.getInt(13));
            b.setFullName(r.getString(14));
            b.setDobStr(r.getString(15));
        } catch (SQLException ex) {
            logger.error(ex.toString());
        }
        
        return b;
    }
    
}
