package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
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

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<User>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));

            writer.write("" + users.size());
            writer.newLine();

            for (User user: users) {
                writer.write(user.getFirstName());
                writer.newLine();

                writer.write(user.getLastName());
                writer.newLine();

                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                writer.write(sdf.format(user.getBirthDate()));
                writer.newLine();

                String male = "no";
                if (user.isMale()) {
                    male = "yes";
                }
                writer.write(male);
                writer.newLine();

                writer.write(user.getCountry().getDisplayedName());
                writer.newLine();
            }
            writer.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            int quantity = Integer.parseInt(reader.readLine());

            for (int index = 0; index < quantity; index++) {
                User user = new User();

                user.setFirstName(reader.readLine());
                user.setLastName(reader.readLine());

                String strDate = reader.readLine();
                int year = Integer.parseInt(strDate.substring(0, 4));
                int month = Integer.parseInt(strDate.substring(4, 6));
                int day = Integer.parseInt(strDate.substring(6, 8));
                GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
                user.setBirthDate(calendar.getTime());

                String male = reader.readLine();
                boolean isMale = false;
                if ("yes".equals(male.toLowerCase())) {
                    isMale = true;
                } else if ("no".equals(male.toLowerCase())) {
                    isMale = false;
                } else {
                    // Обработать исключительную ситуацию
                }
                user.setMale(isMale);

                String strCountry = reader.readLine();
                User.Country country = User.Country.OTHER;
                if ("Ukraine".equals(strCountry)) {
                    country = User.Country.UKRAINE;
                } else if ("Russia".equals(strCountry)) {
                    country = User.Country.RUSSIA;
                } else if ("Other".equals(strCountry)) {
                    country = User.Country.OTHER;
                } else {
                    // Обработать исключительную ситуацию
                }
                user.setCountry(country);

                users.add(user);
            }
            reader.close();
        }

        @Override
        public boolean equals(Object obj) {
            JavaRush javarush = (JavaRush) obj;
            boolean isEquals = false;

            if (users.size() == javarush.users.size()) {
                isEquals = true;

                for (int index = 0; index < users.size(); index++) {
                    if (!users.get(index).equals(javarush.users.get(index))) {
                        isEquals = false;
                        break;
                    }
                }
            }
            return isEquals;
        }
    }
}
