import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class baseball {
    public void start() {


        System.out.println("\t숫자 야구 게임을 시작합니다 -> \t");

        ArrayList<Integer> answer = random();
        chk(answer);

    }
    public ArrayList<Integer> random(){
        HashSet<Integer> ans = new HashSet<>();
        int cnt = 0;
        while(ans.size() < 4){
            if(cnt == 0){
                ans.add((int)(Math.random() * 9 + 1));
                continue;
            }
            ans.add((int)(Math.random() * 10));
            cnt ++;
        }
        ArrayList<Integer> answer = new ArrayList<>(ans);
        return answer;
    }
    public String input(){
        System.out.println("------------------------------------");
        System.out.println("정답을 입력해 주세요.(숫자 4자리)");
        Scanner sc = new Scanner(System.in);
        while(true){
            int cnt = 0;
            String input = sc.next();
            Set<Character> unique = new HashSet<>();
            for(int i=0; i<input.length(); i++){
                if(!unique.add(input.charAt(i))){
                    cnt++;
                }
            }

            if(input.length() != 4){
                System.out.println("0~9 사이의 숫자 4자리를 입력해 주세요.");
            }else if(input.charAt(0) == '0'){
                System.out.println("첫번째 자리에는 0이 올 수 없습니다. 다시 입력해 주세요.");
            }else if(cnt != 0){
                System.out.println("중복된 숫자가 존재합니다. 다시 입력해 주세요.");
            }else{
                try{
                    Integer.parseInt(input);
                    return input;
                }catch(Exception e){
                    System.out.println("숫자만 입력해 주세요.");
                }
            }
        }

    }
    int chk(ArrayList<Integer> answer) {
        int ball = 0;
        int strike = 0;

        while (true) {
            ArrayList<Integer> userInput = new ArrayList<>();

            String input = input();

            System.out.println("내가 입력한 정답 : " + input);
            for(int i=0; i<input.length(); i++){
                userInput.add(input.charAt(i)-'0');
            }
            for(int i=0; i<answer.size(); i++){
                if(answer.contains(userInput.get(i))){
                    if(answer.get(i) == userInput.get(i)){
                        strike++;
                        continue;
                    }
                    ball ++;
                }
            }
            if(strike == 4){
                System.out.println();
                System.out.println(" 승리 ");
                System.out.println();


            }
            System.out.println("B -> " + ball);
            System.out.println("S -> " + ball);
            ball = 0;
            strike = 0;

        }


        }
    }
