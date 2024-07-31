package com.pdrarth.desafio;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.pdrarth.desafio.databinding.ActivityMainBinding;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        binding.calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String number = binding.Numero.getText().toString();

                if(number.isEmpty()){
                binding.Numero.setError("Preencha o campo");
                }
                else {
                    imparorpar();
                }
            }
        });

}
private void imparorpar(){
       int numero = Integer.parseInt(binding.Numero.getText().toString());
        if(numero %2 == 0){
            binding.Resposta.setText("Numero par");
            binding.Resposta.setTextColor(getColor(R.color.Lime));
        }
        else{
            binding.Resposta.setText("Numero impar");
            binding.Resposta.setTextColor(getColor(R.color.Purple));
        }
}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int intemid = item.getItemId();
        if(intemid == R.id.limpar){
            binding.Numero.setText("");
            binding.Resposta.setText("");
        }
        return super.onOptionsItemSelected(item);
    }
}