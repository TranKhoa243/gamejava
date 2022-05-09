package mypackage;

import java.util.ArrayList;
import java.util.Collections;

import mypackage.io.SerializableFileFactory;
import mypackage.model.HighScore;

public class LoadSaveHighScore {
	
	public static void SaveLoadFile(HighScore nHS) {
		ArrayList<HighScore> arrHS=SerializableFileFactory.loadFile("C:\\Users\\Admin\\Desktop\\HighScore.txt");
		int k=arrHS.size()-1;
		if(nHS.getScore()>=arrHS.get(k).getScore()) {
			arrHS.set(k, nHS);
		}
		Collections.sort(arrHS);
		for(HighScore hS: arrHS) {
			System.out.println(hS);
		}
		boolean kt=SerializableFileFactory.saveFile(arrHS, "C:\\Users\\Admin\\Desktop\\HighScore.txt");
		if(kt==true) {
			System.out.println("Sao lưu thành công.");
		}
		else
			System.out.println("Sao lưu thất bại.");
	}

}
