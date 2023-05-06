package com.svalero.happdeporteandroid.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.svalero.happdeporteandroid.R;
import com.svalero.happdeporteandroid.contract.UserModifyContract;
import com.svalero.happdeporteandroid.presenter.MatchRegisterPresenter;
import com.svalero.happdeporteandroid.presenter.UserModifyPresenter;

public class UserModifyView extends AppCompatActivity implements UserModifyContract.View {

    private UserModifyPresenter presenter;
    long userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_modify_view);

        Intent intent = new Intent(getIntent());
        userId = getIntent().getLongExtra("userId", 0); //guardamos el id que nos traemos de la vista detalle

        /**
         * Para presentar el id del equipo en la view de registrar partidos, nos traemos el id por putExtra del Intent
         */
        Log.d("user Modify", "Ver si traigo el ID del usuario: " + userId);
        TextView tvTeamInMatch = findViewById(R.id.tv_user_modify_username);
        tvTeamInMatch.setText(String.valueOf(userId));

        presenter = new UserModifyPresenter(this);

    }

    @Override
    public void showError(String errorMessage) {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void resetForm() {

    }
}