package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

public class ImageReaderFactory {
    public static ImageReader getReader(ImageTypes imageType) {
        ImageReader reader = null;
        if (imageType != null) {
            switch (imageType) {
                case BMP:
                    reader = new BmpReader();
                    break;
                case JPG:
                    reader = new JpgReader();
                    break;
                case PNG:
                    reader = new PngReader();
                    break;
            }
        }
        if (reader == null) {
            throw new IllegalArgumentException("Неизвестный тип картинки");
        }
        return reader;
    }
}
