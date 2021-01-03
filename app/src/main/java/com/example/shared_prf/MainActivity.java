package com.example.shared_prf;



import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    private SharedPreferences mPreferences ;
    private SharedPreferences.Editor mEditor ;

    private EditText mName,mPassword;
    private CheckBox mRemember;
    private Button mSign ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mName = findViewById(R.id.user_name);
        mPassword = findViewById(R.id.password);
        mSign = findViewById(R.id.login);
        mRemember = findViewById(R.id.remember_me);

        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mPreferences.edit();
        check_pref();
        mSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(mRemember.isChecked()){
                    mEditor.putString(getString(R.string.remember_me),"True");
                    mEditor.commit();

                    mEditor.putString(getString(R.string.user_name), String.valueOf(mName));
                    mEditor.commit();

                    mEditor.putString(getString(R.string.user_password), String.valueOf(mPassword));
                    mEditor.commit();

                }else{
                    mEditor.putString(getString(R.string.remember_me),"False");
                    mEditor.commit();

                    mEditor.putString(getString(R.string.user_name),"");
                    mEditor.commit();
                    
                    mEditor.putString(getString(R.string.user_password),"");
                    mEditor.commit();

                }
            }
        });


    }



        private void check_pref() {
            String checkbox= mPreferences.getString(getString(R.string.remember_me),"False") ;
            String name= mPreferences.getString(getString(R.string.user_name),"") ;
            String password= mPreferences.getString(getString(R.string.user_password),"") ;
            mName=setText(name) ;
            mPassword=setText(password) ;
            if (checkbox.equals(true)) {
                mRemember.setChecked(true);

            }else {
                mRemember.setChecked(false);
            }









        }




        }
}