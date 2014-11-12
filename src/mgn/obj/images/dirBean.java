/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mgn.obj.images;

import java.io.Serializable;
import mgn.obj._beans._resetBean;

/**
 *
 * @author lmeans
 */
public class dirBean  extends _resetBean implements Serializable{
    private int dirId;
    private int userId;
    private String dirName;
    private String dirDesc;
    private String dirText;
    private String searchKey;
    
    private int dirGroup;

    /**
     * @return the dirId
     */
    public int getDirId() {
        return dirId;
    }

    /**
     * @param dirId the dirId to set
     */
    public void setDirId(int dirId) {
        this.dirId = dirId;
    }

    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return the dirName
     */
    public String getDirName() {
        return dirName;
    }

    /**
     * @param dirName the dirName to set
     */
    public void setDirName(String dirName) {
        this.dirName = dirName;
    }

    /**
     * @return the dirDesc
     */
    public String getDirDesc() {
        return dirDesc;
    }

    /**
     * @param dirDesc the dirDesc to set
     */
    public void setDirDesc(String dirDesc) {
        this.dirDesc = dirDesc;
    }

    /**
     * @return the dirText
     */
    public String getDirText() {
        return dirText;
    }

    /**
     * @param dirText the dirText to set
     */
    public void setDirText(String dirText) {
        this.dirText = dirText;
    }

    /**
     * @return the dirGroup
     */
    public int getDirGroup() {
        return dirGroup;
    }

    /**
     * @param dirGroup the dirGroup to set
     */
    public void setDirGroup(int dirGroup) {
        this.dirGroup = dirGroup;
    }

    /**
     * @return the searchKey
     */
    public String getSearchKey() {
        return searchKey;
    }

    /**
     * @param searchKey the searchKey to set
     */
    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }
}
