package business.fileImplementation;

import business.BusinessException;
import business.UserNotFoundException;
import business.UserService;
import domain.Admin;
import domain.Guest;
import domain.User;

import java.io.*;
import java.util.List;

public class FileUserServiceImplementation implements UserService {

    String usersFilename;


    public FileUserServiceImplementation(String usersFilename) {
        this.usersFilename = usersFilename;
    }

    @Override
    public User authenticate(String username, String password) throws IOException {
        FileData fd = FileUtility.readAllRows(usersFilename);
        List<String[]> rows = fd.getRows();
        for (String[] row : rows) {
            if (row[1].equals(username) && row[2].equals(password)) {

                if (row[3].equals("Guest")) {
                    User user = new Guest(username, password);
                    return user;
                }

                if (row[3].equals("Admin")) {
                    User user = new Admin(username, password);
                    return user;
                }
            }

        }

        return null;

    }

    @Override
    public void signUp(String username, String password) throws IOException {
        if (existenceCheck(username) == false) {
            // riscriviamo l'intero file quando andiamo ad apportare cambiamenti
            FileData fd = FileUtility.readAllRows(usersFilename);
            PrintWriter pw = new PrintWriter(usersFilename);
            long positionCounter = fd.getPositionCounter();
            pw.println(positionCounter + 1);

            // riscrivo il file

            for (String[] rows : fd.getRows()) {
                // join(char,String[]) serve a ricollegare tutte le stringhe che formano la riga
                pw.println(String.join(FileUtility.COLUMN_SEPARATOR, rows));
            }

            // ora scrivo la riga nuova
            pw.println(positionCounter + 1 + FileUtility.COLUMN_SEPARATOR +
                    username + FileUtility.COLUMN_SEPARATOR +
                    password + FileUtility.COLUMN_SEPARATOR +
                    "Guest");
            pw.close();
        }
    }

    private boolean existenceCheck(String username) throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader(usersFilename));
        try {
            // la prima riga è del contatore quindi skippo
            FileData fd = FileUtility.readAllRows(usersFilename);
            List<String[]> list = fd.getRows();
            for (String[] row : list) {
                if (row[1].equals(username)) return true;
            }
            return false;


        } catch (IOException i) {
            i.printStackTrace();
        }

        return false;
    }
}
