package wrs.WARES.TestsWares;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.WARES.tests.R;


public class PcihoFragment extends Fragment {

    ListView listView;
    String[] namesOfTests;
    String[] namesOfTests2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        listView = (ListView) inflater.inflate(R.layout.fragment_pciho, container, false);

        Adapter adapter = new Adapter(getActivity(), namesOfTests, namesOfTests2);
        listView.setAdapter(adapter);

        final Intent intent = new Intent(getContext(), ExplanationForTest.class);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        intent.putExtra("test", 15);
                        startActivity(intent);
                        return;
                    case 1:
                        intent.putExtra("test", 16);
                        startActivity(intent);
                        return;
                    case 2:
                        intent.putExtra("test", 17);
                        startActivity(intent);
                        return;
                    case 3:
                        intent.putExtra("test", 18);
                        startActivity(intent);
                        return;
                    case 4:
                        intent.putExtra("test", 19);
                        startActivity(intent);
                        return;
                    case 5:
                        intent.putExtra("test", 20);
                        startActivity(intent);
                        return;
                    case 6:
                        intent.putExtra("test", 21);
                        startActivity(intent);
                        return;
                    case 7:
                        intent.putExtra("test", 22);
                        startActivity(intent);
                        return;
                    case 8:
                        intent.putExtra("test", 23);
                        startActivity(intent);
                        return;
                    case 9:
                        intent.putExtra("test", 24);
                        startActivity(intent);
                        return;
                    case 10:
                        intent.putExtra("test", 25);
                        startActivity(intent);
                        return;
                }
            }
        });

        return listView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        namesOfTests = getResources().getStringArray(R.array.pcihonamesforex);
        namesOfTests2 = getResources().getStringArray(R.array.pcihonames2forex);
    }

    static class Adapter extends ArrayAdapter<String> {
        Context context;
        String namesOfTests[];
        String namesOfTests2[];

        Adapter(Context c, String names[], String names2[]) {
            super(c, R.layout.row, R.id.text_view, names);
            this.context = c;
            this.namesOfTests = names;
            this.namesOfTests2 = names2;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            TextView text = row.findViewById(R.id.text_view);
            text.setText(namesOfTests[position]);
            TextView text2 = row.findViewById(R.id.text_view2);
            text2.setText(namesOfTests2[position]);

            return row;
        }
    }
}
