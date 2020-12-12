package com.example.recyclercards;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editText1,editText2;
    private Button button1, button2;

    ArrayList<Coolitems> coolList;

    private RecyclerView recyclerView;
    private  RecyclerView.Adapter adapter;
    private  RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.edittextadd);
        editText2 = findViewById(R.id.edittextdelete);

        button1 = findViewById(R.id.buttonadd);
        button2 = findViewById(R.id.buttondelete);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



               String z = editText1.getText().toString();

               if(TextUtils.isEmpty(z)){
                   editText1.setError("Need user input");
               }

               else{
                   int position = Integer.parseInt(z);
                   addCard(position);
                   //adapter.notifyDataSetChanged();

                   adapter.notifyItemInserted(position);
               }



            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String z =editText2.getText().toString() ;
                if(TextUtils.isEmpty(z)){
                    editText2.setError("Need user input");
                }

                else{

                    int position = Integer.parseInt(z);
                    deleteCard(position);
                    adapter.notifyItemRemoved(position);
                }

            }
        });




        generateFakeData();
        recyclerViewConfig();





    }

    public  void generateFakeData()
    {
        coolList = new ArrayList<>();
        coolList.add(new Coolitems(R.drawable.image, "An artist at work in the street"));
        coolList.add(new Coolitems(R.drawable.oner, "Clicked at Italy"));
        coolList.add(new Coolitems(R.drawable.twor, "Clicked at Rome"));
        coolList.add(new Coolitems(R.drawable.threer, "Clicked at Greece"));
        coolList.add(new Coolitems(R.drawable.fourr, "Clicked at Rome"));
        coolList.add(new Coolitems(R.drawable.fiver, "Clicked at Santorini"));
        coolList.add(new Coolitems(R.drawable.sixr, "Clicked at India"));

    }
    public  void recyclerViewConfig(){
        //config of recycler view

        recyclerView = findViewById(R.id.recyclerView);
        // to increase performance
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        adapter = new CoolAdapter(coolList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    public void addCard( int position ){
        coolList.add(position, new Coolitems(R.drawable.image, "new card added"));
    }

    public void deleteCard( int position ){
        coolList.remove(position);
    }
}