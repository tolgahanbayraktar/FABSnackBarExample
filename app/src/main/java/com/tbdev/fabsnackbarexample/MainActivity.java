package com.tbdev.fabsnackbarexample;

import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.rootLayout);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), "FAB", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Snackbar doğru çalışması için CordinatorLayout olması gerekiyor
     *
     * @param view layout içerisindeki root element oluyor
     */
    public void simpleSnackBar(View view) {

        Snackbar.make(coordinatorLayout, "Simple Snack Bar Örneği", Snackbar.LENGTH_SHORT).show();
        //Snackbar.make(view, "Simple Snack Bar Örneği", Snackbar.LENGTH_SHORT).show();
    }

    public void snackBarwithAction(View view) {
        Snackbar snackbar = Snackbar.make(view, "Hata Oluştu", Snackbar.LENGTH_SHORT);
        snackbar.setAction("TEKRAR DENE", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(coordinatorLayout, "Bu sefer oldu", Snackbar.LENGTH_SHORT).show();
            }
        });

        snackbar.show();
    }

    public void snackBarCustomize(View view) {
        Snackbar snackbar = Snackbar.make(view, "Kişisel Snack Bar Örneği", Snackbar.LENGTH_SHORT);
        snackbar.setAction("TEKRAR DENE", new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        //snackbar.setActionTextColor(Color.WHITE);

        View snackBarLayout = snackbar.getView();
        snackBarLayout.setBackgroundColor(Color.RED);

        TextView textView = snackBarLayout.findViewById(android.support.design.R.id.snackbar_text);
        TextView textViewAction = snackBarLayout.findViewById(android.support.design.R.id.snackbar_action);
        textView.setTextColor(Color.WHITE);
        textViewAction.setTextColor(Color.YELLOW);
        snackbar.show();

    }
}
