package com.javarush.test.level20.lesson02.task01;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* Читаем и пишем в файл: Human
Реализуйте логику записи в файл и чтения из файла для класса Human
Поле name в классе Human не может быть пустым
В файле your_file_name.tmp может быть несколько объектов Human
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {

            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }


    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<Asset>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));

            writer.write(name);
            writer.newLine();
            writer.write("" + assets.size());
            writer.newLine();

            for (Asset asset: assets) {
                writer.write(asset.getName());
                writer.newLine();
                writer.write(String.format(Locale.ENGLISH, "%.2f", asset.getPrice()));
                writer.newLine();
            }

            writer.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            this.name = reader.readLine();
            int quantity = Integer.parseInt(reader.readLine());
            for (int idx = 0; idx < quantity; idx++) {
                Asset asset = new Asset(reader.readLine());
                asset.setPrice(Double.parseDouble(reader.readLine()));

                assets.add(asset);
            }

            reader.close();
        }

        @Override
        public boolean equals(Object obj) {
            Human human = (Human) obj;
            boolean isEquals = false;

            if (name.equals(human.name) && assets.size() == human.assets.size()) {
                isEquals = true;
                for (int idx = 0; idx < assets.size(); idx++) {
                    if (!assets.get(idx).equals(human.assets.get(idx))) {
                        isEquals = false;
                        break;
                    }
                }
            }
            return isEquals;
        }
    }
}
