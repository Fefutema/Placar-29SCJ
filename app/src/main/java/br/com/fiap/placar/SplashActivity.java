package br.com.fiap.placar;

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
    }

}
