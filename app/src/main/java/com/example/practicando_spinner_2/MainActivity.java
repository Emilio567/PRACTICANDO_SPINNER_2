package com.example.practicando_spinner_2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    EditText nombres;

    String [] casas = {"Gryffindor","Hufflepuff","Ravenclaw","Slytherin"};
    int [] imagenes = {R.drawable.gryffindor,R.drawable.hufflepuff,R.drawable.ravenclaw,R.drawable.slytherin};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        nombres = findViewById(R.id.editTextText);

        CasaAdapter adaptador_casas = new CasaAdapter();
        spinner.setAdapter(adaptador_casas);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String casa = casas[position];

                switch (casa){
                    case "Gryffindor":
                        Toast.makeText(MainActivity.this, "Tu nombre es "+nombres.getText().toString()+ " y perteneces a la casa "+ casa, Toast.LENGTH_SHORT).show();
                    break;

                    case "Hufflepuff":
                        Toast.makeText(MainActivity.this, "Tu nombre es "+nombres.getText().toString()+ " y perteneces a la casa "+ casa, Toast.LENGTH_SHORT).show();
                        break;

                    case "Ravenclaw":
                        Toast.makeText(MainActivity.this, "Tu nombre es "+nombres.getText().toString()+ " y perteneces a la casa "+ casa, Toast.LENGTH_SHORT).show();
                        break;

                    case "Slytherin":
                        Toast.makeText(MainActivity.this, "Tu nombre es "+nombres.getText().toString()+ " y perteneces a la casa "+ casa, Toast.LENGTH_SHORT).show();
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    class CasaAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return casas.length;
        }

        @Override
        public Object getItem(int position) {
            return casas[position];
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertview, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            convertview = inflater.inflate(R.layout.visual,null);
            ImageView imageView = convertview.findViewById(R.id.imageView);
            TextView textView = convertview.findViewById(R.id.textView);
            imageView.setImageResource(imagenes[position]);
            textView.setText(casas[position]);
            return convertview;
        }
    }

}