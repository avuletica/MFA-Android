package hr.fesb.mfa_android.activites;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.EditText;

import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.iconics.IconicsDrawable;

import hr.fesb.mfa_android.R;
import hr.fesb.mfa_android.models.UserModel;
import hr.fesb.mfa_android.services.RequestService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText usernameInput;
    private EditText passwordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameInput = findViewById(R.id.username_input);
        passwordInput = findViewById(R.id.password_input);

        usernameInput.setCompoundDrawablesRelative(null, null, new IconicsDrawable(this)
                .icon(GoogleMaterial.Icon.gmd_account_circle)
                .color(Color.RED)
                .sizeDp(24), null);

        AppCompatButton loginButton = findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RequestService.instance.getService().login(createUserModel()).enqueue(loginCallback);
            }
        });

    }

    private void openHomeActivity() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    Callback<Void> loginCallback = new Callback<Void>() {
        @Override
        public void onResponse(Call call, Response response) {
            System.out.println(response.headers());
            openHomeActivity();
        }

        @Override
        public void onFailure(Call call, Throwable t) {
            System.out.println("err" + t);
        }
    };

    private UserModel createUserModel (){
        UserModel user = new UserModel();
        user.setUsername(usernameInput.getText().toString());
        user.setPassword(passwordInput.getText().toString());
        return user;
    }

}
