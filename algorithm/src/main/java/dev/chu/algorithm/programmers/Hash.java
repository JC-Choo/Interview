package dev.chu.algorithm.programmers;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.HashMap;
import java.util.Map;

public class Hash {

    public boolean 전화번호_목록(String[] phone_book) {
        Map<Integer, String> map = new HashMap<>();
        for (String str : phone_book) {
            map.put(str.hashCode(), str);
        }

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            for (String str : phone_book) {
                if (!entry.getValue().equals(str)
                        && (entry.getValue().startsWith(str) || str.startsWith(entry.getValue()))) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean 전화번호_목록_for(String[] phone_book) {
        for (int i=0; i<phone_book.length-1; i++) {
            for (int j=i+1; j<phone_book.length; j++) {
                if (phone_book[i].startsWith(phone_book[j])
                        || phone_book[j].startsWith(phone_book[i])) {
                    return false;
                }
            }
        }
        return true;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String 완주하지_못한_선수(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> map = new HashMap<>();

        for (String str : participant) {
            map.put(str, map.getOrDefault(str, 0)+1);
        }

        for (String str : completion) {
            map.put(str, map.get(str)-1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) {
                answer = entry.getKey();
                return answer;
            }
        }

        return answer;
    }
}
