/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mgn.obj.cal;

import java.io.Serializable;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import obj.db.v1.dbMgrInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.jdbc.rowset.CachedRowSet;

/**
 *
 * @author lmeans
 */
public class calendarObj implements Serializable{
    public  final Logger logger = (Logger) LoggerFactory.getLogger(calendarObj.class);
    calendarSql calendarSql;
    public calendarObj(){
        calendarSql = new calendarSql();
    }
    //sqlGetSelectPostingListToday
    public  List<calendarBean> getListByStartDateAndType(int type,Date Start,Date end,dbMgrInterface db){
        return getList(calendarSql.selectSqlStartDateAndType,new Object[]{Start,end,type},db);
    }
    public  List<calendarBean> getListByEndDateAndType(int type,Date Start,Date end,dbMgrInterface db){
        return getList(calendarSql.selectSqlEndDateAndType,new Object[]{Start,end,type},db);
    }
    public  List<calendarBean> getListByModDateAndType(int type,Date Start,Date end,dbMgrInterface db){
        return getList(calendarSql.selectSqlModDateAndType,new Object[]{Start,end,type},db);
    }
    public  List<calendarBean> getList(String sql,Object[] ary,dbMgrInterface db){
        List<calendarBean> l = new ArrayList<calendarBean>();
        CachedRowSet rs = null;
        try {
            rs = db.getCachedRowSet(sql,ary);
            while(rs.next()){
                l.add(getCalenderBean(rs));
            }
        } catch (Exception ex) {
            logger.error(ex.toString());
        } finally {
            db.closeCachedRowSet(rs);
        }
        return l;
    }
    // =======================================================================
    
    public  List<calendarBean> getListToday(int type,int days,dbMgrInterface db){
        return getList(type,calendarSql.sqlGetSelectPostingListToday(days),db);
    }
    public  List<calendarBean> getList(int type,int days,dbMgrInterface db){
        return getList(type,calendarSql.sqlGetSelectPostingList(days),db);
    }
    private  List<calendarBean> getList(int type,String sql,dbMgrInterface db){
        List<calendarBean> l = new ArrayList<calendarBean>();
        CachedRowSet rs = null;
        try {
            rs = db.getCachedRowSet(sql, new Object[]{type});
            while(rs.next()){
                l.add(getCalenderBean(rs));
            }
        } catch (Exception ex) {
            logger.error(ex.toString());
        } finally {
            db.closeCachedRowSet(rs);
        }
        return l;
    }
    public  void saveCalBean(calendarBean b,dbMgrInterface db){
        try {
            
            db.updateDatabase(
                    b.getCalId() == 0 ? calendarSql.calInsert : calendarSql.calUpdate_v2, 
                    getObject(b));
        } catch (Exception ex) {
            logger.error(ex.toString());
        }
    }
    public  calendarBean getCalEvent(int id,dbMgrInterface db ){
        calendarBean calendarBean = new calendarBean();
        CachedRowSet rs = null;
        try {
            rs = db.getCachedRowSet(calendarSql.calSelectById, new Object[]{id});
            while(rs.next()){
                calendarBean = getCalenderBean(rs);
            }
        } catch (Exception ex) {
            logger.error(ex.toString());
        } finally {
            db.closeCachedRowSet(rs);
        }
        return calendarBean;
    }
    private  calendarBean getCalenderBean(CachedRowSet r){
        calendarBean b = null;
        try {
            b = new calendarBean();
            b.setCalId(r.getInt(1));
            b.setCalRollupId(r.getInt(2));
            b.setCalDesc(r.getString(3));
            b.setCalType(r.getInt(4));
            b.setStartDate(r.getDate(5));
            b.setEnddate(r.getDate(6));
            b.setUserId(r.getInt(7));
            b.setDeptId(r.getInt(8));
            b.setLookupId(r.getInt(9));
            b.setLookupFlag(r.getInt(10));
            b.setSubjectText(r.getString(11));
            b.setSubjectBody((String)r.getObject(12));
            b.setModDate(r.getDate(13));
            
                
            if (b.getStartDate() != null)b.setStartDateDisp(new SimpleDateFormat("EEE MMM dd yyyy hh:mm a").format(b.getStartDate()));
            if (b.getEnddate() != null)  b.setEndDateDisp(new SimpleDateFormat("EEE MMM dd yyyy hh:mm a").format(b.getEnddate()));
            if (b.getModDate() != null)  b.setModDateDisplay(new SimpleDateFormat("EEE MMM dd yyyy hh:mm a").format(b.getModDate()));
            b.setUserName(r.getString(14)+" "+r.getString(15));
            b.setDeptName(r.getString(16));
            
        } catch (SQLException ex) {
            logger.error(ex.toString());
        }
        return b;
    }
    private  Object[] getObject(calendarBean b){

            return new Object[]{
                b.getCalRollupId(),
                b.getCalDesc() == null ? "":b.getCalDesc(),
                b.getCalType(),
              new java.sql.Date( b.getStartDate().getTime())  ,
              new java.sql.Date( b.getEnddate().getTime())  ,
                b.getUserId(),
                b.getDeptId(),
                b.getLookupId(),
                b.getLookupFlag(),
                b.getSubjectText() == null ? "": b.getSubjectText(),
                b.getSubjectBody() == null ? "": b.getSubjectBody(),
                
                b.getCalId() <= 0 ? null :b.getCalId()
                  
            };
       
       
       
    }
    /// ============================================================
    
}
