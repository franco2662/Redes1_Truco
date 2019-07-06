package Connection;

import com.fazecast.jSerialComm.SerialPort;
import java.awt.Window;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Techiend
 */

public class Connection {

    InputStream in;
    OutputStream out;

    public static ArrayList<byte[]> bufferList_send = new ArrayList<byte[]>();
    
    public Connection() {
    }
    
    public static Connection getInstance() {
        return NewSingletonHolder.INSTANCE;
    }
    
    private static class NewSingletonHolder {
        private static final Connection INSTANCE = new Connection();
    }   
    
    public boolean connect (String portName)
    {

        
        SerialPort comPort = SerialPort.getCommPort(portName);
        if (!comPort.openPort())
            return false;
            
        comPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);

        in = comPort.getInputStream();
        out = comPort.getOutputStream();

            
        (new Thread(new SerialReader(in))).start();

        System.out.println("Se ha establecido conexion mediante el puerto "+portName);
        
        return true;
    }
    
    public static void addByte(byte[] trama){
        try {
            out.write(trama);
//            System.out.println("Envio");
        } catch (IOException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static class SerialReader implements Runnable
    {
        InputStream in;

        public SerialReader ( InputStream in )
        {
            this.in = in;
        }

        public void run ()
        {
            byte[] buffer = new byte[6];
            int len = -1;
            try
            {
                while ( ( len = this.in.read(buffer)) > -1 )
                {
                    while (buffer.length<5){}

                    // MANEJAR LO RECIBIDO
                    

                }
            }
            catch ( IOException e )
            {
                e.printStackTrace();
            }
        }

    }

}