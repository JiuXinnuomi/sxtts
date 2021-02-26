package sct_InternetUdp;

import java.net.InetAddress;
import java.net.UnknownHostException;

/** InetAddress
 * 1. getLocalHost：本机
 * 2. getByName：根据域名DNS | IP地址-->IP
 * 3. getHostAddress：返回地址
 * 4. getHostName：返回计算机名
 */

public class TestIP {
    public static void main(String[] args) throws UnknownHostException {
        //使用getLocalHost创建InetAddress对象
        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address.getHostAddress());
        System.out.println(address.getHostName());

        //根据域名得到InetAddress对象
        address = InetAddress.getByName("www.baidu.com");
        System.out.println(address.getHostAddress());
        System.out.println(address.getHostName());

    }
}
