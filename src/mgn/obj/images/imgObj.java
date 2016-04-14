/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mgn.obj.images;


import jvp.obj.bean.imgBean;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import mgn.obj._beans.mgnLookupBean;
import obj.db.v1.dbMgrInterface;
import org.apache.log4j.Logger;
//import org.apache.log4j.Logger;
import sun.jdbc.rowset.CachedRowSet;

/**
 *
 * @author lmeans
 */
public class imgObj implements Serializable{
    public  final Logger logger = (Logger) Logger.getLogger(imgObj.class);
    imgSql imgSql;
    
   public imgObj(){
       imgSql = new imgSql();
   }
   public void insert(imgBean imgBean, dbMgrInterface db){
        try {
            db.updateDatabase(imgSql.fileImgInc, getObj(imgBean));
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
   }
   public Object[] getObj(imgBean b){
       return new Object[]{
           b.getFileName() == null ? "":b.getFileName(),
            b.getFileDesc() == null ? "":b.getFileDesc(),
           b.getFileText() == null ? "": b.getFileText(),
           b.getFileType(),
           b.getDirId(),
           b.getLookupID()
       };
   }
   public int getDirID(dirBean dirBean,dbMgrInterface db){
       dirBean.setSearchKey(dirBean.getUserId()+"_"+Calendar.getInstance().getTimeInMillis());
       Object[] obj = getFileDirObj(dirBean);
       CachedRowSet r = null;
       int dirID =-1;
        try {
            db.updateDatabase(imgSql.fileDirIns, obj);
            r = db.getCachedRowSet(imgSql.fileDirSelect_searchKey,new Object[]{dirBean.getSearchKey()});
            
            while(r.next()){
                dirID = r.getInt(1);
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            db.closeCachedRowSet(r);
        }
        return dirID;
   }
   public Object[] getFileDirObj(final dirBean b){
       return new Object[]{
          
           b.getDirName(),
           b.getDirDesc(),
           b.getDirText() == null ? "" :b.getDirText(),
           b.getDirGroup(),
           b.getUserId(),
           b.getSearchKey()
       };
   }
   // ================================================================
    public  List<mgnFileBean> getFileDirList(int id,dbMgrInterface db){
        return getMgnFileBean(imgSql.sqlSelectFileDirectory,db,new Object[]{id});
    }
    private  List<mgnFileBean> getMgnFileBean(String sql,dbMgrInterface db,Object[] obj){
        List<mgnFileBean> l= new ArrayList<mgnFileBean>();
         CachedRowSet r = null;
        try {
            r = db.getCachedRowSet(sql,obj);
            while(r.next()){
                l.add(getMgnFileBean(r));
            }
        }catch (Exception ex) {
            logger.error(ex.toString());
        } finally {
            db.closeCachedRowSet(r);
        }
        return l;
    }
    public  mgnFileBean getMgnFileBean(CachedRowSet r){
        mgnFileBean b = new mgnFileBean();
        try {
            b.setDir_id(r.getInt(1));
            b.setFile_name(r.getString(2));
            b.setFile_desc(r.getString(3));
            b.setFile_text((String)r.getObject(4));
           
            b.setDir_group(r.getInt(5));
            b.setUser_id(r.getInt(6));
        } catch (SQLException ex) {
            logger.error(ex.toString());
        }
        return b;
    }
    /// ======================================================================
    public  List<mgnLookupBean> selectImageBatch(int id,dbMgrInterface db){
        List<mgnLookupBean> list = new ArrayList<mgnLookupBean>();
        
         CachedRowSet r = null;
        try {
            r = db.getCachedRowSet(imgSql.sqlGrabFileDescName,new Object[]{id});
            while(r.next()){
                mgnLookupBean l = new mgnLookupBean();
                l.setLookupDesc(r.getString(1));
                l.setLookupId(r.getInt(2));
                list.add(l);
            }
        } catch (Exception ex) {
            logger.error(ex.toString());
        } finally {
            db.closeCachedRowSet(r);
        }
        return list;
        
        
        
        
    }
    public  List<mgnLookupBean> selectImageBatch(String sql,dbMgrInterface db,Object[] obj){
        List<mgnLookupBean> list = new ArrayList<mgnLookupBean>();
        CachedRowSet r = null;
        try {
            r = db.getCachedRowSet(sql,obj);
            while(r.next()){
                mgnLookupBean l = new mgnLookupBean();
                l.setLookupId(r.getInt(1));
                l.setLookupDesc(r.getString(2));
                l.setSubjectBody(r.getString(3));
                l.setSubjectText(r.getString(4));
                l.setLookupRollupId(r.getInt(5));
                list.add(l);
            }
        } catch (Exception ex) {
            logger.error(ex.toString());
        } finally {
            db.closeCachedRowSet(r);
        }
        return list;
    }
    public  List<imgBean> selectImageList(dbMgrInterface db){
        return selectImageList(imgSql.sqlSelectImagesDefault,db,null);
    }
    public  List<imgBean> selectImageList(int dirId,dbMgrInterface db){
        return selectImageList(imgSql.sqlSelectImagesV2,db,new Object[]{dirId});
    }
    public  List<imgBean> selectImageList_V2(dbMgrInterface db){
        return selectImageList(imgSql.sqlGrpSelect,db,new Object[]{});
    }
    public  List<imgBean> selectImageList(String sql,dbMgrInterface db,Object[] obj){
        List<imgBean> list = new ArrayList<imgBean>();
        CachedRowSet r = null;
        try {
            r = db.getCachedRowSet(sql,obj);
            while(r.next()){
                imgBean l = new imgBean();
                l.setFileId(r.getInt(1));
                l.setFileName(r.getString(2));
                l.setFileDesc(r.getString(3));
                l.setFileText((String)r.getObject(4));
                l.setFileType(r.getInt(5));
                l.setDirId(r.getInt(6));
                l.setDirName(r.getString(7));
                l.setSysDesc(r.getString(8));
                l.setRootPath(r.getString(9));
                l.setCnt(r.getInt(10));
                l.setDirDesc(r.getString(11));
                l.setLookupID(r.getInt(12));
                list.add(l);
            }
        } catch (Exception ex) {
            logger.error(ex.toString());
        } finally {
            db.closeCachedRowSet(r);
        }
        return list;
    }
}
