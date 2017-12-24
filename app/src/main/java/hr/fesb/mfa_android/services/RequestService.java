package hr.fesb.mfa_android.services;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.OkHttpClient;
import okhttp3.Interceptor;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RequestService {
    public static final RequestService instance = new RequestService();

    /*
        use http://10.0.2.2:8080/ Because Android emulator runs in a Virtual Machine
        therefore here 127.0.0.1 or localhost will be emulator's own loopback address.
     */
    private Retrofit retrofit = new Retrofit.Builder()
            .addConverterFactory(JacksonConverterFactory.create(new ObjectMapper()
                    .setSerializationInclusion(JsonInclude.Include.NON_NULL)))
            .baseUrl("http://10.0.2.2:8080/")
            .client(new OkHttpClient.Builder().addInterceptor(createLoggingInterceptor()).build())
            .build();

    public RequestInterface getService() {
        return service;
    }

    private HttpLoggingInterceptor createLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        return httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    private RequestInterface service = retrofit.create(RequestInterface.class);
}
