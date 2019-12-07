package f2_1461700099.daskom.untag.ta4_rizal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;

import java.util.Objects;
import java.util.Random;

public class DetailActivity extends AppCompatActivity {
    private TextView tvNama, tvMobile, tvEmail;
    private ImageView ivTextDrawable;
    private String[] mColors = {
            "#39add1", // light blue
            "#3079ab", // dark blue
            "#c25975", // mauve
            "#e15258", // red
            "#f9845b", // orange
            "#838cc7", // lavender
            "#7d669e", // purple
            "#53bbb4", // aqua
            "#51b46d", // green
            "#e0ab18", // mustard
            "#637a91", // dark gray
            "#f092b0", // pink
            "#b7c0c7"  // light gray
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tvNama = (TextView) findViewById(R.id.tvNama);
        tvMobile = (TextView) findViewById(R.id.tvMobile);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        ivTextDrawable = (ImageView) findViewById(R.id.ivTextDrawable);

        tvNama.setText(getIntent().getStringExtra("nama"));
        tvMobile.setText(getIntent().getStringExtra("mobile"));
        tvEmail.setText(getIntent().getStringExtra("email"));
        TextDrawable drawable = TextDrawable.builder()
                .buildRound(Objects.requireNonNull(getIntent().getStringExtra("nama")).substring(0,1).toUpperCase(), getColor());
        ivTextDrawable.setImageDrawable(drawable);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        onBackPressed();
        return true;
    }

    private int getColor() {
        String color;

        Random randomGenerator = new Random();
        int randomNumber = randomGenerator.nextInt(mColors.length);

        color = mColors[randomNumber];
        int colorAsInt = Color.parseColor(color);

        return colorAsInt;
    }
}
