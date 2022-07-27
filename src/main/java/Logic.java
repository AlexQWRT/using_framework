import consoletable.ConsoleTable;
import consoletable.table.Cell;
import entities.Teachers;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.*;

public class Logic {
    private Scanner in;
    private static final SessionFactory factory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            factory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    Logic() {
        in = new Scanner(System.in);
    }

    private int readInt(int min, int max) {
        int num = 0;
        String buf = "";
        buf = in.nextLine();
        try {
            num = Integer.parseInt(buf);
            if (num < min || num > max) {
                throw new InputMismatchException();
            }
        } catch (Exception ex) {
            System.out.println("Некорректный ввод! Попробуйте снова.");
            return num;
        }
        return num;
    }

    public int printMenu() {
        System.out.flush();
        System.out.println("1. Показать таблицу");
        System.out.println("2. Добавить запись");
        System.out.println("3. Удалить запись");
        System.out.println("4. Отредактировать запись");
        System.out.println("5. Выйти из программы");
        return readInt(1, 5);
    }

    public void showTable() {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List teachers = session.createQuery("FROM Teachers").list();
            List<Cell> header = new ArrayList<Cell>(){{
                add(new Cell("id"));
                add(new Cell("name"));
                add(new Cell("surname"));
                add(new Cell("patronymic"));
            }};
            List<List<Cell>> body = new ArrayList<List<Cell>>(){{
                for (Iterator iterator = teachers.iterator(); iterator.hasNext();){
                    add(new ArrayList<Cell>(){{
                        Teachers teacher = (Teachers) iterator.next();
                        add(new Cell(String.valueOf(teacher.getTeacherId())));
                        add(new Cell(teacher.getTeacherName()));
                        add(new Cell(teacher.getTeacherSurname()));
                        add(new Cell(teacher.getTeacherPatronymic()));
                    }});
                }
            }};
            new ConsoleTable.ConsoleTableBuilder().addHeaders(header).addRows(body).restrict(false).build().print();
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void addRecord() {
        String name = "", surname = "", patronymic = "";
        System.out.print("Введите имя учителя: ");
        name = in.next();
        System.out.print("Введите фамилию учителя: ");
        surname = in.next();
        System.out.print("Введите отчество учителя: ");
        patronymic = in.next();
        in.nextLine();

        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Teachers t = new Teachers();
            t.setTeacherName(name);
            t.setTeacherSurname(surname);
            t.setTeacherPatronymic(patronymic);
            session.save(t);
            tx.commit();
            System.out.println("Учитель успешно добавлен!");
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void deleteRecord() {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            showTable();
            ArrayList<Integer> teachersIds = new ArrayList<Integer>(session.createQuery("SELECT teacherId FROM Teachers").getResultList());
                    session.createQuery("FROM Teachers").getResultList();
            int min = teachersIds.get(0);
            int max = teachersIds.get(0);
            for (int i = 0; i < teachersIds.size(); i++) {
                if (min > teachersIds.get(i)) {
                    min = teachersIds.get(i);
                }
                if (max < teachersIds.get(i)) {
                    max = teachersIds.get(i);
                }
            }
            System.out.print("Введите id удаляемого учителя: ");
            int choice = readInt(min, max);
            while(!teachersIds.contains(choice)) {
                System.out.println("Введённый вами id не существует, повторите ввод!");
                System.out.print("Введите id удаляемого учителя: ");
                choice = readInt(min, max);
            }
            Teachers t = (Teachers) session.get(Teachers.class, choice);
            session.delete(t);
            tx.commit();
            System.out.println("Учитель успешно удалён!");
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void editRecord() {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            showTable();
            ArrayList<Integer> teachersIds = new ArrayList<Integer>(session.createQuery("SELECT teacherId FROM Teachers").getResultList());
            session.createQuery("FROM Teachers").getResultList();
            int min = teachersIds.get(0);
            int max = teachersIds.get(0);
            for (int i = 0; i < teachersIds.size(); i++) {
                if (min > teachersIds.get(i)) {
                    min = teachersIds.get(i);
                }
                if (max < teachersIds.get(i)) {
                    max = teachersIds.get(i);
                }
            }
            System.out.print("Введите id редактируемого учителя: ");
            int choice = readInt(min, max);
            while(!teachersIds.contains(choice)) {
                System.out.println("Введённый вами id не существует, повторите ввод!");
                System.out.print("Введите id удаляемого учителя: ");
                choice = readInt(min, max);
            }
            String name = "", surname = "", patronymic = "";
            System.out.print("Введите имя учителя: ");
            name = in.next();
            System.out.print("Введите фамилию учителя: ");
            surname = in.next();
            System.out.print("Введите отчество учителя: ");
            patronymic = in.next();
            in.nextLine();
            Teachers t = (Teachers) session.get(Teachers.class, choice);
            t.setTeacherName(name);
            t.setTeacherSurname(surname);
            t.setTeacherPatronymic(patronymic);
            session.update(t);
            tx.commit();
            System.out.println("Учитель успешно отредактирован!");
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void executeMenu() {
        int choice = 0;

        while((choice = printMenu()) != 5) {
            switch(choice) {
                case 1:
                    showTable();
                    break;
                case 2:
                    addRecord();
                    break;
                case 3:
                    deleteRecord();
                    break;
                case 4:
                    editRecord();
                    break;
            }
        }
    }
}
