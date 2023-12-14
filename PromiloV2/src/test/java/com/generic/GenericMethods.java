package com.generic;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class GenericMethods {
	
	public static boolean  imageComparison(String image1, String image2) throws IOException {
		BufferedImage img1 = ImageIO.read(new File(image1));
		BufferedImage img2 = ImageIO.read(new File(image2));
		ImageDiffer imageDiffer = new ImageDiffer();
		ImageDiff imageDiff = imageDiffer.makeDiff(img1, img2);
		return imageDiff.hasDiff();
	}

}
