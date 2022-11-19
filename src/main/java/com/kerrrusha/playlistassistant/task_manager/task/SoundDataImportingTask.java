package com.kerrrusha.playlistassistant.task_manager.task;

import com.kerrrusha.playlistassistant.sound_parser.data.SoundDataImportingService;

public class SoundDataImportingTask extends AbstractTask {

	@Override
	public void run() {
		new SoundDataImportingService().importAll();
	}
}
