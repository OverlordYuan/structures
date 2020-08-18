import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class minlist {
    public int minlist(List<String> strs, List<String> tagets){
        if(strs.size()<3){
            return 0;
        }
        int begin = 0;
        int mid = 0;
        int end = 0;
        int res = 0;
        Set<String> minS = new HashSet<String>();
        for(int i=0;i<strs.size();i++){
            if(tagets.contains(strs.get(i))){
                if(minS.isEmpty()){
                    begin = i;
                    minS.add(strs.get(i));
                }else if(minS.size()==1){

                }
            }
        }
        return res;
    }
}
