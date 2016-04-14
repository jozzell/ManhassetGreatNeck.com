/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mgn.obj.images;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mgn.obj._beans.mgnLookupBean;
import obj.db.v1.dbMgrInterface;
import static org.apache.poi.hwpf.model.FileInformationBlock.logger;
import sun.jdbc.rowset.CachedRowSet;

/**
 *
 * @author lmeans
 */
public class imgObjV2 {
    public void updateLookupDesc(String str,int id,dbMgrInterface db){
        
        try {
            db.updateDatabase((new imgSql()).sqlUpdateLookupDesc, new Object[]{str,id});
            //sqlUpdateLookupDesc
        } catch (Exception ex) {
            Logger.getLogger(imgObjV2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<mgnLookupBean> getImageFilesRollup(int id,dbMgrInterface db){
        return getImageFiles((new imgSql()).getImagSqlRollupID(),new Object[]{id},db);
    }
    public List<mgnLookupBean> getImageFilesLookup(int id,dbMgrInterface db){
        return getImageFiles((new imgSql()).getImagSqlLookupID(),new Object[]{id},db);
    }
    private List<mgnLookupBean> getImageFiles(String sql,Object[] obj,dbMgrInterface db){
        List<mgnLookupBean> list = new ArrayList<mgnLookupBean>();
        CachedRowSet r = null;
        try {
            r = db.getCachedRowSet(sql,obj);
            while(r.next()){
                mgnLookupBean l = new mgnLookupBean();
                l.setLookupRollupId(r.getInt(1));
                l.setLookupId(r.getInt(2));
                l.setLookupDesc(r.getString(3));
                l.setSubjectText(r.getString(4));
                l.setCnt(r.getInt(5));
                list.add(l);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            db.closeCachedRowSet(r);
        }
        return list;
    }
}
