package br.com.fiap.placar;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    private ImageView ivLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ivLogo = (ImageView) findViewById(R.id.ivLogo);

        carregar();

    }

    private void carregar() {
        Animation animacaoLogo = AnimationUtils.loadAnimation(this, R.anim.animacao_splash);
        animacaoLogo.reset();
        ivLogo.clearAnimation();
        ivLogo.startAnimation(animacaoLogo);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent proximaTela = new Intent(SplashActivity.this, MainActivity.class);

                startActivity(proximaTela);
                SplashActivity.this.finish();
            }
        }, 3500);
    }

}
