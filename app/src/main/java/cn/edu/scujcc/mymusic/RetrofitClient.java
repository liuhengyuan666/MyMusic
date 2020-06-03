package cn.edu.scujcc.mymusic;

import com.squareup.moshi.Moshi;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit = null;
    public static Retrofit get(){
        if (retrofit == null){
            Moshi moshi = new Moshi.Builder()
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl("http://47.115.55.205:8080")
                    .addConverterFactory(MoshiConverterFactory.create(moshi))
                    .build();
        }
        return retrofit;
    }
}
