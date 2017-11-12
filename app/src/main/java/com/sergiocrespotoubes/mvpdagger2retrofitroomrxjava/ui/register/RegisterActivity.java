package com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.ui.register;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.MyApplication;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity implements RegisterContract.View {

    // Injects

    @Inject
    RegisterContract.Presenter presenter;

    // Views
    @BindView(R.id.et_name)
    EditText et_name;

    @BindView(R.id.til_name)
    TextInputLayout til_name;

    @BindView(R.id.et_password)
    EditText et_password;

    @BindView(R.id.til_password)
    TextInputLayout til_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        RegisterComponent registerComponent = MyApplication.appComponent.registerComponent().build();
        registerComponent.inject(this);

        presenter.setView(this);
        loadViews();
    }

    private void loadViews() {
        et_name.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean focused) {
                if (!focused) {
                    presenter.onNameFocusLost();
                }
            }
        });

        et_password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean focused) {
                if (!focused) {
                    presenter.onPasswordFocusLost();
                }
            }
        });
    }

    @Override
    public String getName() {
        return et_name.getText().toString();
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public void showEmptyNameError() {
        til_name.setError("You need to enter a name");
    }

    @Override
    public void hideEmptyNameError() {
        til_name.setError("");
    }

    @Override
    public void showEmptyPasswordError() {
        til_password.setError("You need to enter a password");
    }

    @Override
    public void hideEmptyPasswordError() {
        til_password.setError("");
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.bt_continue)
    public void onContinueClick() {
        presenter.onContinueClick();
    }

}