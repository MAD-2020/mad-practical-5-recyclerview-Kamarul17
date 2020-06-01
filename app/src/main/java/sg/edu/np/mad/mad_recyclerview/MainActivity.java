package sg.edu.np.mad.mad_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> todolist = new ArrayList<>();
    private EditText aTodo;
    private Button bAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aTodo = findViewById(R.id.addTodo);
        bAdd = findViewById(R.id.butAdd);

        todolist.add("Buy Milk");
        todolist.add("Send Postage");
        todolist.add("Buy Android Development Book");


        RecyclerView recyclerView = findViewById(R.id.todoView);
        final MyAdapter mAdapter = new MyAdapter(todolist, this);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        bAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                todolist.add(aTodo.getText().toString());
                mAdapter.notifyDataSetChanged();
                aTodo.setText("");
            }
        });
    }
    /**
     * Upon calling this method, the keyboard will retract
     * and the recyclerview will scroll to the last item
     *
     * @param rv RecyclerView for scrolling to
     * @param data ArrayList that was passed into RecyclerView
     */
        private void showNewEntry(RecyclerView rv, ArrayList data){
            //scroll to the last item of the recyclerview
            rv.scrollToPosition(data.size() - 1);

            //auto hide keyboard after entry
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(rv.getWindowToken(), 0);
        }
    }

