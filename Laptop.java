import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

public class Laptop
{
    static void ListOutLaptops(HashMap<Integer, String []> innerData)
    {
        System.out.println();
        for (int i = 1; i <= innerData.size(); i++)
        {
            System.out.println(i + ". " + innerData.get(i)[0]);
        }
    }

    static void ListOutParams(String [] innerData)
    {
        System.out.println("\nНаименование: " + innerData[0]);
        System.out.println("ЦП: " + innerData[1]);
        System.out.println("Объём ОЗУ: " + innerData[2] + " ГБ");
        System.out.println("Видеокарта: " + innerData[3]);
        System.out.println("Объём жёсткого диска: " + innerData[4] + " ГБ");
        System.out.println("ОС: " + innerData[5]);
        System.out.println("Цвет: " + innerData[6]);
    }

    static int CheckNumbers(String param, int max)
    {
        Scanner iScanner = new Scanner(System.in);
        while (true)
        {
            System.out.printf(param + ": ");
            if (iScanner.hasNextInt() == true)
            {
                int number = iScanner.nextInt();
                if (max != 0)
                {
                    if (number > 0 && number <= max)  
                    {
                        return number;
                    }
                    else
                    {
                        System.out.println("Номер введен неправильно.\n");
                    }
                }
                else
                {
                    if (number > 0)  
                    {
                        return number;
                    }
                    else
                    {
                        System.out.println("Номер введен неправильно.\n");
                    }
                }
            }
            else
            {
                System.out.println("Номер введен неправильно.\n");
            }
        }
    }

    static void params(HashMap<Integer, String []> innerData)
    {
        ListOutLaptops(innerData);
        System.out.println();
        int number = CheckNumbers("Введите номер ноутбука, параметры которого хотите посмотреть", innerData.size());
        ListOutParams(innerData.get(number));  
    }

    static void sort(HashMap<Integer, String []> innerData)
    {
        String [] params = new String[] {"Наименование", "ЦП", "Объём ОЗУ", "Видеокарта", "Объём жесткого диска", "ОС", "Цвет"};
        ArrayList<String> sorted = new ArrayList<String>();
        System.out.println("\nПараметры по которым возможно отсортировать ноутбуки:\n");
        for (int i = 0; i < params.length; i++)
        {
            System.out.println((i + 1) + ". " + params[i]);
        }
        System.out.println();
        int number = CheckNumbers("Введите номер параметра из списка", 7);
        if (number == 3 || number == 5)
        {
            int criterion = CheckNumbers("Введите минимальное значение параметра", 0);
            for (int i = 1; i <= innerData.size(); i++)
            {
                if (Integer.valueOf(innerData.get(i)[number - 1]) >= criterion)
                {
                    sorted.add(innerData.get(i)[0]);
                }
            }
        }
        else
        {
            Scanner iScanner = new Scanner(System.in);
            System.out.print("\nВведите часть или полное название параметра, по которому хотите отсортировать ноутбуки: ");
            String word = iScanner.nextLine();
            for (int i = 1; i <= innerData.size(); i++)
            {
                if (innerData.get(i)[number - 1].toLowerCase().contains(word.toLowerCase()))
                {
                    sorted.add(innerData.get(i)[0]);
                }
            }
        }
        if (sorted.isEmpty())
        {
            System.out.println("\nПодходящих под критерий ноутбуков не найдено.\nПопробуйте изменить критерий.");
        }
        else
        {
            System.out.println("\nПодходящие под критерий ноутбуки:\n");
            for (int i = 0; i < sorted.size(); i++)
            {
                System.out.println((i + 1) + ". " + sorted.get(i));
            }
        }
    }
    public static void main(String[] args)
    {   
        String [] victus = new String[] {"HP Victus" ,"AMD Ryzen 5", "16", "NVIDIA GeForce", "512", "DOS", "Grey"};
        String [] macbook = new String[] {"Apple MacBook Pro", "Apple M1 Pro", "16", "Apple graphics", "512", "macOS", "Grey"};
        String [] zenbook = new String[] {"ASUS Zenbook", "AMD Ryzen 5", "8", "AMD Radeon Graphics", "512", "Windows 11 Home", "Black"};
        String [] matebook = new String[] {"HUAWEI MateBook", "Intel Core i3", "8", "Intel UHD Graphics", "256", "Windows 11 Home", "Grey"};
        String [] ideapad = new String[] {"Lenovo IdeaPad", "AMD Ryzen 5", "16", "AMD Radeon Graphics", "512", "DOS", "Grey"};
        String [] pulse = new String[] {"MSI Pulse", "Intel Core i7", "8", "NVIDIA GeForce", "512", "Windows 11 Home", "Black"};
        String [] gram = new String[] {"LG Gram", "Intel Core i7", "16", "Intel UHD Graphics", "1024", "Windows 11 Home", "Black"};
        HashMap<Integer, String []> laptops = new HashMap<>();
        laptops.put(1, victus);
        laptops.put(2, macbook);
        laptops.put(3, zenbook);
        laptops.put(4, matebook);
        laptops.put(5, ideapad);
        laptops.put(6, pulse);
        laptops.put(7, gram);
        System.out.println("Добро пожаловать в интернет-магазин ноутбуков!");
        System.out.println("В наличии имеются следующие модели:");
        ListOutLaptops(laptops);
        System.out.println("\nДля вывода параметров ноутбука введите params;");
        System.out.println("Для сортировки ноутбуков по параметрам введите sort;");
        System.out.println("Для вывода списка имеющихся ноутбуков введите list;");
        System.out.println("Для выхода из системы введите exit.");
        Scanner iScanner = new Scanner(System.in);
        while (true)
        {
            System.out.print("\nВведите команду: ");
            String cmd = iScanner.nextLine();
            if (cmd.equals("params"))
            {
                params(laptops);
            }
            else if (cmd.equals("sort"))
            {
                sort(laptops);
            }
            else if (cmd.equals("list"))
            {
                System.out.println("\nСписок имеющихся ноутбуков:");
                ListOutLaptops(laptops);
            }
            else if (cmd.equals("help"))
            {
                System.out.println("\nДля вывода параметров ноутбука введите params;");
                System.out.println("Для сортировки ноутбуков по параметрам введите sort;");
                System.out.println("Для вывода списка имеющихся ноутбуков введите list;");
                System.out.println("Для выхода из системы введите exit.");
            }
            else if (cmd.equals("exit"))
            {
                break;
            }
            else
            {
                System.out.println("\nТакой команды нет. Попробуйте ещё раз.");
            }
            continue;
        }
    }
}