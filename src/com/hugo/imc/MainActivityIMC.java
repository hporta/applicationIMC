package com.hugo.imc;

import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivityIMC extends ActionBarActivity {
	Button envoyer = null;
  	String result = null;
    EditText poids = null;
    EditText taille = null;
  	RadioGroup group = null;
  	TextView nonresult = null;
    CheckBox mega = null;
    public static final String Resultat = "resultat";
 
    private final String defaut = "Vous devez cliquer sur le bouton « Calculer l'IMC » pour obtenir un résultat.";
   
    private final String megaString = "Vous êtes beau ou belle mais un peu de sport serait pas mal";
   
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_imc);
            envoyer = (Button)findViewById(R.id.calcul);	
            taille = (EditText)findViewById(R.id.taille);
            poids = (EditText)findViewById(R.id.poids);	
            mega = (CheckBox)findViewById(R.id.mega);	
            group = (RadioGroup)findViewById(R.id.group);
            nonresult = (TextView)findViewById(R.id.non_resultat);
            nonresult.setText("vous devez cliquer sur calculer pour obtenir le résultat");

           
            envoyer.setOnClickListener(envoyerListener);
            taille.addTextChangedListener(textWatcher);
            poids.addTextChangedListener(textWatcher);
          }

          
          private TextWatcher textWatcher = new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        		
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
              int after) {
          
            }
          
            @Override
            public void afterTextChanged(Editable s) {
          
            }
          };
        	
          // Uniquement pour le bouton "envoyer"
          private OnClickListener envoyerListener = new OnClickListener() {
            @Override
            public void onClick(View v) {
              if(!mega.isChecked()) {
                // Si la megafonction n'est pas activée
                // On récupère la taille
                String t = taille.getText().toString();
                // On récupère le poids
                String p = poids.getText().toString();
        			
                float tValue = Float.valueOf(t);
        			
                // Puis on vérifie que la taille est cohérente
                if(tValue == 0)
                  Toast.makeText(MainActivityIMC.this, "Tu es de taille nulle??", Toast.LENGTH_SHORT).show();
                else {
                  float pValue = Float.valueOf(p);
                  // Si l'utilisateur a indiqué que la taille était en centimètres
                  // On vérifie que la Checkbox sélectionnée est la deuxième à l'aide de son identifiant
                  if(group.getCheckedRadioButtonId() == R.id.radio1)
                    tValue = tValue / 100;

                  tValue = (float)Math.pow(tValue, 2);//la méthode Math.Pow renvoie une approximation de tValue^2
                  float imc = pValue / tValue;
                  result = "Votre IMC est " + String.valueOf(imc);
                }
              } else
                result = megaString;
              Intent Activite2 = new Intent(MainActivityIMC.this, NewActivity.class);
              Activite2.putExtra(Resultat, result);
              startActivity(Activite2);
            }
          };
        	
          // Listener du bouton de remise à zéro
        	
          // Listener du bouton de la megafonction.
          
        }
    


    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_activity_imc, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/

