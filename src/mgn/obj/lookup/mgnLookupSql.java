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
       
       sqlLookupByType = sql + "where l.lookup_type = ?  order by l.lookup_desc";
}
