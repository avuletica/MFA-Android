package hr.fesb.mfa_android;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.iconics.IconicsDrawable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText usernameEdit = findViewById(R.id.username_input);
        usernameEdit.setCompoundDrawablesRelative(null, null, new IconicsDrawable(this)
                .icon(GoogleMaterial.Icon.gmd_account_circle)
                .color(Color.RED)
                .sizeDp(24), null);

    }

}
