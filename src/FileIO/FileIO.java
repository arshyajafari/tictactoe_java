package FileIO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;

//------------------------------------------------------------------------------------------------------
// Class File IO For Score Save And Read

public class FileIO {

	// ------------------------------------------------------------------------------------------------------
	// Save Score

	public static void saveGame(JButton[] board, String text, Date date) {
		try {
			FileWriter rw = new FileWriter(new File("results/" + date.toString().replace(":", "-") + ".tictactoe"));
			rw.write(text + "\n");
			rw.write(date.toString() + "\n");
			String boardString = "";
			for (int i = 0; i < board.length; i++) {
				boardString += board[i].getText() + ",";
			}
			boardString = boardString.substring(0, boardString.length() - 1);
			rw.write(boardString + "\n");
			rw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// ------------------------------------------------------------------------------------------------------
	// Read File

	public static File[] readFiles() {
		File files[] = new File[6];
		List<String> result = new ArrayList<>();
		search(".*\\.tictactoe", new File("results"), result);
		result.sort(Comparator.reverseOrder());
		int i = 0;
		for (String s : result) {
			files[i] = new File(s);
			i++;
			if (i >= 6)
				break;
		}
		return files;
	}

	// ------------------------------------------------------------------------------------------------------
	// Search File

	public static void search(final String pattern, final File folder, List<String> result) {
		for (final File f : folder.listFiles()) {
			if (f.isFile()) {
				if (f.getName().matches(pattern)) {
					result.add(f.getAbsolutePath());
				}
			}

		}
	}
}
