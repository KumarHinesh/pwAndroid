package mamtalwtrial.hineshkumar.com.pregnantwoman.contractClasses;

import android.database.Cursor;

import org.json.JSONException;
import org.json.JSONObject;

import mamtalwtrial.hineshkumar.com.pregnantwoman.constants.ContantsValues;

public class FormsContract {


    private final String projectName = ContantsValues.PROJECT_NAME;
    //private final String surveyType = "SN";
    private String _ID = "";
    private String _UID = "";
    private String assessid = "";
    private String formDate = ""; // Date
    private String user = "";
    private String womannme = "";
    private String husbandnme = "";

    private String istatus = ""; // Interview Status
    private String istatus88x = ""; // Interview Status

    private String sA1 = "";     // Info Section

    private String count = "";

    private String gpsLat = "";
    private String gpsLng = "";
    private String gpsDT = "";
    private String gpsAcc = "";
    private String gpsElev = "";
    private String deviceID = "";
    private String devicetagID = "";
    private String synced = "";
    private String synced_date = "";
    private String appversion;

    public String getProjectName() {
        return projectName;
    }

    public String get_ID() {
        return _ID;
    }

    public void set_ID(String _ID) {
        this._ID = _ID;
    }

    public String get_UID() {
        return _UID;
    }

    public void set_UID(String _UID) {
        this._UID = _UID;
    }

    public String getFormDate() {
        return formDate;
    }

