/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package form;

/**
 *
 * @author caballeroda_sd2081
 */
class User {
    private int userId;
    private String First_Name, Middle_Name, Last_Name, EMail, UserName;

    public User(int userId, String First_Name, String Middle_Name, String Last_Name, String EMail, String UserName) {
        this.userId = userId;
        this.First_Name = First_Name;
        this.Middle_Name = Middle_Name;
        this.Last_Name = Last_Name;
        this.EMail = EMail;
        this.UserName = UserName;
    }
        
    public int getUserId(){
        return userId;
    }
    
    public String getFirst_Name() {
        return First_Name;
    }

    public String getMiddle_Name() {
        return Middle_Name;
    }

    public String getLast_Name() {
        return Last_Name;
    }

    public String getEMail() {
        return EMail;
    }

    public String getUserName() {
        return UserName;
    }
    
    
    
    
}
