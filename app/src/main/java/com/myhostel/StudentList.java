package com.myhostel;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class StudentList extends ArrayAdapter<Student> {
    private Activity context;
    private List<Student> studentList;

    public StudentList(Activity context, List<Student> studentList){
        super(context,R.layout.activity_view_student_details, studentList);
        this.context = context;
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.activity_student_list,null,true);

        TextView studentname = (TextView) listViewItem.findViewById(R.id.studentname);
        TextView studentemail = (TextView) listViewItem.findViewById(R.id.studentemail);
        TextView studentdept = (TextView) listViewItem.findViewById(R.id.studentdept);
        TextView studentyear = (TextView) listViewItem.findViewById(R.id.studentyear);
        TextView studentroom = (TextView) listViewItem.findViewById(R.id.studentroom);
        TextView studentrollno = (TextView) listViewItem.findViewById(R.id.studentrollno);

        Student student = studentList.get(position);

        studentname.setText(student.getName());
        studentemail.setText(student.getEmail());
        studentdept.setText(student.getDept());
        studentyear.setText(student.getYear());
        studentroom.setText(student.getRoom());
        studentrollno.setText(student.getRollno());

        return listViewItem;


    }
}