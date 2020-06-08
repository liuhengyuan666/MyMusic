package cn.edu.scujcc.mymusic;

import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit = null;
    public static Retrofit get(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://47.115.55.205:8080")
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
