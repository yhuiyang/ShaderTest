package com.yhsoftlab.shadertest;

import java.io.IOException;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.FillResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.util.FPSLogger;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.ui.activity.SimpleBaseGameActivity;
import org.andengine.util.adt.color.Color;

public class SpriteShaderProgramActivity extends SimpleBaseGameActivity {

	// ===========================================================
	// Constants
	// ===========================================================
	private final int CAMERA_WIDTH = 800;
	private final int CAMERA_HEIGHT = 480;

	// ===========================================================
	// Fields
	// ===========================================================
	private Camera mCamera;
	private ITextureRegion mTextureRegion;

	// ===========================================================
	// Constructors
	// ===========================================================

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================
	@Override
	public EngineOptions onCreateEngineOptions() {
		mCamera = new Camera(-0.5f * CAMERA_WIDTH, -0.5f * CAMERA_HEIGHT,
				CAMERA_WIDTH, CAMERA_HEIGHT);
		EngineOptions engOpts = new EngineOptions(true,
				ScreenOrientation.LANDSCAPE_FIXED, new FillResolutionPolicy(),
				mCamera);
		return engOpts;
	}

	@Override
	protected void onCreateResources() throws IOException {
		BitmapTextureAtlas texture = new BitmapTextureAtlas(
				this.getTextureManager(), 1024, 1024);
		mTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(texture, getAssets(), "candy/bean.png", 0, 0);
		texture.load();
	}

	@Override
	protected Scene onCreateScene() {
		Scene scene = new Scene();
		scene.getBackground().setColor(Color.GREEN);
		FlashSprite sprite = new FlashSprite(0, 0, mTextureRegion,
				this.getVertexBufferObjectManager());
		scene.attachChild(sprite);
		scene.registerTouchArea(sprite);
		this.getEngine().registerUpdateHandler(new FPSLogger());
		return scene;
	}

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}
