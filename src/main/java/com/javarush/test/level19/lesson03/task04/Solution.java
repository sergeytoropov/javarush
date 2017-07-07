package com.javarush.test.level19.lesson03.task04;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1978

Подсказка: воспользуйтесь классом Calendar
*/

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner scanner;

        public PersonScannerAdapter(Scanner scanner) {
            this.scanner = scanner;
        }

        @Override
        public Person read() throws IOException
        {
            if (scanner.hasNext()) {
                Scanner sc = new Scanner(scanner.nextLine());

                String lastName = sc.next();
                String firstName = sc.next();
                String middleName = sc.next();
                int day = sc.nextInt();
                int month = sc.nextInt()-1;
                int year = sc.nextInt();
                Calendar calendar = new GregorianCalendar(year, month, day);

                return new Person(firstName, middleName, lastName, calendar.getTime());
            }
            return null;
        }

        @Override
        public void close() throws IOException
        {
            scanner.close();
        }
    }

}
