package com.kerrrusha.playlistassistant.task_manager.task;

import com.kerrrusha.playlistassistant.sound_parser.data.SoundDataImportingService;
import org.apache.log4j.Logger;

public class SoundDataImportingTask extends AbstractTask {

	private static final Logger logger = Logger.getLogger(SoundDataImportingTask.class);

	@Override
	public void run() {
		logger.info("DataCaching task is started.");

		new SoundDataImportingService().importAll();

		logger.info("DataCaching task finished.");
	}
}
