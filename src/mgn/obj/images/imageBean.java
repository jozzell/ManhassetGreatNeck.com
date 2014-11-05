package mgn.obj.images;


import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import mgn.obj._beans._resetBean;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lmeans
 */
@ManagedBean(name = "imageBean")
public class imageBean extends _resetBean implements Serializable{
    public imageBean(String name){
        this.fileName = name;
    }
    private String fileName;

    /**
     * @return the fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @param fileName the fileName to set
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
