package com.lynx.javaemptyproject;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private final ArrayList<TestProject> mTestProjects = new ArrayList<TestProject>() {{
        add(new TestProject("Lynx设置页面", SwitchActivity.class));
        add(new TestProject("Lynx官方Demo", DebugActivity.class));
        add(new TestProject("本地调试Lynx", DebugActivity.class));
        add(new TestProject("自定义LynxDemo", DebugActivity.class));
        add(new TestProject("自定义ReactLynxDemo", DebugActivity.class));
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list);
        init();
    }

    private void init() {
        ListView listView = findViewById(R.id.list_view);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(this, mTestProjects.get(position).clazz);
            if (position == 1) {
                intent.putExtra("url", "main.lynx.bundle");
            } else if (position == 2) {
                intent.putExtra("url", "main.lynx.bundle");
            } else if (position == 3) {
                intent.putExtra("url", "main.lynx.bundle");
            }
            startActivity(intent);
        });

        List<String> projectNames = new ArrayList<>();
        for (TestProject project : mTestProjects) {
            projectNames.add(project.name);
        }

        ArrayAdapter<String> arrayAdapter =
            new ArrayAdapter<>(this, R.layout.item_demo_app, R.id.tv_title, projectNames);
        listView.setAdapter(arrayAdapter);
    }

    static class TestProject {
        final String name;
        final Class<?> clazz;

        TestProject(String name, Class<?> clazz) {
            this.name = name;
            this.clazz = clazz;
        }
    }
}