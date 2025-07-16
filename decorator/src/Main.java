public class Main {
    public static void main(String[] args) {
        String salaryRecords = "Name,Salary\nJohn Smith,100000\nJane Doe,120000";

        DataSource plainSource = new FileDataSource("OutputDemo.txt");
        plainSource.writeData(salaryRecords);

        System.out.println("- Original -----------------");
        System.out.println(plainSource.readData());

        DataSource encoded = new CompressionDecorator(
                new EncryptionDecorator(plainSource));
        encoded.writeData(salaryRecords);

        System.out.println("- Encoded ------------------");
        System.out.println(plainSource.readData());

        System.out.println("- Decoded ------------------");
        System.out.println(encoded.readData());
    }
}