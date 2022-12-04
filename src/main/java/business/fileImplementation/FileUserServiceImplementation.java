package business.fileImplementation;

import business.BusinessException;
import business.UserService;
import domain.Admin;
import domain.Guest;
import domain.User;

import java.io.*;
import java.util.ArrayList;
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
                    User user =new Guest();
                    user.setUsername(row[1]);
                    user.setPassword(row[2]);
                    user.setRole(row[3]);

                    return user;
                }

                if (row[3].equals("Admin")) {
                    User user =new Admin();
                    user.setUsername(row[1]);
                    user.setPassword(row[2]);
                    user.setRole(row[3]);
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

    @Override
    public boolean resetUsername(String newUsername, String currentUsername) throws FileNotFoundException {
        if (existenceCheck(newUsername))
            return false;

        try {

            FileData fd = FileUtility.readAllRows(usersFilename);
            BufferedReader br = new BufferedReader(new FileReader(usersFilename));
            long pCounter = fd.getPositionCounter();
            PrintWriter pw = new PrintWriter(usersFilename);
            List<String[]> list = fd.getRows();
            for (String[] row : list) {
                if (row[1].equals(currentUsername)) {
                    // substitution
                    row[1] = newUsername;

                    // reWrite the file
                    pw.println(pCounter);
                    for (String[] rows : fd.getRows()) {
                        // join(char,String[]) serve a ricollegare tutte le stringhe che formano la riga
                        pw.println(String.join(FileUtility.COLUMN_SEPARATOR, rows));
                    }

                }
            }
            pw.close();
            br.close();


            return true;
        } catch (IOException i) {
            i.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean resetPassword(String newPassword, String username) throws FileNotFoundException {

        try {
            FileData fd = FileUtility.readAllRows(usersFilename);
            BufferedReader br = new BufferedReader(new FileReader(usersFilename));
            long pCounter = fd.getPositionCounter();
            PrintWriter pw = new PrintWriter(usersFilename);
            List<String[]> list = fd.getRows();
            for (String[] row : list) {
                if (row[1].equals(username)) {
                    // substitution
                    row[2] = newPassword;

                    // reWrite the file
                    pw.println(pCounter);
                    for (String[] rows : fd.getRows()) {
                        // join(char,String[]) serve a ricollegare tutte le stringhe che formano la riga
                        pw.println(String.join(FileUtility.COLUMN_SEPARATOR, rows));
                    }

                }
            }
            pw.close();
            br.close();

            return true;
        } catch (IOException i) {
            i.printStackTrace();
        }
        return false;
    }


    @Override
    public List<User> getUserList() throws BusinessException {

        List<User> userList = new ArrayList<>();
        try {
            FileData fd = FileUtility.readAllRows(usersFilename);
            List<String[]> rows = fd.getRows();

            for (String[] row : rows) {
                if(row[3].equals("Guest")){
                User user= new Guest();
                user.setUsername(row[1]);
                user.setPassword(row[2]);
                user.setRole(row[3]);
                userList.add(user);}
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new BusinessException(e);
        }
        return userList;
    }
}
