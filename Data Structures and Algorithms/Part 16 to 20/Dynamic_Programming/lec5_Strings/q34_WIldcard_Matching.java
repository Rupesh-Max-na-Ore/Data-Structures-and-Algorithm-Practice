package Dynamic_Programming.lec5_Strings;

public class q34_WIldcard_Matching {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[] prev=new boolean [m+1]; prev[0]=true;
        for(int i=1;i<=m;i++) prev[i]=false;
        for(int i=1;i<=n;i++){
            boolean[] curr=new boolean [m+1]; curr[0]=true;
            for(int ind=1;ind<=i;ind++){
                if(p.charAt(ind-1)!='*') {
                    curr[0]=false;
                    break;
                }
            }

            for(int j=1;j<=m;j++){
                if(p.charAt(i-1)==s.charAt(j-1)||p.charAt(i-1)=='?') curr[j]=prev[j-1];
                else if(p.charAt(i-1)=='*') curr[j]=curr[j-1]||prev[j];
                else curr[j]=false;
            }
            prev=curr;
        }
        return prev[m];
    }
}
/*public class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] match=new boolean[s.length()+1][p.length()+1];
        match[s.length()][p.length()]=true;
        for(int i=p.length()-1;i>=0;i--){
            if(p.charAt(i)!='*')
                break;
            else
                match[s.length()][i]=true;
        }
        for(int i=s.length()-1;i>=0;i--){
            for(int j=p.length()-1;j>=0;j--){
                if(s.charAt(i)==p.charAt(j)||p.charAt(j)=='?')
                        match[i][j]=match[i+1][j+1];
                else if(p.charAt(j)=='*')
                        match[i][j]=match[i+1][j]||match[i][j+1];
                else
                    match[i][j]=false;
            }
        }
        return match[0][0];
    }
} */