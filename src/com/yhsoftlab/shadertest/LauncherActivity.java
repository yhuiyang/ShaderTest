package com.yhsoftlab.shadertest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class LauncherActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.startActivity(new Intent(this, SpriteShaderProgramActivity.class));
		this.finish();
	}
}
