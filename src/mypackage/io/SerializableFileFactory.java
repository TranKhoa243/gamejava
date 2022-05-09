package mypackage.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import mypackage.model.HighScore;

public class SerializableFileFactory {
	
	public static boolean saveFile(ArrayList<HighScore> arrHS,String patch) {
		try {
			FileOutputStream fos=new FileOutputStream(patch);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(arrHS);
			oos.close();
			fos.close();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	public static ArrayList<HighScore> loadFile(String patch) {
		ArrayList<HighScore> arrHS=new ArrayList<HighScore>();
		try {
			FileInputStream fis=new FileInputStream(patch);
			ObjectInputStream ois=new ObjectInputStream(fis);
			Object data=ois.readObject();
			arrHS=(ArrayList<HighScore>) data;
			ois.close();
			fis.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return arrHS;
	}
	
}
