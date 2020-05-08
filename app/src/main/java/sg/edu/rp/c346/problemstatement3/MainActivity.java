package sg.edu.rp.c346.problemstatement3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int requestCodeForModuleInfo = 1;
    ListView lv;
    ArrayAdapter aa;
    ArrayList<modules> mods;
    ArrayList<String> dg1;
    ArrayList<String> dg2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = this.findViewById(R.id.ListViewModules);

        mods = new ArrayList<>();
        dg1 = new ArrayList<>();
        dg2 = new ArrayList<>();

        dg1.add("B");
        dg1.add("C");
        dg1.add("A");
        dg2.add("A");
        dg2.add("B");
        dg2.add("C");
        mods.add(new modules("Web Services", "C203", dg1, "jason_lim@rp.edu.sg"));
        mods.add(new modules("Android Programming II", "C347", dg2, "jason_lim@rp.edu.sg"));

        aa = new CustomAdapterFront(this, R.layout.row, mods);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MainActivity.this, Info.class);
                i.putExtra("module", mods.get(position));
                startActivityForResult(i, requestCodeForModuleInfo);
            }
        });

    }
}
