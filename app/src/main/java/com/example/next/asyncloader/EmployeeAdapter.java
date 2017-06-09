package com.example.next.asyncloader;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by next on 4/3/17.
 */
public class EmployeeAdapter extends BaseAdapter {
    private LayoutInflater inflater;

List<Employee> arraylist= new ArrayList<Employee>();

    public EmployeeAdapter(Context context, List<Employee> employees) {
        this.arraylist = employees;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return arraylist.size();
    }

    @Override
    public Object getItem(int position) {
        return arraylist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
     Employee emp = (Employee) getItem(position);
        if (convertView==null){
            convertView =inflater.inflate(R.layout.employeedata,null);
        }


        TextView empid = (TextView) convertView.findViewById(R.id.empid);
        empid.setText(emp.empid);
        TextView empname = (TextView) convertView.findViewById(R.id.empname);
        empname.setText(emp.name);
        return convertView;


    }

    public  void setEmployees(List<Employee> data){
        arraylist.addAll(data);
        notifyDataSetChanged();
    }
}
