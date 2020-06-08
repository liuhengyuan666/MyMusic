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

    public void login(String username, String password, Handler handler){
        Retrofit retrofit = RetrofitClient.get();
        UserApi api = retrofit.create(UserApi.class);
        Call<Result<String>> call = api.login(username, password);
        call.enqueue(new Callback<Result<String>>() {
            @Override
            public void onResponse(Call<Result<String>> call, Response<Result<String>> response) {
                if (response.body() != null) {
                    Log.d(TAG, "登录结果是：" + response.body().toString());
                    Result<String> result = response.body();
                    if (result.getStatus() == Result.OK) {  //登录成功
                        Message msg = new Message();
                        msg.what = USER_LOGIN_SUCCESS;
                        msg.obj = result.getData();
                        handler.sendMessage(msg);
                    }else {
                        Message msg = new Message();
                        msg.what = USER_LOGIN_PASSWORD_ERROR;
                        msg.obj = result.getMessage();
                        handler.sendMessage(msg);
                    }
                }else {
                    Message msg = new Message();
                    msg.what = USER_LOGIN_FAIL;
                    handler.sendMessage(msg);
                }
            }

            @Override
            public void onFailure(Call<Result<String>> call, Throwable t) {
                Log.e(TAG, "登录失败", t);
                Message msg = new Message();
                msg.what = USER_LOGIN_FAIL;
                handler.sendMessage(msg);
            }
        });
    }

    //用户注册
    public void register(User user,Handler handler){
        Retrofit retrofit = RetrofitClient.get();
        UserApi api = retrofit.create(UserApi.class);
        Log.d(TAG, "准备注册的用户信息是：" + user);
        Call<Result<User>> call = api.register(user);
        call.enqueue(new Callback<Result<User>>() {
            @Override
            public void onResponse(Call<Result<User>> call, Response<Result<User>> response) {
                if (response.body() != null) {
                    Result<User> result = response.body();
                    if (result.getStatus() == Result.OK) {
                        Log.d(TAG, "用户成功注册");
                        Log.d(TAG, "返回数据是" + response.body());
                        Message msg = new Message();
                        msg.what = USER_REGISTER_SUCCESS;
                        handler.sendMessage(msg);
                    }else if (result.getStatus() == Result.ERROR){
                        Message msg = new Message();
                        msg.what = USER_REGISTER_FAIL;
                        handler.sendMessage(msg);
                    }
                }else{
                    Log.e(TAG,"注册失败！");
                    Message msg = new Message();
                    msg.what = USER_REGISTER_FAIL;
                    handler.sendMessage(msg);
                }
            }

            @Override
            public void onFailure(Call<Result<User>> call, Throwable t) {
                Log.e(TAG,"注册失败！");
                Message msg = new Message();
                msg.what = USER_REGISTER_FAIL;
                handler.sendMessage(msg);
            }
        });
    }
}