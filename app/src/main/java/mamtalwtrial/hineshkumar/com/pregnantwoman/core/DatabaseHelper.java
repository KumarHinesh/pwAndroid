package mamtalwtrial.hineshkumar.com.pregnantwoman.core;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import mamtalwtrial.hineshkumar.com.pregnantwoman.contractClasses.FoetusesContract;
import mamtalwtrial.hineshkumar.com.pregnantwoman.contractClasses.FormsContract;
import mamtalwtrial.hineshkumar.com.pregnantwoman.contractClasses.UserContract;
import mamtalwtrial.hineshkumar.com.pregnantwoman.contractClasses.UserContract.UserTable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String SQL_CREATE_USERS = "CREATE TABLE " + UserTable.TABLE_NAME + "("
            + UserTable.COLUMN__ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + UserTable.COLUMN_USERNAME + " TEXT,"
            + UserTable.COLUMN_PASSWORD + " TEXT,"
            + UserTable.COLUMN_SRANAME + " TEXT"
            + " );";

    public static final String DATABASE_NAME = "pwtrial.db";
    public static final String PROJECT_NAME = "PWTRIAL";
    private static final int DATABASE_VERSION = 1;

    private static final String SQL_CREATE_FOETUSES = "CREATE TABLE "
            + FoetusesContract.FormsTable.TABLE_NAME + "("
            + FoetusesContract.FormsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            FoetusesContract.FormsTable.COLUMN_PROJECTNAME + " TEXT," +
            FoetusesContract.FormsTable.COLUMN_UID + " TEXT," +
            FoetusesContract.FormsTable.COLUMN_UUID + " TEXT," +
            FoetusesContract.FormsTable.COLUMN_FORMDATE + " TEXT," +
            FoetusesContract.FormsTable.COLUMN_USER + " TEXT," +
            FoetusesContract.FormsTable.COLUMN_ISTATUS + " TEXT," +
            FoetusesContract.FormsTable.COLUMN_CRF1_ID + " TEXT," +
            FoetusesContract.FormsTable.COLUMN_SA1 + " TEXT," +
            FoetusesContract.FormsTable.COLUMN_SYNCED + " TEXT," +
            FoetusesContract.FormsTable.COLUMN_SYNCED_DATE + " TEXT," +
            FoetusesContract.FormsTable.COLUMN_APP_VERSION + " TEXT"
            + " );";


    private static final String SQL_CREATE_FORMS = "CREATE TABLE "
            + FormsContract.FormsTable.TABLE_NAME + "("
            + FormsContract.FormsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            FormsContract.FormsTable.COLUMN_PROJECTNAME + " TEXT," +
            FormsContract.FormsTable.COLUMN_UID + " TEXT," +
            FormsContract.FormsTable.COLUMN_FORMDATE + " TEXT," +
            FormsContract.FormsTable.COLUMN_HUSBANDNME + " TEXT," +
            FormsContract.FormsTable.COLUMN_USER + " TEXT," +
            FormsContract.FormsTable.COLUMN_ASSESSID + " TEXT," +
            FormsContract.FormsTable.COLUMN_WOMANNME + " TEXT," +
            FormsContract.FormsTable.COLUMN_ISTATUS + " TEXT," +
            FormsContract.FormsTable.COLUMN_SA1 + " TEXT," +
            FormsContract.FormsTable.COLUMN_GPSLAT + " TEXT," +
            FormsContract.FormsTable.COLUMN_GPSLNG + " TEXT," +
            FormsContract.FormsTable.COLUMN_GPSDATE + " TEXT," +
            FormsContract.FormsTable.COLUMN_GPSACC + " TEXT," +
            FormsContract.FormsTable.COLUMN_GPSELEV + " TEXT," +
            FormsContract.FormsTable.COLUMN_DEVICEID + " TEXT," +
            FormsContract.FormsTable.COLUMN_DEVICETAGID + " TEXT," +
            FormsContract.FormsTable.COLUMN_SYNCED + " TEXT," +
            FormsContract.FormsTable.COLUMN_SYNCED_DATE + " TEXT," +
            FormsContract.FormsTable.COLUMN_APP_VERSION + " TEXT"
            + " );";

    private static final String SQL_DELETE_USERS =
            "DROP TABLE IF EXISTS " + UserTable.TABLE_NAME;
    private static final String SQL_DELETE_FORMS =
            "DROP TABLE IF EXISTS " + FormsContract.FormsTable.TABLE_NAME;

    private final String TAG = "DatabaseHelper";


    public String spDateT = new SimpleDateFormat("dd-MM-yy").format(new Date().getTime());


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_USERS);
        db.execSQL(SQL_CREATE_FORMS);
        db.execSQL(SQL_CREATE_FOETUSES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(SQL_DELETE_USERS);
        db.execSQL(SQL_DELETE_FORMS);
        db.execSQL(SQL_CREATE_FOETUSES);
    }

    // ANDROID DATABASE MANAGER
    public ArrayList<Cursor> getData(String Query) {
        //get writable database
        SQLiteDatabase sqlDB = this.getWritableDatabase();
        String[] columns = new String[]{"message"};
        //an array list of cursor to save two cursors one has results from the query
        //other cursor stores error message if any errors are triggered
        ArrayList<Cursor> alc = new ArrayList<Cursor>(2);
        MatrixCursor Cursor2 = new MatrixCursor(columns);
        alc.add(null);
        alc.add(null);

        try {
            String maxQuery = Query;
            //execute the query results will be save in Cursor c
            Cursor c = sqlDB.rawQuery(maxQuery, null);

            //add value to cursor2
            Cursor2.addRow(new Object[]{"Success"});

            alc.set(1, Cursor2);
            if (null != c && c.getCount() > 0) {

                alc.set(0, c);
                c.moveToFirst();

                return alc;
            }
            return alc;
        } catch (SQLException sqlEx) {
            Log.d("printing exception", sqlEx.getMessage());
            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[]{"" + sqlEx.getMessage()});
            alc.set(1, Cursor2);
            return alc;
        } catch (Exception ex) {

            Log.d("printing exception", ex.getMessage());

            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[]{"" + ex.getMessage()});
            alc.set(1, Cursor2);
            return alc;
        }
    }

    public void syncUser(JSONArray userlist) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(UserTable.TABLE_NAME, null, null);
        try {
            JSONArray jsonArray = userlist;
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObjectUser = jsonArray.getJSONObject(i);

                UserContract user = new UserContract();
                user.Sync(jsonObjectUser);
                ContentValues values = new ContentValues();

                values.put(UserTable.COLUMN_USERNAME, user.getUserName());
                values.put(UserTable.COLUMN_PASSWORD, user.getPassword());
                values.put(UserTable.COLUMN_SRANAME, user.getSraName());
                Long id = db.insert(UserTable.TABLE_NAME, UserTable.COLUMN_NAME_NULLABLE, values);
                Log.d("000088", id + "");
            }


        } catch (Exception e) {
            Log.d(TAG, "syncUser(e): " + e);
        } finally {
            db.close();
        }
    }


    public void updateSyncedForms(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsContract.FormsTable.COLUMN_SYNCED, true);
        values.put(FormsContract.FormsTable.COLUMN_SYNCED_DATE, new Date().toString());

