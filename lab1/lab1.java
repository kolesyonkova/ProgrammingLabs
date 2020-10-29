
import java.util.Random;

public class lab1{
    public static void masD(float[] b, long[] a){
        double [][]d=new double[7][20];
        double y;
        double qw;
        for(int i=0; i<=6;i++){
            for(int j=0;j<=19;j++){
                if (a[i]==10){
                    qw=1/3;
                    y=Math.pow(Math.sin(b[j]),qw);
                    d[i][j]=Math.pow(y,(1-(Math.pow((qw)-Math.sin(b[j])/Math.cos(b[j]),3))/2));
                }
                else if ((a[i]==4)||(a[i]==6)||(a[i]==12)){d[i][j]=Math.asin((b[j]-3.5)/15)*Math.pow(Math.pow(2*Math.cos(b[j]),3)-1,2);}
                else {d[i][j]=Math.pow(Math.log(Math.acos((b[j]-3.5)/15)),0.25/(Math.log(Math.acos(Math.sin(b[j])))));}
                System.out.printf("%4.4f",d[i][j]);
                System.out.printf("   ");
            }
            System.out.printf("%n");
        }
    }
    public static void main(String[] args){
        short q=4;
        int k=0;
        long []d=new long[7];
        while (q<=16){
            d[k]=q;
            k+=1;
            q+=2;
        }
        float max;
        float min;
        max=4.0f;
        min=-11.0f;
        float x[]=new float[20];
        for (int i=0;i<=19;i++){
            Random r = new Random();
            x[i]=r.nextFloat() * (max - min) + min;
        }
        masD(x,d);
    }
}
