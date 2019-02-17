package com.example.android.butterbread;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    @BindView(R.id.Email)
    EditText _Email;
    @BindView(R.id.Password)
    EditText _Password;
    @BindView(R.id.btn_login)
    Button _loginbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating....");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        _loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
                progressDialog.show();
            }
        });
    }

    public void login() {
        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating....");
        progressDialog.show();
        Log.d(TAG, getString(R.string.login));
        if (!validate()) {
            LoginFailed();
            progressDialog.dismiss();
            return;
        }
        _loginbutton.setEnabled(false);



        if (cheaking()) {


            new android.os.Handler().postDelayed(
                    new Runnable() {
                        public void run() {
                            LoginSucces();
                            //progressDialog.dismiss();

                        }

                    }, 3000);
        } else
            LoginFailed();
        _loginbutton.setEnabled(true);
        progressDialog.hide();

    }

    private boolean validate() {
        boolean valid = true;
        String email = _Email.getText().toString();
        String password = _Password.getText().toString();

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _Email.setError("enter a valid email address");
            valid = false;
        } else {
            _Email.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            _Password.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            _Password.setError(null);
        }

        return valid;

    }

    public void LoginFailed() {
        Toast.makeText(getBaseContext(), "Log in Failed", Toast.LENGTH_LONG).show();
    }

    public void LoginSucces() {
        Intent n = new Intent(LoginActivity.this, TimelineActivity.class);
        startActivity(n);
    }

    public boolean cheaking() {
        String email = _Email.getText().toString();
        String password = _Password.getText().toString();
        if (email.equals("hello@me.com") && password.equals("IAMAWESOME"))
            return true;
        else
            return false;
    }


}
