package com.example.androidhormwork;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvTask;
    private TaskAdapter adapter;
    private FloatingActionButton btnOpenAddTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnOpenAddTask = findViewById(R.id.btn_add_task);
        btnOpenAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddTaskActivity.class);
                startActivityForResult(intent, 100);
            }
        });

        rvTask = findViewById(R.id.rv_task);
        rvTask.setLayoutManager(new LinearLayoutManager(this));
        adapter = new TaskAdapter(this,MainActivity.this);
        rvTask.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK) {
            if (data != null) {
                Toast.makeText(MainActivity.this, data.getStringExtra("title"), Toast.LENGTH_SHORT).show();
                TaskModel model = new TaskModel(data.getStringExtra("title"), data.getStringExtra("description"), data.getStringExtra("date"));
                adapter.addData(model);
            }
        }
    }
}