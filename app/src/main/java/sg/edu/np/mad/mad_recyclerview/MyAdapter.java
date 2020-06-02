package sg.edu.np.mad.mad_recyclerview;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    ArrayList<String> data;
    private Context maincontext;
    public MyAdapter(ArrayList<String> input,Context context){
    data = input;
    maincontext = context;
    }

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
    View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.todolist,parent,false);
    return new MyViewHolder(item);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
    final String s = data.get(position);
    holder.txtB.setText(s);

    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            AlertDialog.Builder dialogbox = new AlertDialog.Builder(maincontext);
            View main = LayoutInflater.from(maincontext).inflate(R.layout.delete,null);
            dialogbox.setTitle("Delete");
            dialogbox.setView(main);
            dialogbox.setMessage("Are you sure you want to delete " + s + "?");
            dialogbox.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    data.remove(holder.getLayoutPosition());
                    notifyDataSetChanged();
                }
            });
            dialogbox.setNegativeButton("No",new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            AlertDialog alert = dialogbox.create();
            alert.show();
        }
    });


    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
