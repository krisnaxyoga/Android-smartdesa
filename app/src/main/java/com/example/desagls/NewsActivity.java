package com.example.desagls;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.desagls.Util.AppController;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class NewsActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;
    List<ModelNews> mItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        mRecyclerView = findViewById(R.id.recycle_view);
        mItems = new ArrayList<>();

        select_news();

        layoutManager = new LinearLayoutManager(NewsActivity.this, LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new AdapterData(NewsActivity.this,mItems);
        mRecyclerView.setAdapter(mAdapter);

    }

    private void select_news(){

        StringRequest selectNews = new StringRequest(Request.Method.POST, ServerAPI.URL_TAMPIL_BERITA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("volley","response :  "+response.toString());

                        for(int i = 0; i<response.length(); i++){
                            try {
                                JSONArray array = new JSONArray(response);
                                JSONObject data = array.getJSONObject(i);

                                ModelNews md = new ModelNews();
                                md.setJudul(data.getString("judul"));
                                md.setTanggal(data.getString("created_at"));
                                md.setKategori(data.getString("kategori_artikel_id"));
                                md.setTeks(data.getString("konten"));
                                mItems.add(md);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        mAdapter.notifyDataSetChanged();

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("volley", "error :  "+error.getMessage());
                        Toast.makeText(NewsActivity.this, "Gagal Memuat", Toast.LENGTH_SHORT).show();

                    }
                }){
//            @Override
//            protected Map<String, String> getParams(){
//                Map<String, String> params = new HashMap<String, String>();
//                params.put("username",kode);
//                return params;
//            }
        };
        AppController.getInstance().addToRequestQueue(selectNews);
    }
}
