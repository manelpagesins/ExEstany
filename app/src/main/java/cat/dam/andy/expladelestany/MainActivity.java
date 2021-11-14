package cat.dam.andy.expladelestany;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity {
    static String[] nomPoblacions = new String[]{
            "Banyoles",
            "Camós",
            "Cornellà del Terri",
            "Crespià",
            "Esponellà",
            "Fontcoberta",
            "Palol de Revardit",
            "Porqueres",
            "Sant Miquel de Campmajor",
            "Serinyà",
            "Vilademuls"
    };
    static int[] numPoblacions = new int[]{
            20053,
            677,
            2399,
            254,
            463,
            1469,
            448,
            4677,
            229,
            1133,
            835
    };

    Button boto1;

    String nomPoblacio = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boto1 = (Button) findViewById(R.id.buto_cerca); //Assignem el valor id de el buto1

        AutoCompleteTextView editText = findViewById(R.id.nomPoblacio); //Fem servir l'objecte AutoCompleteTextView per vincular l'objecte amb la id nomPoblacio
        editText.setThreshold(1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, //Configurem l'objecte ArrayAdapter per fer apareixer el array nomPoblacions
                android.R.layout.simple_dropdown_item_1line, nomPoblacions);
        editText.setAdapter(adapter); //Adjuntem l'objecte adapter al editText

        boto1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView tv = (TextView)findViewById(R.id.numeroPoblacio);

                AutoCompleteTextView source = (AutoCompleteTextView) findViewById(R.id.nomPoblacio);
                String nomDePoblacio = source.getText().toString(); //Aconseguim el valor String que ha decidit posar el usuari

                int numeroIndex = Arrays.asList(nomPoblacions).indexOf(nomDePoblacio); //Amb el String anteriorment aconseguit, busquem el seu numero de index dins del array

                int numeroDePoblacio = numPoblacions[numeroIndex]; //Amb el numero de index aconseguit buscarem el numero de poblacio de la poblacio escullida

                String numPoblacioFinal = Integer.toString(numeroDePoblacio); //Convertim el numero de habitants a String per tal de posarlo al TextView amb la id numeroPoblacio

                tv.setText(numPoblacioFinal); //assignem com a parametre el numero de habitants per tal de mostrar-ho per pantalla
            }
        });

    }
}