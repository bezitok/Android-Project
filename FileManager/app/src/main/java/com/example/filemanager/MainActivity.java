package com.example.filemanager;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText;
    Button button, button1, button2, button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);


        button.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {


        switch (v.getId()){
            case R.id.button:
                String text = editText.getText().toString();
                WriteData(text);
                break;
            case R.id.button1:
                ReadData();
                break;
            case R.id.button2:
                SaveFileCache();
                break;
            case R.id.button3:
                ReadCacheFile();
        }
    }

    public void WriteData(String text){
        try {
            FileOutputStream fileOutputStream = openFileOutput("Text File.txt", Context.MODE_PRIVATE);
            fileOutputStream.write(text.getBytes());
            Toast.makeText(this, "Ghi dữ liệu thành công. Dữ liệu được lưu tại " + getFilesDir().toString(), Toast.LENGTH_SHORT).show();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ReadData(){
        try {

            FileInputStream fileInputStream = openFileInput("Text File.txt"); //Tạo 1 luồng để mở file cần đọc, param truyền vào là tên file cần đọc
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream); //Tạo 1 luồng để đọc file đó
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader); //Dùng BufferReader để tránh việc xảy ra lỗi khi đọc file
            String dulieu; //Tạo 1 chuỗi để đọc dữ liệu, readLine() là đọc dữ liệu theo từng dòng
            StringBuffer stringData = new StringBuffer(); //Tạo 1 chuỗi để lưu những dữ liệu đã đọc được
            while ((dulieu = bufferedReader.readLine()) != null){
                stringData.append(dulieu + " ");
            }

            //Sau khi đọc file xong cần đóng các luồng đã mở
            fileInputStream.close();
            inputStreamReader.close();
            bufferedReader.close();

            Toast.makeText(this, stringData, Toast.LENGTH_SHORT).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void SaveFileCache(){
        try {
            File fileCache = File.createTempFile("File cache", ".txt", getCacheDir()); //Tạo file cache mới
            FileWriter fileWriter = new FileWriter(fileCache);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(editText.getText().toString());
            bufferedWriter.close();
            Toast.makeText(this, "Tạo file cache thành công. File được lưu tại " + getCacheDir().toString(), Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void ReadCacheFile(){
        File fileCache = null;
        File[] files = getCacheDir().listFiles();
        for (int i=0; i<files.length; i++){
            fileCache = files[i];
        }

//        File file = new File(getCacheDir() + "/File cache.txt");
        String dulieu = "";
        try {
            FileReader fileReader = new FileReader(fileCache);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            StringBuffer chuoidulieu = new StringBuffer();
            while ((dulieu = bufferedReader.readLine()) != null){
                chuoidulieu.append(dulieu);
            }

            bufferedReader.close();
            fileReader.close();

            Toast.makeText(this, chuoidulieu, Toast.LENGTH_SHORT).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
