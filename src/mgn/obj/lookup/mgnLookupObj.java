/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mgn.obj.lookup;


import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import obj.db.v1.dbMgrInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.jdbc.rowset.CachedRowSet;

/**
 *
 * @author lmeans
 */
public class mgnLookupObj implements Serializable{
    public  final Logger logger = (Logger) LoggerFactory.getLogger(mgnLookupObj.class);
    mgnLookupSql mgnLookupSql;
    public mgnLookupObj(){
        mgnLookupSql = new mgnLookupSql();
    }
    public int insertRec(int user,mgnLookupBean bean,dbMgrInterface db){
        int id = -1;
        CachedRowSet r = null;
        bean.setSearchKey(user+"_"+Calendar.getInstance().getTimeInMillis());
        try {
            db.updateDatabase(mgnLookupSql.sqlLookupIns, getObj(bean));
            r = db.getCachedRowSet(mgnLookupSql.sqlLookupkey,new Object[]{bean.getSearchKey()});
            
            while(r.next()){
                id = r.getInt(1);
            }
            
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }finally {
            db.closeCachedRowSet(r);
        }
        return id;
    }
    public Object[] getObj(mgnLookupBean b){
        return new Object[]{
            //,,,,,,,searchKey
           b.getLookupRollupId(),
           b.getLookupType(),
           b.getLookupDesc(),
           b.getLookupFlag(),
           b.getSubjectText() == null ? "" :b.getSubjectText(),
           b.getSubjectBody() == null ? "" :b.getSubjectBody(),
           b.getSearchKey()
        };
    }

    public  List<mgnLookupBean> getLookupList(int type,dbMgrInterface db){
        List<mgnLookupBean> list = new ArrayList<mgnLookupBean>();
        CachedRowSet r = null;
        try {
            r = db.getCachedRowSet(mgnLookupSql.sqlLookupByType, new Object[]{type});
            while(r.next()){
                list.add(getlookupBean(r));
            }
        } catch (Exception ex) {
            logger.error(ex.toString());
        } finally {
           db.closeCachedRowSet(r);
        }
        return list;
    }
    public  mgnLookupBean getlookupBean(CachedRowSet r){
        mgnLookupBean b = new mgnLookupBean();
        try {
            b.setLookupId(r.getInt(1));
            b.setLookupRollupId(r.getInt(2));
            b.setLookupType(r.getInt(3));
            b.setLookupDesc(r.getString(4));
            b.setLookupFlag(r.getInt(5));
            b.setSubjectText(r.getString(6));
            b.setSubjectBody((String)r.getObject(7));
            
        } catch (SQLException ex) {
           logger.error(ex.toString());
        }
        
        return b;
    }
}
