/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mgn.obj.images;

import java.io.Serializable;

/**
 *
 * @author lmeans
 */
public class imgSql implements Serializable{
    private  final String tmp4 = "x",
     sqlV2Image = " SELECT l.lookup_rollup_id,l.lookup_id,l.lookup_desc,  CONCAT(d.dir_name,f.file_name) ,count(*) "+
                " FROM  mgn_lookup l,mgn_files f,mgn_files_dir d "+
                " where f.lookup_id = l.lookup_id and d.dir_id = f.dir_id ",
     fileDir = " select dir_id,dir_name,dir_desc,dir_text,dir_group,user_id from mgn_files_dir ",
     sqlBatchXX =
             " SELECT l.lookup_id,l.lookup_desc,l.subject_text ,d.dir_name,d.dir_id "+
            " FROM mgn_lookup l,mgn_files_dir d "+
            " where l.lookup_id = d.dir_group ",
        
    sql =   " SELECT f.file_id,f.file_name,f.file_desc,f.file_text,f.file_type,f.dir_id , "+
            " d.dir_name,s.sys_desc,s.subject_text path,1,null,0 "+
            " FROM mgn_files f,mgn_files_dir d,mgn_lookup_sys s "+
            " where d.dir_id = f.dir_id and s.sys_id =  f.file_type ",
    sqlGrp = 
                " SELECT max(f.file_id),max(f.file_name),f.file_desc,null,f.file_type,f.dir_id , "+
                " d.dir_name,s.sys_desc,s.subject_text path,count(*),d.dir_desc ,f.lookup_id"+
                " FROM mgn_files f,mgn_files_dir d,mgn_lookup_sys s "+
                " where d.dir_id = f.dir_id and s.sys_id =  f.file_type "+
                " group by f.file_desc,f.file_type,f.dir_id"+
                " order by 1 desc ";
    public  final String tmp5= "x",
            fileDirIns = "insert into mgn_files_dir (dir_name,dir_desc,dir_text,dir_group,user_id,searchKey) values (?,?,?,?,?,?)",
            fileImgInc = "insert into mgn_files (file_name,file_desc,file_text,file_type,dir_id,lookup_id) values (?,?,?,?,?,?)",
            sqlSelectFileDirectory = fileDir+" where dir_group = ? order by upper (dir_desc)",
            fileDirSelect_searchKey = "select max(dir_id) from mgn_files_dir where searchKey = ?",
            sqlGrabFileDescName = "SELECT distinct file_desc,lookup_id from mgn_files where dir_id = ? order by upper(file_desc)",
        sqlGrpSelect = sqlGrp,
        sqlSelectImagesDefault = 
            sql+" and f.file_id in (SELECT max(file_id) FROM mgn_files group by file_desc)  ",
            //sql+" and f.file_id in (SELECT min(file_id) FROM mgn_files group by file_desc)",
        sqlSelectImagesV2 = sql +" and f.lookup_id = ? ",
        sqlSelectImageBatchListXX = sqlBatchXX+
            " and l.lookup_type = -10 and lookup_id = ? ",
        sqlUpdateLookupDesc = "update  mgn_lookup set lookup_desc = ? where lookup_id = ?";
    
    public String getImagSqlRollupID(){
        return getImagSql(true," l.lookup_rollup_id = ? ");
    }
     public String getImagSqlLookupID(){
        return getImagSql(false,"  l.lookup_id= ? ");
    }
    private String getImagSql(boolean cnt,String where){
       return (new StringBuilder())
                .append(" SELECT l.lookup_rollup_id,l.lookup_id,l.lookup_desc,  CONCAT(d.dir_name,f.file_name) ,")
                .append(cnt ? "count(*)":"0")
                .append( " FROM  mgn_lookup l,mgn_files f,mgn_files_dir d ")
                .append(" where f.lookup_id = l.lookup_id and d.dir_id = f.dir_id ")
                .append(where == null ? "" : " and ")
                .append(where == null ? "" : where)
                .append(cnt ? " group by  l.lookup_id, l.lookup_rollup_id,l.lookup_desc, d.dir_name having count(*) > 0" : "")
               .append(" order by l.lookup_flag desc,2 desc,f.file_id desc")
                .toString();
                
      
    }
}
/*

 sqlX =    " SELECT f.file_id,f.file_name,f.file_desc,f.file_text,f.file_type,f.dir_id "+
            " FROM mgn_files f  ",

*/