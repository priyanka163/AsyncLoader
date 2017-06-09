package com.example.next.asyncloader;

import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Employee>> {
    private static final int THE_LOADER = 0x01;

    EmployeeAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

 adapter= new EmployeeAdapter(this,new ArrayList<Employee>());
        ListView listView= (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);


        getSupportLoaderManager().initLoader(THE_LOADER,null,this).forceLoad();

    }

    @Override
    public Loader onCreateLoader(int id, Bundle args) {
        return new EmployeeLoader(MainActivity.this);   }

    @Override
    public void onLoadFinished(Loader<List<Employee>> loader, List<Employee> data) {
        adapter.setEmployees(data);
    }


    @Override
    public void onLoaderReset(Loader loader) {
        adapter.setEmployees(new ArrayList<Employee>());
    }
}
