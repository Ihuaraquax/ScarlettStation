package com.scarlett.game.html;

import com.scarlett.game.core.ScarlettStationGame;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;

public class ScarlettStationGameHtml extends GwtApplication {
	@Override
	public ApplicationListener getApplicationListener () {
		return new ScarlettStationGame();
	}
	
	@Override
	public GwtApplicationConfiguration getConfig () {
		return new GwtApplicationConfiguration(480, 320);
	}
}
