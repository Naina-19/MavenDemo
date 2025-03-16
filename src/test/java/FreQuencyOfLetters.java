import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class FreQuencyOfLetters {
    @Test
    public void testMaxFrequencyAlphabet(){
    String name= "AFGANISSSSSSSTAN";
    Map<Character,Integer> map= new HashMap<>();
    char[] chars=name.toCharArray();
    for(char c:chars){
        int count=0;
        if(map.get(Character.valueOf(c))==null){
    map.put(c,++count);
        }
        else
        {
            count=map.get(Character.valueOf(c));
            map.put(c,++count);
        }
    }
    int max=0;
    Character charWithMaxFrequency=null;
    for(Map.Entry e:map.entrySet()){
        Integer value=(Integer)e.getValue();
        if(value>max){
            max=value;
            charWithMaxFrequency=(Character)e.getKey();
        }
    }
        System.out.println(map);
        System.out.println("The letter which has max frequency= "+charWithMaxFrequency);

}}
