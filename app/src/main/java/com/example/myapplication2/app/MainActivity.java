package com.example.myapplication2.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.HashMap;


public class MainActivity extends Activity implements BaseSliderView.OnSliderClickListener{


    private SliderLayout mDemoSlider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDemoSlider = (SliderLayout)findViewById(R.id.slider);

        HashMap<String,String> url_maps = new HashMap<String, String>();
        url_maps.put("Hannibal", "http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg");
        url_maps.put("Big Bang Theory", "http://tvfiles.alphacoders.com/100/hdclearart-10.png");
        url_maps.put("House of Cards", "http://cdn3.nflximg.net/images/3093/2043093.jpg");
        url_maps.put("Game of Thrones", "http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");

        for(String name : url_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(url_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.getBundle()
                    .putString("extra",name);

            mDemoSlider.addSlider(textSliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.CubeIn);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);





    }

    @Override
    public void onSliderClick(BaseSliderView baseSliderView) {
        Toast.makeText(this,baseSliderView.getBundle().get("extra") + "",Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.setting_Background2Foreground:
                mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Background2Foreground);
                break;
            case R.id.setting_Accordion:
                mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
                break;
            case R.id.setting_FlipPage:
                mDemoSlider.setPresetTransformer(SliderLayout.Transformer.FlipPage);
                break;

            case R.id.setting_CubeIn:
                mDemoSlider.setPresetTransformer(SliderLayout.Transformer.CubeIn);
                break;

            case R.id.setting_Default:
                mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Default);
                break;

            case R.id.setting_DepthPage:
                mDemoSlider.setPresetTransformer(SliderLayout.Transformer.DepthPage);
                break;

            case R.id.setting_Fade:
                mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Fade);
                break;

            case R.id.setting_FlipHorizontal:
                mDemoSlider.setPresetTransformer(SliderLayout.Transformer.FlipHorizontal);
                break;

            case R.id.setting_RotateDown:
                mDemoSlider.setPresetTransformer(SliderLayout.Transformer.RotateDown);
                break;
            case R.id.setting_RotateUp:
                mDemoSlider.setPresetTransformer(SliderLayout.Transformer.RotateUp);
                break;

            case R.id.setting_Stack:
                mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Stack);
                break;

            case R.id.setting_ZoomOut:
                mDemoSlider.setPresetTransformer(SliderLayout.Transformer.ZoomOut);
                break;

            case R.id.setting_ZoomOutSlide:
                mDemoSlider.setPresetTransformer(SliderLayout.Transformer.ZoomOutSlide);
                break;

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