    public void setFormDate(String formDate) {
        this.formDate = formDate;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getIstatus() {
        return istatus;
    }

    public void setIstatus(String istatus) {
        this.istatus = istatus;
    }

    public String getIstatus88x() {
        return istatus88x;
    }

    public void setIstatus88x(String istatus88x) {
        this.istatus88x = istatus88x;
    }

    public String getsA1() {
        return sA1;
    }

    public void setsA1(String sA1) {
        this.sA1 = sA1;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getGpsLat() {
        return gpsLat;
    }

    public void setGpsLat(String gpsLat) {
        this.gpsLat = gpsLat;
    }

    public String getGpsLng() {
        return gpsLng;
    }

    public void setGpsLng(String gpsLng) {
        this.gpsLng = gpsLng;
    }

    public String getGpsDT() {
        return gpsDT;
    }

    public void setGpsDT(String gpsDT) {
        this.gpsDT = gpsDT;
    }

    public String getGpsAcc() {
        return gpsAcc;
    }

    public void setGpsAcc(String gpsAcc) {
        this.gpsAcc = gpsAcc;
    }

    public String getGpsElev() {
        return gpsElev;
    }

    public void setGpsElev(String gpsElev) {
        this.gpsElev = gpsElev;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getDevicetagID() {
        return devicetagID;
    }

    public void setDevicetagID(String devicetagID) {
        this.devicetagID = devicetagID;
    }

    public String getSynced() {
        return synced;
    }

    public void setSynced(String synced) {
        this.synced = synced;
    }

    public String getSynced_date() {
        return synced_date;
    }

    public void setSynced_date(String synced_date) {
        this.synced_date = synced_date;
    }

    public String getAppversion() {
        return appversion;
    }

    public void setAppversion(String appversion) {
        this.appversion = appversion;
    }

    public String getAssessid() {
        return assessid;
    }

    public void setAssessid(String assessid) {
        this.assessid = assessid;
    }

    public String getWomannme() {
        return womannme;
    }

    public void setWomannme(String womannme) {
        this.womannme = womannme;
    }

    public String getHusbandnme() {
        return husbandnme;
    }

    public void setHusbandnme(String husbandnme) {
        this.husbandnme = husbandnme;
    }


    public FormsContract() {
    }

    public FormsContract Sync(JSONObject jsonObject) throws JSONException {

        this._ID = jsonObject.getString(FormsTable._ID);
        this._UID = jsonObject.getString(FormsTable.COLUMN_UID);

        this.formDate = jsonObject.getString(FormsTable.COLUMN_FORMDATE);
        this.user = jsonObject.getString(FormsTable.COLUMN_USER);
        this.assessid = jsonObject.getString(FormsTable.COLUMN_ASSESSID);
        this.womannme = jsonObject.getString(FormsTable.COLUMN_WOMANNME);
        this.husbandnme = jsonObject.getString(FormsTable.COLUMN_HUSBANDNME);

        this.istatus = jsonObject.getString(FormsTable.COLUMN_ISTATUS);
        this.istatus88x = jsonObject.getString(FormsTable.COLUMN_ISTATUS);
        this.gpsElev = jsonObject.getString(FormsTable.COLUMN_GPSELEV);
        this.sA1 = jsonObject.getString(FormsTable.COLUMN_SA1);

        this.count = jsonObject.getString(FormsTable.COLUMN_COUNT);
        this.gpsLat = jsonObject.getString(FormsTable.COLUMN_GPSLAT);
        this.gpsLng = jsonObject.getString(FormsTable.COLUMN_GPSLNG);
        this.gpsDT = jsonObject.getString(FormsTable.COLUMN_GPSDATE);
        this.gpsAcc = jsonObject.getString(FormsTable.COLUMN_GPSACC);
        this.deviceID = jsonObject.getString(FormsTable.COLUMN_DEVICEID);
        this.devicetagID = jsonObject.getString(FormsTable.COLUMN_DEVICETAGID);
        this.synced = jsonObject.getString(FormsTable.COLUMN_SYNCED);
        this.synced_date = jsonObject.getString(FormsTable.COLUMN_SYNCED_DATE);
        this.appversion = jsonObject.getString(FormsTable.COLUMN_APP_VERSION);

        return this;

    }

    public FormsContract Hydrate(Cursor cursor) {
        this._ID = cursor.getString(cursor.getColumnIndex(FormsTable._ID));
        this._UID = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_UID));
        this.formDate = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_FORMDATE));
        this.user = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_USER));

        this.assessid = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_ASSESSID));
        this.womannme = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_WOMANNME));
        this.husbandnme = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_HUSBANDNME));

        this.istatus = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_ISTATUS));
        this.istatus88x = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_ISTATUS));
        this.gpsElev = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_GPSELEV));
        this.sA1 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SA1));

        this.count = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_COUNT));
        this.gpsLat = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_GPSLAT));
        this.gpsLng = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_GPSLNG));
        this.gpsDT = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_GPSDATE));
        this.gpsAcc = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_GPSACC));
        this.deviceID = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_DEVICEID));
        this.devicetagID = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_DEVICETAGID));
        this.synced = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SYNCED));
        this.synced_date = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SYNCED_DATE));
        this.appversion = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_APP_VERSION));

        // TODO:

        return this;

    }


    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();

        json.put(FormsTable._ID, this._ID == null ? JSONObject.NULL : this._ID);
        json.put(FormsTable.COLUMN_UID, this._UID == null ? JSONObject.NULL : this._UID);
        json.put(FormsTable.COLUMN_FORMDATE, this.formDate == null ? JSONObject.NULL : this.formDate);
        json.put(FormsTable.COLUMN_USER, this.user == null ? JSONObject.NULL : this.user);

        json.put(FormsTable.COLUMN_ASSESSID, this.assessid == null ? JSONObject.NULL : this.assessid);
        json.put(FormsTable.COLUMN_WOMANNME, this.womannme == null ? JSONObject.NULL : this.womannme);
        json.put(FormsTable.COLUMN_HUSBANDNME, this.husbandnme == null ? JSONObject.NULL : this.husbandnme);

        json.put(FormsTable.COLUMN_ISTATUS, this.istatus == null ? JSONObject.NULL : this.istatus);
        json.put(FormsTable.COLUMN_ISTATUS88x, this.istatus88x == null ? JSONObject.NULL : this.istatus88x);
        json.put(FormsTable.COLUMN_GPSELEV, this.gpsElev == null ? JSONObject.NULL : this.gpsElev);

        if (!this.sA1.equals("")) {

            json.put(FormsTable.COLUMN_SA1, this.sA1.equals("") ? JSONObject.NULL : new JSONObject(this.sA1));
        }


        if (!this.count.equals("")) {

            json.put(FormsTable.COLUMN_COUNT, this.count.equals("") ? JSONObject.NULL : new JSONObject(this.count));
        }


        /*if (!this.sA4.equals("")) {
            json.put(FormsTable.COLUMN_SA3, this.sA4.equals("") ? JSONObject.NULL : new JSONObject(this.sA4));
        }
        if (!this.sA5.equals("")) {
            json.put(FormsTable.COLUMN_SA5, this.sA5.equals("") ? JSONObject.NULL : new JSONObject(this.sA5));
        }
        if (!this.sB4.equals("")) {
            json.put(FormsTable.COLUMN_SB4, this.sB4.equals("") ? JSONObject.NULL : new JSONObject(this.sB4));
        }*/
        json.put(FormsTable.COLUMN_GPSLAT, this.gpsLat == null ? JSONObject.NULL : this.gpsLat);
        json.put(FormsTable.COLUMN_GPSLNG, this.gpsLng == null ? JSONObject.NULL : this.gpsLng);
        json.put(FormsTable.COLUMN_GPSDATE, this.gpsDT == null ? JSONObject.NULL : this.gpsDT);
        json.put(FormsTable.COLUMN_GPSACC, this.gpsAcc == null ? JSONObject.NULL : this.gpsAcc);
        json.put(FormsTable.COLUMN_DEVICEID, this.deviceID == null ? JSONObject.NULL : this.deviceID);
        json.put(FormsTable.COLUMN_DEVICETAGID, this.devicetagID == null ? JSONObject.NULL : this.devicetagID);
        json.put(FormsTable.COLUMN_SYNCED, this.synced == null ? JSONObject.NULL : this.synced);
        json.put(FormsTable.COLUMN_SYNCED_DATE, this.synced_date == null ? JSONObject.NULL : this.synced_date);
        json.put(FormsTable.COLUMN_APP_VERSION, this.appversion == null ? JSONObject.NULL : this.appversion);

        return json;
    }


    public static abstract class FormsTable /*implements BaseColumns */ {

        public static final String TABLE_NAME = "forms";
        public static final String COLUMN_NAME_NULLABLE = "NULLHACK";
        public static final String COLUMN_PROJECTNAME = "projectname";

        public static final String _ID = "_id";
        public static final String COLUMN_UID = "_uid";
        public static final String COLUMN_FORMDATE = "formdate";
        public static final String COLUMN_USER = "user";
        public static final String COLUMN_ASSESSID = "assessid";
        public static final String COLUMN_WOMANNME = "womannme";
        public static final String COLUMN_HUSBANDNME = "husbandnme";

        public static final String COLUMN_ISTATUS = "istatus";
        public static final String COLUMN_ISTATUS88x = "istatus88x";

        public static final String COLUMN_SA1 = "sa1";
        public static final String COLUMN_COUNT = "count";

        public static final String COLUMN_GPSLAT = "gpslat";
        public static final String COLUMN_GPSLNG = "gpslng";
        public static final String COLUMN_GPSDATE = "gpsdate";
        public static final String COLUMN_GPSACC = "gpsacc";
        public static final String COLUMN_GPSELEV = "gpselev";
        public static final String COLUMN_DEVICEID = "deviceid";
        public static final String COLUMN_DEVICETAGID = "tagid";
        public static final String COLUMN_SYNCED = "synced";
        public static final String COLUMN_SYNCED_DATE = "synced_date";
        public static final String COLUMN_APP_VERSION = "appversion";

        public static String _URL = "forms.php";
    }


}