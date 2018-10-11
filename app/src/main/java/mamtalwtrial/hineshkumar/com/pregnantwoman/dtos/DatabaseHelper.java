package mamtalwtrial.hineshkumar.com.pregnantwoman.dtos;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import mamtalwtrial.hineshkumar.com.pregnantwoman.dtos.FormsContract.FormsTable;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String SQL_CREATE_USERS = "CREATE TABLE " + UserContract.UserTable.TABLE_NAME + "("
            + UserContract.UserTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + UserContract.UserTable.COLUMN_SRANAME + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + UserContract.UserTable.COLUMN_USERNAME + " TEXT,"
            + UserContract.UserTable.COLUMN_PASSWORD + " TEXT,"
            + UserContract.UserTable.COLUMN_SITE + " TEXT,"
            + UserContract.UserTable.COLUMN_STATUS + " TEXT,"
            + UserContract.UserTable.COLUMN_DATE + " TEXT,"
            + UserContract.UserTable.COLUMN_TIME + " TEXT"
            + " );";

    public static final String DATABASE_NAME = "pwtrial.db";
    public static final String PROJECT_NAME = "PWTRIAL";
    private static final int DATABASE_VERSION = 1;

    private static final String SQL_CREATE_FORMS = "CREATE TABLE "
            + FormsContract.FormsTable.TABLE_NAME + "("
            + FormsContract.FormsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            FormsContract.FormsTable.COLUMN_PROJECTNAME + " TEXT," +
            FormsContract.FormsTable.COLUMN_UID + " TEXT," +
            FormsContract.FormsTable.COLUMN_FORMDATE + " TEXT," +
            FormsContract.FormsTable.COLUMN_USER + " TEXT," +
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
            "DROP TABLE IF EXISTS " + UserContract.UserTable.TABLE_NAME;
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
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(SQL_DELETE_USERS);
        db.execSQL(SQL_DELETE_FORMS);
    }

    public Long addForm(FormsContract fc) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();

        values.put(FormsTable.COLUMN_PROJECTNAME, fc.getProjectName());
        values.put(FormsTable.COLUMN_UID, fc.get_UID());
        values.put(FormsTable.COLUMN_FORMDATE, fc.getFormDate());
        values.put(FormsTable.COLUMN_USER, fc.getUser());
        values.put(FormsTable.COLUMN_ISTATUS, fc.getIstatus());
        values.put(FormsTable.COLUMN_SA1, fc.getsA1());
        values.put(FormsTable.COLUMN_GPSLAT, fc.getGpsLat());
        values.put(FormsTable.COLUMN_GPSLNG, fc.getGpsLng());
        values.put(FormsTable.COLUMN_GPSDATE, fc.getGpsDT());
        values.put(FormsTable.COLUMN_GPSACC, fc.getGpsAcc());
        values.put(FormsTable.COLUMN_GPSELEV, fc.getGpsElev());
        values.put(FormsTable.COLUMN_DEVICEID, fc.getDeviceID());
        values.put(FormsTable.COLUMN_DEVICETAGID, fc.getDevicetagID());
        values.put(FormsTable.COLUMN_SYNCED, fc.getSynced());
        values.put(FormsTable.COLUMN_SYNCED_DATE, fc.getSynced_date());
        values.put(FormsTable.COLUMN_APP_VERSION, fc.getAppversion());


        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                FormsTable.TABLE_NAME,
                FormsTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }
}