/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mgn.obj.images;

/**
 *
 * @author Lloyd
 */
public class mgnMgrObjBean {
    private int rollupId;
    private int lookupId,navPick=0;
    private int lookupType;
    private String who2;
    private String who;

    /**
     * @return the rollupId
     */
    public int getRollupId() {
        return rollupId;
    }

    /**
     * @param rollupId the rollupId to set
     */
    public void setRollupId(int rollupId) {
        this.rollupId = rollupId;
    }

    /**
     * @return the lookupId
     */
    public int getLookupId() {
        return lookupId;
    }

    /**
     * @param lookupId the lookupId to set
     */
    public void setLookupId(int lookupId) {
        this.lookupId = lookupId;
    }

    /**
     * @return the lookupType
     */
    public int getLookupType() {
        return lookupType;
    }

    /**
     * @param lookupType the lookupType to set
     */
    public void setLookupType(int lookupType) {
        this.lookupType = lookupType;
    }

    /**
     * @return the who2
     */
    public String getWho2() {
        return who2;
    }

    /**
     * @param who2 the who2 to set
     */
    public void setWho2(String who2) {
        this.who2 = who2;
    }

    /**
     * @return the who
     */
    public String getWho() {
        return who;
    }

    /**
     * @param who the who to set
     */
    public void setWho(String who) {
        this.who = who;
    }

    /**
     * @return the navPick
     */
    public int getNavPick() {
        return navPick;
    }

    /**
     * @param navPick the navPick to set
     */
    public void setNavPick(int navPick) {
        this.navPick = navPick;
    }
}
