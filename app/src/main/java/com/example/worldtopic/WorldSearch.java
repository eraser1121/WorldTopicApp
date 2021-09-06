package com.example.worldtopic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class WorldSearch extends AppCompatActivity {
    static final String[] Grade = {"  1","  2","  3","  4","  5","  6","  7","  8","  9","  10"};
    ArrayList<String> Search1 = new ArrayList<String>();
    ArrayList<String> Search2 = new ArrayList<String>();
    ArrayList<String> Search3 = new ArrayList<String>();
    ArrayList<String> Search4 = new ArrayList<String>();
    ArrayList<String> Search5 = new ArrayList<String>();
    ArrayList<String> Search6 = new ArrayList<String>();

    class RealTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                int cnt1 = 0;
                int cnt2 = 0;
                int cnt3 = 0;
                int cnt4 = 0;
                int cnt5 = 0;
                int cnt6 = 0;

                Document doc1= Jsoup.connect("https://datalab.naver.com/keyword/realtimeList.naver").get();
                Elements els1=doc1.select(".ranking_list .ranking item");
                for(Element e1:els1) {
                    if (cnt1 < 10) {
                        Search1.add(e1.select(".item_box .item_title_wrap .item_title").text());
                        cnt1++;
                    }
                }
                Document doc2= Jsoup.connect("https://search.yahoo.co.jp/realtime").get();
                Elements els2=doc2.select(".Trend_container__2vkJ- ol li");
                for(Element e2:els2) {
                    if (cnt2 < 10) {
                        Search1.add(e2.select("a article h1 font").text());
                        cnt2++;
                    }
                }
                Document doc3= Jsoup.connect("https://s.weibo.com/top/summary?cate=homepage").get();
                Elements els3=doc3.select(".data table tbody");
                for(Element e3:els3) {
                    if (cnt3 < 10) {
                        Search1.add(e3.select("tr .td-02").text());
                        cnt3++;
                    }
                }
                Document doc4= Jsoup.connect("https://trends.google.co.kr/trends/trendingsearches/daily/rss?geo=US").get();
                Elements els4=doc4.select("item");
                for(Element e4:els4) {
                    if (cnt4 < 10) {
                        Search1.add(e4.select("title").text());
                        cnt4++;
                    }
                }
                Document doc5= Jsoup.connect("https://trends.google.co.kr/trends/trendingsearches/daily/rss?geo=FR").get();
                Elements els5=doc5.select("item");
                for(Element e5:els5) {
                    if (cnt5 < 10) {
                        Search1.add(e5.select("title").text());
                        cnt5++;
                    }
                }
                Document doc6= Jsoup.connect("https://trends.google.co.kr/trends/trendingsearches/daily/rss?geo=RU").get();
                Elements els6=doc6.select("item");
                for(Element e6:els6) {
                    if (cnt6 < 10) {
                        Search1.add(e6.select("title").text());
                        cnt6++;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_world_search);
        new RealTask().execute();
        ArrayAdapter adapter0 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, Grade);
        ArrayAdapter adapter1 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, Search1);
        ArrayAdapter adapter2 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, Search2);
        ArrayAdapter adapter3 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, Search3);
        ArrayAdapter adapter4 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, Search4);
        ArrayAdapter adapter5 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, Search5);
        ArrayAdapter adapter6 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, Search6);



        ListView listview1 = (ListView) findViewById(R.id.grade) ;
        listview1.setAdapter(adapter0);
        ListView listview2 = (ListView) findViewById(R.id.search) ;
        listview2.setAdapter(adapter1);

        listview2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {

                String strText = (String) parent.getItemAtPosition(position);
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.google.com/search?q="+strText));
                startActivity(intent);
            }
        }) ;

        Button btn1 = (Button) findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                listview2.setAdapter(adapter1);
            }
        });

        Button btn2 = (Button) findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                listview2.setAdapter(adapter2);
            }
        });
        Button btn3 = (Button) findViewById(R.id.button3);
        btn3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                listview2.setAdapter(adapter3);
            }
        });
        Button btn4 = (Button) findViewById(R.id.button4);
        btn4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                listview2.setAdapter(adapter4);
            }
        });
        Button btn5 = (Button) findViewById(R.id.button5);
        btn5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                listview2.setAdapter(adapter5);
            }
        });
        Button btn6 = (Button) findViewById(R.id.button6);
        btn6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                listview2.setAdapter(adapter6);
            }
        });
    }
}