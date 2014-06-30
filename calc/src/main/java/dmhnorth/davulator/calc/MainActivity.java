package dmhnorth.davulator.calc;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private int total = 0;
    private String op ="+";
    private String operation ="Yeah?\n";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }




    public void onButtonClick(View v) {
        //Get the opText
        TextView opText = (TextView)
                findViewById(R.id.textView2);

        //Get the operandText
        TextView operandText = (TextView)
                findViewById(R.id.textView);

        //Get the operationText
        TextView operationText = (TextView)
                findViewById(R.id.textView3);

        //Find the button and it's details
        Button button = (Button) v;
        String bText = (String) button.getText();
/*
        //TODO
        //Check if a character has been entered, to append to current..
        assert bText != null;
        if(Character.isDigit(bText.charAt(0))){
            bText = total + bText;
        } else {
            //operation = operation + op;
        }
*/
        operandText.setText(bText);



        //Stop concatenation of operation
        if(bText.equals("Calculate")){
            //do nothing
        } else if (bText.equals("Clear")) {
            //reset
            total = 0;
            op = "+";

            operation = "";
            operationText.setText("---");
            return;
        } else if (!bText.equals(operation)){
            operation = operation + " " + bText;
        }
        operationText.setText(operation);


        //Search for an Operator
        assert bText != null;
        if(bText.equals(op)){
            //do nothing due to accident press.
            return;
        }
        if(bText.equals("+")){
            op = "+";
            opText.setText(op);
            return;
        } else if(bText.equals("-")){
            op = "-";
            opText.setText(op);
            return;
        } else if(bText.equals("*")){
            op = "*";
            opText.setText(op);
            return;
        } else if(bText.equals("/")){
            op = "/";
            opText.setText(op);
            return;
        } else if(bText.equals("Calculate")){
            opText.setText("=");
            operandText.setText(Integer.toString(total));
            return;
        }

        //Parse an operand
        int value = Integer.parseInt(bText);

        //Determine op
        if(op.equals("+")) {
            total += value;
        }
        if(op.equals("-")) {
            total -= value;
        }
        if(op.equals("*")) {
            total = total * value;
        }
        if(op.equals("/")) {
            total = total / value;
            //currently does not account for remainders
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
    }

}
