package sg.edu.np.mad.mad_recyclerview;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder{
    TextView txtB;
    CheckBox chkB;
    public MyViewHolder(View itemView){
        super(itemView);
        txtB = itemView.findViewById(R.id.textTodo);// android.R.id vs R.id
        chkB = itemView.findViewById(R.id.cbTodo);
    }
}
