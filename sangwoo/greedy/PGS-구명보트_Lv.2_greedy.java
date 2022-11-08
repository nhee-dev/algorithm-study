import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int[] list = new int[241];
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i = 0; i < people.length; i++) {
            list[people[i]]++;
            if(people[i] < min) {
                min = people[i];
            }
            if(people[i] > max) {
                max = people[i];
            }
        }

        int result = 0;
        for(int i = max; i >= min; i--) {
            // 몸무게 없는 경우
            if(list[i] < 1) {
                continue;
            }

            // 1명밖에 못타는 경우
            if(i + min > limit) {
                result += list[i];
                list[i] = 0;
                continue;
            }          

            int standard = limit - i;

            while(list[i] > 0) {
                // 더 이상 같이 탈 사람 없는 경우
                if(standard < min) {
                    break;
                }

                // 해당 몸무게 없는 경우
                if(list[standard] == 0) {
                    standard--;
                    continue;
                }

                if(standard == i) {
                    int count = (int)(list[i] /2);
                    result += (int)(list[i] / 2);
                    list[i] = list[i] % 2;           
                    standard--;
                    continue;
                }

                if(list[standard] < list[i]) {
                    list[i] -= list[standard];
                    result += list[standard];
                    list[standard] = 0;
                    standard--;
                    continue;
                } 

                if(list[standard] >= list[i]) {
                    list[standard] -= list[i];
                    result += list[i];
                    list[i] = 0;
                    break;
                }


            }

            // 두 명씩 못타고 남은 경우
            if(list[i] > 0) {
                result += list[i];
                list[i] = 0;
            }
        }       

        return result;
    }
}

/*
class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1;
        for (; i < j; --j) {
            if (people[i] + people[j] <= limit)
                ++i;
        }
        return people.length - i;
    }
}
*/