package hr.fesb.mfa_android.services;

import hr.fesb.mfa_android.models.UserModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RequestInterface {

    @POST("login")
    Call<Void> login(@Body UserModel userModel);

}
