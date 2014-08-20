/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BEAN;

/**
 *
 * @author rosa
 */
public class Login {
    
    private static String user;
    private static String pass;

    public static String getUser() {
        return user;
    }

    public static void setUser(String user) {
        Login.user = user;
    }

    public static String getPass() {
        return pass;
    }

    public static void setPass(String pass) {
        Login.pass = pass;
    }
    
    
    
}
