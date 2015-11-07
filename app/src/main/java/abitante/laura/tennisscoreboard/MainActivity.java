package abitante.laura.tennisscoreboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtScore1;
    TextView txtScore2;

    Button btnOpponent;
    Button btnMe;

    int score1 = 0;
    int score2 = 0;

    int opponent = 0;
    int me = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtScore1 = (TextView) findViewById(R.id.score1);
        txtScore2 = (TextView) findViewById(R.id.score2);
        btnOpponent = (Button) findViewById(R.id.btnOpponent);
        btnMe = (Button) findViewById(R.id.btnMe);
        updateScores();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void updateScore1 (View view) {
        //    txtScore1.setText("teste");
        boolean shouldUpdate = true;
        if (score1 == 0) {
            score1 = 15;
        } else if (score1 == 15) {
            score1 = 30;
        } else if (score1 == 30) {
            score1 = 40;
            if (score2 == 40){
                txtScore1.setText("DEUCE");
                txtScore2.setText("DEUCE");
                shouldUpdate = false;
            }
        }
        else if (score1 == 40){
            if (score2 != 40 && score2 != 41){
                opponent++;
                updateScores();
            }
            else if (score2 == 41){
                score2 = 40;
                txtScore1.setText("DEUCE");
                txtScore2.setText("DEUCE");
                shouldUpdate = false;
            }
            else{
                score1 = 41;
                txtScore1.setText("ADV");
                txtScore2.setText("40");
                shouldUpdate = false;
            }

        }
        else if (score1 == 41){
            opponent++;
            updateScores();
        }
        else{
            score1 = 0;
        }
        if (shouldUpdate) {
            txtScore1.setText(Integer.toString(score1));
        }
    }

    public void updateScore2 (View view){
        boolean shouldUpdate = true;

            if (score2 == 0){
                score2 = 15;
            }
            else if (score2 == 15){
                score2 = 30;
            }
            else if (score2 == 30){
                score2 = 40;
                if (score1 == 40){
                    txtScore1.setText("DEUCE");
                    txtScore2.setText("DEUCE");
                    shouldUpdate = false;
                }
            }

            else if (score2 == 40){
                if (score1 != 40 && score1 != 41){
                    me++;
                    updateScores();
                }
                else if (score1 == 41){
                    score1 = 40;
                    txtScore1.setText("DEUCE");
                    txtScore2.setText("DEUCE");
                    shouldUpdate = false;
                }
                else{
                    score2 = 41;
                    txtScore2.setText("ADV");
                    txtScore1.setText("40");
                    shouldUpdate = false;
                }
            }

            else if (score2 == 41){
                me++;
                updateScores();
            }
            else {
                score2 = 0;
            }
        if (shouldUpdate) {
            txtScore2.setText(Integer.toString(score2));
        }
    }

    public void updateScores(){
        score1 = 0;
        score2 = 0;
        txtScore1.setText("0");
        txtScore2.setText("0");
        btnOpponent.setText("Opponent ("+ opponent +")");
        btnMe.setText("ME (" + me +")");
    }

    public void resetScores(View view){
        opponent = 0;
        me = 0;
        updateScores();
    }

}
