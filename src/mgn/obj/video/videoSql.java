/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mgn.obj.video;

import java.io.Serializable;

/**
 *
 * @author lmeans
 */
public class videoSql implements Serializable{
    private  final String sql =
    " SELECT  v.video_id,v.video_type,v.video_desc,v.video_value,v.video_width, "+
    " v.video_height,v.video_player,v.lookup_id,v.sys_id,v.lookup_flag,v.subject_text, "+
    " v.subject_body,l.lookup_desc,l.subject_text "+
    " FROM mgn_video v,mgn_lookup l "+
    " where l.lookup_id = v.lookup_id ";
    public  final String
            sqlSelectVideoByType = sql+" and v.video_type = ? order by v.lookup_flag desc,v.video_desc";
}
