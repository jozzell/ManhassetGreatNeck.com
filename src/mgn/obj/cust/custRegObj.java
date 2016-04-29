/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mgn.obj.cust;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import mgn.obj._beans.customerBean;
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
    public List<customerRegBean> getcustomerRegBean(int id,dbMgrInterface db){
        List<customerRegBean> list = new ArrayList<customerRegBean>();
        CachedRowSet r = null;
         try {
            r = db.getCachedRowSet(custRegSql.sqlCustReg, new Object[]{id});
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
    public customerRegBean getcustomerRegBean(CachedRowSet r){
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
            
            
        } catch (SQLException ex) {
            logger.error(ex.toString());
        }
        
        return b;
    }
}
