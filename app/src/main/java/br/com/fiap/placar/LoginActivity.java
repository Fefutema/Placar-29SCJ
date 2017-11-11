package br.com.fiap.placar;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class LoginActivity extends AppCompatActivity {

    private EditText etLogin;
    private EditText etSenha;
    private Button btConectar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etLogin = (EditText) findViewById(R.id.etLogin);
        etSenha = (EditText) findViewById(R.id.etSenha);
        btConectar = (Button) findViewById(R.id.btConectar);

        btConectar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuario usuario = new Usuario(etLogin.getText().toString(), etSenha.getText().toString());

                Intent validaLogin = new Intent(LoginActivity.this, ValidaLoginActivity.class);
                validaLogin.putExtra("USUARIO", usuario);

                startActivityForResult(validaLogin, Constantes.KEY_REQUEST_CODE_VALIDAR_LOGIN);


            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case Constantes.KEY_REQUEST_CODE_VALIDAR_LOGIN:
                switch(resultCode) {
                    case RESULT_OK:

                        boolean isLoginValido = data.getBooleanExtra(Constantes.KEY_RESULT_LOGIN, false);

                            if(isLoginValido){
                                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(i);
                                finish();
                            }else{
                                Toast.makeText(LoginActivity.this, "Login ou senha inválidas",
                                        Toast.LENGTH_LONG).show();
                            }

                        break;
                }
                break;
        }

    }
}
