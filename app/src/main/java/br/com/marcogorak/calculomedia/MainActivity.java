package br.com.marcogorak.calculomedia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Declarando atributos da classe
    EditText edtNome;
    EditText edtNota1;
    EditText edtNota2;
    Button btnCalcular;
    TextView txtResultado;
    Double Media;
    String Resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Associando os elementos da tela com os atributos da classe
        edtNome = (EditText) findViewById(R.id.edtNome);
        edtNota1 = (EditText) findViewById(R.id.edtNota1);
        edtNota2 = (EditText) findViewById(R.id.edtNota2);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        txtResultado = (TextView) findViewById(R.id.txtResultado);

        //Implementando o ouvinte de eventos
        btnCalcular.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        //Validando qual o elemento ecutado pelo ouvinte
        if (btnCalcular.getId() == id) {
            //Faz o calculo da média convertendo os elementos de String para Double
            Media = (Double.parseDouble(edtNota1.getText().toString())*0.4)+(Double.parseDouble(edtNota2.getText().toString())*0.6);

            //Valida se a nota foi maior que 7
            if (Media >=7 ) {
                //Monta a frase de Aprovado através do método String.format
                Resultado = String.format("Olá %s, sua nota foi %.1f você foi Aprovado!", edtNome.getText().toString(), Media);
                txtResultado.setText(Resultado);
            } else {
                //Monta a frase de Reprovado através do método String.format
                Resultado = String.format("Olá %s, sua nota foi %.1f você foi Reprovado!", edtNome.getText().toString(), Media);
                txtResultado.setText(Resultado);
            }

        }

    }
}
