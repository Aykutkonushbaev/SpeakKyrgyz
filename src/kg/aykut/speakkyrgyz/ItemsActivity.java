package kg.aykut.speakkyrgyz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.List;
import kg.aykut.speakkyrgyz.R;


public class ItemsActivity extends Activity {

    private SKDataSource dataSource;
    private ListView listViewItems;
    private TextView textView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.items);

        dataSource = new SKDataSource(this);
        dataSource.open();
        final Intent intent = getIntent();
        final long id = intent.getLongExtra(DatabaseHelper.COLUMN_GROUP_ID, 0);
        List<ItemsModel> itemsModels = dataSource.getItemsByGroup(id);

        listViewItems = (ListView) findViewById(R.id.listViewItems);
        textView = (TextView) findViewById(R.id.textView1);
        textView.setText(intent.getStringExtra(DatabaseHelper.COLUMN_NAME));

        final ArrayAdapter<ItemsModel> adapter = new ArrayAdapter<ItemsModel>(this, android.R.layout.simple_list_item_1, itemsModels);
        listViewItems.setAdapter(adapter);
        
        listViewItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
                ItemsModel group = (ItemsModel) adapterView.getItemAtPosition(position);
                intent.putExtra(DatabaseHelper.COLUMN_TRANSLATION, group.getTranslation());
                intent.putExtra(DatabaseHelper.COLUMN_TRANSCRIPT, group.getTranscript());
                intent.putExtra(DatabaseHelper.COLUMN_AUDIO, group.getAudio());
                intent.setAction(intent.ACTION_VIEW);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        dataSource.open();
        super.onResume();
    }

    @Override
    protected void onPause() {
        dataSource.close();
        super.onPause();
    }

}