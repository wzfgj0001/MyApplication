package servicetest.zkk.com.myapplication.ListExa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import servicetest.zkk.com.myapplication.R;

/**
 * Function:<br>
 * <p/>
 * date: 2017/2/20.
 *
 * @author GuJian
 */
public class ViewHolderAdapter extends BaseAdapter{
    private List<String> mData;
    private LayoutInflater mInflater;
    public ViewHolderAdapter(Context context,List<String> mData){
        this.mData = mData;
        mInflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView==null){
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.viewholder_item_layout,null);
            holder.mTextView = (TextView) convertView.findViewById(R.id.text_tv);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        holder.mTextView.setText(mData.get(position));
        return convertView;
    }

    public final  class ViewHolder{
        TextView mTextView;
    }

//    @Override
//    public int getItemViewType(int position) {
//        return super.getItemViewType(position);
//    }
}
