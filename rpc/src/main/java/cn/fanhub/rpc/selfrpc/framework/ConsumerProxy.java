package cn.fanhub.rpc.selfrpc.framework;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

public class ConsumerProxy {


    public static <T> T consume(final Class<T> interfaceClass, final String host, final int port) throws Exception{
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class<?>[] {interfaceClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Socket socket = new Socket(host, port);
                ObjectOutputStream outputStream = null;
                ObjectInputStream inputStream = null;
                try {
                    outputStream = new ObjectOutputStream(socket.getOutputStream());
                    outputStream.writeUTF(method.getName());
                    outputStream.writeObject(args);
                    inputStream = new ObjectInputStream(socket.getInputStream());
                    Object result = inputStream.readObject();
                    if (result instanceof Throwable) {
                        throw ((Throwable) result);
                    }
                    return result;
                } finally {
                    inputStream.close();
                    outputStream.close();
                    socket.close();
                }

            }
        });
    }
}