package com.team.backendjibi.shared;

import java.util.Random;

public class GeneratePassword {
    private static final String msg="ABCDEFGHIJKLMNOPKRSTUVWXYZabcdefghjiklmnopqrstuvwxyz0123456789";
    public static String genererPassword(){
        StringBuilder passwordGenerated=new StringBuilder();
        Random rd = new Random();
        for(int i=0;i<msg.length();i++){
            char g=msg.charAt(rd.nextInt(msg.length()));
            passwordGenerated.append(g);
        }
        return passwordGenerated.toString();
    }
}
