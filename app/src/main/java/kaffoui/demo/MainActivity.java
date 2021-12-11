package kaffoui.demo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private double val1 = 0;
    private double val2 = 0;
    private String operation = "";
    private boolean isOp1 = true;
    private boolean dec = false;
    private boolean cal = false;
    private double dec1 = 0.0;
    private double dec2 = 0.0;
    private double resultat;
    private TextView ecran;
    private Button btnClear;
    private Button btnEgal;
    private Button btn8, btn5;
    private View.OnClickListener ajouterChiffreListener;
    private Calculatrice calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View view = null;
        calc = new Calculatrice();
        ecran = findViewById(R.id.screen);
        //Methode 1
        btnClear = findViewById(R.id.btnClear);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                effacer(view);
                calc.effacer();
            }
        });
        //Methode 2
        btnEgal = findViewById(R.id.btnEgal);
        btnEgal.setOnClickListener(this);
        //Methode 3
        ajouterChiffreListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ajouterChiffre(view);
            }
        };
        btn5 = findViewById(R.id.btn5);
        btn5.setOnClickListener(ajouterChiffreListener);
        btn8 = findViewById(R.id.btn8);
        btn8.setOnClickListener(ajouterChiffreListener);
    }
    private void afficher(){
        if(!isOp1){ ecran.setText(String.valueOf(val1) +" "+operation+" "+String.valueOf(val2)); }
 else{
                if(cal == true){
                    ecran.setText( String.valueOf(resultat) );
                }else{
                    ecran.setText( String.valueOf(val1) );
                }
            }
        }
        public void setOperation(View v){
            switch( v.getId() ){
                case R.id.btnPlus : operation = "+"; break;
                case R.id.btnMoins : operation = "-"; break;
                case R.id.btnDiv : operation = "/"; break;
                case R.id.btnFois : operation = "*"; break;
                case R.id.btnMod : operation = "%"; break;
                default:
                    return; //Ne retourne rien
            }
            isOp1 = false;
            afficher();
        }
        public void ajouterChiffre(View v){
            int val = Integer.parseInt(((Button)v).getText().toString());
            if(!isOp1){
                val2 = val2 * 10 + val;
                afficher();
            }else {
                val1 = val1 * 10 + val;
                afficher();
            }
        }
        public void calculer(View view){
            if(!isOp1){
                switch (operation){
                    case "+" : resultat = this.calc.addition(val1,
                            val2).toDouble(); break;
                    case "-" : resultat = this.calc.soustration(val1,
                            val2).toDouble(); break;
                    case "*" : resultat = this.calc.multiplication(val1,
                            val2).toDouble(); break;
                    case "/" : resultat = this.calc.division(val1,
                            val2).toDouble(); break;
                    case "%" : resultat = this.calc.reste(val1,
                            val2).toDouble(); break;
                    default:
                        return;
                }
                val2 = 0;
                cal = true;
                isOp1 = true;
                afficher();
            }
        }
        public void effacer(View view){
            val1 = 0;
            val2 = 0;
            operation = "";
            isOp1 = true;
            resultat = 0;
            cal = false;
            this.calc.effacer();
            afficher();
        }
        public void ValDecimal(View view){
            if(dec == false){
// if(isOp1){
// dec1 = val1 * 10 + (double)(val1/10);
// } else {
// dec2 = val2 * 10 + (double)(val2/10);
// }
            }
            dec = true;
            afficher();
        }
        public void plusMoins(View view){
            if(isOp1){
                val1 = val1 * (-1);
            }else{val2 = val2 * (-1);}
            afficher();
        }
        @Override
        public void onClick(View view) {
            calculer(view);
        }


}