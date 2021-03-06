package dmhnorth.davulator.calc;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private int total = 0;
    private String op ="+";
    private String operation ="Yeah?\n";
    private int value;
    private TextView operandText;
    private TextView operationText;
    private TextView opText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get the operandText
        operandText = (TextView)
                findViewById(R.id.textView);

        //Get the operationText
        operationText = (TextView)
                findViewById(R.id.textView3);

        //Get the opText
        opText = (TextView)
                findViewById(R.id.textView2);

        //Update the opText to reflect Calc start state
        opText.setText(op);


        //Reloading a state contingency
        if(savedInstanceState != null) {

            total = savedInstanceState.getInt("total");
            value = savedInstanceState.getInt("value");
            operation = savedInstanceState.getString("operation");
            op = savedInstanceState.getString("opText");


            //Update the view to reflect loaded values
            operandText.setText(Integer.toString(total));
            operationText.setText(operation);
            opText.setText(op);
        }
    }



    @Override
    protected void onSaveInstanceState(
            Bundle savedInstanceState){
        //Stores all useful values in the (key,value) map
        savedInstanceState.putInt("total",total);
        savedInstanceState.putInt("value", value);
        savedInstanceState.putString("operation", operation);
        savedInstanceState.putString("opText",op);

        super.onSaveInstanceState(savedInstanceState);
    }

    public void onButtonClick(View v) {

        //Find the button and it's details
        Button button = (Button) v;
        String bText = (String) button.getText();


        //TODO
//        currently probably doesn't work due to initialisation of the bText variable ?
//        Check if a character has been entered, to append to current..
//        assert bText != null;
//        if(Character.isDigit(bText.charAt(0))) {
//            try {
//                value = (value * 10) + Integer.parseInt(bText);
//                operandText.setText(value);
//                return;
//            } catch (Exception e){
//                //do nothing
//            }
//        }



        operandText.setText(bText);



        //Stop concatenation of operation
        assert bText != null;
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

        if(bText.equals(op)){
            //do nothing due to accidental button press.
            return;
        }

        opText.setText(op);

        if(bText.equals("+")){
            op = "+";
            return;
        } else if(bText.equals("-")){
            op = "-";
            return;
        } else if(bText.equals("*")){
            op = "*";
            return;
        } else if(bText.equals("/")){
            op = "/";
            return;
        } else if(bText.equals("Calculate")){
            opText.setText("=");
            operandText.setText(Integer.toString(total));
            return;
        }

        //Parse an operand
        value = Integer.parseInt(bText);

        //Determine op
        if(op.equals("+")) {
            total += value;
        }
        if(op.equals("-")) {
            total -= value;
        }
        if(op.equals("*")) {
            total = total * value;
            //currently does not take precedence over + or -
        }
        if(op.equals("/")) {
            total = total / value;
            //currently does not take precedence over + or -
            //currently does not account for remainder
        }
    }




    //These are default implementations when creating an Android project

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
