import java.util.Scanner;
import java.text.DecimalFormat;
/**
 * Created by Administrator on 2017/3/27.
 */

public class caltmp {
    public static void main(String[] args) {
        int i=0;
        while(i==0)
            i=create();
    }
    public static int create()
    {
        java.util.Random r = new java.util.Random();
        double x=0.0,k=0,l=0;
        int i,a=0,b=0,c=0,d=0,t,j,m=0;
        int q=0,p=0;
        int e[] = new int[2];
        int f[] = new int[2];
        String base = "+-*/";
        StringBuffer sb = new StringBuffer();

        i=r.nextInt(2);
        if(i==1)
            a = renature();
        else
            e=refraction();
        if( i!=1)
        {
            System.out.print(e[0]+"/"+e[1]);
        }
        else
        {
            System.out.print(a);
        }
        c = r.nextInt(base.length());
        sb.append(base.charAt(c));
        String ss=sb.toString();
        System.out.print(ss);
        j=r.nextInt(2);
        if(j==1)
            b = renature();
        else
            f=refraction();
        if(j!=1)
        {
            System.out.print(f[0]+"/"+f[1]+"=");
        }
        else
        {
            System.out.print(b+"=");
        }
        switch (ss) {
            case "+":
                if(i==1||j==1)
                {
                    a=a+b;
                }
                else if(i==0||j==1)
                {
                    e[0]=e[1]*b+e[0];
                }
                else if(i==1||j==0)
                {
                    f[0]=f[1]*a+f[0];
                }
                else
                {
                    p=simplify(e[1],f[1]);
                    q=e[1]*f[1]/p;
                    e[0]=e[0]*(q/e[1]);
                    f[0]=f[0]*(q/f[1]);
                    e[0]=e[0]+f[0];
                    e[1]=q;
                }
                break;
            case "-":
                if(i==1||j==1)
                {
                    a=a-b;
                }
                else if(i==0||j==1)
                {
                    e[0]=e[0]-e[1]*b;
                }
                else if(i==1||j==0)
                {
                    f[0]=f[1]*a-f[0];
                }
                else
                {
                    p=simplify(e[1],f[1]);
                    q=e[1]*f[1]/p;
                    e[0]=e[0]*(q/e[1]);
                    f[0]=f[0]*(q/f[1]);
                    e[0]=e[0]-f[0];
                    e[1]=q;
                }
                break;
            case "*":
                if(i==1||j==1)
                {
                    a=a*b;
                }
                else if(i==0||j==1)
                {
                    e[0]=e[0]*b;
                }
                else if(i==1||j==0)
                {
                    f[0]=f[0]*a;
                }
                else
                {
                    e[0]=e[0]*f[0];
                    e[1]=e[1]*f[1];
                }
                break;
            case "/":
                if(i==1||j==1)
                {
                    e[0]=a;
                    e[1]=b;
                }
                else if(i==0||j==1)
                {
                    e[1]=e[1]*b;
                }
                else if(i==1||j==0)
                {
                    f[1]=f[1]*a;
                    t=f[1];
                    f[1]=f[0];
                    f[0]=t;
                }
                else
                {
                    e[0]=e[0]*f[1];
                    e[1]=e[1]*f[0];
                }
                break;
            default:break;
        }
        l++;
        System.out.print(" 请输入答案:");
        Scanner xx = new Scanner(System.in);
        String text[]= new String[10];
        String str = xx.nextLine();
        if(str.equals("quit"))
        {
            return 1;
        }
        if(str.contains("/")) {//数据类型为int
            text = str.split("/");
            c = Integer.parseInt(text[0]);
            d = Integer.parseInt(text[1]);
        }
        if(!str.contains("/")) {

            c = Integer.parseInt(str);
            d = 0;
        }
        DecimalFormat df = new DecimalFormat("0.00%");

        if(d==0)
        {
            if(c==a)
            {
                k++;
                x=k/l;
                System.out.print(" 回答正确,正确率为"+df.format(x)+"\n");
            }
            else {

                System.out.print(" 回答错误,正确率为"+df.format(x)+"\n");
            }
        }
        else
        {
            if(c==e[0]&&d==e[1])
            {
                System.out.print(" 回答正确,正确率为"+df.format(x)+"\n");
            }
            else {
                System.out.print(" 回答错误,正确率为"+df.format(x)+"\n");
            }
        }
        return 0;
    }
    public static int renature()
    {
        java.util.Random r = new java.util.Random();
        int a;
        a=r.nextInt(99)+1;
        return (a);
    }
    public static int[] refraction()
    {
        java.util.Random r = new java.util.Random();
        int a[]=new int[2];
        a[0]=r.nextInt(99)+1;
        a[1]=r.nextInt(99)+1;
        return (a);
    }

    public static int simplify(int a,int b) {
        int c;
        c=a%b;
        while( c!=0 )
        {
            a=b;
            b=c;
            c=a%b;
        }
        return b;
    }
}
