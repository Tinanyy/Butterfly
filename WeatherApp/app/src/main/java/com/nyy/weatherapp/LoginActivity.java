package com.nyy.weatherapp;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.avos.avoscloud.AVAnalytics;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.LogInCallback;


public class LoginActivity extends BaseActivity {

    private TextView txtRegister;
    private AutoCompleteTextView etLogin;
    private EditText etPassword;
    private CheckBox cbTick;
    private TextView ftPassword;
    private Button loginBtn;
    private View mLogin;
    private View mProgress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if(AVUser.getCurrentUser()!=null){
            startActivity(new Intent(LoginActivity.this,MainActivity.class));
            LoginActivity.this.finish();

        }

       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
      //  getSupportActionBar().setTitle("登陆");
        etLogin=(AutoCompleteTextView)findViewById(R.id.et_login);

        etPassword=(EditText)findViewById(R.id.et_password);
        etPassword.setOnEditorActionListener(new TextView.OnEditorActionListener(){
            @Override
            public boolean onEditorAction(TextView textView,int id,KeyEvent keyEvent) {

                if (id == R.id.et_login || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });


        loginBtn=(Button)findViewById(R.id.bt_login) ;
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptLogin();
            }
        });

        txtRegister = (TextView) findViewById(R.id.txt_register);
        txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
                LoginActivity.this.finish();
            }
        });

        mLogin =findViewById(R.id.login_form);
        mProgress=findViewById(R.id.login_progress);

    }

    private void attemptLogin(){
        etLogin.setError(null);
        etPassword.setError(null);

        final String username=etLogin.getText().toString();
        final String password=etPassword.getText().toString();

        boolean cancel=false;
        View focusView =null;

        if(!TextUtils.isEmpty(password)&&!isPasswordValid(password)){
            etPassword.setError("密码大于6位");
            focusView=etPassword;
            cancel=true;
        }

        if(TextUtils.isEmpty(username)){
            etLogin.setError("请输入用户名");
            focusView=etLogin;
            cancel=true;

        }

        if(cancel){
            focusView.requestFocus();
        }else{
            showProgress(true);
            AVUser.logInInBackground(username, password, new LogInCallback<AVUser>() {
                @Override
                public void done(AVUser avUser, AVException e) {
                    if(e ==null){
                        LoginActivity.this.finish();
                        startActivity(new Intent(LoginActivity.this,MainActivity.class));
                    }else{
                        showProgress(false);
                        Toast.makeText(LoginActivity.this, e.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                }

            });
        }
    }

    private boolean isPasswordValid(String password){

         return password.length()>6;
    }

    /*
    *
    * shows the progress UI and hides the login form.
    * */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show){
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.

        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mLogin.setVisibility(show ? View.GONE : View.VISIBLE);
            mLogin.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mLogin.setVisibility(show ? View.GONE : View.VISIBLE);
                }

            });

            mProgress.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgress.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgress.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        }else{
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgress.setVisibility(show?View.VISIBLE:View.GONE);
            mLogin.setVisibility(show?View.GONE:View.VISIBLE);

            }

        }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==android.R.id.home){
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause(){
        super.onPause();
        AVAnalytics.onPause(this);
    }

    @Override
    protected void onResume(){
        super.onResume();
        AVAnalytics.onResume(this);

    }

}
