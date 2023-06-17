import java.io.*;
import java.util.*;
import java.text.*;


class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) throws Exception {
        // 1. 약관 별 유효기간 데이터 map 생성
        Map<String, Integer> termsMap = new HashMap<>(); // 약관 종류 : 유효기간(달)
        for(int i=0; i<terms.length; i++) {
            String[] temp = terms[i].split(" ");
            termsMap.put(temp[0], Integer.parseInt(temp[1]));
        }
        
        // 2. 개인 정보 파기 날짜 계산
        ArrayList<Integer> removedFiles = new ArrayList<>();
        for(int i=0; i<privacies.length; i++) {
            String[] temp = privacies[i].split(" "); // 날짜, 약관 종류
            String dateOfInfo = temp[0];
            String termType = temp[1];
            
            int term = termsMap.get(termType); // 유효 기간
            String removedDate = calDate(dateOfInfo, term); // 파기 날짜 계산
            if(isRemoved(today, removedDate)) removedFiles.add(i+1); // 파기 여부 확인
        }
        
        int[] answer = new int[removedFiles.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = removedFiles.get(i);
        }
        Arrays.sort(answer);
        
        return answer;
    }
    
    public String calDate(String startDate, int month) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
        Calendar cal = Calendar.getInstance();
        
        Date date = dateFormat.parse(startDate);
        cal.setTime(date);
        
        cal.add(Calendar.MONTH, month); // 유효기간 만큼 더하기
        cal.add(Calendar.DATE, -1); // 유효기간 하루 전까지만 보관 가능 하기 때문에 하루 빼주기
        
        if(cal.get(Calendar.DATE) > 28) { // 모든 달은 28일까지만 있음
            cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 28);
        }
        
        return dateFormat.format(cal.getTime());
    }
    
    public boolean isRemoved(String today, String removedDate) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
        Date to = dateFormat.parse(today);
        Date remove = dateFormat.parse(removedDate);
        
        return to.after(remove); // 파기날짜 보다 오늘이 더 크면 true(파기 날짜가 지났을 때)
    }
}