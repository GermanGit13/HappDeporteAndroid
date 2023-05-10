package com.svalero.happdeporteandroid.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.mapbox.geojson.Point;
import com.mapbox.maps.CameraOptions;
import com.mapbox.maps.MapView;
import com.mapbox.maps.plugin.annotation.AnnotationConfig;
import com.mapbox.maps.plugin.annotation.AnnotationPlugin;
import com.mapbox.maps.plugin.annotation.AnnotationPluginImplKt;
import com.mapbox.maps.plugin.annotation.generated.PointAnnotationManager;
import com.mapbox.maps.plugin.annotation.generated.PointAnnotationManagerKt;
import com.mapbox.maps.plugin.annotation.generated.PointAnnotationOptions;
import com.svalero.happdeporteandroid.R;
import com.svalero.happdeporteandroid.contract.MatchListContract;
import com.svalero.happdeporteandroid.domain.Match;
import com.svalero.happdeporteandroid.presenter.MatchListPresenter;

import java.util.List;


/**
 * Implementamos el MatchListContract.View
 * Implementamos el interfacae Callback<DirectionsResponse> para hacer la llamada a la API de Mapbox y pasarle los puntos a calcular ruta
 */
public class MapsActivity extends AppCompatActivity  implements MatchListContract.View {
//        Callback<DirectionsResponse> {

    private MapView mapView; //Mapa declarado en el layout
    private PointAnnotationManager pointAnnotationManager; //Para obtener un Point para la latitude y longitude
    private MatchListPresenter matchListPresenter; //Para llamar al presenter y solicitarle los partidos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        mapView = findViewById(R.id.mapView); //cargamos el mapa
        initializePointManager(); // inicializamos el pointmanager

        //TODO Me devuelve un null pointer al intentar pintar todos los partidos
        matchListPresenter = new MatchListPresenter(this); //instanciamos el presenter y le pasamos la vista
        matchListPresenter.loadAllMatches(); //recogemos las tareas del presenter que habla con el model
    }

    /**
     * Inicializamos el pointmanager
     */
    private void initializePointManager() {
        AnnotationPlugin annotationPlugin = AnnotationPluginImplKt.getAnnotations(mapView);
        AnnotationConfig annotationConfig = new AnnotationConfig();
        pointAnnotationManager = PointAnnotationManagerKt.createPointAnnotationManager(annotationPlugin, annotationConfig);
    }

    /**
     * Para poder crear un marker y que lo pinte por cada puente
     * @param point Pasamos el point
     * @param title el nombre del puente
     */
    private void addMarker(Point point, String title) {
        PointAnnotationOptions pointAnnotationOptions = new PointAnnotationOptions()
                .withPoint(point)
                .withTextField(title) //asi aparece el nombre en el mapa
                .withIconImage(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_banner_foreground));
        pointAnnotationManager.create(pointAnnotationOptions);
    }

    /**
     * Fija la camara del mapa donde nosotros queramos, asi el mapa arranca desde ese punto
     * @param point
     */
    private void setCameraPosition(Point point) {
        CameraOptions cameraPosition = new CameraOptions.Builder()
                .center(point)
                .pitch(0.0)
                .zoom(13.5)
                .bearing(-17.6)
                .build();
        mapView.getMapboxMap().setCamera(cameraPosition);
    }

    private void addMatchesToMap(List<Match> matches) {
        for (Match match : matches) {
            Point point = Point.fromLngLat(match.getLongitude(), match.getLatitude());
            addMarker(point, match.getTeamB());

            //Ojo se ha quitado la parte de recuperar el foco en la última tarea creada
            Match lastMatch = matches.get(matches.size() - 1); // recogemos el ultimo partido
            setCameraPosition(Point.fromLngLat(lastMatch.getLongitude(), lastMatch.getLatitude())); //Fijamos la camara del mapa en el ultimo puente
        }
    }

    /**
     * Metodo opbtenido desde el contract.view para traer del model los partidos a pintar
     */
    @Override
    public void showMatches(List<Match> matches) {
        addMatchesToMap(matches); //añadimos las tareas al mapa con el nuevo sistema que nos trae el presenter
    }

    /**
     * Mensaje que recibimos del contract.view
     */
    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

//    @Override
//    public void onResponse(Call<DirectionsResponse> call, Response<DirectionsResponse> response) {
//
//    }
//
//    @Override
//   public void onFailure(Call<DirectionsResponse> call, Throwable t) {
//
//    }

    /**
     * Para crear el menu (el actionBar)
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar, menu); //Inflamos el menu
        return true;
    }

    /**
     * Para cuando elegimos una opcion del menu
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //TODO cambiar el botón de las preferencias y Mapas para llevarlo a su activity
        if (item.getItemId() == R.id.go_home) { //Evaluar a que opcion hemos pichado
            Intent intent = new Intent(this, MainActivity.class); //donde nos manda al pinchar sobre el boton + en el action bar
            startActivity(intent);
            return true;
        }
        else if (item.getItemId() == R.id.view_map) { //Para cuando pulsan en la boton del mapa en el actionbar
            Intent intent = new Intent(this, MapsActivity.class); //donde nos manda al pinchar sobre el boton mapas en el action bar
            startActivity(intent);
            return true;
        }  else if (item.getItemId() == R.id.go_fav) { //Para cuando pulsan en la boton del mapa en el actionbar
            Intent intent = new Intent(this, FavTeamListView.class); //donde nos manda al pinchar sobre el boton mapas en el action bar
            startActivity(intent);
            return true;
        }
        return false;
    }
}