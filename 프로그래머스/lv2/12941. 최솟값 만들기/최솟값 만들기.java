import java.io.*;
import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        // 1. A, B 정렬
        Arrays.sort(A);
        Arrays.sort(B);
        
        // 2. 두 수를 뽑아 더하기
        int answer = 0;
        for(int i=0; i<A.length; i++) {
            answer += A[i] * B[B.length-1-i]; // (작은 수 * 큰 수) 짝으로 곱해서 더하기
        }
        return answer;
    }
}