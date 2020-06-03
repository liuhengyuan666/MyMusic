package cn.edu.scujcc.mymusic;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class UserLab {
    public final static int USER_LOGIN_SUCCESS = 1;
    public final static int USER_LOGIN_FAIL = -1;
    public final static int USER_LOGIN_PASSWORD_ERROR = -2;
    public final static int USER_REGISTER_FAIL = -3;
    public final static int USER_REGISTER_SUCCESS = 2;
    public final static String USER_CURRENT = "USER_CURRENT";
    public final static String USER_TOKEN = "USER_TOKEN";

    private final static String TAG = "MyMusic";
    private static UserLab INSTANCE = null;

    private UserLab() {
    }

    public static UserLab getInstance() {
        if (null == INSTANCE) {
            INSTANCE = new UserLab();
        }
        return INSTANCE;
    }

    public void login(String user, String p, Handler handler) {
    }
}