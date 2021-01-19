package sct_test;

/**
 * 测试枚举类型
 */

public class TestEnum {

    public static void main(String[] args) {

        System.out.print(Season.SPRING);
        Season a = Season.AUTUMN;

        switch (a){
            case SPRING:
                System.out.println("春天到了");
                break;
            case SUMMER:
                System.out.println("夏天到了");
                break;
            case AUTUMN:
                System.out.println("秋天到了");
                break;
            case WINTER:
                System.out.println("冬天到了");
                break;
        }
    }

    enum Season{
        SPRING,SUMMER,AUTUMN,WINTER
    }

    enum Week{
        星期一,星期二,星期三,星期四,星期五,星期六,星期日
    }
}
