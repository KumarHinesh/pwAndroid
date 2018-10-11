package mamtalwtrial.hineshkumar.com.pregnantwoman.dtos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String SQL_CREATE_USERS = "CREATE TABLE " + UsersContract.UsersTable.TABLE_NAME + "("
            + UsersTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + UsersTable.ROW_USERNAME + " TEXT,"
            + UsersTable.ROW_PASSWORD + " TEXT,"
            + UsersTable.FULL_NAME + " TEXT"
            + " );";

    public static final String DATABASE_NAME = "kmc.db";
    public static final String DB_NAME = DATABASE_NAME.replace(".", "_copy.");
    public static final String PROJECT_NAME = "KMC-2018-2020";
    private static final int DATABASE_VERSION = 1;
    private static final String SQL_CREATE_FORMS = "CREATE TABLE "
            + FormsTable.TABLE_NAME + "("
            + FormsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            FormsTable.COLUMN_PROJECTNAME + " TEXT," +
            FormsTable.COLUMN_SURVEYTYPE + " TEXT," +
            FormsTable.COLUMN__UID + " TEXT," +
            FormsTable.COLUMN_FORMDATE + " TEXT," +
            FormsTable.COLUMN_USER + " TEXT," +
            FormsTable.COLUMN_ISTATUS + " TEXT," +
            FormsTable.COLUMN_ISTATUS88X + " TEXT," +
            FormsTable.COLUMN_SINFO + " TEXT," +
            FormsTable.COLUMN_SA1 + " TEXT," +
            FormsTable.COLUMN_SB2 + " TEXT," +
            FormsTable.COLUMN_SC1 + " TEXT," +
            FormsTable.COLUMN_SC2 + " TEXT," +
            FormsTable.COLUMN_SC3 + " TEXT," +
            FormsTable.COLUMN_SC4 + " TEXT," +
            FormsTable.COLUMN_SC5 + " TEXT," +
            FormsTable.COLUMN_SC6 + " TEXT," +
            FormsTable.COLUMN_SD1 + " TEXT," +
            FormsTable.COLUMN_SD2 + " TEXT," +
            FormsTable.COLUMN_SD3 + " TEXT," +
            FormsTable.COLUMN_SE + " TEXT," +
            FormsTable.COLUMN_SF + " TEXT," +
            FormsTable.COLUMN_ENDINGDATETIME + " TEXT," +
            FormsTable.COLUMN_GPSLAT + " TEXT," +
            FormsTable.COLUMN_GPSLNG + " TEXT," +
            FormsTable.COLUMN_GPSDT + " TEXT," +
            FormsTable.COLUMN_GPSACC + " TEXT," +
            FormsTable.COLUMN_GPSELEV + " TEXT," +
            FormsTable.COLUMN_DEVICEID + " TEXT," +
            FormsTable.COLUMN_DEVICETAGID + " TEXT," +
            FormsTable.COLUMN_SYNCED + " TEXT," +
            FormsTable.COLUMN_SYNCED_DATE + " TEXT," +
            FormsTable.COLUMN_APPVERSION + " TEXT"
            + " );";

    private static final String SQL_DELETE_USERS =
            "DROP TABLE IF EXISTS " + UsersContract.UsersTable.TABLE_NAME;
    private static final String SQL_DELETE_FORMS =
            "DROP TABLE IF EXISTS " + FormsTable.TABLE_NAME;

    private final String TAG = "DatabaseHelper";


    public String spDateT = new SimpleDateFormat("dd-MM-yy").format(new Date().getTime());


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_USERS);
        db.execSQL(SQL_CREATE_FORMS);

        db.execSQL(SQL_CREATE_DISTRICT_TABLE);
        db.execSQL(SQL_CREATE_UC);
        db.execSQL(SQL_CREATE_PSU_TABLE);
        db.execSQL(SQL_CREATE_MWRA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(SQL_DELETE_USERS);
        db.execSQL(SQL_DELETE_FORMS);

        db.execSQL(SQL_DELETE_TALUKA);
        db.execSQL(SQL_DELETE_UCS);
        db.execSQL(SQL_DELETE_VILLAGE);
        db.execSQL(SQL_DELETE_MWRA);
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