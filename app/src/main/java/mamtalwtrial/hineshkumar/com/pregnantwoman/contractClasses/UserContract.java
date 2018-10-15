package mamtalwtrial.hineshkumar.com.pregnantwoman.contractClasses;

import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

public class UserContract {

    private static final String TAG = "Users_CONTRACT";

    private Long id;
    private String sraName;
    private String userName;
    private String password;

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

    public String getSraName() {
        return sraName;
    }

    public void setSraName(String sraName) {
        this.sraName = sraName;
    }

    public UserContract Sync(JSONObject jsonObject) throws JSONException {
        this.userName = jsonObject.getString(UserTable.COLUMN_USERNAME);
        this.password = jsonObject.getString(UserTable.COLUMN_PASSWORD);
        this.sraName = jsonObject.getString(UserTable.COLUMN_SRANAME);
        return this;

    }

    public static abstract class UserTable implements BaseColumns {

        public static final String TABLE_NAME = "Users";
        public static final String COLUMN_NAME_NULLABLE = "NULLHACK";
        public static final String COLUMN__ID = "_id";
        public static final String COLUMN_SRANAME = "sra_name";
        public static final String COLUMN_USERNAME = "user_name";
        public static final String COLUMN_PASSWORD = "password";

        public static final String _URI = "users.php";
    }
}