/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mgn.obj.images;

import java.io.File;
import java.io.Serializable;
import obj.db.v1.dbMgrInterface;

/**
 *
 * @author lmeans
 */
public class loadImageDb implements Serializable{
    final String imgInsert = " INSERT INTO mgn_files (file_name,file_desc,file_text,file_type,dir_id) VALUES (?,?,?,?,?);";
    int lookupid = 6;
    public void loadImages(dbMgrInterface db,int i){
        
    }
    public void dirScan(String path,String dir,int dirID){
        //List<String> results = new ArrayList<String>();
        File[] files = new File(path+"/"+dir).listFiles();
        String str = "";
        int ptr  =1,cnt=0;
        str = String.format("%02d", ptr);
        lookupid++;
        for (File file : files){
            cnt++;
            if (cnt > 25){
                ptr++;
                cnt = 0;
                str = String.format("%02d", ptr);
                lookupid++;
            }
            
            //System.err.println("INSERT INTO mgn_files (file_desc,file_name,file_type,dir_id,lookup_id) VALUES ('Page "+str+"','"+file.getName()+"',"+-10+","+dirID+","+lookupid+");");
            
            
            //results.add(file.getName());
        }
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args){
        loadImageDb loadImageDb = new loadImageDb();
        
        loadImageDb.dirScan(
                "C:/_bisc/_javaApps/jlData/mgn",
                "adult_learning_center",
                1);
         loadImageDb.dirScan(
                "C:/_bisc/_javaApps/jlData/mgn",
               "learning_center",
                2);
        loadImageDb.dirScan(
                "C:/_bisc/_javaApps/jlData/mgn",
               "otd2k7",
                3);
         loadImageDb.dirScan(
                "C:/_bisc/_javaApps/jlData/mgn",
                "pond_view_homes",
                4);
    }
}
