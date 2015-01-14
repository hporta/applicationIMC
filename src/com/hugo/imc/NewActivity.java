package com.hugo.imc;

import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.app.Activity;
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

public class NewActivity extends Activity {
	 Button raz = null;
	 TextView result = null;
	 protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.layout_resultat);
	        result = (TextView)findViewById(R.id.result);
	        raz = (Button)findViewById(R.id.raz);
			raz.setOnClickListener(razListener);
			Intent i = getIntent();
			String resultat = i.getStringExtra(MainActivityIMC.Resultat);
			result.setText(resultat);
			}
	 
	         private OnClickListener razListener = new OnClickListener(){
	        	@Override
	        	public void onClick(View v){
	        		Intent Activite1 = new Intent(NewActivity.this, MainActivityIMC.class);
	        		startActivity(Activite1);
	        		
	        	}
	        };
	        
	       /* private OnClickListener razListener = new OnClickListener() {
	            @Override
	            public void onClick(View v) {
	              poids.getText().clear();
	              taille.getText().clear();
	              result.setText(defaut);
	            }
	          };*/
	 }

