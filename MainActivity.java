package com.example.martinee.blockuiapp;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.TextView;


public class MainActivity extends Activity {
    private BlockUI ui;
    private TextView tvRes;
    private BlockControl bc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        ui = (com.example.martinee.blockuiapp.BlockUI)findViewById(R.id.bui);
        tvRes = (TextView)findViewById(R.id.tvRes);
        new BlockControl(this,ui);
//        com.example.martinee.blockuiapp.BlockUI v=(com.example.martinee.blockuiapp.BlockUI) findViewById(R.id.bui);
        ui.setOnTouchListener(ui.ma);
//        bc.init();
//        bc.init();
//        BlockControl.init();
//        setContentView(BlockUI);

    }

    public void setText(final String txt) {
        runOnUiThread(new Runnable() {
            public void run() {

                tvRes.setText(txt);
            }
        });
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
}
