/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mgn.obj.lookupSys;

import java.io.Serializable;

/**
 *
 * @author lmeans
 */
public class mgnSysLookupSql implements Serializable{
    private  final String  sqlSys = 
            " SELECT s.sys_id,s.sys_rollup_id,s.sys_type,s.sys_desc,s.lookup_flag, "+
            " s.subject_text,s.subject_body "+
            " FROM mgn_lookup_sys s ";
    public  final String 
            sqlcheck = "SELECT max(sys_id) from  mgn_lookup_sys where sys_id = -24",
            sqlSysLookupAccessLvl = sqlSys+" where s.sys_type = ? and  s.lookup_flag <= ? order by s.lookup_flag",
            sqlSysLookupByID = sqlSys+" where s.sys_id = ? order by upper(s.sys_desc)",
            sqlSysLookupByType = sqlSys+" where s.sys_type = ? order by upper(s.sys_desc)";
}
