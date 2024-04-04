package com.principal.tfghabitos;

import android.content.Intent;
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
    private ImageButton btnToday, btnAdd, btnStatistics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendarView = findViewById(R.id.calendarView);
        spinnerFilter = findViewById(R.id.spinnerFilter);
        habitsRecyclerView = findViewById(R.id.habitsRecyclerView);

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

        // Aquí debes implementar la lógica para cargar los hábitos en el RecyclerView
        // según el filtro seleccionado y la fecha del calendario.
    }
}
