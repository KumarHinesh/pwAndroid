package mamtalwtrial.hineshkumar.com.pregnantwoman.dtos;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import  mamtalwtrial.hineshkumar.com.pregnantwoman.dtos.FormsContract.FormsTable;

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
    public static final String DB_NAME = DATABASE_NAME.replace(".", "_copy.");
    public static final String PROJECT_NAME = "PWTRIAL";
    private static final int DATABASE_VERSION = 1;

    private static final String SQL_CREATE_FORMS = "CREATE TABLE "
            + FormsContract.FormsTable.TABLE_NAME + "("
            + FormsContract.FormsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            FormsContract.FormsTable.COLUMN_PROJECTNAME + " TEXT," +
            FormsContract.FormsTable.COLUMN_SURVEYTYPE + " TEXT," +
            FormsContract.FormsTable.COLUMN__UID + " TEXT," +
            FormsContract.FormsTable.COLUMN_FORMDATE + " TEXT," +
            FormsContract.FormsTable.COLUMN_USER + " TEXT," +
            FormsContract.FormsTable.COLUMN_ISTATUS + " TEXT," +
            FormsContract.FormsTable.COLUMN_ISTATUS88X + " TEXT," +
            FormsContract.FormsTable.COLUMN_SINFO + " TEXT," +
            FormsContract.FormsTable.COLUMN_SA1 + " TEXT," +
            FormsContract.FormsTable.COLUMN_ENDINGDATETIME + " TEXT," +
            FormsContract.FormsTable.COLUMN_GPSLAT + " TEXT," +
            FormsContract.FormsTable.COLUMN_GPSLNG + " TEXT," +
            FormsContract.FormsTable.COLUMN_GPSDT + " TEXT," +
            FormsContract.FormsTable.COLUMN_GPSACC + " TEXT," +
            FormsContract.FormsTable.COLUMN_GPSELEV + " TEXT," +
            FormsContract.FormsTable.COLUMN_DEVICEID + " TEXT," +
            FormsContract.FormsTable.COLUMN_DEVICETAGID + " TEXT," +
            FormsContract.FormsTable.COLUMN_SYNCED + " TEXT," +
            FormsContract.FormsTable.COLUMN_SYNCED_DATE + " TEXT," +
            FormsContract.FormsTable.COLUMN_APPVERSION + " TEXT"
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
        values.put(FormsTable.COLUMN_SURVEYTYPE, fc.getSurveyType());
        values.put(FormsTable.COLUMN__UID, fc.getUID());
        values.put(FormsTable.COLUMN_FORMDATE, fc.getFormDate());
        values.put(FormsTable.COLUMN_USER, fc.getUser());
        values.put(FormsTable.COLUMN_ISTATUS, fc.getIstatus());
        values.put(FormsTable.COLUMN_ISTATUS88X, fc.getIstatus88x());
        values.put(FormsTable.COLUMN_SINFO, fc.getsInfo());
        values.put(FormsTable.COLUMN_SA1, fc.getsA1());
        values.put(FormsTable.COLUMN_SB2, fc.getsB2());
        values.put(FormsTable.COLUMN_SC1, fc.getsC1());
        values.put(FormsTable.COLUMN_SC2, fc.getsC2());
        values.put(FormsTable.COLUMN_SC3, fc.getsC3());
        values.put(FormsTable.COLUMN_SC4, fc.getsC4());
        values.put(FormsTable.COLUMN_SC5, fc.getsC5());
        values.put(FormsTable.COLUMN_SC6, fc.getsC6());
        values.put(FormsTable.COLUMN_SD1, fc.getsD1());
        values.put(FormsTable.COLUMN_SD2, fc.getsD2());
        values.put(FormsTable.COLUMN_SD3, fc.getsD3());
        values.put(FormsTable.COLUMN_SE, fc.getsE());
        values.put(FormsTable.COLUMN_SF, fc.getsF());
        values.put(FormsTable.COLUMN_ENDINGDATETIME, fc.getEndingdatetime());
        values.put(FormsTable.COLUMN_GPSLAT, fc.getGpsLat());
        values.put(FormsTable.COLUMN_GPSLNG, fc.getGpsLng());
        values.put(FormsTable.COLUMN_GPSDT, fc.getGpsDT());
        values.put(FormsTable.COLUMN_GPSACC, fc.getGpsAcc());
        values.put(FormsTable.COLUMN_GPSELEV, fc.getGpsElev());
        values.put(FormsTable.COLUMN_DEVICEID, fc.getDeviceID());
        values.put(FormsTable.COLUMN_DEVICETAGID, fc.getDevicetagID());
        values.put(FormsTable.COLUMN_SYNCED, fc.getSynced());
        values.put(FormsTable.COLUMN_SYNCED_DATE, fc.getSynced_date());
        values.put(FormsTable.COLUMN_APPVERSION, fc.getAppversion());


        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                FormsTable.TABLE_NAME,
                FormsTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }
}