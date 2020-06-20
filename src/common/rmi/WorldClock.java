package common.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDateTime;

///要实现RMI，服务器和客户端必须共享同一个接口。我们定义一个WorldClock接口，代码如下：
public interface WorldClock extends Remote {
    LocalDateTime getLocalDateTime(String zoneId) throws RemoteException;
}