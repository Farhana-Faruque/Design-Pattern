import java.io.*;
import java.util.Base64;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

class CompressionDecorator extends DataSourceDecorator {
    public CompressionDecorator(DataSource source) {
        super(source);
    }

    @Override
    public void writeData(String data) {
        try {
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            try (DeflaterOutputStream dos = new DeflaterOutputStream(bout)) {
                dos.write(data.getBytes());
            }
            String compressedData = Base64.getEncoder().encodeToString(bout.toByteArray());
            super.writeData(compressedData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String readData() {
        String data = super.readData();
        byte[] dataBytes = Base64.getDecoder().decode(data);
        try {
            ByteArrayInputStream bin = new ByteArrayInputStream(dataBytes);
            InflaterInputStream iis = new InflaterInputStream(bin);
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            int b;
            while ((b = iis.read()) != -1) {
                bout.write(b);
            }
            return new String(bout.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}