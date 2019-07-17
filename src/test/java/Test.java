import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args){
        String str1 = null;
        String str2 = null;
        int i=0;
        //List<String> inputs = Arrays.asList("ITEM0001 x 1", "ITEM0013 x 2", "ITEM0022 x 1");
        Scanner sca = new Scanner(System.in);
        List<String> inputs = new ArrayList<String>();
        while (true){
            System.out.println("请输入菜品名称：");
            str1 = sca.next();
            if("黄焖鸡".equalsIgnoreCase(str1)){
                str1 = "ITEM0001";
            }else if("肉夹馍".equals(str1)){
                str1 = "ITEM0013";
            }else if("凉皮".equals(str1)){
                str1 = "ITEM0022";
            }else if("冰锋".equals(str1)){
                str1 = "ITEM0030";
            }else {
                str1 = "";
            }
            System.out.println("请输入数量：");
            i = sca.nextInt();
            str2 = str1 +" * "+ i ;
            System.out.println(str2);
            inputs.add(str2);
            System.out.println("是否继续输入：y/n");
            str1 = sca.next();
            if("n".equalsIgnoreCase(str1)){
                System.out.println("谢谢您的点餐，马上就好！");
                break;
            }else if("y".equalsIgnoreCase(str1)){
                continue;
            }
        }
        sca.close();
        App app = new App(new ItemRepositoryTestImpl(), new SalesPromotionRepositoryTestImpl());
        String receiptString = app.bestCharge(inputs);
    }
}
