package com.example.next.asyncloader;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by next on 4/3/17.
 */
public class EmployeeLoader extends AsyncTaskLoader<List<Employee>> {


    public EmployeeLoader(Context context) {
        super(context);
    }

    @Override
    public List<Employee> loadInBackground() {
List<Employee> list= new ArrayList<>();
        list.add(new Employee("candidate1", "pri"));
        list.add(new Employee("candidate2", "priya"));
        list.add(new Employee("candidate3", "priyanka"));
        list.add(new Employee("candidate4", "ganajalkhed"));


        return list;
    }
}
