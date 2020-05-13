import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeSerializingObject {

    public static void main(String[] args) {
        Employee employeeInput = null;
        FileInputStream fis = null;
        ObjectInputStream ois =null;
        try
        {
            fis = new FileInputStream("Employee.ser");
            ois = new ObjectInputStream(fis);
            employeeInput = (Employee)ois.readObject();
            System.out.println("serialised object is ");
            ois.close();
            fis.close();

        }catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        System.out.println(employeeInput.getSerializeValueName());
        System.out.println(employeeInput.getNonSerializeValueSalary());
        System.out.println(employeeInput.getDate());
    }
}
