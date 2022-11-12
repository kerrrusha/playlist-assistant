package com.kerrrusha.playlistassistant.task_manager.task;

import com.kerrrusha.playlistassistant.sound_parser.data.SoundDataCachingService;
import org.apache.log4j.Logger;

import java.io.IOException;

public class DataCachingTask extends AbstractTask {

	private static final Logger logger = Logger.getLogger(DataCachingTask.class);

	@Override
	public void run() {
		logger.info("DataCaching task is started.");

		try {
			new SoundDataCachingService().requestAll();
		} catch (IOException e) {
			logger.error(e.getMessage());
		}

		logger.info("DataCaching task finished.");
	}
}
