import java.util.Base64;

class EncryptionDecorator extends DataSourceDecorator {
    public EncryptionDecorator(DataSource source) {
        super(source);
    }

    @Override
    public void writeData(String data) {
        String encryptedData = encrypt(data);
        super.writeData(encryptedData);
    }

    @Override
    public String readData() {
        String data = super.readData();
        return decrypt(data);
    }

    private String encrypt(String data) {
        byte[] bytes = data.getBytes();
        byte[] encoded = Base64.getEncoder().encode(bytes);
        return new String(encoded);
    }

    private String decrypt(String data) {
        byte[] bytes = data.getBytes();
        byte[] decoded = Base64.getDecoder().decode(bytes);
        return new String(decoded);
    }
}
