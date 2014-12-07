package t5.androidcourse.menus;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MenusActivity extends Activity {

    private TextView tvMessage;
    private int colorSelected = -1;
    private final int toastGravity = Gravity.TOP|Gravity.CENTER_HORIZONTAL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menus);

        tvMessage = (TextView) findViewById(R.id.tvMessage);
        registerForContextMenu(tvMessage);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        boolean returnValue = true;

        switch(item.getItemId()) {
            case R.id.ctop_red:
                tvMessage.setTextColor(Color.RED);
                colorSelected = 0;
                break;
            case R.id.ctop_green:
                tvMessage.setTextColor(Color.GREEN);
                colorSelected = 1;
                break;
            case R.id.ctop_blue:
                tvMessage.setTextColor(Color.BLUE);
                colorSelected = 2;
                break;
            default:
                returnValue = super.onContextItemSelected(item);
                break;
        }
        item.setChecked(true);
        return returnValue;

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v.getId() == this.tvMessage.getId()) {
            getMenuInflater().inflate(R.menu.context_menu, menu);
            if (colorSelected >= 0) menu.getItem(colorSelected).setChecked(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean returnValue = true;
        switch (item.getItemId()) {
            case R.id.option_welcome:
                toastFormat("Option Welcome selected");
                break;
            case R.id.option_about:
                toastFormat("Option About selected");
                break;
            case R.id.option_options:
                toastFormat("Option Options selected");
                break;
            case R.id.option_options_theme:
                toastFormat("Option Options->Theme selected");
                break;
            case R.id.option_options_sound:
                toastFormat("Option Options->Sound selected");
                break;
            case R.id.option_exit:
                toastFormat("Option Exit selected");
                break;
            default:
                returnValue = super.onOptionsItemSelected(item);
                break;
        }
        return returnValue;
    }

    private void toastFormat(String string){
        Toast toast = Toast.makeText(this, string, Toast.LENGTH_SHORT);
        toast.setGravity(toastGravity, 0, 100);
        toast.show();
    }
}
