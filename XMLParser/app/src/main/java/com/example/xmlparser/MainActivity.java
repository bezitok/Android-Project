package com.example.xmlparser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.xmlparser.Adapter.CustomAdapter;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    InputStream inputStream;
    List<BaiViet> baiVietList;
    BaiViet baiViet;
    String noidung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);
        baiVietList = new ArrayList<>();

        GetDataXML();

        CustomAdapter customAdapter = new CustomAdapter(MainActivity.this, R.layout.custom_listview, baiVietList);
        listView.setAdapter(customAdapter);

    }

    public void GetDataXML(){

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    URL url = new URL("https://vietnamnet.vn/rss/the-thao.rss");
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.connect();

                    inputStream = httpURLConnection.getInputStream();
//                    InputStreamReader reader = new InputStreamReader(inputStream);
//                    BufferedReader bufferedReader = new BufferedReader(reader);
//
//                    StringBuilder builder = new StringBuilder();
//                    String line = "";
//
//                    while ((line = bufferedReader.readLine()) != null){
//                        builder.append(line);
//                    }
//
//                    Log.d("Dữ liệu: ", builder.toString());

                    XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                    XmlPullParser xmlPullParser = factory.newPullParser();
                    xmlPullParser.setInput(inputStream, null);

                    int events = xmlPullParser.getEventType();

                    while (events != XmlPullParser.END_DOCUMENT){
                        switch (events){
                            case XmlPullParser.START_TAG:
                                String themo = xmlPullParser.getName();
                                Log.d("kiemtra", themo);
                                if(themo.equals("item")){
                                    baiViet = new BaiViet();
                                }

                                break;
                            case XmlPullParser.TEXT:
                                noidung = xmlPullParser.getText();

                                break;
                            case XmlPullParser.END_TAG:
                                String thedong = xmlPullParser.getName();
                                if(thedong.equals("title") && baiViet != null){
                                    baiViet.setTitle(noidung);
                                }else if(thedong.equals("description") && baiViet != null){
                                    baiViet.setDescription(noidung);
                                }else if(thedong.equals("link") && baiViet != null){
                                    baiViet.setLink(noidung);
                                }else if(thedong.equals("pubupdate") && baiViet != null){
                                    baiViet.setPubdate(noidung);
                                }else if(thedong.equals("image") && baiViet != null){
                                    baiViet.setImage(noidung);
                                }else if(thedong.equals("item") && baiViet != null){
                                    baiVietList.add(baiViet);
                                }
                                break;
                        }
                        events = xmlPullParser.next();
                    }

                    for(int i=0; i<baiVietList.size(); i++){
                        Log.d("DATA", baiVietList.get(i).getTitle());
                    }

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (XmlPullParserException e) {
                    e.printStackTrace();
                }

            }
        });

        thread.start();
    }
}
