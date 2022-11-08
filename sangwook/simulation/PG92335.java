package simulation;


public class PG92335 {
    public static void main(String[] args) {
        Solution1 s = new Solution1();
        s.solution(110011,10);
    }
}
class Solution1 {
    int answer = 0;

    public int solution(int n, int k) {

        StringBuilder num = new StringBuilder();
        int value = n;
        int rest = 0;
        while( value > k ){
            int r =  value % k;
            num.insert(0, r);
            value/=k;
        }
        num.insert(0, value);

        check(num.toString());
        System.out.println(answer);
        return answer;
    }

    void check( String num){
        int startIdx = 0;
        int endIdx = 1;

        while(startIdx < num.length()){

            String number = num.substring(startIdx,endIdx);
            if(num.charAt(endIdx-1) == '0') {
                startIdx = endIdx;
                endIdx = startIdx + 1;
                continue;
            }
            if(num.equals("0")){
                startIdx++;
                endIdx++;
                continue;
            }
            if(isPrime(Integer.parseInt(number))){

                if(startIdx == 0){
                    if(num.charAt(endIdx) != '0'){
                        endIdx++;
                    }else{
                        answer++;
                        startIdx = endIdx+1;
                        endIdx = startIdx+1;
                    }
                }else if(endIdx < num.length()-1){
                    if(num.charAt(startIdx-1) == '0' && num.charAt(endIdx) == '0'){
                        answer++;
                        startIdx = endIdx+1;
                        endIdx = startIdx+1;
                    }else{
                        endIdx++;
                    }
                }else if(endIdx == num.length()){
                    if(num.charAt(startIdx-1) == '0'){
                        answer++;
                    }
                    startIdx = endIdx + 1;
                }
            }else {
                endIdx++;
            }

        }

    }


    Boolean isPrime(int number){

        if(number == 2){
            return true;
        }


        if(number == 1 || number % 2 == 0){
            return false;
        }


        int sqrt = (int) Math.sqrt(number);

        for(int i = 3; i <= sqrt; i+=2){
            if(number % i == 0){
                return false;
            }
        }

        return true;
    }
}