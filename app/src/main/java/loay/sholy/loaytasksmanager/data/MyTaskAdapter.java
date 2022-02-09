package loay.sholy.loaytasksmanager.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import loay.sholy.loaytasksmanager.R;

public class MyTaskAdapter extends ArrayAdapter<MyTask>// هو الوسيط بين مصدر المعطيات وعرضها على الشاشة وهي عبارة عم فئة وارثة لفئة من نوع Adapter
{

    public MyTaskAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    @NonNull
    @Override
    /**
     * ملائمة المعطى وطريقة عرضه
     * @param position رقم المعطى
     * @param converView
     * @param parent
     * @return     رقمه تعيد واجهة عرض لمعطى واحد حسب
     */
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //View v=View.inflate(getContext(),R.layout.task_item_layout,parent);
        View v= LayoutInflater.from(getContext()).inflate(R.layout.task_item_layout,parent,false);
        // استخراج المعطى حسب رقمه
        MyTask item= getItem(position);
        // تجهيز مؤشر لكل كائن على الواجهة
        TextView title=v.findViewById(R.id.itmTaskTitle);
        TextView subj=v.findViewById(R.id.itmTaskSubject);
        ImageButton btnDel=v.findViewById(R.id.itmBtnDel);
        ImageButton btncall=v.findViewById(R.id.itmBtnCall);
        ImageButton btnEdit=v.findViewById(R.id.itmBtnEdit);
        RatingBar rbNecessity=v.findViewById(R.id.itmRtNecessity);
        // وضع قيم المعطى المستخرج على كائنات الواجهة
        title.setText(item.getTitle());
        subj.setText(item.getSubject());
        rbNecessity.setRating(5*(item.getImportant()/(float)10));


        return v;

    }
}
