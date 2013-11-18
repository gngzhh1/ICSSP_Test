package com.activity.se_conference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import myViews.MyAgendaListAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class Agenda_Fragment extends Fragment {

	private TextView MondayTextView;
	// private TextView LocationTextView;
	private ListView agendaList;
	private boolean isMondayVisible = true;

	// private boolean isTuesdayVisble = false;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater
				.inflate(R.layout.agenda_fragment, container, false);
		MondayTextView = (TextView) view.findViewById(R.id.agenda_Mon);
		agendaList = (ListView) view.findViewById(R.id.agenda_List);
		agendaList.setAdapter(new MyAgendaListAdapter(getActivity(), getData()));

		MondayTextView.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (isMondayVisible) {
					agendaList.setVisibility(View.GONE);
					isMondayVisible = false;
				} else if (!isMondayVisible) {
					agendaList.setVisibility(View.VISIBLE);
					isMondayVisible = true;
				}
			}
		});

		return view;
	}

	private List<Map<String, Object>> getData() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("title", "开幕式");
		map.put("time", "08:00-09:00");
		map.put("address", "南京大学食堂1楼");
		map.put("isSelected", "0");
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("title", "会议1");
		map.put("time", "10:00-11:00");
		map.put("address", "南京大学食堂2楼");
		map.put("isSelected", "0");
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("title", "会议2");
		map.put("time", "14:00-16:00");
		map.put("address", "南京大学食堂3楼");
		map.put("isSelected", "0");
		list.add(map);

		return list;
	}
}