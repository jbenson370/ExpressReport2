/*
 Express Report: Generate travel expense claims
 
 Copyright (C) 2015 Jordan Benson jbenson@ualberta.ca
 
 This program is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.
 This program is distributed in the hope that it will be useful, 
 but WITHOUT NY WARRANTY; without even the implied warranty of
 MERCHANT ABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the 
 GNU General Public License for more details. 
 You should have received a copy of the GNU General Public License
 along with this program. If not, see <http://www.gnu.org/licenses/>.
 
 */

package com.jbenson.expressreport;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class Activity_itemNew extends Activity implements OnItemSelectedListener
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{

		super.onCreate(savedInstanceState);
		setContentView(R.layout.item_detailform);
	
		Spinner spinner1 = (Spinner) findViewById(R.id.currencyMenu);
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
		        R.array.currency_array, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinner1.setAdapter(adapter1);
		spinner1.setOnItemSelectedListener(this);
		
		Spinner spinner2 = (Spinner) findViewById(R.id.categoryMenu);
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
		        R.array.category_array, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinner2.setAdapter(adapter2);
		spinner2.setOnItemSelectedListener(this);
		Claim claim = getIntent().getParcelableExtra("parsedClaim");
		ClaimList claimList = getIntent().getParcelableExtra("parsedClaimList");
		
		setupSaveBtn(claim, claimList);
		setupCancelBtn(claim, claimList);
	}

	private void setupSaveBtn(final Claim claim, final ClaimList claimList) {
		// Get reference to the button
				Button addItem = (Button) findViewById(R.id.saveItem_btn);
				//Set the click listener to run my code
				addItem.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						Item item = new Item();
						EditText itemDescription = (EditText) findViewById(R.id.itemDescription_txt);
						item.setDescription(itemDescription.getText().toString());
						Spinner spinner1 = (Spinner) findViewById(R.id.currencyMenu);
						item.setCurrency(spinner1.getSelectedItem().toString());
						Spinner spinner2 = (Spinner) findViewById(R.id.categoryMenu);
						item.setCategory(spinner2.getSelectedItem().toString());
						EditText itemCost = (EditText) findViewById(R.id.cost_txt);
						int costValue = Integer.parseInt(itemCost.getText().toString());
						item.setCost(costValue);
						
						Intent i = new Intent();
						i.putExtra("parsedItem", item);
						i.putExtra("parsedClaim",claim);
						i.putExtra("parsedClaimList", claimList);
						setResult(RESULT_OK, i);
						finish();
					    }	
					});
			}
		

	private void setupCancelBtn(final Claim claim, final ClaimList claimList) {
		// Get reference to the button
				Button addItem = (Button) findViewById(R.id.cancelItem_btn);
				//Set the click listener to run my code
				addItem.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						Intent i = new Intent();
						i.putExtra("parsedClaim",claim);
						i.putExtra("parsedClaimList", claimList);
						setResult(2, i);
						finish();
					    }	
					});
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		
	}
}
