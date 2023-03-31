import java.util.*;

class Program미로탈출명령어 {
    String str="impossible";
    boolean end=false;
    int n,m,x,y,r,c,k;
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "impossible";
        this.n=n;
        this.m=m;
        this.x=x;
        this.y=y;
        this.r=r;
        this.c=c;
        this.k=k;
        int diff = k - (int)Math.abs(x-r) + (int)Math.abs(y-c);

        if (diff <0 || diff % 2 != 0){
            return "impossible";
        }
        backT(x,y,"",0);
        answer = str;
        return answer;
    }

    public void backT(int px, int py, String s, int count) {
        if (end) return;
        int diff = (int)Math.abs(px-r) + (int)Math.abs(py-c);
        if (diff > k-count) return;
        else if (k == count) {
            if (px==r && py==c) {
                str = s;
                end = true;
                return;
            }
        }
        else if (px==r && py==c) {
            if ((k-count)%2==1) return;
        }

        if (px+1 <= n) backT(px+1, py, s+"d", count+1);
        if (py-1 > 0) backT(px, py-1, s+"l", count+1);
        if (py+1 <= n) backT(px, py+1, s+"r", count+1);
        if (px-1 > 0) backT(px-1, py, s+"u", count+1);

        return;
    }
}

