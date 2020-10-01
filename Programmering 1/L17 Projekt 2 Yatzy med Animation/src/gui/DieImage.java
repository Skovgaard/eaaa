package gui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DieImage {
	private ImageView dieFace;
	private ArrayList<Image> images = new ArrayList<Image>();

	public DieImage() {

		// attempt to read images from resources
		for (int i = 1; i < 7; i++) {
			try {
				images.add(new Image(new FileInputStream("res/die" + i + ".png")));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// set default to image 0
		dieFace = new ImageView(images.get(0));

	}

	public ImageView getdieFace() {
		return dieFace;
	}

	public void setDieFace(int dieFaceValue) {
		dieFace.setImage(images.get(dieFaceValue - 1));
	}

	public ArrayList<Image> getImages() {
		return images;
	}
}