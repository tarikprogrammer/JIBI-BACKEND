package com.team.backendjibi.shared;

import java.util.Random;

public class GeneratedRef {
    private static final String ref="012345678998765432107483883";
    public static String generateRef(){
        Random rd=new Random();
        StringBuilder refRes=new StringBuilder();
        for(int i=0;i<ref.length();i++){
            refRes.append(rd.nextInt(ref.length()));
        }
        return refRes.toString();
    }
}
