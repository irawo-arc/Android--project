package com.example.befit.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static org.xmlpull.v1.XmlPullParser.TEXT;

public class BefitHelper extends SQLiteOpenHelper {

    private static  final String DATABASE_NAME = "Userslist.db";
    private static  final int DATABASE_VERSION = 1;

    public BefitHelper(Context context){
        super(context,DATABASE_NAME,null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        final String SQL_CREATE_BEFIT_USERS_TABLE = "CREATE TABLE   " + BefitContract.BeFitUsersEntry.TABLE_NAME+"("+
                BefitContract.BeFitUsersEntry._ID  + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                BefitContract.BeFitUsersEntry.COLUMN_NAME+ "TEXT NOT NULL,"+
                BefitContract.BeFitUsersEntry.COLUMN_EMAIL+ "TEXT NOT NULL,"+
                BefitContract.BeFitUsersEntry.COLUMN_PW+ "TEXT NOT NULL,"+
                BefitContract.BeFitUsersEntry.COLUMN_H+"TEXT NOT NULL,"+
                BefitContract.BeFitUsersEntry.COLUMN_W+"TEXT NOT NULL" +");";

        db.execSQL(SQL_CREATE_BEFIT_USERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS " + BefitContract.BeFitUsersEntry.TABLE_NAME);
    onCreate(db);
    }
}
