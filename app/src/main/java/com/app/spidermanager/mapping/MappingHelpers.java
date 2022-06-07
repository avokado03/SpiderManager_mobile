package com.app.spidermanager.mapping;

public class MappingHelpers {
    public static Boolean intSexToBoolean(int value){
        switch (value){
            case 0:
                return false;
            case 1:
                return true;
            default:
                return null;
        }
    }
}
