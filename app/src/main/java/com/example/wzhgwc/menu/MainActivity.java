package com.example.wzhgwc.menu;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.ContextMenu;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.TextView;
        import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView tv1;
    private int mcount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1=(TextView) findViewById(R.id.textView);
        registerForContextMenu(tv1);
        mcount=0;


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,1,0,R.string.m1);
        menu.add(0,1,0,R.string.m2);
        menu.add(0,1,0,R.string.m3);
        menu.add(0,mcount+3,0,"c"+mcount);
        return super.onCreateOptionsMenu(menu);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this,item.getTitle().toString(),Toast.LENGTH_LONG).show();
        return  super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        mcount++;
        menu.add(0,1,0,R.string.m1);
        menu.add(0,1,0,R.string.m2);
        menu.add(0,mcount+3,0,"context"+mcount);
        super.onCreateContextMenu(menu, v, menuInfo);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Toast.makeText(this,item.getTitle(),Toast.LENGTH_LONG).show();
        return super.onContextItemSelected(item);

    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        mcount++;
        menu.add(0,mcount+3,0,"p"+mcount);
        return super.onPrepareOptionsMenu(menu);
    }
}
