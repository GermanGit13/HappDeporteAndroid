package com.svalero.happdeporteandroid.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.svalero.happdeporteandroid.R;

/**
 * Extiende de AppCompatActivity: donde hay un motón de código para usar por esos sobreescribimos los métodos de esta clase
 * implements AdapterView.OnItemClickListener Implementa el metodo onItemClick que le dice que cuando hagamos click en un elemento de la lista se habra en otra activity
 * Implementamos el contract en este caso como es un página con botones que nos llevan a otras activities no hace falta
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Declaramos la parte gráfica de la activity uy le asociamos el id del recurso
     */

    Button listTeam;
    Button addTeam;
    Button listUsers;
    Button addUser;
    Button listMatches;
    Button addMatch; //Po si decido crearlo desde la ventana inicial y no desde el listado de equipos


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }




    /**
     * PAra crear el menu (el actionBar)
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
        if (item.getItemId() == R.id.go_preferences) { //Evaluar a que opcion hemos pichado
            Intent intent = new Intent(this, MainActivity.class); //donde nos manda al pinchar sobre el boton + en el action bar
            startActivity(intent);
            return true;
        }
//        else if (item.getItemId() == R.id.view_map) { //Para cuando pulsan en la boton del mapa en el actionbar
//            Intent intent = new Intent(this, MainActivity.class); //donde nos manda al pinchar sobre el boton mapas en el action bar
//            startActivity(intent);
//            return true;
//        }
        return false;
    }
}