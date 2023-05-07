package com.svalero.happdeporteandroid.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;


import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.svalero.happdeporteandroid.R;
import com.svalero.happdeporteandroid.contract.UserModifyContract;
import com.svalero.happdeporteandroid.domain.User;
import com.svalero.happdeporteandroid.presenter.TeamRegisterPresenter;
import com.svalero.happdeporteandroid.presenter.UserModifyPresenter;

public class UserModifyView extends AppCompatActivity implements UserModifyContract.View {

    long userId;
    private User user;
    private Bundle bundle; //creamos un bundle para crecoger el objeta extra enviado que esta serializable
    private UserModifyPresenter presenter;
    private Snackbar snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_modify_view);

//        presenter = new UserModifyContract.Presenter(user, user, this);
        /**
         * Recuperamos el objeto selecciona en el adapterUSer
         */
        bundle = getIntent().getExtras();
        user = (User) bundle.getSerializable("user");
        userId = user.getId();

        Log.d("user Modify", "Ver si traigo el ID del usuario: " + user.getId());

        fillData(this.user);

        presenter = new UserModifyPresenter(this);
    }

    public void modifyUserCancel(View view) {
        onBackPressed();
    }

    public void modifyButtonUser(View view) {
        TextView tvUserId = findViewById(R.id.tv_user_modify_id);
        EditText etUsername = findViewById(R.id.et_user_modify_username);
        EditText etPass = findViewById(R.id.et_user_modify_pass);
        EditText etRol = findViewById(R.id.et_user_modify_rol);
        CheckBox cbCoach = (CheckBox) findViewById(R.id.cb_user_modify_coach_boolean);
        EditText etName = findViewById(R.id.et_user_modify_name);
        EditText etSurname = findViewById(R.id.et_user_modify_surname);
        EditText etAddress = findViewById(R.id.et_user_modify_address);
        EditText etMail = findViewById(R.id.et_user_modify_mail);
        EditText etPhone = findViewById(R.id.et_user_modify_phone);

        String username = etUsername.getText().toString();
        String pass = etPass.getText().toString();
        String rol = etRol.getText().toString();
        Boolean coach = cbCoach.isChecked();
        String name = etName.getText().toString();
        String surname = etSurname.getText().toString();
        String address = etAddress.getText().toString();
        String mail = etMail.getText().toString();
        String phone = etPhone.getText().toString();

        /**
         * Validaciones de los campos
         */
//        if (markerA <= 0) {
//            Toast.makeText(this, R.string.add_result_markerA, Toast.LENGTH_LONG).show();
//            return;
//        }

        User userNew = new User(username, pass, rol, coach, name, surname, address, mail, phone);
        presenter.modifyUser(userId, userNew);
    }

    @Override
    public void showError(String errorMessage) {
        Snackbar.make(((EditText) findViewById(R.id.et_user_modify_username)), errorMessage,
                BaseTransientBottomBar.LENGTH_LONG).show();
    }

    @Override
    public void showMessage(String message) {
        snackbar.make(((EditText) findViewById(R.id.et_user_modify_username)), message,BaseTransientBottomBar.LENGTH_SHORT)
                .setAction("Volver", new View.OnClickListener() { //Crea un boton en el snackbar
                    @Override
                    public void onClick(View v) {
                        onBackPressed(); //Volver al listado general
                    }
                })
                .show();
        }

    private void fillData(User user) {
        TextView tvUserId = findViewById(R.id.tv_user_modify_id);
        EditText etUsername = findViewById(R.id.et_user_modify_username);
        EditText etPass = findViewById(R.id.et_user_modify_pass);
        EditText etRol = findViewById(R.id.et_user_modify_rol);
        CheckBox cbCoach = (CheckBox) findViewById(R.id.cb_user_modify_coach_boolean);
        EditText etName = findViewById(R.id.et_user_modify_name);
        EditText etSurname = findViewById(R.id.et_user_modify_surname);
        EditText etAddress = findViewById(R.id.et_user_modify_address);
        EditText etMail = findViewById(R.id.et_user_modify_mail);
        EditText etPhone = findViewById(R.id.et_user_modify_phone);

        tvUserId.setText(String.valueOf(user.getId()));
        etUsername.setText(user.getUsername());
        etPass.setText(user.getPass());
        etRol.setText(user.getRol());
        cbCoach.setChecked(user.isCoach());
        etName.setText(user.getName());
        etSurname.setText(user.getSurname());
        etAddress.setText(user.getAddress());
        etMail.setText(user.getMail());
        etPhone.setText(user.getPhone());
    }
}