package com.example.befit.data;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class BefitContent extends ContentProvider {
    private BefitHelper mDbHelper;

    public static final int TASKS = 100;
    public static final int TASKS_WITH_ID = 101;

    private static final UriMatcher URI_MATCHER = uriMatcher();

    public static UriMatcher uriMatcher(){
        UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(BefitContract.AUTHORITY,BefitContract.PATH_BEFIT_DATA,TASKS);
        uriMatcher.addURI(BefitContract.AUTHORITY,BefitContract.PATH_BEFIT_DATA+"/#",TASKS_WITH_ID);
        return uriMatcher;
    }

    @Override
    public boolean onCreate() {
        mDbHelper = new BefitHelper(super.getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        //retrieve from the database
        SQLiteDatabase database = mDbHelper.getReadableDatabase();

        int match = URI_MATCHER.match(uri);
        Cursor cursor;

        switch (match){
            case TASKS:
                cursor = database.query(BefitContract.BeFitUsersEntry.TABLE_NAME,projection,selection,selectionArgs,null,null,sortOrder);
                break;
            case TASKS_WITH_ID:
                cursor = database.query(BefitContract.BeFitUsersEntry.TABLE_NAME,null,null,null,null,null,null);
                break;
            default:
                throw new UnsupportedOperationException("Invalid uri" + uri);
        }
        //set a notification URI on the Cursor and return that Cursor
        cursor.setNotificationUri(getContext().getContentResolver(), uri);
        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        SQLiteDatabase database = mDbHelper.getReadableDatabase();

        int match = URI_MATCHER.match(uri);
        Uri returnedUri = null;

        switch (match){
            case TASKS:
                long id = database.insert(BefitContract.BeFitUsersEntry.TABLE_NAME,null,values);
                if(id > 0){
                    returnedUri = ContentUris.withAppendedId(BefitContract.BeFitUsersEntry.CONTENT_URI,id);
                }
                break;
            default:throw new UnsupportedOperationException("Invalid uri"+ uri);

        }
        getContext().getContentResolver().notifyChange(uri,null);
        return returnedUri;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
