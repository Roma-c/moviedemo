package com.androidTest.movieDemo.ui.login;


import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.text.method.SingleLineTransformationMethod;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

import com.androidTest.movieDemo.R;
import com.androidTest.movieDemo.model.Results;
import com.androidTest.movieDemo.ui.MainActivity;
import com.androidTest.movieDemo.ui.ViewModelFactory;
import com.androidTest.movieDemo.ui.base.BaseFragment;
import com.androidTest.movieDemo.ui.movie.MovieFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends BaseFragment {

    ViewDataBinding binding;

    private List<Results.Movie> notesList = new ArrayList<>();


    @BindView(R.id.btn_login)
    AppCompatButton btnLogin;

    @BindView(R.id.pwd_toggle)
    ImageView pwdToggle;


    @BindView(R.id.edt_password)
    AppCompatEditText edtPassword;

    @BindView(R.id.edt_username)
    AppCompatEditText edtUsername;


    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @Inject
    ViewModelFactory vmFactory;

    LoginViewModel vm;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_login,container,false);
        View view = binding.getRoot();
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnLogin.setOnClickListener(v -> {

            if(edtUsername.getText().length() == 0)
            {
                Toast.makeText(getContext(), "Please enter email", Toast.LENGTH_SHORT).show();
            }
            else if(!isValidEmail(edtUsername.getText()))
            {
                Toast.makeText(getContext(), "Please enter valid email", Toast.LENGTH_SHORT).show();
            }
            else
            {
                ( (MainActivity)getActivity()).setFragment(new MovieFragment());
            }


        });


        pwdToggle.setOnClickListener(v -> {



            if (edtPassword.getTransformationMethod().getClass().getName()
                    .equals("android.text.method.PasswordTransformationMethod")
            ) {
                edtPassword.setTransformationMethod(SingleLineTransformationMethod.getInstance());
                pwdToggle.setImageResource(R.drawable.ic_baseline_visibility);
            } else {
                edtPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                pwdToggle.setImageResource(R.drawable.ic_baseline_visibility_off);
            }

            edtPassword.setSelection(edtPassword.getText().length());
        });


        edtUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if(isValidEmail(edtUsername.getText()) && (edtPassword.getText().length() > 8 && edtPassword.getText().length()<15))
                {
                    btnLogin.setBackgroundColor(getResources().getColor(R.color.text_blue));
                    btnLogin.setEnabled(true);
                }
                else
                {
                    btnLogin.setBackgroundColor(getResources().getColor(R.color.gray));
                    btnLogin.setEnabled(false);
                }

            }
        });

        edtPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(isValidEmail(edtUsername.getText()) && (edtPassword.getText().length() > 8 && edtPassword.getText().length()<15))
                {
                    btnLogin.setBackgroundColor(getResources().getColor(R.color.text_blue));
                    btnLogin.setEnabled(true);
                }
                else
                {
                    btnLogin.setBackgroundColor(getResources().getColor(R.color.gray));
                    btnLogin.setEnabled(false);
                }
            }
        });





    }



    private void showProgressBar(boolean isVisible) {
        if (isVisible)
            progressBar.setVisibility(View.VISIBLE);
        else
            progressBar.setVisibility(View.GONE);
    }



    /**
     *  email validation method
     */
    private boolean isValidEmail(CharSequence target) {
        Pattern emailPattern =  Patterns.EMAIL_ADDRESS;

        Pattern pattern = Pattern.compile(emailPattern.toString());
        Matcher matcher = pattern.matcher(target);

        return matcher.matches();
    }


}
