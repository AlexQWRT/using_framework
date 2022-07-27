import entities.Teachers;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;

public class Main {
    public static void main(final String[] args) {
        new Logic().executeMenu();
    }
}