package cn.fanhub.rpc.selfrpc.framework;

import org.apache.commons.lang3.reflect.MethodUtils;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProviderReflect {
    private static final ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool();

    public static void provider(final Object service, int port) throws Exception{
        final ServerSocket serverSocket = new ServerSocket(port);
        while (true) {
            final Socket socket = serverSocket.accept();
            EXECUTOR_SERVICE.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                        String methodName = inputStream.readUTF();
                        Object[] arguments = ((Object[]) inputStream.readObject());

                        ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                        try {
                            Object result = MethodUtils.invokeExactMethod(service, methodName, arguments);
                            outputStream.writeObject(result);
                        } catch (Throwable t) {
                            outputStream.writeObject(t);
                        } finally {
                            outputStream.close();
                        }
                        inputStream.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }
}