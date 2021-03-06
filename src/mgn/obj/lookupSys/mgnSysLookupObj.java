/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mgn.obj.lookupSys;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import mgn.obj._beans.mgnLookupBean;
import mgn.obj.lookup.mgnLookupObj;

import obj.db.v1.dbMgrInterface;
import org.apache.log4j.Logger;
//import org.apache.log4j.Logger;
import sun.jdbc.rowset.CachedRowSet;

/**
 *
 * @author lmeans
 */
public class mgnSysLookupObj implements Serializable{
    public  final Logger logger = (Logger) Logger.getLogger(mgnSysLookupObj.class);
    mgnSysLookupSql mgnSysLookupSql;
    mgnLookupObj mgnLookupObj;
    public mgnSysLookupObj(){
        mgnSysLookupSql = new mgnSysLookupSql();
        mgnLookupObj = new mgnLookupObj();
    }
    public void chckConection(dbMgrInterface db) throws Exception{
        CachedRowSet r = null;
        try {
            r = db.getCachedRowSet(mgnSysLookupSql.sqlcheck, new Object[]{});
            while(r.next()){
                
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
           db.closeCachedRowSet(r);
        }
    }
    public  List<mgnLookupBean> getSysLookupListByID(int id,dbMgrInterface db){
        return getSysLookupList(mgnSysLookupSql.sqlSysLookupByID,new Object[]{id},db);
    }
    public  List<mgnLookupBean> getSysLookupList(int type,dbMgrInterface db){
        return getSysLookupList(mgnSysLookupSql.sqlSysLookupByType,new Object[]{type},db);
    }
    public  List<mgnLookupBean> getSysLookupListAccess(int type,int access,dbMgrInterface db){
        return getSysLookupList(mgnSysLookupSql.sqlSysLookupAccessLvl,new Object[]{type,access},db);
    }
    public  List<mgnLookupBean> getSysLookupList(String sql,Object[] obj,dbMgrInterface db){
        
        List<mgnLookupBean> list = new ArrayList<mgnLookupBean>();
        CachedRowSet r = null;
        try {
            r = db.getCachedRowSet(sql, obj);
            while(r.next()){
                list.add(mgnLookupObj.getlookupBean(r));
            }
        } catch (Exception ex) {
            logger.error(ex.toString());
        } finally {
           db.closeCachedRowSet(r);
        }
        return list;
    }
    
}
