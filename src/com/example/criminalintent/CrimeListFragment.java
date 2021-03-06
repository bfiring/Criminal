package com.example.criminalintent;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

public class CrimeListFragment extends ListFragment {

	private ArrayList<Crime> mCrimes;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		getActivity().setTitle(R.string.crimes_tittle);
		mCrimes=Crimelab.get(getActivity()).getCrimes();
		
		CrimeAdapter adapter=new CrimeAdapter(mCrimes);
		setListAdapter(adapter);
		
		
	}
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		Crime c=((CrimeAdapter)getListAdapter()).getItem(position);
		Intent i=new Intent(getActivity(),CrimePagerActivity.class);
		i.putExtra(CrimeFragment.EXTRA_CRIME_ID,c.getId());
		startActivity(i);
	}
	
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		((CrimeAdapter)getListAdapter()).notifyDataSetChanged();
	}

	private class CrimeAdapter extends ArrayAdapter<Crime>{

		public CrimeAdapter(ArrayList<Crime> crimes)
		{
			super(getActivity(),0,crimes);
		}
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			if(convertView==null)
			{
				convertView=getActivity().getLayoutInflater().inflate(R.layout.list_item_crime, null);
			}
			Crime c=getItem(position);
			TextView titletTextView=(TextView)convertView.findViewById(R.id.crime_list_item_titleTextView);
			titletTextView.setText(c.getTittle());
			TextView dateTextView=(TextView)convertView.findViewById(R.id.crime_list_item_dateTextView);
			dateTextView.setText(c.getDate().toString());
			CheckBox solvedCheckBox=(CheckBox)convertView.findViewById(R.id.crime_list_item_solvedCheckBox);
			solvedCheckBox.setChecked(c.isSolved());
			
			return convertView;
		}
	}

}
