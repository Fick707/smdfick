package com.fick.smd.swing;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Example extends Applet {
	JButton play, loop, stop;
	AudioClip audio = null;

	@Override
	public void init() {
		resize(200, 30);
		play = new JButton("Play");
		loop = new JButton("Loop");
		stop = new JButton("Stop");
		stop.setEnabled(false);
		audio = getAudioClip(getCodeBase(), "music.wav");
		add(play);
		add(loop);
		add(stop);
		play.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				playActionPerformed(e);
			}
		});
		loop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loopActionPerformed(e);
			}
		});
		stop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				stopActionPerformed(e);
			}
		});
		// audio.play();
		play.setEnabled(false);
		loop.setEnabled(true);
		stop.setEnabled(true);
		audio.loop();
	}

	private void playActionPerformed(ActionEvent e) {
		if (audio != null) {
			audio.play();
			play.setEnabled(false);
			loop.setEnabled(false);
			stop.setEnabled(true);
			showStatus("Playing sound only once!");
		} else {
			showStatus("Sound file no loaded!");
		}
	}

	private void loopActionPerformed(ActionEvent e) {
		if (audio != null) {
			audio.loop();
			play.setEnabled(false);
			loop.setEnabled(false);
			stop.setEnabled(true);
			showStatus("Playing sound all the time!");
		} else {
			showStatus("Sound file no loaded!");
		}
	}

	private void stopActionPerformed(ActionEvent e) {
		audio.stop();
		loop.setEnabled(true);
		stop.setEnabled(false);
		play.setEnabled(true);
	}
}
