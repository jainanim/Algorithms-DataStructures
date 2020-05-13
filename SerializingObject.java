import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

public class SerializingObject {
    public static void main(String[] args) {
        Employee employeeOutput = new Employee();
        employeeOutput.setSerializeValueName("anima hii ");
        employeeOutput.setNonSerializeValueSalary(100000);
        employeeOutput.setDate(new Date());
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try{
            fos = new FileOutputStream("Employee.ser");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(employeeOutput);

            System.out.println("serialised data saved ");

            oos.close();
            fos.close();
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
