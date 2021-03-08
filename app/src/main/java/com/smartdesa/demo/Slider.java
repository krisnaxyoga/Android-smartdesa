package com.smartdesa.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.AdapterViewFlipper;
import android.widget.Toast;

import com.smartdesa.demo.API.APIRequestData;
import com.smartdesa.demo.API.RetroServer;
import com.smartdesa.demo.Adapter.AdapterSlider;
import com.smartdesa.demo.Model.slider.ModelSlider;
import com.smartdesa.demo.Model.slider.ResponseModelSlider;
import com.synnapps.carouselview.CarouselView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Slider extends AppCompatActivity {

    APIRequestData mApiInterface;
    private AdapterViewFlipper adapterViewFlipper;
    CarouselView carouselView;
//    SliderLayout sliderLayout;
//    private List<ModelSlider> listslider = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);

        mApiInterface = RetroServer.getClient().create(APIRequestData.class);
        adapterViewFlipper = findViewById(R.id.adapterViewFlipper);

        Call<ResponseModelSlider> call  = mApiInterface.getResponseModelSlider();

        call.enqueue(new Callback<ResponseModelSlider>() {
            @Override
            public void onResponse(Call<ResponseModelSlider> call, Response<ResponseModelSlider> response) {

                ArrayList<ModelSlider> listslider = response.body().getData();

                AdapterSlider adapterSlider = new AdapterSlider(getApplicationContext(),listslider);

                adapterViewFlipper.setAdapter(adapterSlider);
                adapterViewFlipper.setFlipInterval(3000);
                adapterViewFlipper.startFlipping();

            }

            @Override
            public void onFailure(Call<ResponseModelSlider> call, Throwable t) {
                Log.e("Retrofit Get Error", t.toString());
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
//        sliderviews();
//        sliderLayout = findViewById(R.id.slider);
//        sliderLayout.setIndicatorAnimation(SliderLayout.Animations.WORM);
//        sliderLayout.setScrollTimeInSec(1);

//        SliderView sliderView = new SliderView(this);
//        setSliderViews();

    }




//    public void sliderviews(){
//        Call<ResponseModelSlider> data = mApiInterface.getResponseModelSlider();
//        data.enqueue(new Callback<ResponseModelSlider>() {
//            @Override
//            public void onResponse(Call<ResponseModelSlider> call, Response<ResponseModelSlider> response) {
//
//                ArrayList<ModelSlider> listslider = response.body().getData();
//
//                AdapterSlider adapterSlider = new AdapterSlider(getApplicationContext(),listslider);
//
//                adapterViewFlipper.setAdapter(adapterSlider);
//                adapterViewFlipper.setFlipInterval(1000);
//                adapterViewFlipper.startFlipping();
//
//            }
//
//            @Override
//            public void onFailure(Call<ResponseModelSlider> call, Throwable t) {
//                Log.e("Retrofit Get Error", t.toString());
//                Toast.makeText(Slider.this,"Kesalahan Server", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }



//    public void setSliderViews() {
//        Call<ResponseModelSlider> data = mApiInterface.getResponseModelSlider();
//        data.enqueue(new Callback<ResponseModelSlider>() {
//            @Override
//            public void onResponse(Call<ResponseModelSlider> call, Response<ResponseModelSlider>
//                    response) {
//
//                    listslider = response.body().getData();
////                    ModelSlider listData = new ModelSlider(listslider.("gambar"));
////                    list_dataList.add(listData);
//                    setupdata(listslider);
//
////                    mAdapterPengumuman = new AdapterListPengumuman(ListPengumuman.this, listpengumuman);
////                    RecyclerPengumuman.setAdapter(mAdapterPengumuman);
////                    mAdapterPengumuman.notifyDataSetChanged();
//
//
//            }
//            @Override
//            public void onFailure(Call<ResponseModelSlider> call, Throwable t) {
//                Log.e("Retrofit Get Error", t.toString());
//                Toast.makeText(Slider.this,"Kesalahan Server", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//    private void setupdata(List<ModelSlider> listslider) {
//
//        for (int i = 0; i <= 4; i++) {
//            final ModelSlider ld = listslider.get(i);
//            SliderView sliderView = new SliderView(this);
//            sliderView.setImageUrl(ld.getGambar());
//
//            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
//            final int finalI = i;
//            sliderLayout.addSliderView(sliderView);
//
//        }
//    }

}