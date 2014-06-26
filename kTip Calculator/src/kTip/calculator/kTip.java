package kTip.calculator;

import java.text.DecimalFormat;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class kTip extends Activity implements OnClickListener {

	TextView totalAmount, eachPerson;
	EditText tip, billTotal, numberofPeople;
	Button calculate, reset;
	double tiptax, cTax, bTotal, nofPeople, total, person;
	String x = "", y = "";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		initialize();

	}
	
	//initialize all the button and textviews on the interface
	public void initialize() {
		totalAmount = (TextView) findViewById(R.id.totalAmount);
		eachPerson = (TextView) findViewById(R.id.eachPerson);
		tip = (EditText) findViewById(R.id.tip);
		billTotal = (EditText) findViewById(R.id.billTotal);
		numberofPeople = (EditText) findViewById(R.id.numberofPeople);
		calculate = (Button) findViewById(R.id.calculate);
		reset = (Button) findViewById(R.id.reset);
		reset.setOnClickListener(this);
		calculate.setOnClickListener(this);
	}
	
	//converts the text into double
	private void convertEditText() {
		tiptax = ((Double.parseDouble(tip.getText().toString())) / 100) + 1;
		bTotal = Double.parseDouble(billTotal.getText().toString());
		nofPeople = Double.parseDouble(numberofPeople.getText().toString());
	}
	
	
	public void onClick(View arg0) {
		// TODO Auto-generated method stub

		switch (arg0.getId()) {
			
		//when user click calculate, compute the value for the user and displays it
		case R.id.calculate:
			if (billTotal.getText().toString().length() != 0
					&& numberofPeople.getText().toString().length() != 0
					&& tip.getText().toString().length() != 0) {
				convertEditText();
				total = (bTotal) * (tiptax);
				DecimalFormat a = new DecimalFormat("#.##");
				x = a.format(total);
				person = total / nofPeople;
				y = a.format(person);
				totalAmount.setText(x);
				eachPerson.setText(y);
				x = "";
				y = "";
			}
			break;
		
		//when usser click reset button, it resets all the values on the interface
		case R.id.reset:
			totalAmount.setText("0");
			eachPerson.setText("0");
			numberofPeople.setText("");
			tip.setText("15");
			billTotal.setText("");
			numberofPeople.setText("");
			break;
		}

	}
}
