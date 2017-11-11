package br.com.fiap.placar;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ValidaLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valida_login);

        if(getIntent() != null){
            Usuario usuario = getIntent().getParcelableExtra("USUARIO");
            validarUsuario(usuario);
        }

    }

    private void validarUsuario(final Usuario usuario) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent resultado = new Intent();
               if(usuario.getLogin().equals("android") && usuario.getSenha().equals("123")){
                   resultado.putExtra(Constantes.KEY_RESULT_LOGIN, true);
               }else {
                   resultado.putExtra(Constantes.KEY_RESULT_LOGIN, false);
               }

                setResult(RESULT_OK, resultado);
                finish();
            }
        }, 1500);

    }

}
