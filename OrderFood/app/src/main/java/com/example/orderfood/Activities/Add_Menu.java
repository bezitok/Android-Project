package com.example.orderfood.Activities;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.orderfood.Adapter.List_KindOfFood_Adapter;
import com.example.orderfood.DAO.Food_DAO;
import com.example.orderfood.DAO.KindOfFood_DAO;
import com.example.orderfood.DTO.Food_DTO;
import com.example.orderfood.DTO.KindOfFood_DTO;
import com.example.orderfood.R;

import java.util.List;

public class Add_Menu extends AppCompatActivity {

    EditText edt_foodName;
    EditText edt_foodCost;
    ImageButton btn_addKindOfFood;
    ImageView img_selectKindOfFood;
    Button btn_Confirm, btn_Cancel;
    Spinner spinner_addFood;
    KindOfFood_DAO kindOfFood_dao;
    List<KindOfFood_DTO> kindOfFood_List;
    List_KindOfFood_Adapter adapter;
    String link_Image;
    Food_DAO food_dao;

    public static final int REQUEST_CODE = 1;
    public static final int REQUEST_CODE_OPEN = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_menu);

        initWidget();

        kindOfFood_dao = new KindOfFood_DAO(Add_Menu.this);
        food_dao = new Food_DAO(Add_Menu.this);

        displayKindOfFood();


    }

    public void initWidget(){
        edt_foodName = findViewById(R.id.add_menu_edt_name);
        edt_foodCost = findViewById(R.id.add_menu_edt_cost);
        btn_addKindOfFood = findViewById(R.id.add_menu_img_btn_add);
        img_selectKindOfFood = findViewById(R.id.add_menu_img_selectKindOfFood);
        btn_Confirm = findViewById(R.id.add_menu_btn_confirm);
        btn_Cancel = findViewById(R.id.add_menu_btn_cancel);
        spinner_addFood = findViewById(R.id.add_menu_spinner);
    }

    public void displayKindOfFood(){
        kindOfFood_List = kindOfFood_dao.getAllKindOfFoodInfo();
        adapter = new List_KindOfFood_Adapter(Add_Menu.this, R.layout.a_kind_of_food_layout, kindOfFood_List);
        spinner_addFood.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public void select_KindOfFood(View view) {

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select image"), REQUEST_CODE_OPEN);

    }


    public void addKindOfFood(View view) {
        Intent intent = new Intent(Add_Menu.this, Add_Kind_Of_Food.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE ){

            if(resultCode == Activity.RESULT_OK){
                Intent intent = data;
                boolean check = intent.getBooleanExtra(Add_Kind_Of_Food.RESULT, false);
                if(check){
                    displayKindOfFood();
                    Toast.makeText(Add_Menu.this, "Add successfully", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(Add_Menu.this, "Add failed", Toast.LENGTH_LONG).show();
                }
            }

        }else if (requestCode == REQUEST_CODE_OPEN){
            if (resultCode == Activity.RESULT_OK){
                link_Image = data.getData().toString();
                img_selectKindOfFood.setImageURI(data.getData());
            }
        }


    }

    public void confirmAddMenu(View view) {

        int pos = spinner_addFood.getSelectedItemPosition();
        int id_kindOfFood = kindOfFood_List.get(pos).getId_KindOfFood();
        String foodName = edt_foodName.getText().toString();
        String foodCost = edt_foodCost.getText().toString();

        if (foodName.isEmpty() || foodCost.isEmpty()){
            if (foodName.isEmpty()){
                edt_foodName.setError("Can't be empty");
            }else {
                edt_foodCost.setError("Can't be empty");
            }
        }else {
            Food_DTO food = new Food_DTO();
            food.setFoodName(foodName);
            food.setFoodCost(foodCost);
            food.setFoodImage(link_Image);
            food.setId_KindOfFood(id_kindOfFood);

            boolean check = food_dao.addFood(food);
            if (check){
                Toast.makeText(Add_Menu.this, "Add successfully", Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(Add_Menu.this, "Add failed", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void cancelAddMenu(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Add_Menu.this);
        builder.setCancelable(false);
        builder.setTitle("Alert");
        builder.setMessage("Do you want to cancel?");
        builder.setPositiveButton("No", null);
        builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
