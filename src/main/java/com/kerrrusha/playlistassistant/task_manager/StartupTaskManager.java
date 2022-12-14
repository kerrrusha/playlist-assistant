package com.kerrrusha.playlistassistant.task_manager;

import com.kerrrusha.playlistassistant.sound_parser.data.SoundDataProvider;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class StartupTaskManager implements ServletContextListener {

	private ScheduledExecutorService scheduler;

	@Override
	public void contextInitialized(ServletContextEvent event) {
		scheduler = Executors.newSingleThreadScheduledExecutor();
		//scheduler.scheduleAtFixedRate(new SoundDataImportingTask(), 0, 1, TimeUnit.DAYS);

		SoundDataProvider.getInstance();
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		scheduler.shutdownNow();
	}
}
