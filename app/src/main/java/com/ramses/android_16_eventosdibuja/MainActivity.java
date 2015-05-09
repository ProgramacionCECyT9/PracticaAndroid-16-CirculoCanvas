package com.ramses.android_16_eventosdibuja;

/*
Autor: RAMSÉS MARTÍNEZ ORTIZ (C) Mayo 2015
VERSIÓN: 1.0

Descripción: Programa de la práctica número 16 "Eventos".
    Solución al problema: "Modificar la práctica 15 para que dibuje círculos al dibujar sobre la pantalla"

Observaciones: --.

Compilación: se compila en tiempo de ejecucion.

Ejecución: se ejecuta desde el IDE de Android Studio con las teclas shift + F10.  (En Windows)
*/

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        SpecialView miVista = new SpecialView(this);
        setContentView(miVista);
    }

    class SpecialView extends View {

        float x = 100;
        float y = 100;
        String accion = "Accion";
        String texto = "Evento";
        Path path = new Path();

        public SpecialView(Context context) {
            super(context);
        }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.WHITE);//Se crea el lienzo
        Paint paint = new Paint();//Crea el pincel

        paint.setColor(Color.GREEN);//Color del pincel
        //paint.setStyle(Paint.Style.FILL);//Pincel con relleno
        paint.setStyle(Paint.Style.STROKE);//Pincel sólo con conterno


        if (accion == "down") {
            path.addCircle(x, y, 20, Path.Direction.CW);//Estilo del circulo al presionarse
        }
        if (accion == "move") {
            path.addCircle(x, y, 20, Path.Direction.CW);//Estilo del circulo al presionarse
        }

        canvas.drawPath(path, paint);

        paint.setColor(Color.BLACK);
        paint.setTextSize(24);
        paint.setStrokeWidth(15);
        paint.setStyle(Paint.Style.FILL);
        //Agrega los textos al lienzo
        canvas.drawText("Evento: "+texto, 100, 150, paint);
        canvas.drawText("x = " + x + "   y = " + y, 100, 75, paint);
    }


    @Override
    public boolean onTouchEvent(MotionEvent evento) {
        //Al presionar la pantalla
        x = evento.getX();
        y = evento.getY();

        //Modifica variables dependiendo de la accion que suceda
        if (evento.getAction() == MotionEvent.ACTION_DOWN) {
            accion = "down";
            texto = "Action Down";
        }

        if (evento.getAction() == MotionEvent.ACTION_UP) {
            accion = "up";
            texto = "Action Up";
        }

        if (evento.getAction() == MotionEvent.ACTION_MOVE) {
            accion = "move";
            texto = "Action Move";
        }
        invalidate();
        return true;
    }
}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
