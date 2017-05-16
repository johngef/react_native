package com.gefufeng.rndemo.views;

import android.widget.ImageView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;

/**
 * Created by gefufeng on 17/5/15.
 */

public class ReactImageManager extends SimpleViewManager<ImageView> {
    @Override
    public String getName() {
        return "NativeImageView";
    }

    @Override
    protected ImageView createViewInstance(ThemedReactContext reactContext) {
//        return new ImageView(reactContext, );
        return null;
    }
}
