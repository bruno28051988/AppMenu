package com.br.menu;

import android.os.Bundle;
import android.view.View;
import android.view.Menu;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Floating Action Button (cartinha)
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Você clicou no Fab", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //Trecho por montar o Drawer
        //Cria a referências para toda a área do NavigationDrawer
        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        //Cria a referência para a navegação a navegação
        NavigationView navigationView = findViewById(R.id.nav_view);


        // Define as configurações do Drawer
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow, R.id.nav_contato, R.id.nav_share, R.id.nav_about)
                .setDrawerLayout(drawer)
                .build();

        // Configura a área que irá carregar os fragmentos
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        //Apresenta o botão no menu da tela
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);

        // Trecho responsável por fazer a navegação do NVD funcionar
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    //Caso eu queira apagar o menu de 3 pontinhos basta apagar o trecho abaixo...
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    //até aqui...

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}