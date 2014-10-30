NicePicPlay
===========

from daimajia/AndroidImageSlider

第一步：
Gradle添加

dependencies {
    compile "com.android.support:support-v4:+"
    compile 'com.squareup.picasso:picasso:2.3.2'
    compile 'com.nineoldandroids:library:2.4.0'
    compile 'com.daimajia.slider:library:1.1.0@aar'
}

第二步：
权限添加

    <!-- if you want to load images from the internet -->
    <uses-permission android:name="android.permission.INTERNET" />

    <!-- if you want to load images from a file OR from the internet -->
    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />

第三步：
代码sample

	<com.daimajia.slider.library.SliderLayout
        android:id="@+id/slider"
        android:layout_width="match_parent"
        android:layout_height="200dp"
        />

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
