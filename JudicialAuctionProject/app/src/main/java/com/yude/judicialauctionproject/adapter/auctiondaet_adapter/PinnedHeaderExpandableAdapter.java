package com.yude.judicialauctionproject.adapter.auctiondaet_adapter;

import android.content.Context;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.yude.judicialauctionproject.R;
import com.yude.judicialauctionproject.views.view.PinnedHeaderExpandableListView;


public class PinnedHeaderExpandableAdapter extends BaseExpandableListAdapter implements PinnedHeaderExpandableListView.HeaderAdapter {
	private String[][] childrenData;
	private String[] groupData;
	private Context context;
	private PinnedHeaderExpandableListView listView;
	private LayoutInflater inflater;
	
	public PinnedHeaderExpandableAdapter(String[][] childrenData, String[] groupData
			, Context context, PinnedHeaderExpandableListView listView){
		this.groupData = groupData; 
		this.childrenData = childrenData;
		this.context = context;
		this.listView = listView;
		inflater = LayoutInflater.from(this.context);
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		return childrenData[groupPosition][childPosition];
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return 0;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition,
							 boolean isLastChild, View convertView, ViewGroup parent) {
		View view = null;
        if (convertView != null) {  
            view = convertView;  
        } else {  
            view = createChildrenView();  
        }

/*

		// 总
		TextView t_sun_tv = (TextView)view.findViewById(R.id.t_sun_tv);
		TextView t_sun2_tv = (TextView)view.findViewById(R.id.t_sun2_tv);
		TextView t_sun3_tv = (TextView)view.findViewById(R.id.t_sun3_tv);
		TextView t_sun4_tv = (TextView)view.findViewById(R.id.t_sun4_tv);
		TextView t_sun5_tv = (TextView)view.findViewById(R.id.t_sun5_tv);

		t_sun_tv.setText(childrenData[groupPosition][childPosition]);
		t_sun_tv.setText(childrenData[groupPosition][childPosition]);
		t_sun_tv.setText(childrenData[groupPosition][childPosition]);
		t_sun_tv.setText(childrenData[groupPosition][childPosition]);
		t_sun_tv.setText(childrenData[groupPosition][childPosition]);
		// 成交量
		TextView t_fix_tv = (TextView)view.findViewById(R.id.t_fix_tv);
		TextView t_fix2_tv = (TextView)view.findViewById(R.id.t_fix2_tv);
		TextView t_fix3_tv = (TextView)view.findViewById(R.id.t_fix3_tv);
		TextView t_fix4_tv = (TextView)view.findViewById(R.id.t_fix4_tv);
		TextView t_fix5_tv = (TextView)view.findViewById(R.id.t_fix5_tv);

		t_fix_tv.setText(childrenData[groupPosition][childPosition]);
		t_fix_tv.setText(childrenData[groupPosition][childPosition]);
		t_fix_tv.setText(childrenData[groupPosition][childPosition]);
		t_fix_tv.setText(childrenData[groupPosition][childPosition]);
		t_fix_tv.setText(childrenData[groupPosition][childPosition]);

		// 价格
		TextView t_money_tv = (TextView)view.findViewById(R.id.t_money_tv);
		TextView t_money2_tv = (TextView)view.findViewById(R.id.t_money2_tv);
		TextView t_money3_tv = (TextView)view.findViewById(R.id.t_money3_tv);
		TextView t_money4_tv = (TextView)view.findViewById(R.id.t_money4_tv);
		TextView t_money5_tv = (TextView)view.findViewById(R.id.t_money5_tv);

		t_money_tv.setText(childrenData[groupPosition][childPosition]);
		t_money_tv.setText(childrenData[groupPosition][childPosition]);
		t_money_tv.setText(childrenData[groupPosition][childPosition]);
		t_money_tv.setText(childrenData[groupPosition][childPosition]);
		t_money_tv.setText(childrenData[groupPosition][childPosition]);


		//  成交率
		TextView t_proportion_tv = (TextView)view.findViewById(R.id.t_proportion_tv);
		TextView t_proportion2_tv = (TextView)view.findViewById(R.id.t_proportion2_tv);
		TextView t_proportion3_tv = (TextView)view.findViewById(R.id.t_proportion3_tv);
		TextView t_proportion4_tv = (TextView)view.findViewById(R.id.t_proportion4_tv);
		TextView t_proportion5_tv = (TextView)view.findViewById(R.id.t_proportion5_tv);

		t_proportion_tv.setText(childrenData[groupPosition][childPosition]);
		t_proportion_tv.setText(childrenData[groupPosition][childPosition]);
		t_proportion_tv.setText(childrenData[groupPosition][childPosition]);
		t_proportion_tv.setText(childrenData[groupPosition][childPosition]);
		t_proportion_tv.setText(childrenData[groupPosition][childPosition]);


*/


		return view;
	}


	@Override
	public int getChildrenCount(int groupPosition) {
		return childrenData[groupPosition].length;
	}

	@Override
	public Object getGroup(int groupPosition) {
		return groupData[groupPosition];
	}

	@Override
	public int getGroupCount() {
		return groupData.length;
	}

	@Override
	public long getGroupId(int groupPosition) {
		return 0;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
							 View convertView, ViewGroup parent) {
		View view = null;
        if (convertView != null) {  
            view = convertView;  
        } else {  
            view = createGroupView();  
        } 
        
        ImageView iv = (ImageView)view.findViewById(R.id.groupIcon);
		
		if (isExpanded) {
			iv.setImageResource(R.mipmap.h_z_browser);
		}
		else{
			iv.setImageResource(R.mipmap.h_h_browser);
		}


		//设置外层
        TextView groupto_tv = (TextView)view.findViewById(R.id.groupto_tv);
		groupto_tv.setText(groupData[groupPosition]);

		TextView unmber_tv = (TextView)view.findViewById(R.id.unmber_tv);
		//unmber_tv.setText(groupData[groupPosition]);


        return view;  
	}

	@Override
	public boolean hasStableIds() {
		return true;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return true;
	}
	
	private View createChildrenView() {
		return inflater.inflate(R.layout.child, null);
	}
	
	private View createGroupView() {
		return inflater.inflate(R.layout.group, null);
	}

	@Override
	public int getHeaderState(int groupPosition, int childPosition) {
		final int childCount = getChildrenCount(groupPosition);
		if (childPosition == childCount - 1) {
			return PINNED_HEADER_PUSHED_UP;
		} else if (childPosition == -1
				&& !listView.isGroupExpanded(groupPosition)) {
			return PINNED_HEADER_GONE;
		} else {
			return PINNED_HEADER_VISIBLE;
		}
	}

	@Override
	public void configureHeader(View header, int groupPosition,
								int childPosition, int alpha) {
		String groupData =  this.groupData[groupPosition];
		((TextView) header.findViewById(R.id.groupto)).setText(groupData);
		
	}
	
	private SparseIntArray groupStatusMap = new SparseIntArray();
	
	@Override
	public void setGroupClickStatus(int groupPosition, int status) {
		groupStatusMap.put(groupPosition, status);
	}

	@Override
	public int getGroupClickStatus(int groupPosition) {
		if (groupStatusMap.keyAt(groupPosition)>=0) {
			return groupStatusMap.get(groupPosition);
		} else {
			return 0;
		}
	}
}
