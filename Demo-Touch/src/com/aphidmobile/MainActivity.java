package com.aphidmobile;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.aphidmobile.flip.FlipViewGroup;
import com.aphidmobile.fliptouch.R;

public class MainActivity extends Activity {
	private FlipViewGroup contentView;

	/**
	 * Called when the activity is first created.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		setTitle(R.string.activity_title);
		contentView = (FlipViewGroup)findViewById(R.id.flipview);

		
		contentView.addFlipView(View.inflate(this, R.layout.first_page, null));
		contentView.addFlipView(View.inflate(this, R.layout.second_page, null));
		contentView.addFlipView(View.inflate(this, R.layout.third_page, null));
		
		View fourth = View.inflate(this, R.layout.fourth_page, null);
		TextView textView1 = (TextView) fourth.findViewById(R.id.textView1);
		textView1.setText("[4] Noam Chomsky");
		TextView textView2 = (TextView) fourth.findViewById(R.id.textView2);
		textView2.setText("Noam Chomsky  is an American linguist, philosopher,[6][7] cognitive scientist, logician,[8][9] historian, political critic, and activist. He is an Institute Professor and Professor (Emeritus) in the Department of Linguistics & Philosophy at MIT, where he has worked for over 50 years.[10] In addition to his work in linguistics, he has written on war, politics, and mass media, and is the author of over 100 books.");
		contentView.addFlipView(fourth);
		

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent intent = new Intent(
			Intent.ACTION_VIEW, 
			Uri.parse("http://openaphid.github.com/blog/2012/05/21/how-to-implement-flipboard-animation-on-android/")
		);
		startActivity(intent);

		return true;
	}

	@Override
	protected void onResume() {
		super.onResume();
		contentView.onResume();
	}

	@Override
	protected void onPause() {
		super.onPause();
		contentView.onPause();
	}

}
