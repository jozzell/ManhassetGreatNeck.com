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
     fileDir = " select dir_id,dir_name,dir_desc,dir_text,dir_group,user_id from mgn_files_dir ",
     sqlBatchXX =
             " SELECT l.lookup_id,l.lookup_desc,l.subject_text ,d.dir_name,d.dir_id "+
            " FROM mgn_lookup l,mgn_files_dir d "+
            " where l.lookup_id = d.dir_group ",
        
    sql =   " SELECT f.file_id,f.file_name,f.file_desc,f.file_text,f.file_type,f.dir_id , "+
            " d.dir_name,s.sys_desc,s.subject_text path "+
            " FROM mgn_files f,mgn_files_dir d,mgn_lookup_sys s "+
            " where d.dir_id = f.dir_id and s.sys_id =  f.file_type ";
        
    public  final String tmp5= "x",
            sqlSelectFileDirectory = fileDir+" where dir_group = ? order by upper (dir_desc)",
            sqlGrabFileDescName = "SELECT distinct file_desc,lookup_id from mgn_files where dir_id = ? order by upper(file_desc)",
            
        sqlSelectImagesDefault = 
            sql+" and f.file_id in (SELECT max(file_id) FROM mgn_files group by file_desc)  ",
            //sql+" and f.file_id in (SELECT min(file_id) FROM mgn_files group by file_desc)",
        sqlSelectImages = sql +" and f.lookup_id = ? ",
        sqlSelectImageBatchListXX = sqlBatchXX+
            " and l.lookup_type = -10 and lookup_id = ? ";
}
/*

 sqlX =    " SELECT f.file_id,f.file_name,f.file_desc,f.file_text,f.file_type,f.dir_id "+
            " FROM mgn_files f  ",

*/