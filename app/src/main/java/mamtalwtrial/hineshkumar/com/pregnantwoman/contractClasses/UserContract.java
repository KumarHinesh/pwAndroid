package mamtalwtrial.hineshkumar.com.pregnantwoman.contractClasses;

import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

import mamtalwtrial.hineshkumar.com.pregnantwoman.dtos.SiteDTO;

public class UserContract {

    private static final String TAG = "Users_CONTRACT";

    private Long id;
    private String sraName;
    private String userName;
    private String password;
    //private TeamTitleDTO teamTitle;
    private SiteDTO site;
    //private List<FormCrf1DTO> formCrf1;
    private Integer status;
    private String date;
    private String time;


    public UserContract() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    /*public TeamTitleDTO getTeamTitle() {
        return teamTitle;
    }

    public void setTeamTitle(TeamTitleDTO teamTitle) {
        this.teamTitle = teamTitle;
    }*/

    public SiteDTO getSite() {
        return site;
    }

    public void setSite(SiteDTO site) {
        this.site = site;
    }

    /*public List<FormCrf1DTO> getFormCrf1() {
        return formCrf1;
    }*/

    /*public void setFormCrf1(List<FormCrf1DTO> formCrf1) {
        this.formCrf1 = formCrf1;
    }*/

    public String getSraName() {
        return sraName;
    }

    public void setSraName(String sraName) {
        this.sraName = sraName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public UserContract Sync(JSONObject jsonObject) throws JSONException {
        this.userName = jsonObject.getString(UserTable.COLUMN_USERNAME);
        this.password = jsonObject.getString(UserTable.COLUMN_PASSWORD);
        this.sraName = jsonObject.getString(UserTable.COLUMN_SRANAME);
        return this;

    }

    public static abstract class UserTable implements BaseColumns {

        public static final String TABLE_NAME = "login";
        public static final String COLUMN_NAME_NULLABLE = "NULLHACK";
        public static final String COLUMN__ID = "_id";
        public static final String COLUMN_SRANAME = "sraName";
        public static final String COLUMN_USERNAME = "userName";
        public static final String COLUMN_PASSWORD = "password";
        public static final String COLUMN_SITE = "site";
        public static final String COLUMN_STATUS = "status";
        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_TIME = "time";

        public static final String _URI = "users.php";
    }
}