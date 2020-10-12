import java.io.*;
import java.util.List;

public class ReadWriteFile {
    private List<Product> productList;

    public void writeFile() {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(new File("filetext.txt"));
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(this.productList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            closeOS(fileOutputStream);
            closeOS(objectOutputStream);

        }
    }

    public void readFile() {
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            fileInputStream = new FileInputStream(new File("filetext.txt"));
            objectInputStream = new ObjectInputStream(fileInputStream);
            productList = (List<Product>) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            closeIS(fileInputStream);
            closeIS(objectInputStream);
        }
    }
    public void closeIS (InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void closeOS (OutputStream os) {
        if (os != null) {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
