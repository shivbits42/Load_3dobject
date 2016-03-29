package com.example.shivanshudwivedi.load3dobject;

import android.content.Context;
import android.renderscript.BaseObj;
import android.view.MotionEvent;

import org.rajawali3d.Object3D;
import org.rajawali3d.lights.DirectionalLight;
import org.rajawali3d.loader.IParser;
import org.rajawali3d.loader.LoaderOBJ;
import org.rajawali3d.loader.ParsingException;
import org.rajawali3d.materials.textures.TextureManager;
import org.rajawali3d.renderer.RajawaliRenderer;
import org.xml.sax.Parser;

/**
 * Created by Shivanshu Dwivedi on 29-03-2016.
 */
public class Renderer  extends RajawaliRenderer{

    public Context context;
    private DirectionalLight directionalLight;
TextureManager textureManager;
    public Renderer(Context context) {
        super(context);
        this.context=context;
    }

    @Override
    protected void initScene() {


        directionalLight=new DirectionalLight(1f ,0.5f,-1.5f);
        directionalLight.setColor(.5f, .2f, .1f);
        directionalLight.setPower(2);


        LoaderOBJ parser=new LoaderOBJ(context.getResources(),textureManager,R.raw.saturn_obj);
        try {
            parser.parse();
            Object3D baseObj=parser.getParsedObject();
            getCurrentScene().addLight(directionalLight);
            getCurrentScene().addChild(baseObj);
        } catch (ParsingException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onOffsetsChanged(float xOffset, float yOffset, float xOffsetStep, float yOffsetStep, int xPixelOffset, int yPixelOffset) {

    }

    @Override
    public void onTouchEvent(MotionEvent event) {

    }
}
