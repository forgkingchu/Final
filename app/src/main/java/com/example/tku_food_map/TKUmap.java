package com.example.tku_food_map;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import java.util.ArrayList;

public class TKUmap extends AppCompatActivity implements OnMapReadyCallback {

    private MapView mMapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tkumap);

        mMapView = (MapView) findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);
        mMapView.getMapAsync(this);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        ArrayList<MyAdapter.Post> data = new ArrayList<>();
        data.add(new MyAdapter.Post("吃乎意料","地址:新北市淡水區北新路182巷21弄13號","營業時間：11:00–14:30、16:00–20:00，週六公休","義大利麵"));
        data.add(new MyAdapter.Post("椒麻雞大王","地址：新北市淡水區北新路182巷5弄31號","營業時間：11:00–20:30，週日公休。","便當"));
        data.add(new MyAdapter.Post("大吉祥香豆富","地址：新北市淡水區學府路171號","營業時間：週一至週日 11:00–20:00","臭豆腐"));
        data.add(new MyAdapter.Post("源味滷肉飯","地址：新北市淡水區北新路147號","營業時間：06:00–22:00，週六、日公休","米飯"));
        data.add(new MyAdapter.Post("淡大手工蒸餃","地址：新北市淡水區學府路211-9號","營業時間：11:30–14:00, 17:00–20:00，週日公休","蒸餃"));
        data.add(new MyAdapter.Post("4F小飯館","地址：新北市淡水區北新路182巷32號2F","營業時間：11:30–15:00, 17:00–22:00，週一、二公休","義大利麵"));
        data.add(new MyAdapter.Post("迦南餐廳","新北市淡水區水源街二段92巷5弄6號B1","營業時間：06:00–22:00，週六、日公休","米飯"));
        data.add(new MyAdapter.Post("Buona Pasta","地址：新北市淡水區北新路184巷142弄9號","營業時間：週一至週日 11:30–14:30, 17:00–21:00","義大利麵"));
        data.add(new MyAdapter.Post("FiFi Natural 手工義式香草漢堡","地址：新北市淡水區北新路184巷246號","營業時間：06:00–22:00，週六、日公休","漢堡"));
        data.add(new MyAdapter.Post(" . "," ."," ."," ."));

        MyAdapter adapter = new MyAdapter(this, data);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap.getUiSettings().setZoomControlsEnabled(true);

        LatLng start = new LatLng(25.17720019131368, 121.4484408);
        googleMap.addMarker(new MarkerOptions().position(start).title("吃呼意料"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(start));
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(16));

        googleMap.addMarker(new MarkerOptions().position(new LatLng(25.17720019131368, 121.4484408)).title("吃呼意料"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(25.177371374946482, 121.44945736860184)).title("椒麻雞大王"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(25.17453311861919, 121.44626519743811)).title("大吉祥香豆富"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(25.179272309556396, 121.44959756860189)).title("源味滷肉飯"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(25.176566605104185, 121.44688349743814)).title("淡大手工蒸餃"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(25.178043130927467, 121.44873172627466)).title("4F小飯館"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(25.17751854368279, 121.44983675708568)).title("迦南餐廳"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(25.177249321677024, 121.45106189331852)).title("Buona Pasta"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(25.17713115600719, 121.45174206376267)).title("FiFi Natural 手工義式香草漢堡"));
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    protected void onPause() {
        mMapView.onPause();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        mMapView.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mMapView.onSaveInstanceState(outState);
    }

}


