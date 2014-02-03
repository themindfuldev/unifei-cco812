package pacote_12643.controle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 * Inicia um processamento de som.
 * @author Tiago
 */
public class ThreadSom extends Thread {
	/**
	 * Stream de áudio.
	 */
	private AudioStream as;

	/**
	 * Construtor
	 * @param nomeArquivo
	 */
	public ThreadSom(String nomeArquivo) {
		try {
			// Abre o arquivo de áudio
			InputStream is = new FileInputStream(nomeArquivo);
			as = new AudioStream(is);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
	public void run() {
		// executa o som
		AudioPlayer.player.start(as);
	}
}