// Which row to update, based on the title
        String where = FormsContract.FormsTable._ID + " = ?";
        String[] whereArgs = {id};

        int count = db.update(
                FormsContract.FormsTable.TABLE_NAME,
                values,
                where,
                whereArgs);
    }

    public void updateSyncedFoetuses(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FoetusesContract.FormsTable.COLUMN_SYNCED, true);
        values.put(FoetusesContract.FormsTable.COLUMN_SYNCED_DATE, new Date().toString());

// Which row to update, based on the title
        String where = FormsContract.FormsTable._ID + " = ?";
        String[] whereArgs = {id};

        int count = db.update(
                FoetusesContract.FormsTable.TABLE_NAME,
                values,
                where,
                whereArgs);
    }

    public Long addfoetuses(FoetusesContract fc) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();

        values.put(FoetusesContract.FormsTable.COLUMN_PROJECTNAME, fc.getProjectName());
        values.put(FoetusesContract.FormsTable.COLUMN_UID, fc.getUID());
        values.put(FoetusesContract.FormsTable.COLUMN_UUID, fc.getUUID());
        values.put(FoetusesContract.FormsTable.COLUMN_FORMDATE, fc.getFormDate());
        values.put(FoetusesContract.FormsTable.COLUMN_CRF1_ID, fc.getCrf1());
        values.put(FoetusesContract.FormsTable.COLUMN_ISTATUS, fc.getIstatus());
        values.put(FoetusesContract.FormsTable.COLUMN_SA1, fc.getsA1());
        values.put(FoetusesContract.FormsTable.COLUMN_SYNCED, fc.getSynced());
        values.put(FoetusesContract.FormsTable.COLUMN_SYNCED_DATE, fc.getSynced_date());
        values.put(FoetusesContract.FormsTable.COLUMN_APP_VERSION, fc.getAppversion());

        long newRowId;
        newRowId = db.insert(
                FoetusesContract.FormsTable.TABLE_NAME,
                FoetusesContract.FormsTable.COLUMN_NAME_NULLABLE,
                values);

        return newRowId;
    }

    public Long addForm(FormsContract fc) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();


        values.put(FormsContract.FormsTable.COLUMN_PROJECTNAME, fc.getProjectName());
        values.put(FormsContract.FormsTable.COLUMN_UID, fc.get_UID());
        values.put(FormsContract.FormsTable.COLUMN_FORMDATE, fc.getFormDate());
        values.put(FormsContract.FormsTable.COLUMN_USER, fc.getUser());
        values.put(FormsContract.FormsTable.COLUMN_ISTATUS, fc.getIstatus());
        values.put(FormsContract.FormsTable.COLUMN_SA1, fc.getsA1());
        values.put(FormsContract.FormsTable.COLUMN_GPSLAT, fc.getGpsLat());
        values.put(FormsContract.FormsTable.COLUMN_GPSLNG, fc.getGpsLng());
        values.put(FormsContract.FormsTable.COLUMN_GPSDATE, fc.getGpsDT());
        values.put(FormsContract.FormsTable.COLUMN_GPSACC, fc.getGpsAcc());
        values.put(FormsContract.FormsTable.COLUMN_GPSELEV, fc.getGpsElev());
        values.put(FormsContract.FormsTable.COLUMN_DEVICEID, fc.getDeviceID());
        values.put(FormsContract.FormsTable.COLUMN_DEVICETAGID, fc.getDevicetagID());
        values.put(FormsContract.FormsTable.COLUMN_SYNCED, fc.getSynced());
        values.put(FormsContract.FormsTable.COLUMN_SYNCED_DATE, fc.getSynced_date());
        values.put(FormsContract.FormsTable.COLUMN_APP_VERSION, fc.getAppversion());

        // Insert the new row, returning the primary key value of the new row


        long newRowId;
        newRowId = db.insert(
                FormsContract.FormsTable.TABLE_NAME,
                FormsContract.FormsTable.COLUMN_NAME_NULLABLE,
                values);


        return newRowId;
    }

    public long updateQuestion(Long id, String data) {
        SQLiteDatabase db = this.getReadableDatabase();

        /*db.rawQuery("UPDATE "+ FormsTable.TABLE_NAME +" SET () ",)*/
// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsContract.FormsTable.COLUMN_SA1, data);


// Which row to update, based on the ID
        String selection = FormsContract.FormsTable._ID + " = ?";
        //String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};
        String[] selectionArgs = {String.valueOf(id)};

        long count = db.update(FormsContract.FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public long updateFoetusesUID(String uid, Long id) {
        SQLiteDatabase db = this.getReadableDatabase();

        /*db.rawQuery("UPDATE "+ FormsTable.TABLE_NAME +" SET () ",)*/
// New value for one column
        ContentValues values = new ContentValues();
        values.put(FoetusesContract.FormsTable.COLUMN_UID, uid);


// Which row to update, based on the ID
        String selection = FoetusesContract.FormsTable._ID + " = ?";
        //String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};
        String[] selectionArgs = {String.valueOf(id)};

        long count = db.update(FoetusesContract.FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public long updateUID(String uid, Long id) {
        SQLiteDatabase db = this.getReadableDatabase();

        /*db.rawQuery("UPDATE "+ FormsTable.TABLE_NAME +" SET () ",)*/
// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsContract.FormsTable.COLUMN_UID, uid);


// Which row to update, based on the ID
        String selection = FormsContract.FormsTable._ID + " = ?";
        //String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};
        String[] selectionArgs = {String.valueOf(id)};

        long count = db.update(FormsContract.FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    // mwra - uPDATE
    public int updateSB2() {
        SQLiteDatabase db = this.getReadableDatabase();

        /*db.rawQuery("UPDATE "+ FormsTable.TABLE_NAME +" SET () ",)*/
// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsContract.FormsTable.COLUMN_SA1, 2);


// Which row to update, based on the ID
        String selection = FormsContract.FormsTable._ID + " = ?";
        //String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};
        String[] selectionArgs = {String.valueOf(2)};

        int count = db.update(FormsContract.FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public String getDataFromTable() {

        String str = null;
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + FormsContract.FormsTable.TABLE_NAME + " WHERE _id = 1";

        Cursor cursor = db.rawQuery(selectQuery, null);

        String[] data = null;
        if (cursor.moveToFirst()) {
            do {
                str = cursor.getString(2) + cursor.getString(4)
                        + cursor.getString(0) + cursor.getString(6) + cursor.getString(5) + cursor.getString(1);


            } while (cursor.moveToNext());
        }

        return str;
    }

    public String getDataFoetusesTable() {

        String str = null;
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + FoetusesContract.FormsTable.TABLE_NAME;

        Cursor cursor = db.rawQuery(selectQuery, null);

        String[] data = null;
        if (cursor.moveToFirst()) {
            do {
                str = str + " new record :" + cursor.getString(2) + cursor.getString(4)
                        + cursor.getString(0) + cursor.getString(6) + cursor.getString(7) + cursor.getString(1);

            } while (cursor.moveToNext());
        }

        return str;
    }

    /*  public FormsContract getUnsyncedChildForms() {
          SQLiteDatabase db = this.getReadableDatabase();
          Cursor c = null;
          String[] columns = {
                  FormsContract.FormsTable._ID,
                  *//*FormsTable.COLUMN_UID,
                FormsTable.COLUMN_APP_VERSION,
                FormsTable.COLUMN_WOMANNME,
                FormsTable.COLUMN_ASSESSID,
                FormsTable.COLUMN_FORMDATE,
                FormsTable.COLUMN_USER,*//*
                FormsContract.FormsTable.COLUMN_SA1,
        };
        String whereClause = null;
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                FormsContract.FormsTable._ID + " ASC";

        FormsContract allFC = null;
        try {
            c = db.query(
                    FormsContract.FormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                allFC = new FormsContract().Hydrate(c);
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
    }
*/
    ////Collection
    public Collection<FormsContract> getAllData() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                FormsContract.FormsTable._ID,
                FormsContract.FormsTable.COLUMN_UID,
                /*FormsTable.COLUMN_APP_VERSION,
                FormsTable.COLUMN_WOMANNME,
                FormsTable.COLUMN_ASSESSID,
                FormsTable.COLUMN_FORMDATE,
                FormsTable.COLUMN_USER,*/
                FormsContract.FormsTable.COLUMN_SA1,
        };
        String whereClause = null;
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                FormsContract.FormsTable._ID + " ASC";

        Collection<FormsContract> allFC = new ArrayList<FormsContract>();
        try {
            c = db.query(
                    FormsContract.FormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                FormsContract fc = new FormsContract();
                allFC.add(fc.Hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
    }

    //
    public Collection<FormsContract> getUnsyncedCrf1() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                FormsContract.FormsTable._ID,
                FormsContract.FormsTable.COLUMN_UID,
                FormsContract.FormsTable.COLUMN_PROJECTNAME,
                FormsContract.FormsTable.COLUMN_FORMDATE,
                FormsContract.FormsTable.COLUMN_USER,
                FormsContract.FormsTable.COLUMN_SA1,
                FormsContract.FormsTable.COLUMN_HUSBANDNME,
                FormsContract.FormsTable.COLUMN_ISTATUS,
                FormsContract.FormsTable.COLUMN_DEVICEID,
                FormsContract.FormsTable.COLUMN_DEVICETAGID,
                FormsContract.FormsTable.COLUMN_ASSESSID,
                FormsContract.FormsTable.COLUMN_FORMDATE,
                FormsContract.FormsTable.COLUMN_DEVICETAGID,
                FormsContract.FormsTable.COLUMN_SYNCED,
                FormsContract.FormsTable.COLUMN_SYNCED_DATE,
                FormsContract.FormsTable.COLUMN_APP_VERSION,

                FormsContract.FormsTable.COLUMN_WOMANNME,

                FormsContract.FormsTable.COLUMN_GPSACC,
                FormsContract.FormsTable.COLUMN_GPSDATE,
                FormsContract.FormsTable.COLUMN_GPSELEV,
                FormsContract.FormsTable.COLUMN_GPSLAT,
                FormsContract.FormsTable.COLUMN_GPSLNG
        };
        String whereClause = null;
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                FormsContract.FormsTable._ID + " ASC";

        Collection<FormsContract> allFC = new ArrayList<FormsContract>();
        try {
            c = db.query(
                    FormsContract.FormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                FormsContract fc = new FormsContract();
                allFC.add(fc.Hydrate(c));
                //allFC.add(fc.Hydrate(c, 0));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
    }

    public Collection<FoetusesContract> getUnsyncedFoetuses() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                FoetusesContract.FormsTable._ID,
                FoetusesContract.FormsTable.COLUMN_UID,
                FoetusesContract.FormsTable.COLUMN_UUID,
                FoetusesContract.FormsTable.COLUMN_PROJECTNAME,
                FoetusesContract.FormsTable.COLUMN_FORMDATE,
                FoetusesContract.FormsTable.COLUMN_USER,
                FoetusesContract.FormsTable.COLUMN_SA1,
                /*FoetusesContract.FormsTable.COLUMN_CRF1_ID,*/
                FoetusesContract.FormsTable.COLUMN_ISTATUS,
                FoetusesContract.FormsTable.COLUMN_SYNCED,
                FoetusesContract.FormsTable.COLUMN_SYNCED_DATE,
                FoetusesContract.FormsTable.COLUMN_APP_VERSION

        };
        String whereClause = null;
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                FormsContract.FormsTable._ID + " ASC";

        Collection<FoetusesContract> allFC = new ArrayList<FoetusesContract>();
        try {
            c = db.query(
                    FormsContract.FormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                FoetusesContract fc = new FoetusesContract();
                allFC.add(fc.Hydrate(c));
                //allFC.add(fc.Hydrate(c, 0));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
    }

}