package com.svalero.happdeporteandroid.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.mapbox.geojson.Point;
import com.mapbox.maps.MapView;
import com.mapbox.maps.plugin.annotation.generated.PointAnnotationManager;
import com.svalero.happdeporteandroid.R;
import com.svalero.happdeporteandroid.contract.TeamRegisterContract;
import com.svalero.happdeporteandroid.domain.Match;
import com.svalero.happdeporteandroid.domain.Team;
import com.svalero.happdeporteandroid.presenter.MatchRegisterPresenter;
import com.svalero.happdeporteandroid.presenter.TeamRegisterPresenter;

import retrofit2.http.Body;

public class TeamRegisterView extends AppCompatActivity implements TeamRegisterContract.View {

    private TeamRegisterPresenter presenter;
    private long userId; //id del equipo
    private String nameTeam; //Equipo pasado por intent.putExtra

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_register_view);

        Intent intent = new Intent(getIntent());
        userId = getIntent().getLongExtra("userId", 0); //guardamos el id que nos traemos de la vista detalle
        nameTeam = getIntent().getStringExtra("name"); //guardamos el id que nos traemos de la vista detalle

        /**
         * Para presentar el id del usuario en la view de registrar equipos, nos traemos el id por putExtra del Intent
         */
        Log.d("user Register", "Ver si traigo el ID del usuario: " + userId + "-" + nameTeam);
        TextView tvUserInTeam = findViewById(R.id.tv_userIdInTeam);
        tvUserInTeam.setText(String.valueOf(nameTeam));

        presenter = new TeamRegisterPresenter(this);
    }

    public void saveButtonTeam(View view) {
//        TextView tvTeamInMatch = findViewById(R.id.tv_teamIdInMatch);
        EditText etCategory = findViewById(R.id.et_team_addCategory);
        EditText etCompetition = findViewById(R.id.et_team_addCompetition);

        EditText etDayTrain = findViewById(R.id.et_team_addDayTrain);
        EditText etStartTrain = findViewById(R.id.et_team_addStartTrain);
        EditText etEndTrain = findViewById(R.id.et_team_addEndTrain);
        CheckBox cbActive = (CheckBox) findViewById(R.id.cb_team_addActive);

        String category = etCategory.getText().toString();
        String competition = etCompetition.getText().toString();
        String dayTrain = etDayTrain.getText().toString();
        String startTrain = etStartTrain.getText().toString();
        String endTrain = etEndTrain.getText().toString();
        Boolean active = cbActive.isChecked();

        /**
         * Validaciones de los campos
         */
//        if (markerA <= 0) {
//            Toast.makeText(this, R.string.add_result_markerA, Toast.LENGTH_LONG).show();
//            return;
//        }


        Team team = new Team(category, competition, dayTrain, startTrain, endTrain, active);
        presenter.registerTeam(userId, team);
    }

    public void goBackButton(View view) {
        onBackPressed();
    }

    @Override
    public void showError(String errorMessage) {
        Snackbar.make(((EditText) findViewById(R.id.et_team_addCategory)), errorMessage,
                BaseTransientBottomBar.LENGTH_LONG).show();
    }

    @Override
    public void showMessage(String message) {
        Snackbar.make(((EditText) findViewById(R.id.et_team_addCategory)), message,
                BaseTransientBottomBar.LENGTH_LONG).show();
    }

    @Override
    public void resetForm() {
        ((TextView) findViewById(R.id.tv_teamIdInMatch)).setText("");
        ((EditText) findViewById(R.id.et_teamB)).setText("");
        ((EditText) findViewById(R.id.et_markerA)).setText("");
        ((EditText) findViewById(R.id.et_markerB)).setText("");
        ((EditText) findViewById(R.id.et_analysis)).setText("");
        ((EditText) findViewById(R.id.et_dateMatch)).setText("");
        ((EditText) findViewById(R.id.et_hourMatch)).setText("");

        ((EditText) findViewById(R.id.et_teamB)).requestFocus();
    }
}