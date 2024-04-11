package com.principal.tfghabitos;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.ImageButton;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private CalendarView calendarView;
    private Spinner spinnerFilter;
    private RecyclerView habitsRecyclerView;
    private ImageButton btnToday, btnAdd, btnStatistics, btnSettings, btnDarknight;
    private View rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendarView = findViewById(R.id.calendarView);
        spinnerFilter = findViewById(R.id.spinnerFilter);
        habitsRecyclerView = findViewById(R.id.habitsRecyclerView);
        btnSettings = findViewById(R.id.btnSettings);
        btnDarknight = findViewById(R.id.btnDarknight);

        // Referencias a los botones de la barra inferior
        btnToday = findViewById(R.id.btnToday);
        btnAdd = findViewById(R.id.btnAdd);
        btnStatistics = findViewById(R.id.btnStatistics);

        // Agregar escuchadores de clic para los botones
        btnToday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para ir al día actual
                // Puedes implementar la lógica para que el calendario se muestre en el día actual
                calendarView.setDate(System.currentTimeMillis(), true, true);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para abrir la actividad de añadir hábito
                // Puedes iniciar una nueva actividad aquí usando un Intent
                Intent intent = new Intent(MainActivity.this, AddHabitActivity.class);
                startActivity(intent);
            }
        });

        btnStatistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para abrir la actividad de estadísticas
                // Puedes iniciar una nueva actividad aquí usando un Intent
                Intent intent = new Intent(MainActivity.this, StatisticsActivity.class);
                startActivity(intent);
            }
        });

        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abrir la nueva pantalla (Activity de configuración)
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

        // Establecer el clic del botón
        btnDarknight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Llamar al método para cambiar el color de fondo
                changeBackgroundColor();
            }
        });

        // Aquí debes implementar la lógica para cargar los hábitos en el RecyclerView
        // según el filtro seleccionado y la fecha del calendario.
    }

    private void changeBackgroundColor() {
        // Cambiar el color de fondo de la vista raíz
        rootView.setBackgroundColor(Color.parseColor("#2c3e50")); // Puedes cambiar el color a tu preferencia
    }
}
