/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mgn.obj;

/**
 *
 * @author lmeans
 */
public enum mgnVarEnum {
     sysId_User_Pending(101),
     sysId_SpinneyHillImageBatch(-10);
    private final int i;
    private mgnVarEnum(int i){
        this.i = i;
    }
    public int getType(){
    return this.i;
}
}
