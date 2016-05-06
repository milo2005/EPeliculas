package movil.epeliculas;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

import movil.epeliculas.adapters.PeliculaAdapter;
import movil.epeliculas.models.Pelicula;
import movil.epeliculas.util.C;

public class MainActivity extends AppCompatActivity implements DialogInterface.OnClickListener {

    PeliculaAdapter adapter;

    ListView list;

    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.list);

        C.data = new ArrayList<>();
        adapter= new PeliculaAdapter(this, C.data);

        list.setAdapter(adapter);
        loadPeliculas();

        registerForContextMenu(list);

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        adapter.notifyDataSetChanged();
    }

    //region Metodo LoadPeliculas
    public void loadPeliculas(){
        Pelicula p1 = new Pelicula();
        p1.setNombre("Civil War");
        p1.setFechaEstreno(new Date());
        p1.setCategoria("Accion");
        p1.setSinopsis("Guerra entre Capitan America y Ironman");
        p1.setImagen("http://www.24horas.cl/incoming/capturajpg-1855006/ALTERNATES/w620h350/Captura.JPG");

        Pelicula p2 = new Pelicula();
        p2.setNombre("Batman v Superman");
        p2.setFechaEstreno(new Date());
        p2.setCategoria("Accion");
        p2.setSinopsis("Guerra entre Batman y Superman");
        p2.setImagen("http://www.ew.com/sites/default/files/styles/tout_image_gallery_612/public/i/2016/03/02/batman-v-superman-dawn-of-justice-000220568.jpg?itok=fYKcugql");

        Pelicula p3 = new Pelicula();
        p3.setNombre("Conjuro 2");
        p3.setFechaEstreno(new Date());
        p3.setCategoria("Terror");
        p3.setSinopsis("Pelicula de terror inspirada en sucesos reales");
        p3.setImagen("http://www.el-nacional.com/escenas/nueva-entrega-pelicula-estrenara-junio_NACIMA20160109_0049_19.jpg");

        C.data.add(p1);
        C.data.add(p2);
        C.data.add(p3);

        adapter.notifyDataSetChanged();


    }
    //endregion

    //region Option Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_add:

                Intent intent = new Intent(this, AddActivity.class);
                startActivity(intent);

                break;
            case R.id.action_about: break;
            case R.id.action_help: break;
        }



        return super.onOptionsItemSelected(item);
    }
    //endregion


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_ctx, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)
                item.getMenuInfo();

        pos = info.position;

        switch(item.getItemId()){
            case R.id.action_edit: break;
            case R.id.action_delete:
                showDeleteAlert();
                break;
        }
        return super.onContextItemSelected(item);
    }

    private void showDeleteAlert(){
        AlertDialog alert = new AlertDialog.Builder(this)
                .setTitle("Eliminar")
                .setMessage("Desea eleminar la pelicula ?")
                .setPositiveButton("Aceptar",this)
                .setNegativeButton("Cancelar", this)
                .create();
        alert.show();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        if(which == DialogInterface.BUTTON_POSITIVE){
            C.data.remove(pos);
            adapter.notifyDataSetChanged();
        }
    }
}

