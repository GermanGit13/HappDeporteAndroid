package com.svalero.happdeporteandroid.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.svalero.happdeporteandroid.R;
import com.svalero.happdeporteandroid.contract.TeamModifyContract;
import com.svalero.happdeporteandroid.domain.Team;
import com.svalero.happdeporteandroid.domain.User;
import com.svalero.happdeporteandroid.presenter.TeamModifyPresenter;
import com.svalero.happdeporteandroid.presenter.UserModifyPresenter;

public class TeamModifyView extends AppCompatActivity implements TeamModifyContract.View {

    private Team team;
    long teamId;
    long userId;
    private Bundle bundle; //creamos un bundle para crecoger el objeta extra enviado que esta serializable
    private TeamModifyPresenter presenter;
    private Snackbar snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_modify_view);

        noticeId(); //Para avisar que necesita el id

        /**
         * Recuperamos el objeto selecciona en el adapterUSer
         */
        bundle = getIntent().getExtras();
        team = (Team) bundle.getSerializable("team");
//        userId = team.getUser().getId();
        teamId = team.getId();

        Log.d("Team Modify", "Ver si traigo el ID del equipo: " + team.getId());

        fillData(team);

        presenter = new TeamModifyPresenter(this);
    }

    public void modifyTeamCancel(View view) {
        onBackPressed();
    }

    public void modifyButtonTeam(View view) {
//        TextView tvUserId = findViewById(R.id.tv_user_modify_id);
        EditText etUserInTeam = findViewById(R.id.et_modify_userIdInTeam);
        EditText etCategory = findViewById(R.id.et_modify_team_Category);
        EditText etCompetition = findViewById(R.id.et_modify_team_Competition);
        EditText etDayTrain = findViewById(R.id.et_modify_team_DayTrain);
        EditText etStartTrain = findViewById(R.id.et_modify_team_StartTrain);
        EditText etEndTrain = findViewById(R.id.et_modify_team_EndTrain);
        CheckBox cbActive = (CheckBox) findViewById(R.id.cb_modify_team_Active);

        long userInTeam = Long.parseLong(etUserInTeam.getText().toString());
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

        Team teamNew = new Team(category, competition, dayTrain, startTrain, endTrain, active);
        presenter.modifyTeam(teamId, userInTeam, teamNew);
    }




    private void fillData(Team team) {
//        EditText etUserId = findViewById(R.id.et_modify_userIdInTeam);
        EditText etCategory = findViewById(R.id.et_modify_team_Category);
        EditText etCompetition = findViewById(R.id.et_modify_team_Competition);
        //cuota va por constante en la API
        EditText etDayTrain = findViewById(R.id.et_modify_team_DayTrain);
        EditText etStartTrain = findViewById(R.id.et_modify_team_StartTrain);
        EditText etEndTrain = findViewById(R.id.et_modify_team_EndTrain);
        CheckBox cbActive = (CheckBox) findViewById(R.id.cb_modify_team_Active);

//        etUserId.setText(String.valueOf(team.getUser().getId()));
        etCategory.setText(team.getCategory());
        etCompetition.setText(team.getCompetition());
        etDayTrain.setText(team.getDayTrain());
        etStartTrain.setText(team.getStartTrain());
        etEndTrain.setText(team.getEndTrain());
        cbActive.setChecked(team.isActive());
    }

    private void noticeId() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.modify_coach);
        builder.setMessage(R.string.title_modify);
        builder.setPositiveButton(R.string.accept, null);
        AlertDialog dialog = builder.create();
        dialog.show();
//            .setNegativeButton(R.string.not, (dialog, id) -> dialog.dismiss()); //Botones del dialogo que salta
//            Intent intent = new Intent(this, InspectorAllActivity.class); //Lo devuelvo al details del inspector
//            this.startActivity(intent); //lanzamos el intent que nos lleva al layout correspondiente
//            AlertDialog dialog = builder.create();
//            dialog.show();//Importante para que se muestre
    }

    @Override
    public void showError(String errorMessage) {
        Snackbar.make(((EditText) findViewById(R.id.et_modify_team_Category)), errorMessage,
                BaseTransientBottomBar.LENGTH_LONG).show();
    }

    @Override
    public void showMessage(String message) {
        snackbar.make(((EditText) findViewById(R.id.et_modify_team_Category)), message,BaseTransientBottomBar.LENGTH_SHORT)
                .setAction("Volver", new View.OnClickListener() { //Crea un boton en el snackbar
                    @Override
                    public void onClick(View v) {
                        onBackPressed(); //Volver al listado general
                    }
                })
                .show();
    }
}