package com.example.lenovo.myapplication;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText E1,E2;
my my;
SQLiteDatabase mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        E1=findViewById(R.id.e1);
        E2=findViewById(R.id.e2);
    }

    public void dl(View view) {
        String name = E1.getText().toString();
        String pwd = E2.getText().toString();
        my = new my(MainActivity.this, "userdb.db", null, 1);
        mydb = my.getWritableDatabase();
        Cursor c = mydb.query("users", new String[]{"userid"}, "userid=?and password=?", new String[]{name, pwd}, null, null, null);
        if (c.moveToFirst()) {
            startActivity(new Intent(MainActivity.this, Main2Activity.class));
        } else {
            Toast.makeText(MainActivity.this, "登录失败，请先注册", Toast.LENGTH_LONG).show();
        }
    }

    public void ze(View view) {
        String name=E1.getText().toString();
        String pwd=E2.getText().toString();
        my=new my(MainActivity.this,"userdb.db",null,1);
        mydb=my.getWritableDatabase();
        ContentValues CV=new ContentValues();
            CV.put("userid",name);
            CV.put("password",pwd);
            mydb.insert("users",null,CV);
            Toast.makeText(MainActivity.this,"注册完成",Toast.LENGTH_LONG).show();
    }}

