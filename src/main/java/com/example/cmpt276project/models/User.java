package com.example.cmpt276project.models;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;
    private String name;
    private String password;
    public User() { 
    }
    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        if(name.length() == 0){
            throw new IllegalArgumentException("Invalid Username!");
        }
        else{
            this.name = name;            
        }

    }
    public String getPassword() {
        return password;
    }



    public void setPassword(String password) {

        // verify if the password meets the proper criteria 
        int length = password.length();
        if(length < 8){
            throw new IllegalArgumentException("Invalid Password!");
        }
        else{
            boolean lowerCaseFlag = false;
            boolean capitalFlag = false; 
            boolean symbolFlag = false;
            boolean numberFlag = false;
            for(int i = 0; i < length; i++){
                char c = password.charAt(i);
                if( Character.isDigit(c)){
                    numberFlag = true;
                }
                else if( Character.isUpperCase(c)){
                    capitalFlag = true;
                }
                else if( Character.isLowerCase(c)){
                    lowerCaseFlag = true;
                }
                else if( isAlphaNumeric(c) == false){
                    symbolFlag = true;
                }
                if(lowerCaseFlag && capitalFlag && symbolFlag && numberFlag){
                    this.password = password;
                    return;
                }

            }
            throw new IllegalArgumentException("Invalid Password!");
        }

    }
    
    public int getUid() {
        return uid;
    }
    public void setUid(int uid) {
        this.uid = uid;
    }
    
    private static boolean isAlphaNumeric(char ch) {
        if ((ch >= '0' & ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
          return true;
        return false;
      }

}
