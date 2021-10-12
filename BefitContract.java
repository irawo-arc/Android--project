package com.example.befit.data;

import android.net.Uri;
import android.provider.BaseColumns;

import java.net.URI;

public class BefitContract {

    private BefitContract() {}

    public static final String AUTHORITY = "com.example.befit.data";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + AUTHORITY);
    public static final String PATH_BEFIT_DATA ="BeFitData";

    public static final class BeFitUsersEntry implements BaseColumns{
    public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_BEFIT_DATA).build();

    public static final String TABLE_NAME= "BeFitUsers";
    public static final String COLUMN_NAME ="user_name";
    public static final String COLUMN_EMAIL = "user_email";
    public static final String COLUMN_PW = "user_pw";
    public static final String COLUMN_W ="user_weight";
    public static final String COLUMN_H ="user_height";

//        final String SQL_CREATE_BEFIT_USERS_TABLE = "CREATE TABLE" + BefitContract.BeFitUsersEntry.TABLE_NAME+"("+
//                BefitContract.BeFitUsersEntry.COLUMN_NAME+ "TEXT NOT NULL,"+
//               BefitContract.BeFitUsersEntry.COLUMN_EMAIL+ "TEXT NOT NULL,"+
//              BefitContract.BeFitUsersEntry.COLUMN_PW+ "TEXT NOT NULL,"+
//              BefitContract.BeFitUsersEntry.COLUMN_H+"TEXT NOT NULL,"+
//               BefitContract.BeFitUsersEntry.COLUMN_W+"TEXT NOT NULL" +");";



    }
}


