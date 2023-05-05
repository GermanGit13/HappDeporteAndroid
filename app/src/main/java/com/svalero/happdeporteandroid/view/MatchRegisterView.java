package com.svalero.happdeporteandroid.view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.mapbox.geojson.Point;
import com.mapbox.maps.MapView;
import com.mapbox.maps.plugin.annotation.AnnotationConfig;
import com.mapbox.maps.plugin.annotation.AnnotationPlugin;
import com.mapbox.maps.plugin.annotation.AnnotationPluginImplKt;
import com.mapbox.maps.plugin.annotation.generated.PointAnnotationManager;
import com.mapbox.maps.plugin.annotation.generated.PointAnnotationManagerKt;
import com.mapbox.maps.plugin.annotation.generated.PointAnnotationOptions;
import com.mapbox.maps.plugin.gestures.GesturesPlugin;
import com.mapbox.maps.plugin.gestures.GesturesUtils;
import com.svalero.happdeporteandroid.R;
import com.svalero.happdeporteandroid.contract.MatchRegisterContract;
import com.svalero.happdeporteandroid.domain.Match;
import com.svalero.happdeporteandroid.presenter.MatchRegisterPresenter;

public class MatchRegisterView extends AppCompatActivity implements MatchRegisterContract.View {

    private MapView matchMap; //Porque en el layout de registrar Match tenemos un mapa
    private Point point; //Guardamos el point para gestionar la latitu y longuitud
    private PointAnnotationManager pointAnnotationManager; //Para anotar el point así es común para todos
    private MatchRegisterPresenter presenter;
    private long teamId; //id del equipo

    @SuppressLint("WrongViewCast") //Para poder presentar el TextView del idteam
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_register_view);

        Intent intent = new Intent(getIntent());
        teamId = getIntent().getLongExtra("teamId", 0); //guardamos el id que nos traemos de la vista detalle

        /**
         * Para presentar el id del equipo en la view de registrar partidos, nos traemos el id por putExtra del Intent
         */
        Log.d("match Register", "Ver si traigo el ID del equipo: " + teamId);
        TextView tvTeamInMatch = findViewById(R.id.tv_teamIdInMatch);
        tvTeamInMatch.setText(String.valueOf(teamId));

        presenter = new MatchRegisterPresenter(this);
        matchMap = findViewById(R.id.matchMap); //le pasamos el mapa creado en el layout activity_match_register y lo metemos en el constrait de abajo

        GesturesPlugin gesturesPlugin = GesturesUtils.getGestures(matchMap);
        gesturesPlugin.addOnMapClickListener(point -> {
            removeAllMarkers();
            this.point = point;
//            addMarker(point);
            return true;
        });

        initializePointManager();
    }

    /**
     * Inicializamos el pointmanager
     */
    private void initializePointManager() {
        AnnotationPlugin annotationPlugin = AnnotationPluginImplKt.getAnnotations(matchMap);
        AnnotationConfig annotationConfig = new AnnotationConfig();
        pointAnnotationManager = PointAnnotationManagerKt.createPointAnnotationManager(annotationPlugin, annotationConfig);
    }

    /**
     * Para poder crear un marker y que lo pinte por cada partido
     */
    private void addMarker(Point point) {
        PointAnnotationOptions pointAnnotationOptions = new PointAnnotationOptions()
                .withPoint(point)
                .withIconImage(BitmapFactory.decodeResource(getResources(), R.mipmap.red_marker));
        pointAnnotationManager.create(pointAnnotationOptions);
    }

    private void removeAllMarkers() {
        pointAnnotationManager.deleteAll();
    }

    public void saveButtonMatch(View view) {
//        TextView tvTeamInMatch = findViewById(R.id.tv_teamIdInMatch);
        EditText etTeamB = findViewById(R.id.et_teamB);
        EditText etMarkerA = findViewById(R.id.et_markerA);
        EditText etMarkerB = findViewById(R.id.et_markerB);
        EditText etAnalysis = findViewById(R.id.et_analysis);
        EditText etDateMatch = findViewById(R.id.et_dateMatch);
        EditText etHourMatch = findViewById(R.id.et_hourMatch);

//        long idTeam = teamId;
        String teamB = etTeamB.getText().toString();
        int markerA = Integer.parseInt(etMarkerA.getText().toString());
        int markerB = Integer.parseInt(etMarkerB.getText().toString());
        String analisys = etAnalysis.getText().toString();
        String dateMatch = etDateMatch.getText().toString();
        String hourMatch = etHourMatch.getText().toString();


        /**
         * Validaciones de los campos
         */
//        if (markerA <= 0) {
//            Toast.makeText(this, R.string.add_result_markerA, Toast.LENGTH_LONG).show();
//            return;
//        }
//        if (markerB <= 0) {
//            Toast.makeText(this, R.string.add_result_markerA, Toast.LENGTH_LONG).show();
//            return;
//        }
//        if (dateMatch == null) {
//            Toast.makeText(this, R.string.add_date, Toast.LENGTH_LONG).show();
//            return;
//        }
//        if (hourMatch == null) {
//            Toast.makeText(this, R.string.add_date, Toast.LENGTH_LONG).show();
//            return;
//        }
        if (point == null) {
            Toast.makeText(this, R.string.select_location_message, Toast.LENGTH_LONG).show();
            return;
        }

        Match match = new Match(teamB, markerA, markerB, analisys, point.latitude(), point.longitude(), dateMatch, hourMatch);
        presenter.registerMatch(teamId, match);
    }

    public void goBackButton(View view) {
        onBackPressed();
    }

    @Override
    public void showError(String errorMessage) {
        Snackbar.make(((EditText) findViewById(R.id.et_teamB)), errorMessage,
                BaseTransientBottomBar.LENGTH_LONG).show();
    }

    @Override
    public void showMessage(String message) {
        Snackbar.make(((EditText) findViewById(R.id.et_teamB)), message,
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