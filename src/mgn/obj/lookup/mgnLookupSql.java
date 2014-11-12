/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mgn.obj.lookup;

import java.io.Serializable;

/**
 *
 * @author lmeans
 */
public class mgnLookupSql implements Serializable{
    final  String sql = 
            " SELECT l.lookup_id,l.lookup_rollup_id,l.lookup_type,l.lookup_desc,l.lookup_flag,l.subject_text, "+
            " l.subject_body FROM mgn_lookup l "
           ;
    public  final String
       sqlLookupIns = "insert into mgn_lookup (lookup_rollup_id,lookup_type,lookup_desc,lookup_flag,subject_text,subject_body,searchKey )"+
            " values (?,?,?,?,?,?,?)",
       sqlLookupkey = "select max(lookup_id) from mgn_lookup where searchKey = ?",
       sqlLookupByType = sql + "where l.lookup_type = ?  order by l.lookup_desc";
}
