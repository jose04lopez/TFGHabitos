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
    private boolean isDarkMode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendarView = findViewById(R.id.calendarView);
        calendarView.setWeekDayTextAppearance(R.style.CalenderViewWeekCustomText);
        
        spinnerFilter = findViewById(R.id.spinnerFilter);
        habitsRecyclerView = findViewById(R.id.habitsRecyclerView);
        btnSettings = findViewById(R.id.btnSettings);
        btnDarknight = findViewById(R.id.btnDarknight);

        rootView = findViewById(android.R.id.content);

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

        btnDarknight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Llamar al método para cambiar el color de fondo
                toggleDarkMode();
            }
        });

    }




    private void toggleDarkMode() {
        isDarkMode = !isDarkMode;
        if (isDarkMode) {
            setDarkModeColors();
        } else {
            restoreOriginalColors();
        }
    }

    private void setDarkModeColors() {
        // Cambiar los colores a modo oscuro
        rootView.setBackgroundColor(Color.parseColor("#333333")); // Cambia el color de fondo a tu preferencia
        // Puedes cambiar los colores de otros elementos de la interfaz aquí
        calendarView.setWeekDayTextAppearance(R.style.CalenderViewCustomPrueba);
        calendarView.invalidate();
    }

    private void restoreOriginalColors() {
        // Restaurar los colores originales
        rootView.setBackgroundColor(Color.WHITE); // Cambia el color de fondo a tu preferencia
        // Puedes restaurar los colores de otros elementos de la interfaz aquí
    }
}
